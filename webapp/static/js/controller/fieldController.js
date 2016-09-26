'use strict';
 
App.controller('FieldController', ['$scope', 'PuzzleService', '$uibModal', function($scope, PuzzleService, $uibModal) {
          var self = this;
          self.manaCrystals = [];
          self.searchCardsList = [];
          self.enemyMana = 0;
          $scope.dragging = false;
          
          $('#searchBtn').click(function() {
        	  self.searchCards($('#search').val());
          });
          
          $('#closeSearch').click(function() {
              $scope.closeSearchPanel();
              $('.show-search-btn').show();
          });
          
          $('.show-search-btn').click(function() {
              $scope.showSearchPanel();
              $('.show-search-btn').hide();
          });
          
          self.searchCards = function(name) {
        	  PuzzleService.searchCards(name).then(
        	          function(response) {
        	              self.searchCardsList.length = 0;
        	              
        	              for (var i = 0; i < response.length; i++) {
        	                  var element = response[i];
        	                  self.searchCardsList.push({
                                  card: element,
                                  attack: element.defaultAttack,
                                  hp: element.defaultHp,
                                  cost: element.defaultCost
                              });
        	              }

        	              console.log(self.searchCardsList);
                      },
                      function(errResponse){
                           console.error('Error while searching cards');
                      }
        	  );
          }
          
          self.fetchHeroes = function() {
              PuzzleService.fetchAllHeroes().then(
                      function(response) {
                          self.heroes = response;
                      },
                      function(errResponse){
                           console.error('Error while searching cards');
                      }
              );
          }
          self.fetchHeroes();
          
          self.fetchHeropowers = function() {
              PuzzleService.fetchAllHeropowers().then(
                      function(response) {
                          self.heropowers = response;
                      },
                      function(errResponse){
                           console.error('Error while searching cards');
                      }
              );
          }
          self.fetchHeropowers();
          
          function convertManaCrystals(mana) {
              self.manaCrystals.length = 0;
              
              for (var i = 1; i <= mana.manaTotal; i++) {
                  self.manaCrystals.push({
                      locked: i > mana.manaTotal - mana.manaLocked,
                      used: i > mana.manaAvailable
                  });
              }
          }
          
          self.fetchPuzzle = function(id) {
        	  PuzzleService.fetchPuzzle(id)
              .then(
                   function(response) {
                       self.enemyhero = response.enemyHero;
                       self.playerhero = response.playerHero;
                       
                       if (self.enemyhero.minions) {
                           $.each(self.enemyhero.minions, function(_, minion) {
                               minion.enemy = true;
                           });
                       }
                       
                       self.playerMana = {
                           manaTotal: self.playerhero.manaTotal,
                           manaLocked: self.playerhero.manaLocked,
                           manaAvailable: self.playerhero.manaAvailable
                       };
                       
                       self.enemyMana = {
                           manaTotal: self.enemyhero.manaTotal,
                           manaAvailable: self.enemyhero.manaAvailable
                       };
                       
                       convertManaCrystals(self.playerMana);
                   },
                    function(errResponse){
                        console.error('Error while fetching puzzle');
                   }
               );
          }
          
          // TODO: replace 1 with actual id.
          self.fetchPuzzle(1);
          
          $scope.dragStart = function(item) {
              $('[dnd-allowed-types]').each(function(_, el) {
                  var $el = $(el);
                  var types = $el.attr('dnd-allowed-types');
                  if (types.indexOf(item.card.type) !== -1) {
                      $el.addClass('dragAllowed');
                  } else {
                      $el.addClass('dragDisabled');
                  }
              });
              
              if (window.getSelection) {
                  if (window.getSelection().empty) {  // Chrome
                      window.getSelection().empty();
                  } else if (window.getSelection().removeAllRanges) {  // Firefox
                      window.getSelection().removeAllRanges();
                  }
              } else if (document.selection) {  // IE?
                  document.selection.empty();
              }
              
              $scope.dragging = true;
          }
          
          $scope.minionDrop = function(item, enemy) {
              item.enemy = enemy;
              return item;
          }
          
          $scope.dragEnd = function() {
              $scope.dragging = false;
              $('.dragAllowed').removeClass('dragAllowed');
              $('.dragDisabled').removeClass('dragDisabled');
          }

          $scope.dndDropHand = function(event, index, item, external, type, allowedType) {
        	  var result = item;
        	  
        	  if (!result.card) {
        		  result = {
        		      card: item
        		  }
        	  }
        	  
        	  if (!Number.isInteger(result.cost)) {
        		  result.cost = result.card.defaultCost;
        	  }
        	  
        	  if (!Number.isInteger(result.hp)) {
        		  result.hp = result.card.defaultHp;
        	  }
        	  
        	  if (!Number.isInteger(result.attack)) {
        		  result.attack = result.card.defaultAttack;
        	  }
        	  
        	  return result;
          }
          
          $scope.dndDropSearch = function() {
              return false;
          }
          
          $scope.showSearchPanel = function() {
              $('.search-results').show();
          }
          
          $scope.closeSearchPanel = function() {
              $('.search-results').hide();
          }
          
          $scope.dndWeapon = function(event, index, item, external, type, player) {
              self[player].weapon = {
                  card: item.card,
                  attack: item.attack || item.card.defaultAttack,
                  hp: item.hp || item.card.defaultHp
              }
          }
          
          $scope.editMinion = function(minion) {
              var modalInstance = $uibModal.open({
                  animation: true,
                  templateUrl: 'minionPopupContent.html',
                  controller: 'MinionPopupCtrl',
                  size: 'sm',
                  resolve: {
                      minion: function () {
                          return minion;
                      }
                  }
              });
          }
          
          $scope.editHero = function(hero, enemy) {
              hero.enemy = enemy;
              var modalInstance = $uibModal.open({
                  animation: true,
                  templateUrl: 'heroPopupContent.html',
                  controller: 'HeroPopupCtrl',
                  size: 'md',
                  resolve: {
                      heroes: function () {
                          return self.heroes;
                      }, 
                      hero: function() {
                          return hero;
                      }
                  }
              });
          }
          
          $scope.editHeropower = function(hero) {
              var modalInstance = $uibModal.open({
                  animation: true,
                  templateUrl: 'heropowerPopupContent.html',
                  controller: 'HeropowerPopupCtrl',
                  size: 'md',
                  resolve: {
                      heropowers: function () {
                          return self.heropowers;
                      }, 
                      hero: function() {
                          return hero;
                      }
                  }
              });
          }
          
          $scope.editCard = function(card) {
              var modalInstance = $uibModal.open({
                  animation: true,
                  templateUrl: 'cardPopupContent.html',
                  controller: 'CardPopupCtrl',
                  size: 'sm',
                  resolve: {
                      card: function () {
                          return card;
                      }
                  }
              });
          }
          
          $scope.editWeapon = function(weapon) {
              if (!!weapon) {
                  var modalInstance = $uibModal.open({
                      animation: true,
                      templateUrl: 'weaponPopupContent.html',
                      controller: 'WeaponPopupCtrl',
                      size: 'sm',
                      resolve: {
                          weapon: function () {
                              return weapon;
                          }
                      }
                  });                 
              }
          }
          
          $scope.editMana = function(mana, enemy) {
              if (!!mana) {
                  mana.enemy = enemy;
                  var modalInstance = $uibModal.open({
                      animation: true,
                      templateUrl: 'manaPopupContent.html',
                      controller: 'ManaPopupCtrl',
                      size: 'sm',
                      resolve: {
                          mana: function () {
                              return mana;
                          }
                      }
                  });
                  
                  modalInstance.result.then(function(mana) {
                      if (mana.enemy) {
                          self.enemyhero.manaAvailable = mana.manaAvailable;
                          self.enemyhero.manaTotal = mana.manaTotal;
                      } else {
                          convertManaCrystals(mana);
                          self.playerhero.manaAvailable = mana.manaAvailable;
                          self.playerhero.manaTotal = mana.manaTotal;
                          self.playerhero.manaLocked = mana.manaLocked;
                      }
                  });
              }
          }
     }]);
'use strict';
 
App.controller('HeroController', ['$scope', 'PuzzleService', function($scope, PuzzleService) {
          var self = this;
          self.heroes = [];
               
          self.fetchAllPlayers = function(){
        	  PuzzleService.fetchAllPlayers()
                  .then(
                       function(response) {
                           self.heroes = response;
                       },
                        function(errResponse){
                            console.error('Error while fetching heroes');
                       }
                       );
          };
          
          self.fetchAllPlayers();
     }]);
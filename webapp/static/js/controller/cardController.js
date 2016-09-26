'use strict';
 
App.controller('CardController', ['$scope', 'PuzzleService', function($scope, PuzzleService) {
          var self = this;
          self.cards = [];
               
          self.fetchAllCards = function(){
        	  PuzzleService.fetchAllCards()
                  .then(
                       function(response) {
                           self.cards = response;
                       },
                        function(errResponse){
                            console.error('Error while fetching cards');
                       }
                       );
          };
          
          self.fetchAllCards();
     }]);
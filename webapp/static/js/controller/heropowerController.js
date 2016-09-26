'use strict';
 
App.controller('HeropowerController', ['$scope', 'PuzzleService', function($scope, PuzzleService) {
          var self = this;
          self.heropowers = [];
               
          self.fetchAllHeropowers = function(){
        	  PuzzleService.fetchAllPlayers()
                  .then(
                       function(response) {
                           self.heropowers = response;
                       },
                        function(errResponse){
                            console.error('Error while fetching heropowers');
                       }
                       );
          };
          
          self.fetchAllHeropowers();
     }]);
'use strict';
 
App.controller('MinionController', ['$scope', 'PuzzleService', function($scope, PuzzleService) {
          var self = this;
          self.minions = [];
               
          self.fetchAllMinions = function(){
        	  PuzzleService.fetchAllMinions()
                  .then(
                       function(response) {
                           self.minions = response;
                       },
                        function(errResponse){
                            console.error('Error while fetching minions');
                       }
                       );
          };
          
          self.fetchAllMinions();
     }]);
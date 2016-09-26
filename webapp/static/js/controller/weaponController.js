'use strict';
 
App.controller('WeaponController', ['$scope', 'PuzzleService', function($scope, PuzzleService) {
          var self = this;
          self.weapons = [];
               
          self.fetchAllWeapons = function(){
        	  PuzzleService.fetchAllWeapons()
                  .then(
                       function(response) {
                           self.heropowers = response;
                       },
                       function(errResponse){
                            console.error('Error while fetching heropowers');
                       }
                   );
          };
          
          self.fetchAllWeapons();
     }]);
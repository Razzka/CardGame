'use strict';
 
App.factory('PuzzleService', ['$http', '$q', function($http, $q){
 
    return {
            fetchAllCards: function() {
                    return $http.get('/Hearthpuzzle/ajax/get-cards')
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while fetching cards');
                                        return $q.reject(errResponse);
                                    }
                            );
            },
            fetchPuzzle: function(id) {
            	return $http.get('/Hearthpuzzle/ajax/get-puzzle-' + id)
                .then(
                        function(response){
                            return response.data;
                        },
                        function(errResponse){
                            console.error('Error while fetching heroes');
                            return $q.reject(errResponse);
                        }
                );
            },
            fetchAllPlayers: function() {
                return $http.get('/Hearthpuzzle/ajax/get-players')
                .then(
                        function(response){
                            return response.data;
                        }, 
                        function(errResponse){
                            console.error('Error while fetching heroes');
                            return $q.reject(errResponse);
                        }
                );
            },
            fetchAllHeroes: function() {
                return $http.get('/Hearthpuzzle/ajax/get-heroes')
                .then(
                        function(response){
                            return response.data;
                        }, 
                        function(errResponse){
                            console.error('Error while fetching heroes');
                            return $q.reject(errResponse);
                        }
                );
            },
            fetchAllMinions: function() {
                return $http.get('/Hearthpuzzle/ajax/get-minions')
                .then(
                        function(response){
                            return response.data;
                        }, 
                        function(errResponse){
                            console.error('Error while fetching minions');
                            return $q.reject(errResponse);
                        }
                );
            },
            fetchAllHeropowers: function() {
                return $http.get('/Hearthpuzzle/ajax/get-heropowers')
                .then(
                        function(response){
                            return response.data;
                        }, 
                        function(errResponse){
                            console.error('Error while fetching heropowers');
                            return $q.reject(errResponse);
                        }
                );
            },
            fetchAllWeapons: function() {
                return $http.get('/Hearthpuzzle/ajax/get-weapons')
                .then(
                        function(response){
                            return response.data;
                        }, 
                        function(errResponse){
                            console.error('Error while fetching weapons');
                            return $q.reject(errResponse);
                        }
                );
            },
            searchCards: function(name) {
                return $http.get('/Hearthpuzzle/ajax/search-cards', {
                	params: {
                		name: name
                	}
                }).then(
                        function(response){
                            return response.data;
                        }, 
                        function(errResponse){
                            console.error('Error while fetching weapons');
                            return $q.reject(errResponse);
                        }
                );
            }
    };
}]);
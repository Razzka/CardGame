angular.module('customdirectives', [])
.directive('hero', function(){
  return {
    scope: {
      h: '='
    },
    restrict: 'E',
    replace: true,
    templateUrl: '/Hearthpuzzle/resources/html/hero.htm'
  };
}).directive('heropower', function(){
  return {
    scope: {
      p: '=' // player
    },
    restrict: 'E',
    replace: true,
    templateUrl: '/Hearthpuzzle/resources/html/heropower.htm'
  };
}).directive('weapon', function(){
  return {
    scope: {
      w: '='
    },
    restrict: 'E',
    replace: true,
    templateUrl: '/Hearthpuzzle/resources/html/weapon.htm'
  };
}).directive('minion', function(){
  return {
    scope: {
      m: '='
    },
    restrict: 'E',
    replace: true,
    templateUrl: '/Hearthpuzzle/resources/html/minion.htm'
  };
}).directive('card', function(){
  return {
	scope: {
      c: '='
    },
    restrict: 'E',
    replace: true,
    templateUrl: '/Hearthpuzzle/resources/html/card.htm'
  };
});
App.controller('HeropowerPopupCtrl', function ($scope, $uibModalInstance, heropowers, hero) {
    $scope.heropowers = heropowers;
    $scope.hero = hero;
    
    $scope.ok = function () {
        $uibModalInstance.close($scope.hero);
    };
    
    $scope.addCost = function(cost) {
        $scope.hero.heropowerCost += cost;
        if ($scope.hero.heropowerCost < 0) {
            $scope.hero.heropowerCost = 0;
        }
        
        if ($scope.hero.heropowerCost > 9999) {
            $scope.hero.heropowerCost = 9999;
        }
    }
    
    $scope.costChange = function() {
        if (!Number.isInteger($scope.hero.heropowerCost) || $scope.hero.heropowerCost < 1) {
            $scope.hero.heropowerCost = 1;
        }
        
        if ($scope.hero.heropowerCost > 9999) {
            $scope.hero.heropowerCost = 9999;
        }
    }
    
    $scope.changeHeropower = function(h) {
        $scope.hero.heropower = h;
    }
});
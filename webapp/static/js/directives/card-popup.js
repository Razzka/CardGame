App.controller('CardPopupCtrl', function ($scope, $uibModalInstance, card) {
    $scope.card = card;
    
    if (!$scope.card.effects) {
        $scope.card.effects = "";
    }
    
    $scope.ok = function () {
        $uibModalInstance.close($scope.card);
    };
    
    $scope.addHp = function(hp) {
        $scope.card.hp += hp;
        if ($scope.card.hp < 1) {
            $scope.card.hp = 1;
        }
        
        if ($scope.card.hp > 9999) {
            $scope.card.hp = 9999;
        }
    }
    
    $scope.addAttack = function(attack) {
        $scope.card.attack += attack;
        if ($scope.card.attack < 0) {
            $scope.card.attack = 0;
        }
        
        if ($scope.card.attack > 9999) {
            $scope.card.attack = 9999;
        }
    }
    
    $scope.addCost = function(cost) {
        $scope.card.cost += cost;
        if ($scope.card.cost < 0) {
            $scope.card.cost = 0;
        }
        
        if ($scope.card.cost > 99) {
            $scope.card.cost = 99;
        }
    }
    
    $scope.attackChange = function() {
        if (!Number.isInteger($scope.card.attack) || $scope.card.attack < 0) {
            $scope.card.attack = 0;
        }
        
        if ($scope.card.attack > 9999) {
            $scope.card.attack = 9999;
        }
    }
    
    $scope.costChange = function() {
        if (!Number.isInteger($scope.card.cost) || $scope.card.cost < 0) {
            $scope.card.cost = 0;
        }
        
        if ($scope.card.cost > 99) {
            $scope.card.cost = 99;
        }
    }
    
    $scope.hpChange = function() {
        if (!Number.isInteger($scope.card.hp) || $scope.card.hp < 1) {
            $scope.card.hp = 1;
        }
        
        if ($scope.card.hp > 9999) {
            $scope.card.hp = 9999;
        }
    }
});
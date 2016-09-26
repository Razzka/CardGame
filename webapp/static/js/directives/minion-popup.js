App.controller('MinionPopupCtrl', function ($scope, $uibModalInstance, minion) {
    $scope.minion = minion;
    
    if (!$scope.minion.effects) {
        $scope.minion.effects = "";
    }
    
    $scope.divine = $scope.minion.effects.indexOf('divine') != -1;
    $scope.taunt = $scope.minion.effects.indexOf('taunt') != -1;
    $scope.frozen = $scope.minion.effects.indexOf('frozen') != -1;
    $scope.stealth = $scope.minion.effects.indexOf('stealth') != -1;
    $scope.sleep = $scope.minion.effects.indexOf('sleep') != -1;
    
    $scope.clickToggle = function(effect) {
        $scope[effect] = !$scope[effect]; 
        if ($scope[effect]) { 
            $scope.minion.effects += effect;
        } else { 
            $scope.minion.effects = $scope.minion.effects.replace(effect, '');
        }
    }
    
    $scope.ok = function () {
        $uibModalInstance.close($scope.minion);
    };
    
    $scope.addHp = function(hp) {
        $scope.minion.hp += hp;
        if ($scope.minion.hp < 1) {
            $scope.minion.hp = 1;
        }
        
        if ($scope.minion.hp > 9999) {
            $scope.minion.hp = 9999;
        }
    }
    
    $scope.addAttack = function(attack) {
        $scope.minion.attack += attack;
        if ($scope.minion.attack < 0) {
            $scope.minion.attack = 0;
        }
        
        if ($scope.minion.attack > 9999) {
            $scope.minion.attack = 9999;
        }
    }
    
    $scope.attackChange = function() {
        if (!Number.isInteger($scope.minion.attack) || $scope.minion.attack < 0) {
            $scope.minion.attack = 0;
        }
        
        if ($scope.minion.attack > 9999) {
            $scope.minion.attack = 9999;
        }
    }
    
    $scope.hpChange = function() {
        if (!Number.isInteger($scope.minion.hp) || $scope.minion.hp < 1) {
            $scope.minion.hp = 1;
        }
        
        if ($scope.minion.hp > 9999) {
            $scope.minion.hp = 9999;
        }
    }
});
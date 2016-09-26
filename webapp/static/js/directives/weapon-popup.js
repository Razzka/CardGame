App.controller('WeaponPopupCtrl', function ($scope, $uibModalInstance, weapon) {
    $scope.weapon = weapon;
    
    $scope.ok = function () {
        $uibModalInstance.close($scope.weapon);
    };
    
    $scope.addHp = function(hp) {
        $scope.weapon.hp += hp;
        if ($scope.weapon.hp < 1) {
            $scope.weapon.hp = 1;
        }
        
        if ($scope.weapon.hp > 9999) {
            $scope.weapon.hp = 9999;
        }
    }
    
    $scope.addAttack = function(attack) {
        $scope.weapon.attack += attack;
        if ($scope.weapon.attack < 0) {
            $scope.weapon.attack = 0;
        }
        
        if ($scope.weapon.attack > 9999) {
            $scope.weapon.attack = 9999;
        }
    }
    
    $scope.attackChange = function() {
        if (!Number.isInteger($scope.weapon.attack) || $scope.weapon.attack < 0) {
            $scope.weapon.attack = 0;
        }
        
        if ($scope.weapon.attack > 9999) {
            $scope.weapon.attack = 9999;
        }
    }
    
    $scope.hpChange = function() {
        if (!Number.isInteger($scope.weapon.hp) || $scope.weapon.hp < 1) {
            $scope.weapon.hp = 1;
        }
        
        if ($scope.weapon.hp > 9999) {
            $scope.weapon.hp = 9999;
        }
    }
});
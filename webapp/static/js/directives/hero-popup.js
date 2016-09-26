App.controller('HeroPopupCtrl', function ($scope, $uibModalInstance, heroes, hero) {
    $scope.heroes = heroes;
    $scope.hero = hero;
    
    $scope.ok = function () {
        $uibModalInstance.close($scope.hero);
    };
    
    $scope.addHp = function(hp) {
        $scope.hero.hp += hp;
        if ($scope.hero.hp < 1) {
            $scope.hero.hp = 1;
        }
        
        if ($scope.hero.hp > 9999) {
            $scope.hero.hp = 9999;
        }
    }
    
    $scope.addArmor = function(armor) {
        $scope.hero.armor += armor;
        if ($scope.hero.armor < 0) {
            $scope.hero.armor = 0;
        }
        
        if ($scope.hero.armor > 9999) {
            $scope.hero.armor = 9999;
        }
    }
    
    $scope.addAttack = function(attack) {
        $scope.hero.attack += attack;
        if ($scope.hero.attack < 0) {
            $scope.hero.attack = 0;
        }
        
        if ($scope.hero.attack > 9999) {
            $scope.hero.attack = 9999;
        }
    }
    
    $scope.attackChange = function() {
        if (!Number.isInteger($scope.hero.attack) || $scope.hero.attack < 0) {
            $scope.hero.attack = 0;
        }
        
        if ($scope.hero.attack > 9999) {
            $scope.hero.attack = 9999;
        }
    }
    
    $scope.hpChange = function() {
        if (!Number.isInteger($scope.hero.hp) || $scope.hero.hp < 1) {
            $scope.hero.hp = 1;
        }
        
        if ($scope.hero.hp > 9999) {
            $scope.hero.hp = 9999;
        }
    }
    
    $scope.armorChange = function() {
        if (!Number.isInteger($scope.hero.armor) || $scope.hero.armor < 1) {
            $scope.hero.armor = 1;
        }
        
        if ($scope.hero.armor > 9999) {
            $scope.hero.armor = 9999;
        }
    }
    
    $scope.changeHero = function(h) {
        $scope.hero.hero = h;
    }
});
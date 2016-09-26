App.controller('ManaPopupCtrl', function ($scope, $uibModalInstance, mana) {
    $scope.mana = mana;
    
    $scope.ok = function () {
        $uibModalInstance.close($scope.mana);
    };
    
    $scope.addManaTotal = function(mana) {
        $scope.mana.manaTotal += mana;
        if ($scope.mana.manaTotal < 1) {
            $scope.mana.manaTotal = 1;
        }
        
        if ($scope.mana.manaTotal > 10) {
            $scope.mana.manaTotal = 10;
        }
        
        if ($scope.mana.manaTotal < $scope.mana.manaAvailable + $scope.mana.manaLocked) {
            if ($scope.mana.manaAvailable > 0) {
                $scope.mana.manaAvailable = $scope.mana.manaTotal - $scope.mana.manaLocked;
            } else {
                $scope.mana.manaLocked = $scope.mana.manaTotal;
            }
        }
    }
    
    $scope.addManaLocked = function(mana) {
        $scope.mana.manaLocked += mana;
        if ($scope.mana.manaLocked < 0) {
            $scope.mana.manaLocked = 0;
        }
        
        if ($scope.mana.manaLocked > $scope.mana.manaTotal - $scope.mana.manaAvailable) {
            $scope.mana.manaLocked = $scope.mana.manaTotal - $scope.mana.manaAvailable;
        }
    }
    
    $scope.addManaAvailable = function(mana) {
        $scope.mana.manaAvailable += mana;
        if ($scope.mana.manaAvailable < 0) {
            $scope.mana.manaAvailable = 0;
        }
        
        if ($scope.mana.manaAvailable > $scope.mana.manaTotal - $scope.mana.manaLocked) {
            $scope.mana.manaAvailable = $scope.mana.manaTotal - $scope.mana.manaLocked;
        }
        
        if ($scope.mana.manaAvailable > $scope.mana.manaTotal - $scope.mana.manaLocked) {
            $scope.mana.manaAvailable = $scope.mana.manaTotal - $scope.mana.manaLocked;
        }
    }
});
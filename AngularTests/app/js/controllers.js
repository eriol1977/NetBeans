'use strict';

/* Controllers */

angular.module('myApp.controllers', []).
        controller('ListaCtrl', function($scope) {
            $scope.states = [
                {code: 'SC',
                    name: 'Santa Catarina',
                    region: 'South'},
                {code: 'RS',
                    name: 'Rio Grande do Sul',
                    region: 'South'},
                {code: 'BA',
                    name: 'Bahia',
                    region: 'North East'},
                {code: 'CE',
                    name: 'Ceará',
                    region: 'North East'}
            ];
        })
        .controller('ValidacaoCtrl', function($scope) {
            $scope.getCssClasses = function(ngModelController) {
                return {
                    'form-group has-error': ngModelController.$invalid,
                    'form-group has-success': ngModelController.$valid
                };
            };
            $scope.showError = function(ngModelController, error) {
                return ngModelController.$error[error];
            };
        }).controller('PasswordCtrl', function($scope) {

}).controller('ItemCtrl', function($scope, $routeParams) {
    $scope.items = [
        {id: '1', name: 'Forchetta'},
        {id: '2', name: 'Coltello'}
    ];
    $scope.getItemById = function(id) {
        for (var i = 0; i < $scope.items.length; i++) {
            if ($scope.items[i].id === id)
                return $scope.items[i];
        }
    };
    $scope.selectedItem = $scope.getItemById($routeParams.itemId);
}).controller('PaginationCtrl', function($scope) {
    $scope.numPages = 7;
    $scope.currentPage = 3;
});
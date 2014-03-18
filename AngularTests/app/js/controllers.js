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

    $scope.switchPage = function(page) {
        $scope.pageContent = "Conteudo da página " + page;
    };

    $scope.switchPage($scope.currentPage);
}).controller('TableSortCtrl', function($scope) {
    $scope.orderedCol = 'id';
    $scope.reverse = false;
    $scope.items = [
        {id: '1', name: 'Forchetta'},
        {id: '2', name: 'Coltello'},
        {id: '3', name: 'Cucchiaio'},
        {id: '4', name: 'Piatto'},
        {id: '5', name: 'Bicchiere'}
    ];
}).controller('AlertCtrl', function($scope) {
    $scope.alerts = [{type: 'success', msg: 'Success!'},
        {type: 'info', msg: 'Info!'},
        {type: 'warning', msg: 'Warning!'},
        {type: 'danger', msg: 'Danger!'}];

    $scope.anotherAlert = {type: 'warning', msg: 'Eis aqui outro alerta...'};
}).controller('AccordionController', ['$scope', '$attrs',
    function($scope, $attrs) {
        this.groups = [];
        this.closeOthers = function(openGroup) {
            angular.forEach(this.groups, function(group) {
                if (group !== openGroup) {
                    group.isOpen = false;
                }
            });
        };
        this.addGroup = function(groupScope) {
            var that = this;
            this.groups.push(groupScope);
            groupScope.$on('$destroy', function(event) {
                that.removeGroup(groupScope);
            });
        };
        this.removeGroup = function(group) {
            var index = this.groups.indexOf(group);
            if (index !== -1) {
                this.groups.splice(this.groups.indexOf(group), 1);
            }
        };
    }]);
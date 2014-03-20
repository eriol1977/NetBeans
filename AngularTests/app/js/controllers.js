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

    $scope.pageSizeOptions = new Array(5, 10, 15, 20, 25, 30);
    $scope.items = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23];
    $scope.pageSize = 10;
    $scope.current = 1;
    $scope.switchPage2 = function(page) {
        $scope.pageContent2 = "Conteudo da página " + page;
    };

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
}).controller('AccorCtrl', function($scope) {
    $scope.items = [
        {heading: 'Cabeçalho 1', body: 'Texto 1'},
        {heading: 'Cabeçalho 2', body: 'Texto 2'},
        {heading: 'Cabeçalho 3', body: 'Texto 3'},
        {heading: 'Cabeçalho 4', body: 'Texto 4'},
        {heading: 'Cabeçalho 5', body: 'Texto 5'}
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
    }]).controller('TableHeaderFilterCtrl', function($scope) {
    $scope.items = [
        {name: 'banana', color: 'amarelo', price: '0.99'},
        {name: 'laranja', color: 'laranja', price: '1.99'},
        {name: 'maça', color: 'vermelho', price: '1.99'},
        {name: 'pinha', color: 'verde', price: '3.99'},
        {name: 'manga', color: 'amarelo', price: '2.99'}
    ];
    $scope.filters = createFiltersArray();
    $scope.clearFilter = function(index) {
        $scope.filters[index] = "";
    };
    $scope.$watch('filters', updateFilterPattern, true);

    function getItemKeys() {
        var keys = [];
        for (var k in $scope.items[0])
            keys.push(k);
        return keys;
    }

    function createFiltersArray() {
        return Array.apply(null, new Array(getItemKeys().length)).map(String.prototype.valueOf, "");
    }

    function updateFilterPattern() {
        $scope.filterPattern = new Object();
        var keys = getItemKeys();
        for (var i = 0; i < keys.length; i++)
            $scope.filterPattern[keys[i]] = $scope.filters[i];
    }
});
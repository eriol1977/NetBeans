'use strict';


// Declare app level module which depends on filters, and services
angular.module('myApp', [
  'ngRoute',
  'myApp.filters',
  'myApp.services',
  'myApp.directives',
  'myApp.controllers'
]).
config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view1', {templateUrl: 'partials/lista.html', controller: 'ListaCtrl'});
  $routeProvider.when('/view2', {templateUrl: 'partials/validacao.html', controller: 'ValidacaoCtrl'});
  $routeProvider.when('/view3', {templateUrl: 'partials/password.html', controller: 'PasswordCtrl'});
  $routeProvider.when('/view4/:itemId', {templateUrl: 'partials/item.html', controller: 'ItemCtrl'});
  $routeProvider.when('/view5', {templateUrl: 'partials/pagination.html', controller: 'PaginationCtrl'});
  $routeProvider.when('/view6', {templateUrl: 'partials/tablesort.html', controller: 'TableSortCtrl'});
  $routeProvider.when('/view7', {templateUrl: 'partials/alert.html', controller: 'AlertCtrl'});
  $routeProvider.when('/view8', {templateUrl: 'partials/accordion.html', controller: 'AccorCtrl'});
  $routeProvider.when('/view9', {templateUrl: 'partials/tableheaderfilter.html', controller: 'TableHeaderFilterCtrl'});
  $routeProvider.otherwise({redirectTo: '/view1'});
}]);

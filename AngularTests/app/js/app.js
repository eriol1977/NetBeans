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
  $routeProvider.otherwise({redirectTo: '/view1'});
}]);

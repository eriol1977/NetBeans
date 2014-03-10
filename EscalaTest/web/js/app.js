'use strict';

angular.module('myApp', [
    'ngRoute',
    'myApp.services',
    'myApp.controllers',
    'myApp.filters'
]).config(['$routeProvider', function($routeProvider) {
        $routeProvider.when('/schedules', {templateUrl: 'schedules.html', controller: 'SchedulesCtrl'});
        $routeProvider.when('/services/:scheduleId', {templateUrl: 'services.html', controller: 'ServicesCtrl'});
        $routeProvider.when('/events/:scheduleId/:serviceId', {templateUrl: 'events.html', controller: 'EventsCtrl'});
        $routeProvider.otherwise({redirectTo: '/schedules'});
    }]);

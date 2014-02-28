'use strict';

var customerServices = angular.module('myApp.services', ['ngResource']);

customerServices.factory('Schedules', function($resource){
    return $resource('http://localhost:8080/CrewMemberBackend/webresources/schedule/:id',{});
});

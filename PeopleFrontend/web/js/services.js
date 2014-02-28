'use strict';

var customerServices = angular.module('myApp.services', ['ngResource']);

customerServices.factory('People', function($resource){
    return $resource('http://localhost:8080/PeopleBackend/webresources/people/:id',{},{
        update: {method:'PUT'}
    });
});

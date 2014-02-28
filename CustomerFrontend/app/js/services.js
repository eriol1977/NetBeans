'use strict';

var customerServices = angular.module('myApp.services', ['ngResource']);

customerServices.factory('Customers', function($resource){
    return $resource('http://localhost:8080/CustomerBackend/webresources/customers/:id',{},{
        query: {method:'GET',isArray:true}
    });
});

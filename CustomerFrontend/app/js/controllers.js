'use strict';

angular.module('myApp.controllers', []).
  controller('CustomerCtrl', function($scope, Customers) {
          $scope.allCustomers = Customers.query();
          $scope.selectCustomer = function(customer)
          {
              $scope.selected = customer;
          };
  });
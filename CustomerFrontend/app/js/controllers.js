'use strict';

angular.module('myApp.controllers', []).
  controller('CustomerCtrl', function($scope, Customers) {
          $scope.allCustomers = Customers.query();
          $scope.selectCustomer = function(customer)
          {
              $scope.selected = customer;
          };
          
          $scope.insertCustomer = function() {
              var customer = new Customers({
                  customerId: "777",
                  name: "Tony Manero SPA",
                  city: "Cincinnati",
                  state: "SC"
              });
              customer.$save(); 
          };
          
          $scope.deleteCustomer = function(customer) {
              Customers.delete({id: customer.customerId});
              //$scope.allCustomers = Customers.query();
          };
          
          $scope.getCustomer = function(id) {
              if(id === undefined)
                  id = "1";
              $scope.gotCustomer = Customers.get({id:id});
          };
  });
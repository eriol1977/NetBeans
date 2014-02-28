'use strict';

angular.module('myApp.controllers', []).
        controller('PeopleCtrl', function($scope, People) {
            refreshModel();
            
            $scope.findPerson = function(id) {
                $scope.foundPerson = People.get({id: id});
            };

            $scope.insertPerson = function(id,name) {
                var person = {pid:id,name:name};
                People.save(person,refreshModel);
            };
            
            $scope.editPerson = function(person,newName) {
                person.name = newName;
                People.update({id: person.pid},person);
            };
           
            $scope.deletePerson = function(id) {
                People.delete({id: id},refreshModel);
            };
           
            function refreshModel() {
                $scope.allPeople = People.query();
            }
        });
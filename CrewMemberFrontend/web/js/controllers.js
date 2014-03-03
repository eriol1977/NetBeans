'use strict';

angular.module('myApp.controllers', []).
        controller('SchedulesCtrl', function($scope, Schedules, EXTENDED_WEEK_DAYS) {
            refreshModel();

            $scope.weekDays = EXTENDED_WEEK_DAYS;

            $scope.sortField = undefined;
            $scope.reverse = false;
            $scope.sort = function(fieldName) {
                if ($scope.sortField === fieldName) {
                    $scope.reverse = !$scope.reverse;
                } else {
                    $scope.sortField = fieldName;
                    $scope.reverse = false;
                }
            };

            $scope.pageNumber = 0;
            $scope.pageSize = 15;
            $scope.pageSizeOptions = new Array(10,15,20,25,30);
            $scope.resetPageNumber = function() {
                $scope.pageNumber = 0;
            };
            $scope.getNumberOfPages = function() {
                if ($scope.filteredSchedules.length === 0)
                    return 0;
                return ($scope.filteredSchedules.length / $scope.pageSize);
            };
            $scope.getPaginationArray = function() {
                var size = $scope.getNumberOfPages();
                if (size === 0)
                    return new Array();
                return new Array(Math.ceil(size));
            };
            $scope.incrementPage = function() {
                if ($scope.assertPageNumber(true))
                    $scope.pageNumber++;
            };
            $scope.decrementPage = function() {
                if ($scope.assertPageNumber(false))
                    $scope.pageNumber--;
            };
            $scope.jumpToPage = function(page) {
                $scope.pageNumber = page;
            };
            $scope.assertPageNumber = function(incrementing) {
                if (incrementing) {
                    return $scope.pageNumber < $scope.getNumberOfPages() - 1;
                } else {
                    return $scope.pageNumber > 0;
                }
            };
            $scope.getNextPreviousCssClass = function(incrementing) {
                return {
                    'disabled': !$scope.assertPageNumber(incrementing)
                };
            };
            $scope.getPageCssClass = function(page) {
                if (page === $scope.pageNumber)
                    return {
                        'background-color': '#99ccff'
                    };
            };


//            $scope.findPerson = function(id) {
//                $scope.foundPerson = People.get({id: id});
//            };
//
//            $scope.insertPerson = function(id,name) {
//                var person = {pid:id,name:name};
//                People.save(person,refreshModel);
//            };
//            
//            $scope.editPerson = function(person,newName) {
//                person.name = newName;
//                People.update({id: person.pid},person);
//            };
//           
//            $scope.deletePerson = function(id) {
//                People.delete({id: id},refreshModel);
//            };

            function refreshModel() {
                $scope.schedules = Schedules.query();
            }
        });
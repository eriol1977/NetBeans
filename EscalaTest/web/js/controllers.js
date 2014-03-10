'use strict';

angular.module('myApp.controllers', []).
        controller('SchedulesCtrl', function($scope, Schedules, TableSort) {
            refreshModel();

            $scope.sortData = new Array(undefined, false);
            $scope.sort = function(fieldName) {
                TableSort.sort(fieldName, $scope.sortData);
            };

            function refreshModel() {
                $scope.loading = true;
                $scope.schedules = Schedules.query({}, function() {
                    $scope.loading = false;
                });
            }

            $scope.getSchedule = function(id) {
                return Schedules.get({id: id});
            };

        }).
        controller('ServicesCtrl', function($scope, $routeParams, Services, TableSort) {

            $scope.sortData = new Array(undefined, false);
            $scope.sort = function(fieldName) {
                TableSort.sort(fieldName, $scope.sortData);
            };

            $scope.loading = true;

            $scope.empty = false;

            $scope.scheduleId = $routeParams.scheduleId;

            $scope.services = Services.query({scheduleId: $routeParams.scheduleId}, function() {
                $scope.loading = false;
                if ($scope.services.length === 0)
                    $scope.empty = true;
            });

        }).
        controller('EventsCtrl', function($scope, $routeParams, Events, TableSort) {

            $scope.sortData = new Array(undefined, false);
            $scope.sort = function(fieldName) {
                TableSort.sort(fieldName, $scope.sortData);
            };

            $scope.loading = true;

            $scope.events = Events.query({scheduleId: $routeParams.scheduleId, crewMemberId: $routeParams.serviceId}, function() {
                $scope.loading = false;
            });

        });
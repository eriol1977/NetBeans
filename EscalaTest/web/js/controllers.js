'use strict';

angular.module('myApp.controllers', []).
        controller('SchedulesCtrl', function($scope, Schedules) {
            refreshModel();

            $scope.orderedCol = 'id';
            $scope.reverse = false;

            $scope.switchPage = function(page) {
                // do something?
            };
            $scope.pageSizeOptions = new Array(10, 15, 20, 25, 30);
            function refreshModel() {
                $scope.loading = true;
                $scope.schedules = Schedules.query({}, function() {
                    $scope.loading = false;
                    $scope.pageSize = 15;
                    $scope.currentPage = 1;
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

            $scope.services = Services.query({scheduleId: $routeParams.scheduleId}, servicesLoaded);

            $scope.alert = {type: 'warning', msg: 'A programação não possui serviços!'};

            function servicesLoaded() {
                $scope.loading = false;
                if ($scope.services.length === 0) {
                    $scope.empty = true;
                }
            };
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
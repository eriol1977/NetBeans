'use strict';

var appService = angular.module('myApp.services', ['ngResource']);

appService.factory('Schedules', function($resource) {
    return $resource('http://localhost:8080/CrewMemberBackend/webresources/schedule/:id', {});
});

appService.factory('WeekDaysService', function() {
    return {
        isDaysCompatible: function(values, mask) {
            var allValues = 127;
            var localValues = values & allValues;
            var localMask = mask & allValues;
            if (localValues === 0 && localMask !== 0)
                return false;
            return ((localValues & localMask) === localValues);
        }
    };
});
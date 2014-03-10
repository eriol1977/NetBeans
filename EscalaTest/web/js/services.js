'use strict';

var appService = angular.module('myApp.services', ['ngResource']);

appService.factory('Schedules', function($resource) {
    return $resource('http://localhost:8096/wplexon-/scalecrew/schedules', {}, {
        query: {
            method: "GET",
            isArray: 'true',
            headers: {'Content-Type': 'application/json; charset=UTF-8'}
        }
    });
});

appService.factory('Services', function($resource) {
    return $resource('http://localhost:8096/wplexon-/scalecrew/crewMembers/:scheduleId', {});
});

appService.factory('Events', function($resource) {
    return $resource('http://localhost:8096/wplexon-/scalecrew/events/:scheduleId/:crewMemberId', {});
});

appService.service('TableSort', function() {
    this.sort = function(fieldName, sortData) {
        if (sortData[0] === fieldName) {
            sortData[1] = !sortData[1];
        } else {
            sortData[0] = fieldName;
            sortData[1] = false;
        }
    };
});
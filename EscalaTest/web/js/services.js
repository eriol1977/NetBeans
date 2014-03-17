'use strict';

var appService = angular.module('myApp.services', ['ngResource']);

appService.factory('Schedules', function($resource) {
    return $resource('http://192.168.0.177:8096/wplexon-/scalecrew/schedules', {});
});

appService.factory('Services', function($resource) {
    return $resource('http://192.168.0.177:8096/wplexon-/scalecrew/crewMembers/:scheduleId', {});
});

appService.factory('Events', function($resource) {
    return $resource('http://192.168.0.177:8096/wplexon-/scalecrew/events/:scheduleId/:crewMemberId', {});
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
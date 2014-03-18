'use strict';

/* Filters */

angular.module('myApp.filters', []).
  filter('interpolate', ['version', function(version) {
    return function(text) {
      return String(text).replace(/\%VERSION\%/mg, version);
    };
  }]).filter('pagination', function() {
    return function(elements, selectedPage, pageSize) {
        var start = (selectedPage - 1) * pageSize;
        return elements.slice(start, start + pageSize);
    };
});

'use strict';

/* Directives */


angular.module('myApp.directives', []).directive('pagination', function() {
    return {
        restrict: 'E',
        scope: {
            numPages: '=',
            currentPage: '='
        },
        template: '<div><ul class="pagination">' +
                '<li ng-class="{disabled: noPrevious()}">' +
                '<a ng-click="selectPrevious()">Previous</a>' +
                '</li>' +
                '<li ng-repeat="page in pages"' +
                'ng-class="{active: isActive(page)}">' +
                '<a ng-click="selectPage(page)">{{page}}</a>' +
                '</li>' +
                '<li ng-class="{disabled: noNext()}">' +
                '<a ng-click="selectNext()">Next</a>' +
                '</li>' +
                '</ul></div>',
        replace: true,
        link: function(scope) {
            scope.$watch('numPages', function(value) {
                scope.pages = [];
                for (var i = 1; i <= value; i++) {
                    scope.pages.push(i);
                }
                if (scope.currentPage > value) {
                    scope.selectPage(value);
                }
            });

            scope.isActive = function(page) {
                return scope.currentPage === page;
            };

            scope.selectPage = function(page) {
                if (!scope.isActive(page)) {
                    scope.currentPage = page;
                }
            };

            scope.noNext = function() {
                return scope.currentPage === scope.numPages;
            };

            scope.noPrevious = function() {
                return scope.currentPage === 1;
            };

            scope.selectNext = function() {
                if (!scope.noNext()) {
                    scope.selectPage(scope.currentPage + 1);
                }
            };

            scope.selectPrevious = function() {
                if (!scope.noPrevious()) {
                    scope.selectPage(scope.currentPage - 1);
                }
            };
        }
    };
}).directive('sort', function() {
    return {
        restrict: 'A',
        transclude: true,
        template:
                '<a ng-click="onClick()">' +
                '<span ng-transclude></span>' +
                '<i class="glyphicon" ng-class="{\'glyphicon-arrow-up\' : orderedCol === by && !reverse,  \'glyphicon-arrow-down\' : orderedCol===by && reverse}"></i>' +
                '</a>',
        scope: {
            orderedCol: '=field',
            by: '=by',
            reverse: '=rev'
        },
        link: function(scope) {
            scope.onClick = function() {
                if (scope.orderedCol === scope.by) {
                    scope.reverse = !scope.reverse;
                } else {
                    scope.by = scope.orderedCol;
                    scope.reverse = false;
                }
            };
        }
    };
});

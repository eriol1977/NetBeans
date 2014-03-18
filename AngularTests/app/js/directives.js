'use strict';

/* Directives */


angular.module('myApp.directives', []).directive('pagination', function() {
    return {
        restrict: 'E',
        scope: {
            numPages: '=',
            currentPage: '=',
            onSelectPage: '&'
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
                    scope.onSelectPage({page: page});
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
}).directive('pagination2', function() {
    return {
        restrict: 'E',
        scope: {
            collection: '=',
            pageSize: '=',
            pageSizeOptions: '=',
            currentPage: '=',
            onSelectPage: '&'
        },
        template: '<div><ul class="pagination">' +
                '<li>' +
                '<a><select ng-model="pageSize" ng-options="page for page in pageSizeOptions">' +
                '<option value="">All</option>' +
                '</select></a>' +
                '</li>' +
                '<li ng-hide="hidePagination()" ng-class="{disabled: noPrevious()}">' +
                '<a ng-click="selectPrevious()">Previous</a>' +
                '</li>' +
                '<li ng-hide="hidePagination()" ng-repeat="page in pages"' +
                'ng-class="{active: isActive(page)}">' +
                '<a ng-click="selectPage(page)">{{page}}</a>' +
                '</li>' +
                '<li ng-hide="hidePagination()" ng-class="{disabled: noNext()}">' +
                '<a ng-click="selectNext()">Next</a>' +
                '</li>' +
                '</ul></div>',
        replace: true,
        link: function(scope) {

            function getCollectionSize()
            {
                return scope.collection.length;
            }
            ;

            function getNumberOfPages() {
                var size = getCollectionSize();
                if (size === 0 || scope.pageSize === null) {
                    scope.pageSize = size;
                    return 1;
                }
                return Math.ceil(size / scope.pageSize);
            }
            ;

            function updatePages()
            {
                var numberOfPages = getNumberOfPages();
                scope.pages = [];
                for (var i = 1; i <= numberOfPages; i++) {
                    scope.pages.push(i);
                }
                if (scope.currentPage > numberOfPages) {
                    scope.selectPage(numberOfPages);
                }
            }
            ;

            scope.hidePagination = function() {
                return getNumberOfPages() === 1;
            };

            scope.$watch('collection', function() {
                updatePages();
            });

            scope.$watch('pageSize', function() {
                updatePages();
            });

            scope.isActive = function(page) {
                return scope.currentPage === page;
            };

            scope.selectPage = function(page) {
                if (!scope.isActive(page)) {
                    scope.currentPage = page;
                    scope.onSelectPage({page: page});
                }
            };

            scope.noNext = function() {
                return scope.currentPage === getNumberOfPages();
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
}).directive('alert', function() {
    return {
        restrict: 'E',
        replace: true,
        transclude: true,
        template:
                '<div ng-hide="hideAlert" class="alert alert-{{alert.type}}">{{alert.msg}}' +
                '<button type="button" class="close">&times;</button>' +
                '<div ng-transclude></div>' +
                '</div>',
        scope: {alert: '='},
        link: function(scope, element) {

            scope.hideAlert = false;

            var closeButton = angular.element(element.children()[0]);
            closeButton.bind("click", hideAlert);

            function hideAlert() {
                scope.$apply('hideAlert = true');
            }
        }
    };
}).directive('accordion', function() {
    return {
        restrict: 'E',
        controller: 'AccordionController',
        link: function(scope, element, attrs) {
            element.addClass('panel-group');
        }
    };
}).directive('accordionGroup', function() {
    return {
        require: '^accordion',
        restrict: 'E',
        transclude: true,
        replace: true,
        template: '<div class="panel-group">' +
                '<div class="panel panel-default" >' +
                '<div class="panel-heading">' +
                '<h4 class="panel-title">' +
                '<a class="accordion-toggle" ng-click="isOpen=!isOpen">{{heading}}</a>' +
                '</h4>' +
                '</div>' +
                '</div>' +
                '<div class="panel-collapse collapse in" ng-show="isOpen">' +
                '<div class="panel-body" ng-transclude></div>' +
                '</div>' +
                '</div>',
        scope: {heading: '@'},
        link: function(scope, element, attrs, accordionCtrl) {
            accordionCtrl.addGroup(scope);
            scope.isOpen = false;
            scope.$watch('isOpen', function(value) {
                if (value) {
                    accordionCtrl.closeOthers(scope);
                }
            });
        }
    };
});

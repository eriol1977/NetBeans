describe('pagination directive', function() {
    var $scope, element, lis;
    beforeEach(module('myApp.directives'));

    beforeEach(inject(function($compile, $rootScope) {
        $scope = $rootScope;
        $scope.numPages = 5;
        $scope.currentPage = 3;
        element = $compile('<pagination num-pages="numPages" current-page="currentPage"></pagination>')($scope);
        $scope.$digest();
        lis = function() {
            return element.find('li');
        };
    }));

    it('has the number of the page as text in each page item',
            function() {
                for (var i = 1; i <= $scope.numPages; i++) {
                    expect(lis().eq(i).text()).toEqual('' + i);
                }
            });

    it('sets the current-page to be active', function() {
        var currentPageItem = lis().eq($scope.currentPage);
        expect(currentPageItem.hasClass('active')).toBe(true);
    });

    it('disables "next" if current-page is num-pages', function() {
        $scope.currentPage = 5;
        $scope.$digest();
        var nextPageItem = lis().eq(-1);
        expect(nextPageItem.hasClass('disabled')).toBe(true);
    });

    it('disables "previous" if current-page is 1', function() {
        $scope.currentPage = 1;
        $scope.$digest();
        var previousPageItem = lis().eq(0);
        expect(previousPageItem.hasClass('disabled')).toBe(true);
    });

    it('changes currentPage if a page link is clicked', function() {
        var page2 = lis().eq(2).find('a').eq(0);
        page2.click();
        $scope.$digest();
        expect($scope.currentPage).toBe(2);
    });

    it('does not change the current page on "next" click if already at last page', function() {
        var next = lis().eq(-1).find('a');
        $scope.currentPage = 5;
        $scope.$digest();
        next.click();
        $scope.$digest();
        expect($scope.currentPage).toBe(5);
    });

    it('does not change the current page on "previous" click if already at first page', function() {
        var previous = lis().eq(0).find('a');
        $scope.currentPage = 1;
        $scope.$digest();
        previous.click();
        $scope.$digest();
        expect($scope.currentPage).toBe(1);
    });

    it('changes the number of items when numPages changes', function() {
        $scope.numPages = 8;
        $scope.$digest();
        expect(lis().length).toBe(10);
        expect(lis().eq(0).text()).toBe('Previous');
        expect(lis().eq(-1).text()).toBe('Next');
    });
});


describe('sort directive', function() {
    var $scope, element, tr, td, linkSortId, linkSortName;
    beforeEach(module('myApp.directives'));

    beforeEach(inject(function($compile, $rootScope) {
        $scope = $rootScope;
        $scope.orderedCol = 'id';
        $scope.reverse = false;
        $scope.items = [
            {id: '1', name: 'Forchetta'},
            {id: '2', name: 'Coltello'},
            {id: '3', name: 'Cucchiaio'},
            {id: '4', name: 'Piatto'},
            {id: '5', name: 'Bicchiere'}
        ];
        element = $compile('<table class="table table-striped table-hover">' +
                '<tr>' +
                '<th sort by="orderedCol" rev="reverse" field="\'id\'">Id</th>' +
                '<th sort by="orderedCol" rev="reverse" field="\'name\'">Name</th>' +
                '</tr>' +
                '<tr ng-repeat="item in items | orderBy:orderedCol:reverse">' +
                '<td>{{item.id}}</td>' +
                '<td>{{item.name}}</td>' +
                '</tr>' +
                '</table>')($scope);
        $scope.$digest();
        tr = function(index) {
            return element.find('tr').eq(index + 1); // +1 para pular o header
        };
        td = function(indexTr, indexTd) {
            return tr(indexTr).find('td').eq(indexTd);
        };
        linkSortId = function() {
            return element.find('a').eq(0);
        };
        linkSortName = function() {
            return element.find('a').eq(1);
        };
    }));

    it('shows items ordered by id when starting',
            function() {
                for (var i = 0; i < $scope.items.length; i++) {
                    expect(td(i, 0).text()).toEqual($scope.items[i].id);
                    expect(td(i, 1).text()).toEqual($scope.items[i].name);
                }
            });

    it('orders by reversed id when clicking the id header',
            function() {
                linkSortId().click();
                $scope.$digest();
                var size = $scope.items.length;
                for (var i = 0; i < size; i++) {
                    expect(td(i, 0).text()).toEqual($scope.items[size - i - 1].id);
                    expect(td(i, 1).text()).toEqual($scope.items[size - i - 1].name);
                }
            });

    it('orders by name when clicking the name header',
            function() {
                linkSortName().click();
                $scope.$digest();
                expect(td(0, 1).text()).toEqual('Bicchiere');
                expect(td(1, 1).text()).toEqual('Coltello');
                expect(td(2, 1).text()).toEqual('Cucchiaio');
                expect(td(3, 1).text()).toEqual('Forchetta');
                expect(td(4, 1).text()).toEqual('Piatto');
            });

    it('orders by reversed name when clicking the name header twice',
            function() {
                linkSortName().click();
                $scope.$digest();
                linkSortName().click();
                $scope.$digest();
                expect(td(0, 1).text()).toEqual('Piatto');
                expect(td(1, 1).text()).toEqual('Forchetta');
                expect(td(2, 1).text()).toEqual('Cucchiaio');
                expect(td(3, 1).text()).toEqual('Coltello');
                expect(td(4, 1).text()).toEqual('Bicchiere');
            });
});
describe('pagination directive', function() {
    var $scope, element, pageItem, pageLink, nextItem, nextLink, previousItem, previousLink, itemsSize;
    beforeEach(module('myApp.directives'));

    beforeEach(inject(function($compile, $rootScope) {
        $scope = $rootScope;
        $scope.items = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23];
        $scope.pageSizeOptions = new Array(5, 10, 15, 30);
        $scope.pageSize = 10;
        $scope.currentPage = 2;
        element = $compile('<pagination2 collection="items" page-size="pageSize" page-size-options="pageSizeOptions" current-page="currentPage"></pagination2>')($scope);
        $scope.$digest();
        pageItem = function(index) {
            return element.find('li').eq(index + 1); // os primeiros dois são a combo e o previous
        };
        pageLink = function(index) {
            return pageItem(index).find('a').eq(0);
        };
        nextItem = function() {
            return element.find('li').eq(-1);
        };
        nextLink = function() {
            return nextItem().find('a').eq(0);
        };
        previousItem = function() {
            return element.find('li').eq(1);
        };
        previousLink = function() {
            return previousItem().find('a').eq(0);
        };
        itemsSize = function() {
            return element.find('li').length - 3;
        };
    }));

    it('has the number of the page as text in each page item', function() {
        expect(pageItem(1).text()).toEqual('1');
        expect(pageItem(2).text()).toEqual('2');
        expect(pageItem(3).text()).toEqual('3');
    });
    
    it('has a Next page item', function() {
        expect(nextItem().text()).toEqual('Next');
    });
    
    it('has a Previous page item', function() {
        expect(previousItem().text()).toEqual('Previous');
    });

    it('sets the current-page to be active', function() {
        var currentPageItem = pageItem($scope.currentPage);
        expect(currentPageItem.hasClass('active')).toBe(true);
    });

    it('disables "next" if current-page is num-pages', function() {
        $scope.currentPage = 3;
        $scope.$digest();
        expect(nextItem().hasClass('disabled')).toBe(true);
    });

    it('disables "previous" if current-page is 1', function() {
        $scope.currentPage = 1;
        $scope.$digest();
        expect(previousItem().hasClass('disabled')).toBe(true);
    });

    it('changes currentPage if a page link is clicked', function() {
        pageLink(2).click();
        $scope.$digest();
        expect($scope.currentPage).toBe(2);
    });

    it('does not change the current page on "next" click if already at last page', function() {
        $scope.currentPage = 3;
        $scope.$digest();
        nextLink().click();
        $scope.$digest();
        expect($scope.currentPage).toBe(3);
    });

    it('does not change the current page on "previous" click if already at first page', function() {
        $scope.currentPage = 1;
        $scope.$digest();
        previousLink().click();
        $scope.$digest();
        expect($scope.currentPage).toBe(1);
    });

    it('changes the number of items when the collection changes', function() {
        expect($scope.pageSize).toBe(10);
        $scope.items = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15];
        $scope.$digest();
        expect(itemsSize()).toBe(2);
    });

    it('executes the onSelectPage expression when the current page changes', inject(function($compile, $rootScope) {
        $rootScope.selectPageHandler = jasmine.createSpy('selectPageHandler');
        element = $compile(
                '<pagination2 collection="items" page-size="pageSize" page-size-options="pageSizeOptions" current-page="currentPage"' +
                ' on-select-page="selectPageHandler(page)">' +
                '</pagination2>')($rootScope);
        $rootScope.$digest();
        pageLink(1).click();
        $rootScope.$digest();
        expect($rootScope.selectPageHandler).toHaveBeenCalledWith(1);
    }));

});
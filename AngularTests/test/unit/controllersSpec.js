describe('ListaCtrl', function() {
    var scope;
    var ctrl;
    beforeEach(module("myApp.controllers"));
    beforeEach(inject(function($rootScope, $controller) {
        scope = $rootScope.$new();
        ctrl = $controller("ListaCtrl", {$scope: scope});
    }));

    it("should have SC as first state", function() {
        expect(scope.states[0].code).toBe('SC');
        expect(scope.states[0].name).toBe('Santa Catarina');
        expect(scope.states[0].region).toBe('South');
    });
});
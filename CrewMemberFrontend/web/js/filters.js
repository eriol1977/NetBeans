angular.module('myApp.filters', []).filter('dateFilter', function() { //201311061016
    return function(inputDate) {
        var dateString = inputDate.toString();
        var formattedDate = dateString.substring(6, 8) + "/" + dateString.substring(4, 6) + "/" + dateString.substring(0, 4);
        if (dateString.length > 8)
            formattedDate += " " + dateString.substring(8, 10) + ":" + dateString.substring(10, 12);
        return formattedDate;
    };
}).filter('weekDayFilter', function() { //31
    return function(inputFlags) {
        if (inputFlags === 31)
            return "ÚTIL";
        else {
            var names = "";
            var WEEK_DAY_VALUES = new Array(1, 2, 4, 8, 16, 32, 64);
            var WEEK_DAY_SHORT_NAMES = new Array("SEG", "TER", "QUA", "QUI", "SEX", "SÁB", "DOM");
            for (var i = 0; i < WEEK_DAY_VALUES.length; i++)
            {
                if (isDaysCompatible(WEEK_DAY_VALUES[i], inputFlags))
                    names += WEEK_DAY_SHORT_NAMES[i] + " ";
            }
            return names;
        }
    };
    
    function isDaysCompatible(values,mask) {
        var allValues = 127;
        var localValues = values & allValues;
        var localMask = mask & allValues;
        if (localValues === 0 && localMask !== 0)
            return false;
        return ((localValues & localMask) === localValues);
    };
});


        

        
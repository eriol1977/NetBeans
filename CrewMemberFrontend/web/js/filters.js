angular.module('myApp.filters', []).filter('dateConverter', function() { //201311061016
    return function(inputDate) {
        var dateString = inputDate.toString();
        var formattedDate = dateString.substring(6, 8) + "/" + dateString.substring(4, 6) + "/" + dateString.substring(0, 4);
        if (dateString.length > 8)
            formattedDate += " " + dateString.substring(8, 10) + ":" + dateString.substring(10, 12);
        return formattedDate;
    };
}).filter('weekDayConverter', function(WEEK_DAYS, WeekDaysService) { //31
    return function(inputFlags) {
        if (inputFlags === 31)
            return "ÚTIL";
        else {
            var names = "";
            for (var i = 0; i < WEEK_DAYS.length; i++)
            {
                if (WeekDaysService.isDaysCompatible(WEEK_DAYS[i].value, inputFlags))
                    names += WEEK_DAYS[i].shortName + " ";
            }
            return names;
        }
    };
}).filter('weekDayFilter', function(EXTENDED_WEEK_DAYS, WeekDaysService) {
    return function(elements, label) {
        if (label === undefined || label === null)
            return elements;

        var selectedWeekDay;
        for (var j = 0; j < EXTENDED_WEEK_DAYS.length; j++) {
            if (EXTENDED_WEEK_DAYS[j].shortName === label)
                selectedWeekDay = EXTENDED_WEEK_DAYS[j];
        }
        var filteredElements = new Array();
        for (var i = 0; i < elements.length; i++) {
            if (WeekDaysService.isDaysCompatible(selectedWeekDay.value, elements[i].flags))
                filteredElements.push(elements[i]);
        }
        return filteredElements;
    };
}).filter('pagination', function() {
    return function(elements, selectedPage, pageSize) {
        var start = selectedPage * pageSize;
        return elements.slice(start, start + pageSize);
    };
});
;




        
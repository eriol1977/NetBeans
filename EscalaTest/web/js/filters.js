angular.module('myApp.filters', []).filter('dateConverter', function() { //201311061016
    return function(inputDate) {
        var dateString = inputDate.toString();
        var formattedDate = dateString.substring(6, 8) + "/" + dateString.substring(4, 6) + "/" + dateString.substring(0, 4);
        if (dateString.length > 8)
            formattedDate += " " + dateString.substring(8, 10) + ":" + dateString.substring(10, 12);
        return formattedDate;
    };
}).filter('timeConverter', function() { //366 --> 06:06
    return function(inputTime) {
        var hours = Math.ceil(inputTime / 60);
        var hoursString = hours.toString();
        if(hours < 10)
            hoursString = "0" + hoursString;
        var minutes = inputTime % 60;
        var minutesString = minutes.toString();
        if(minutes < 10)
            minutesString = "0" + minutesString;
        var formattedTime = hoursString + ":" + minutesString;
        return formattedTime;
    };
}).filter('pagination', function() {
    return function(elements, selectedPage, pageSize) {
        var start = selectedPage * pageSize;
        return elements.slice(start, start + pageSize);
    };
});
;




        
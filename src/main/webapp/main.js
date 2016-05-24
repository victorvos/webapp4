$(document).ready(function() {

    $("#showForm").click(function () {
        $("#countryForm").toggle();
    });

    $("#showList").click(function () {
        $("#countryList").toggle();
    });
    
    $("#all").click(function(){
        $.get("/restservices/countries", function(data) {
            $("#countries").append(data);
            console.log("all!");
        });
    });
    
    $("#populations").click(function(){
        $.get("/restservices/countries/largestpopulations", function(data) {
            $("#countries").append(data);
            console.log("populations!");
        });
    });

    $("#surfaces").click(function(){
        $.get("/restservices/countries/largestsurfaces", function(data) {
            $("#countries").append(data);
            console.log("surfaces!");
        });
    });
    
});
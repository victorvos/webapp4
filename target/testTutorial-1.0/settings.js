var activiteitenItems = "";
var gelegenhedenItems = "";
var instantiesItems = "";
var groepstypenItems = "";
var liedjesItems = "";
var filmersItems = "";
var financienItems = "";

$(document).ready(function(){
    $("#activiteitenTitle").click(function() {
        $.get("/restservices/activiteiten", function (data) {
            console.log(data);
            $(".section").text("");
            $.each(data, function (i, activiteit) {
                activiteitenItems =  " <li class='activiteitItem' id='activiteitItem" + activiteit.ID + "'><form id='activiteit" + activiteit.ID + "'>";
                activiteitenItems += "     <input type='text' name='id" + activiteit.ID + "' value='" + activiteit.ID + "' readonly />";
                activiteitenItems += "     <input type='text' name='naam" + activiteit.ID + "' value='" + activiteit.naam + "' />";
                activiteitenItems += "     <input type='submit' name='submit' value='update' />";
                activiteitenItems += " </form></li>";

                $("#activiteitenSection").append(activiteitenItems);
            });
            activiteitenItems =  "<li><form id='newActiviteit'>";
            activiteitenItems += "  <input type='text' name='naam' placeholder='naam...' />";
            activiteitenItems += "  <input type='submit' name='submit' value='voeg toe' />";
            activiteitenItems += "</from></li>";

            $("#activiteitenSection").append(activiteitenItems);
        });
    });

    $("#gelegenhedenTitle").click(function() {
        $.get("/restservices/gelegenheden", function (data) {
            console.log(data);
            $(".section").text("");
            $.each(data, function (i, gelegenheid) {
                gelegenhedenItems =  " <li class='gelegenheidItem' id='gelegenheidItem" + gelegenheid.ID + "'><form id='gelegenheid" + gelegenheid.ID + "'>";
                gelegenhedenItems += "     <input type='text' name='id' value='" + gelegenheid.ID + "' readonly />";
                gelegenhedenItems += "     <input type='text' name='naam' value='" + gelegenheid.naam + "' />";
                gelegenhedenItems += "     <input type='submit' name='submit' value='update' />";
                gelegenhedenItems += " </form></li>";

                $("#gelegenhedenSection").append(gelegenhedenItems);
            });
            gelegenhedenItems =  "<li>";
            gelegenhedenItems += "  <input type='text' name='naam' placeholder='Name' />";
            gelegenhedenItems += "  <input type='submit' name='submit' value='voeg toe' />";
            gelegenhedenItems += "</li>";

            $("#gelegenhedenSection").append(gelegenhedenItems);
        });
    });

    $("#groepstypenTitle").click(function() {
        $.get("/restservices/groepstypen", function (data) {
            console.log(data);
            $(".section").text("");
            $.each(data, function (i, groepstype) {
                groepstypenItems =  " <li class='groepstypeItem' id='groepstypeItem" + groepstype.ID + "'><form id='groepstype" + groepstype.ID + "'>";
                groepstypenItems += "     <input type='text' name='id" + groepstype.ID + "' value='" + groepstype.ID + "' readonly />";
                groepstypenItems += "     <input type='text' name='naam" + groepstype.ID + "' value='" + groepstype.naam + "' />";
                groepstypenItems += "     <input type='submit' name='submit' value='update' />";
                groepstypenItems += " </li>";

                $("#groepstypenSection").append(groepstypenItems);
            });
            gelegenhedenItems =  "<li>";
            gelegenhedenItems += "  <input type='text' name='naam' placeholder='naam...' />";
            gelegenhedenItems += "  <input type='submit' name='submit' value='voeg toe' />";
            gelegenhedenItems += "</li>";
        });
    });
});

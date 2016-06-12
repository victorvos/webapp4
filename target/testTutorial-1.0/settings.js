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
                activiteitenItems =  " <li class='activiteitItem' id='activiteitItem" + activiteit.ID + "'><form id='activiteitForm" + activiteit.ID + "'>";
                activiteitenItems += "     <input type='text' name='id' value='" + activiteit.ID + "' readonly />";
                activiteitenItems += "     <input type='text' name='naam' value='" + activiteit.naam + "' />";
                activiteitenItems += "     <input type='submit' class='submitActiviteit' id='" + activiteit.ID + "' value='update' />";
                activiteitenItems += " </form></li>";

                $("#activiteitenSection").append(activiteitenItems);
            });
            activiteitenItems =  "<li><form id='newActiviteit'>";
            activiteitenItems += "  <input type='text' name='naam' placeholder='naam' />";
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
            groepstypenItems =  "<li>";
            groepstypenItems += "  <input type='text' name='naam' placeholder='naam' />";
            groepstypenItems += "  <input type='submit' name='submit' value='voeg toe' />";
            groepstypenItems += "</li>";

            $("#groepstypenSection").append(groepstypenItems);
        });
    });

    $("#liedjesTitle").click(function() {
        $.get("/restservices/liedjes", function (data) {
            console.log(data);
            $(".section").text("");
            $.each(data, function (i, liedje) {
                liedjesItems =  " <li class='liedjeItem' id='liedjeItem" + liedje.ID + "'><form id='liedje" + liedje.ID + "'>";
                liedjesItems += "     <input type='text' name='id" + liedje.ID + "' value='" + liedje.ID + "' readonly />";
                liedjesItems += "     <input type='text' name='titel" + liedje.ID + "' value='" + liedje.titel + "' />";
                liedjesItems += "     <input type='text' name='video" + liedje.ID + "' value='" + liedje.video + "' />";
                liedjesItems += "     <input type='text' name='tekst" + liedje.ID + "' value='" + liedje.tekst + "' />";
                liedjesItems += "     <input type='text' name='opmerking" + liedje.ID + "' value='" + liedje.opmerking + "' />";
                liedjesItems += "     <input type='submit' name='submit' value='update' />";
                liedjesItems += " </li>";

                $("#liedjesSection").append(liedjesItems);
            });
            liedjesItems =  "<li>";
            liedjesItems += "  <input type='text' name='titel' placeholder='titel' />";
            liedjesItems += "  <input type='text' name='video' placeholder='video' />";
            liedjesItems += "  <input type='text' name='tekst' placeholder='tekst' />";
            liedjesItems += "  <input type='text' name='opmerking' placeholder='opmerking' />";
            liedjesItems += "  <input type='submit' name='submit' value='voeg toe' />";
            liedjesItems += "</li>";

            $("#liedjesSection").append(liedjesItems);
        });
    });

    $(".submitActiviteit").click(function() {
        $.post( "/restservices/activiteiten/update", $("#activiteitForm" + $(this).attr('id')).serialize(), function(data) {
            $("body").html( data );
            console.log(data);
        });
    });
});

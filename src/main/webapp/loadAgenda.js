var agendaItems = "";
$(document).ready(function() {
    setPage("#register");
});

$("#settingsIcon").click(function () {
    setPage("#settings");
});

$("#historyLink").click(function () {
    setPage("#history");
});

$("#fab").click(function () {
    setPage("#indi");
});

$("#agendaLink").click(function () {
    setPage("#agenda");
    $.get("/restservices/evenementen", function (data) {
        console.log(data);
        $(".section").text("");
        $.each(data, function (i, e) {
            agendaItems =  " <tr class='record' id='agendaItem" + e.eNr.toString().substr(e.eNr.length - 3) + "'>";
            agendaItems += "     <td class='recordToDo'></td>";
            agendaItems += "     <td class='recordName'>" + e.eNr.toString().substr(e.eNr.length - 3) + "</td>";
            agendaItems += "     <td class='recordFilmer'></td>";
            agendaItems += "     <td class='recordType'>" + e.instantie.groepstype.naam + "</td>";
            agendaItems += "     <td class='recordTime'>" + e.begintijd.substr(0, 5) + " - " + e.eindtijd.substr(0, 5) + "</td>";
            agendaItems += "     <td class='recordProgress'>" + e.kans + "%</td>";
            agendaItems += " </tr>";
            $.get("/restservices/filmen/" + e.eNr, function (filmers) {
                console.log(filmers[0].filmer.voornaam);
                console.log(filmers.length - 1);
                if (filmers != null) {
                    $("#agendaItem" + e.eNr.toString().substr(e.eNr.length - 3) + " .recordFilmer").append(filmers[0].filmer.voornaam + " " + filmers[0].filmer.achternaam);
                    if(filmers.length > 1) {
                        $("#agendaItem" + e.eNr.toString().substr(e.eNr.length - 3) + " .recordFilmer").append("" + " (+" + (filmers.length - 1).toString() + ")");
                    }
                }
            });
            $(".section").append(agendaItems).fadeIn('slow');
        });
    });
});

function setPage(page) {
    $("#register").hide();
    $("#agenda").hide();
    $("#indi").hide();
    $("#settings").hide();

    if(page != "#agenda") {
        $("#index").hide();
    }
    else {
        $("#index").show();
    }

    $(page).show();
}
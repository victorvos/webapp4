package boogie;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import java.sql.Date;
import java.sql.Time;

/**
 * Created by larsd on 06-Jun-16.
 */
public class Evenement {
    
    private int eNr = 0;

    private int kans = -1;

    private Date datum = ServiceProvider.getDate();
    private Time begintijd = ServiceProvider.getTime();
    private Time eindtijd = ServiceProvider.getTime();

    private String locatie = "NULL";
    private int afstand = -1;
    private String verrassing = "NULL";
    private String binnenruimte = "NULL";

    private String opmerking = "NULL";

    private Instantie instantie = ServiceProvider.getInstantie();
    private Liedje liedje = ServiceProvider.getLiedje();
    private Gelegenheid gelegenheid = ServiceProvider.getGelegenheid();
    private Activiteit activiteit = ServiceProvider.getActiviteit();
    private Prijs prijs = ServiceProvider.getPrijs();
    private Kosten kosten = ServiceProvider.getKosten();
    private Edit edit = ServiceProvider.getEdit();

    public Evenement(int eNr, int kans, Date datum, Time begintijd, Time eindtijd, String locatie, int afstand, String verrassing, String binnenruimte, String opmerking, Instantie instantie, Liedje liedje, Gelegenheid gelegenheid, Activiteit activiteit, Prijs prijs, Kosten kosten, Edit edit) {
        this.eNr = ((eNr == 0 || eNr == -1) ? 0 : eNr);
        this.kans = ((kans == 0 || kans == -1) ? -1 : kans);
        this.datum = ((datum == null) ? ServiceProvider.getDate() : datum);
        this.begintijd = ((begintijd == null) ? ServiceProvider.getTime() : begintijd);
        this.eindtijd = ((eindtijd == null) ? ServiceProvider.getTime() : eindtijd);
        this.locatie = ((locatie == null) ? "NULL" : locatie);
        this.afstand = ((afstand == 0 || afstand == -1) ? -1 : afstand);
        this.verrassing = ((verrassing == null) ? "NULL" : verrassing);
        this.binnenruimte = ((binnenruimte == null) ? "NULL" : binnenruimte);
        this.opmerking = ((opmerking == null) ? "NULL" : opmerking);
        this.instantie = ((instantie == null) ? ServiceProvider.getInstantie() : instantie);
        this.liedje = ((liedje == null) ? ServiceProvider.getLiedje() : liedje);
        this.gelegenheid = ((gelegenheid == null) ? ServiceProvider.getGelegenheid() : gelegenheid);
        this.activiteit = ((activiteit == null) ? ServiceProvider.getActiviteit() : activiteit);
        this.prijs = ((prijs == null) ? ServiceProvider.getPrijs() : prijs);
        this.kosten = ((kosten == null) ? ServiceProvider.getKosten() : kosten);
        this.edit = ((edit == null) ? ServiceProvider.getEdit() : edit);
    }

    public int geteNr() {
        return eNr;
    }

    public int getKans() {
        return kans;
    }

    public Date getDatum() {
        return datum;
    }

    public Time getBegintijd() {
        return begintijd;
    }

    public Time getEindtijd() {
        return eindtijd;
    }

    public String getLocatie() {
        return locatie;
    }

    public int getAfstand() {
        return afstand;
    }

    public String getVerrassing() {
        return verrassing;
    }

    public String getBinnenruimte() {
        return binnenruimte;
    }

    public String getOpmerking() {
        return opmerking;
    }

    public Instantie getInstantie() {
        return instantie;
    }

    public Liedje getLiedje() {
        return liedje;
    }

    public Gelegenheid getGelegenheid() {
        return gelegenheid;
    }

    public Activiteit getActiviteit() {
        return activiteit;
    }

    public Prijs getPrijs() {
        return prijs;
    }

    public Kosten getKosten() {
        return kosten;
    }

    public Edit getEdit() {
        return edit;
    }

    public JsonObjectBuilder getJsonObject() {
        JsonObjectBuilder job = Json.createObjectBuilder();

        job.add("eNr", eNr);

        job.add("kans", kans);

        job.add("datum", datum.toString());
        job.add("begintijd", begintijd.toString());
        job.add("eindtijd", eindtijd.toString());

        job.add("locatie", locatie);
        job.add("afstand", afstand);
        job.add("verrassing", verrassing);
        job.add("binnenruimte", binnenruimte);

        job.add("opmerking", opmerking);

        job.add("instantie", instantie.getJsonObject());
        job.add("liedje", liedje.getJsonObject());
        job.add("gelegenheid", gelegenheid.getJsonObject());
        job.add("activiteit", activiteit.getJsonObject());
        job.add("prijs", prijs.getJsonObject());
        job.add("kosten", kosten.getJsonObject());
        job.add("edit", edit.getJsonObject());

        return job;
    }
}

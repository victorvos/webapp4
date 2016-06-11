package boogie;

import javax.json.Json;
import javax.json.JsonObjectBuilder;

/**
 * Created by larsd on 06-Jun-16.
 */
public class Filmer {

    private int ID;

    private String achternaam;
    private String voornaam;
    private String opmerking;

    private int aantal_projecten;
    private double verdiend;
    private int loonpercentage;

    private String email;
    private String wachtwoord;
    private String telefoonnummer;

    public Filmer(int ID, String achternaam, String voornaam, String opmerking, int aantal_projecten, double verdiend, int loonpercentage, String email, String wachtwoord, String telefoonnummer) {
        this.ID = ((ID == 0 || ID == -1) ? 0 : ID);
        this.achternaam = ((achternaam == null) ? "NULL" : achternaam);
        this.voornaam = ((voornaam == null) ? "NULL" : voornaam);
        this.opmerking = ((opmerking == null) ? "NULL" : opmerking);
        this.aantal_projecten = ((aantal_projecten == 0 || aantal_projecten == -1) ? 0 : aantal_projecten);
        this.verdiend = ((verdiend == 0 || verdiend == -1) ? 0 : verdiend);
        this.loonpercentage = ((loonpercentage == 0 || loonpercentage == -1) ? 0 : loonpercentage);
        this.email = ((email == null) ? "NULL" : email);
        this.wachtwoord = ((wachtwoord == null) ? "NULL" : wachtwoord);
        this.telefoonnummer = ((telefoonnummer == null) ? "NULL" : telefoonnummer);
    }

    public int getID() {
        return ID;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getOpmerking() {
        return opmerking;
    }

    public int getAantal_projecten() {
        return aantal_projecten;
    }

    public double getVerdiend() {
        return verdiend;
    }

    public int getLoonpercentage() {
        return loonpercentage;
    }

    public String getEmail() {
        return email;
    }

    public String getWachtwoord() {
        return wachtwoord;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public JsonObjectBuilder getJsonObject() {
        JsonObjectBuilder job = Json.createObjectBuilder();

        job.add("ID", ID);
        job.add("achternaam", achternaam);
        job.add("voornaam", voornaam);
        job.add("opmerking", opmerking);
        job.add("aantal_projecten", aantal_projecten);
        job.add("verdiend", verdiend);
        job.add("loonpercentage", loonpercentage);
        job.add("email", email);
        job.add("wachtwoord", wachtwoord);
        job.add("telefoonnummer", telefoonnummer);

        return job;
    }
}

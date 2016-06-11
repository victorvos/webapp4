package boogie;

import javax.json.Json;
import javax.json.JsonObjectBuilder;

/**
 * Created by larsd on 06-Jun-16.
 */
public class Deelnemer {

    private int ID;

    private String naam;
    private String email;
    private String telefoonnummer;
    private boolean contacteerbaar;

    private Instantie instantie;

    public Deelnemer(int ID, String naam, String email, String telefoonnummer, boolean contacteerbaar, Instantie instantie) {
        this.ID = ID;
        this.naam = naam;
        this.email = email;
        this.telefoonnummer = telefoonnummer;
        this.contacteerbaar = contacteerbaar;
        this.instantie = instantie;
    }

    public int getID() {

        return ID;
    }

    public String getNaam() {
        return naam;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefoonnummer() {
        return telefoonnummer;
    }

    public boolean isContacteerbaar() {
        return contacteerbaar;
    }

    public Instantie getInstantie() {
        return instantie;
    }

    public JsonObjectBuilder getJsonObject() {
        JsonObjectBuilder job = Json.createObjectBuilder();

        job.add("ID", ID);
        job.add("naam", naam);
        job.add("email", email);
        job.add("telefoonnummer", telefoonnummer);
        job.add("contacteerbaar", contacteerbaar);

        return job;
    }
}

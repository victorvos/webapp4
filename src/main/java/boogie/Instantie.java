package boogie;

import javax.json.Json;
import javax.json.JsonObjectBuilder;

/**
 * Created by larsd on 06-Jun-16.
 */
public class Instantie {

    private int ID;

    private String naam;
    private int aantal;

    private Groepstype groepstype = ServiceProvider.getGroepstype();

    public Instantie(int ID, String naam, int aantal, Groepstype groepstype) {
        this.ID = ((ID == 0 || ID == -1) ? 0 : ID);
        this.naam = ((naam == null) ? "NULL" : naam);
        this.aantal = ((aantal == 0 || ID == -1) ? 0 : aantal);
        this.groepstype = ((groepstype == null) ? ServiceProvider.getGroepstype() : groepstype);
    }

    public int getID() {
        return ID;
    }

    public String getNaam() {
        return naam;
    }

    public int getAantal() {
        return aantal;
    }

    public Groepstype getGroepstype() {
        return groepstype;
    }

    public JsonObjectBuilder getJsonObject() {
        JsonObjectBuilder job = Json.createObjectBuilder();

        job.add("ID", ID);
        job.add("naam", naam);
        job.add("aantal", aantal);
        job.add("groepstype", groepstype.getJsonObject());

        return job;
    }
}

package boogie;

import javax.json.Json;
import javax.json.JsonObjectBuilder;

/**
 * Created by larsd on 06-Jun-16.
 */
public class Groepstype {

    private int ID;
    private String naam;

    public Groepstype(int ID, String naam) {
        this.ID = ((ID == 0 || ID == -1) ? 0 : ID);
        this.naam = ((naam == null) ? "NULL" : naam);
    }

    public int getID() {
        return ID;
    }

    public String getNaam() {
        return naam;
    }

    public JsonObjectBuilder getJsonObject() {
        JsonObjectBuilder job = Json.createObjectBuilder();

        job.add("ID", ID);
        job.add("naam", naam);

        return job;
    }
}

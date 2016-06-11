package boogie;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import java.sql.Date;

/**
 * Created by larsd on 06-Jun-16.
 */
public class Edit {

    private int ID;

    private String tekst;

    private String demoversie;
    private String eindversie;

    private Date deadline;

    public Edit(int ID, String tekst, String demoversie, String eindversie,Date deadline) {
        this.ID = ID;
        this.tekst = tekst;
        this.demoversie = demoversie;
        this.eindversie = eindversie;
        this.deadline = deadline;
    }

    public int getID() {

        return ID;
    }

    public String getTekst() {
        return tekst;
    }

    public String getDemoversie() {
        return demoversie;
    }

    public String getEindversie() {
        return eindversie;
    }

    public Date getDeadline() {
        return deadline;
    }

    public JsonObjectBuilder getJsonObject() {
        JsonObjectBuilder job = Json.createObjectBuilder();

        job.add("ID", ID);
        job.add("tekst", tekst);
        job.add("demoversie", demoversie);
        job.add("eindversie", eindversie);
        job.add("deadline", deadline.toString());

        return job;
    }
}

package boogie;

import javax.json.Json;
import javax.json.JsonObjectBuilder;

/**
 * Created by larsd on 06-Jun-16.
 */
public class Liedje {

    private int ID;
    private String titel;
    private String video;
    private String opmerking;
    private String tekst;

    public Liedje(int ID, String titel, String video, String opmerking, String tekst) {
        this.ID = ((ID == 0 || ID == -1) ? 0 : ID);
        this.titel = ((titel == null) ? "NULL" : titel);

        this.video = ((video == null) ? "NULL" : video);
        this.opmerking = ((opmerking == null) ? "NULL" : opmerking);
        this.tekst = ((tekst == null) ? "NULL" : tekst);
    }

    public int getID() {
        return ID;
    }

    public String getTitel() {
        return titel;
    }

    public String getVideo() {
        return video;
    }

    public String getOpmerking() {
        return opmerking;
    }

    public String getTekst() {
        return tekst;
    }

    public JsonObjectBuilder getJsonObject() {
        JsonObjectBuilder job = Json.createObjectBuilder();

        job.add("ID", ID);
        job.add("titel", titel);
        job.add("video", video);
        job.add("opmerking", opmerking);
        job.add("tekst", tekst);

        return job;
    }
}

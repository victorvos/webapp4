package boogie;

import javax.json.Json;
import javax.json.JsonObjectBuilder;

/**
 * Created by larsd on 06-Jun-16.
 */
public class Filmt {

    private int filmerStatus;

    private Evenement evenement;
    private Filmer filmer;

    public Filmt(int filmerStatus, Evenement evenement, Filmer filmer) {
        this.filmerStatus = ((filmerStatus == 0 || filmerStatus == -1) ? 0 : filmerStatus);
        this.evenement = ((evenement == null) ? ServiceProvider.getEvenement() : evenement);
        this.filmer = ((filmer == null) ? ServiceProvider.getFilmer() : filmer);
    }

    public int getFilmerStatus() {

        return filmerStatus;
    }

    public Evenement getEvenement() {
        return evenement;
    }

    public Filmer getFilmer() {
        return filmer;
    }


    public JsonObjectBuilder getJsonObject() {
        JsonObjectBuilder job = Json.createObjectBuilder();

        job.add("filmerStatus", filmerStatus);

        job.add("filmer", filmer.getJsonObject());

        return job;
    }
}

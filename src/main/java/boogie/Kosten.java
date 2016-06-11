package boogie;

import javax.json.Json;
import javax.json.JsonObjectBuilder;

/**
 * Created by larsd on 06-Jun-16.
 */
public class Kosten {

    private int ID;

    private double werfing;
    private double planning;
    private double filmer;
    private double edit;
    private double diverse;
    private double reis;

    public Kosten(int ID, double werfing, double planning, double filmer, double edit, double diverse, double reis) {
        this.ID = ID;
        this.werfing = werfing;
        this.planning = planning;
        this.filmer = filmer;
        this.edit = edit;
        this.diverse = diverse;
        this.reis = reis;
    }

    public int getID() {
        return ID;
    }

    public double getWerfing() {
        return werfing;
    }

    public double getPlanning() {
        return planning;
    }

    public double getFilmer() {
        return filmer;
    }

    public double getEdit() {
        return edit;
    }

    public double getDiverse() {
        return diverse;
    }

    public double getReis() {
        return reis;
    }

    public JsonObjectBuilder getJsonObject() {
        JsonObjectBuilder job = Json.createObjectBuilder();

        job.add("ID", ID);
        job.add("werfing", werfing);
        job.add("planning", planning);
        job.add("filmer", filmer);
        job.add("edit", edit);
        job.add("diverse", diverse);
        job.add("reis", reis);

        return job;
    }
}

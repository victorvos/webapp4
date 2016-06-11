package boogie;

import javax.json.Json;
import javax.json.JsonObjectBuilder;
import java.sql.Date;

/**
 * Created by larsd on 06-Jun-16.
 */
public class Prijs {

    private int ID;

    private double basis;
    private double diverse;
    private double korting;
    private double ontvangen;

    private Date gevraagd;
    private Date factuurdatum;
    private Date herinnerings_datum;

    public Prijs(int ID, double basis, double diverse, double korting, double ontvangen, Date gevraagd, Date factuurdatum, Date herinnerings_datum) {
        this.ID = ID;
        this.basis = basis;
        this.diverse = diverse;
        this.korting = korting;
        this.ontvangen = ontvangen;
        this.gevraagd = gevraagd;
        this.factuurdatum = factuurdatum;
        this.herinnerings_datum = herinnerings_datum;
    }

    public int getID() {
        return ID;
    }

    public double getBasis() {
        return basis;
    }

    public double getDiverse() {
        return diverse;
    }

    public double getKorting() {
        return korting;
    }

    public double getOntvangen() {
        return ontvangen;
    }

    public Date getGevraagd() {
        return gevraagd;
    }

    public Date getFactuurdatum() {
        return factuurdatum;
    }

    public Date getHerinnerings_datum() {
        return herinnerings_datum;
    }

    public JsonObjectBuilder getJsonObject() {
        JsonObjectBuilder job = Json.createObjectBuilder();

        job.add("ID", ID);
        job.add("basis", basis);
        job.add("diverse", diverse);
        job.add("korting", korting);
        job.add("ontvangen", ontvangen);
        job.add("gevraagd", gevraagd.toString());
        job.add("factuurdatum", factuurdatum.toString());
        job.add("herinnerings_datum", herinnerings_datum.toString());

        return job;
    }
}

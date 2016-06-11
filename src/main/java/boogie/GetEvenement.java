package boogie;


import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.*;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by larsd on 23-May-16.
 */
@Path("/evenementen")
public class GetEvenement {

    EvenementDAO evenementDAO = ServiceProvider.getEvenementDAO();

    @GET
    @Produces("application/json")
    public String getEvenementen() {
        List<Evenement> evenementen = evenementDAO.getAll();

        return getJsonFromArray(evenementen).build().toString();
    }

    @GET
    @Path("{enr}")
    @Produces("application/json")
    public String getEvenementById(@PathParam("enr") String eNr) {
        ArrayList<Evenement> evenementen = new ArrayList<Evenement>();

        evenementen.add(evenementDAO.getEvenementByID(Integer.parseInt(eNr)));

        return getJsonFromArray(evenementen).build().toString();
    }


    public JsonArrayBuilder getJsonFromArray(List<Evenement> evenementen) {


        JsonArrayBuilder jab = Json.createArrayBuilder();

        for (Evenement evenement : evenementen) {
            jab.add(evenement.getJsonObject());
        }

        return jab;

    }


}

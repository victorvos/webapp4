package boogie;


import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by larsd on 23-May-16.
 */
@Path("/activiteiten")
public class GetActiviteit {

    ActiviteitDAO activiteitDAO = ServiceProvider.getActiviteitDAO();

    @GET
    @Produces("application/json")
    public String getActiviteiten() {
        List<Activiteit> activiteiten = activiteitDAO.getAll();

        return getJsonFromArray(activiteiten).build().toString();
    }


    public JsonArrayBuilder getJsonFromArray(List<Activiteit> activiteiten) {

            JsonArrayBuilder jab = Json.createArrayBuilder();

            for (Activiteit activiteit : activiteiten) {
                jab.add(activiteit.getJsonObject());
            }

            return jab;
    }


}

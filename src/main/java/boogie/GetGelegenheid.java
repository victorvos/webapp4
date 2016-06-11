package boogie;


import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

/**
 * Created by larsd on 23-May-16.
 */
@Path("/gelegenheden")
public class GetGelegenheid {

    GelegenheidDAO gelegenheidDAO = ServiceProvider.getGelegenheidDAO();

    @GET
    @Produces("application/json")
    public String getGelegenheden() {
        List<Gelegenheid> gelegenheden = gelegenheidDAO.getAll();

        return getJsonFromArray(gelegenheden).build().toString();
    }


    public JsonArrayBuilder getJsonFromArray(List<Gelegenheid> gelegenheden) {

            JsonArrayBuilder jab = Json.createArrayBuilder();

            for (Gelegenheid gelegenheid : gelegenheden) {
                jab.add(gelegenheid.getJsonObject());
            }

            return jab;
    }


}

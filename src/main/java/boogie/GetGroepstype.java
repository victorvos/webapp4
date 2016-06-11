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
@Path("/groepstypen")
public class GetGroepstype {

    GroepstypeDAO groepstypeDAO = ServiceProvider.getGroepstypeDAO();

    @GET
    @Produces("application/json")
    public String getGroepstypen() {
        List<Groepstype> groepstypen = groepstypeDAO.getAll();

        return getJsonFromArray(groepstypen).build().toString();
    }


    public JsonArrayBuilder getJsonFromArray(List<Groepstype> groepstypen) {

            JsonArrayBuilder jab = Json.createArrayBuilder();

            for (Groepstype groepstype : groepstypen) {
                jab.add(groepstype.getJsonObject());
            }

            return jab;
    }


}

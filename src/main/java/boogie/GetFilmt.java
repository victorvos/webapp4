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
@Path("/filmen")
public class GetFilmt {

    FilmtDAO filmtDAO = ServiceProvider.getFilmtDAO();

    @GET
    @Path("{enr}")
    @Produces("application/json")
    public String getFilmersById(@PathParam("enr") String eNr) {
        return getJsonFromArray(filmtDAO.getAllByEnr(Integer.parseInt(eNr))).build().toString();
    }


    public JsonArrayBuilder getJsonFromArray(List<Filmt> filmers) {

        JsonArrayBuilder jab = Json.createArrayBuilder();

        for (Filmt e : filmers) {
            jab.add(e.getJsonObject());
        }

        return jab;

    }


}

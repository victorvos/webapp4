package worldmap.persistence;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;


/**
 * Created by larsd on 23-May-16.
 */
@Path("/countries")
public class GetCountries {

    CountryDAO countryDAO = ServiceProvider.getCountryDAO();

    @GET
    @Produces("application/json")
    public String getCountries() {
        List<Country> countries = countryDAO.findAll();

        return getJsonFromArray(countries).build().toString();
    }

//    @GET
//    @Produces("application/json")
//    public String getCountryById(@QueryParam("code") String code) {
//        ArrayList<Country> countries = new ArrayList<Country>();
//        countries.add(countryDAO.findByCode(code));
//
//        return getJsonFromArray(countries).toString();
//    }

    @GET
    @Path("/largestsurfaces")
    @Produces("application/json")
    public String getLargestSurfaces() {
        List<Country> countries = countryDAO.find10LargestSurfaces();

        return getJsonFromArray(countries).build().toString();
    }

    @GET
    @Path("/largestpopulations")
    @Produces("application/json")
    public String getLargestPopulations() {
        List<Country> countries = countryDAO.find10LargestPopulations();

        return getJsonFromArray(countries).build().toString();
    }



    public JsonArrayBuilder getJsonFromArray(List<Country> countries) {


        JsonArrayBuilder jab = Json.createArrayBuilder();

        for (Country c : countries) {
            JsonObjectBuilder job = Json.createObjectBuilder();

            job.add("code", c.getCode());
            job.add("name", c.getName());
            job.add("continent", c.getContinent());
            job.add("region", c.getRegion());
            job.add("surface", c.getSurface());
            job.add("population", c.getPopulation());
            job.add("government", c.getGovernmentForm());

            jab.add(job);
        }

        return jab;
    }


}

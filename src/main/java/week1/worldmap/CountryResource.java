package week1.worldmap;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/countries")
public class CountryResource {

    CountryDAO countryDAO = ServiceProvider.getCountryDAO();

    @GET
    @Produces("application/json")
    public String getCountries() {

        List<Country> countries = countryDAO.findAll();

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
        return jab.build().toString();
    }
//
//    @GET
//    @Path("/save")
//    @Produces("application/json")
//    public String save(Country c) {
//        countryDAO.save(c);
//        return c.toString();
//    }

    @GET
    @Path("/largestpopulations")
    @Produces("application/json")
    public String getLargestPopulations() {
        List<Country> countries = countryDAO.findbylargestPopulation();

        JsonArrayBuilder jab = Json.createArrayBuilder();

        for (Country c : countries) {
            JsonObjectBuilder job = Json.createObjectBuilder();
            job.add("name", c.getName());
            job.add("populations", c.getPopulation());
            jab.add(job);
        }
        return jab.build().toString();
    }

    @GET
    @Path("/largestsurfaces")
    @Produces("application/json")
    public String getLargestSurfaces() {
        List<Country> countries = countryDAO.findbylargestSurface();

        JsonArrayBuilder jab = Json.createArrayBuilder();

        for (Country c : countries) {
            JsonObjectBuilder job = Json.createObjectBuilder();
            job.add("name", c.getName());
            job.add("surface", c.getSurface());
            jab.add(job);
        }
        return jab.build().toString();
    }
}
package worldmap.persistence;

/**
 * Created by larsd on 23-May-16.
 */
public class ServiceProvider {
    private static CountryDAO countryDAO = new CountryDAO();

    public static CountryDAO getCountryDAO() {
        return countryDAO;
    }
}

package worldmap.persistence;


public class ServiceProvider {
    private static CountryDAO countryDAO = new CountryDAO();

    public static CountryDAO getCountryDAO() {
        return countryDAO;
    }
}

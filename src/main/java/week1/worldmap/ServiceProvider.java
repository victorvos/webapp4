package week1.worldmap;

public class ServiceProvider {
	private static CountryDAO countryDAO = new CountryDAO();

	public static CountryDAO getCountryDAO() {
		return countryDAO;
	}
}
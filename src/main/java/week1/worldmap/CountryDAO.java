package week1.worldmap;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class CountryDAO extends BaseDAO {
    private List<Country> selectCustomers(String query) {
        List<Country> results = new ArrayList<Country>();
        try (Connection con = super.getConnection()){
            Statement stmt = con.createStatement();
            ResultSet dbResultSet = stmt.executeQuery(query);
            while (dbResultSet.next()) {
                String code = dbResultSet.getString("code");
                String name = dbResultSet.getString("name");
                String continent = dbResultSet.getString("continent");
                String region = dbResultSet.getString("region");
                double surface = dbResultSet.getDouble("surface");
                int population = dbResultSet.getInt("population");
                String government = dbResultSet.getString("government");
                Country newCountry = new Country(code, name, continent, region, surface, population, government);
                results.add(newCountry);

            }
        } catch (SQLException sqle) { sqle.printStackTrace(); }
        return results;
    }

    public List<Country> findAll(){
        return selectCustomers("SELECT code, name, continent, region, surface, population, goverment");
    }
    public Country findByCode(String code2){
        return selectCustomers("SELECT code2, name, continent, region, surface, population, goverment").get(0);
    }

    public boolean deleteCOuntry(Country c){
        boolean result = false;
        boolean customerreality = findByCode(c.getCode()) != null;

        if (customerreality) {
            String query = "DELETE FROM country WHERE code = " +c.getCode();

            try (Connection con = getConnection()) {

                Statement stmt = con.createStatement();
                if (stmt.executeUpdate(query) == 1) { // 1 row updated!
                    result = true;
                }
            } catch (SQLException sqle) {
                sqle.printStackTrace();
            }
        }

        return result;
    }

    public List<Country> findbylargestSurface(){
        return selectCustomers("SELECT * FROM country ORDER BY surface DESC LIMIT 10");
    }
    public List<Country> findbylargestPopulation(){
        return selectCustomers("SELECT * FROM country ORDER BY population DESC LIMIT 10");
    }

    public List<Country> find10LargestPopulations() {
        return selectCustomers("SELECT * FROM country ORDER BY population DESC LIMIT 10");
    }
    public List<Country> find10LargestSurfaces() {
        return selectCustomers("SELECT * FROM country ORDER BY population DESC LIMIT 10");
    }

}

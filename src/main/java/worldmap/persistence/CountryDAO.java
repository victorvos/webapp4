package worldmap.persistence;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by larsd on 23-May-16.
 */
public class CountryDAO extends BaseDAO {

    public List<Country> findAll() {
        return selectCountries("SELECT * FROM country");
    }

    public List<Country> find10LargestPopulations() {
        return selectCountries("SELECT * FROM country ORDER BY population DESC LIMIT 10");
    }

    public List<Country> find10LargestSurfaces() {
        return selectCountries("SELECT * FROM country ORDER BY surfaceArea DESC LIMIT 10");
    }

    public Country findByCode(String code) {
        return selectCountries("SELECT * FROM country WHERE code=" + code).get(0);
    }

    public Country save(Country country) {

        try (Connection con = super.getConnection()) {

            String code = country.getCode();
            String name = country.getName();
            String continent = country.getContinent();
            String region = country.getRegion();
            int population = country.getPopulation();
            double surface = country.getSurface();
            String governmentForm = country.getGovernmentForm();

            Statement statement = con.createStatement();
            statement.executeQuery("INSERT INTO country (code,name,continent,region,population,surfaceArea,governmentForm) VALUES(" + code + "," + name + "," + continent + "," + region+ "," + population+ "," + surface+ "," + governmentForm + ")");

        }catch (SQLException sqle) { sqle.printStackTrace(); }

        return country;
    }

    private List<Country> selectCountries(String query) {

        List<Country> results = new ArrayList<Country>();

        try (Connection con = super.getConnection()){

            Statement stmt = con.createStatement();
            ResultSet dbResultSet = stmt.executeQuery(query);

            while (dbResultSet.next()) {

                String code = dbResultSet.getString("code");
                String name = dbResultSet.getString("name");
                String continent = dbResultSet.getString("continent");
                String region = dbResultSet.getString("region");
                int population = dbResultSet.getInt("population");
                double surface = dbResultSet.getDouble("surfaceArea");
                String governmentForm = dbResultSet.getString("governmentForm");

                results.add(new Country(code,name,continent,region,surface,population,governmentForm));
            }
        } catch (SQLException sqle) { sqle.printStackTrace(); }

        return results;
    }

    public Country update(Country country) {

        try(Connection con = super.getConnection()) {

            String code = country.getCode();
            String name = country.getName();
            String continent = country.getContinent();
            String region = country.getRegion();
            int population = country.getPopulation();
            double surface = country.getSurface();
            String governmentForm = country.getGovernmentForm();

            Statement statement = con.createStatement();
            statement.executeQuery("UPDATE country SET name="+name+", continent="+continent+", region="+region+", population="+population+", surfaceArea="+surface+", governmentForm="+governmentForm+" WHERE code="+code);

        }catch (SQLException sqle) { sqle.printStackTrace(); }

        return country;

    }

    public boolean delete(Country country) {

        try(Connection con = super.getConnection()) {

            Statement stmt = con.createStatement();
            if(stmt.executeQuery("DELETE FROM country WHERE code=" + country.getCode()) != null) {
                return true;
            }

        }catch (SQLException sqle) { sqle.printStackTrace(); }
        return false;

    }

}

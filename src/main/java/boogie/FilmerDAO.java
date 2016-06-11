package boogie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by larsd on 06-Jun-16.
 */
public class FilmerDAO extends BaseDAO {

    public Filmer getFilmerByID(int filmerID) {
        List<Filmer> i = select("select * from filmer where ID =" + filmerID);
        if(i.size() > 0) {
            return i.get(0);
        }
        return null;
    }
    
    public Filmer save(Filmer filmer) {

        try (Connection con = super.getConnection()) {

            int ID = filmer.getID();
            String achternaam = filmer.getAchternaam();
            String opmerking = filmer.getOpmerking();
            int aantal_projecten = filmer.getAantal_projecten();
            double verdiend = filmer.getVerdiend();
            int loonpercentage = filmer.getLoonpercentage();
            String wachtwoord = filmer.getWachtwoord();
            String email = filmer.getEmail();
            String telefoonnummer = filmer.getTelefoonnummer();
            String voornaam = filmer.getVoornaam();

            Statement statement = con.createStatement();
            statement.executeQuery(
                    "INSERT INTO filmer "
                            + "("
                            + "ID,"
                            + "achternaam,"
                            + "opmerking,"
                            + "aantal_projecten,"
                            + "verdiend,"
                            + "loonpercentage,"
                            + "wachtwoord,"
                            + "email,"
                            + "telefoonnummer,"
                            + "voornaam"
                            + ")"
                            + "VALUES("
                            + ID + ","
                            + achternaam + ","
                            + opmerking + ","
                            + aantal_projecten + ","
                            + verdiend + ","
                            + loonpercentage + ","
                            + wachtwoord + ","
                            + email + ","
                            + telefoonnummer + ","
                            + voornaam + ")"
            );

        }catch (SQLException sqle) { sqle.printStackTrace(); }

        return filmer;
    }

    private List<Filmer> select(String query) {

        List<Filmer> results = new ArrayList<Filmer>();

        try (Connection con = super.getConnection()){

            Statement stmt = con.createStatement();
            ResultSet dbResultSet = stmt.executeQuery(query);

            while (dbResultSet.next()) {
                int ID = dbResultSet.getInt("ID");
                String achternaam = dbResultSet.getString("Achternaam");
                String opmerking = dbResultSet.getString("Opmerking");
                int aantal_projecten = dbResultSet.getInt("Aantal_projecten");
                double verdiend = dbResultSet.getDouble("Verdiend");
                int loonpercentage = dbResultSet.getInt("Loonpercentage");
                String wachtwoord = dbResultSet.getString("Wachtwoord");
                String email = dbResultSet.getString("email");
                String telefoonnummer = dbResultSet.getString("telefoonnummer");
                String voornaam = dbResultSet.getString("voornaam");

                results.add(new Filmer(ID,achternaam,voornaam,opmerking,aantal_projecten,verdiend,loonpercentage,email,wachtwoord,telefoonnummer));
            }
        } catch (SQLException sqle) { sqle.printStackTrace(); }

        return results;
    }

    public Filmer update(Filmer filmer) {

        try(Connection con = super.getConnection()) {

            int ID = filmer.getID();
            String achternaam = filmer.getAchternaam();
            String opmerking = filmer.getOpmerking();
            int aantal_projecten = filmer.getAantal_projecten();
            double verdiend = filmer.getVerdiend();
            int loonpercentage = filmer.getLoonpercentage();
            String wachtwoord = filmer.getWachtwoord();
            String email = filmer.getEmail();
            String telefoonnummer = filmer.getTelefoonnummer();
            String voornaam = filmer.getVoornaam();


            Statement statement = con.createStatement();

            statement.executeQuery(
                    "UPDATE filmer SET"
                    +" achternaam="             +achternaam
                    +",opmerking="              +opmerking
                    +",aantal_projecten="       +aantal_projecten
                    +",verdiend="               +verdiend
                    +",loonpercentage="         +loonpercentage
                    +",wachtwoord="             +wachtwoord
                    +",email="                  +email
                    +",telefoonnummer="         +telefoonnummer
                    +",voornaam="               +voornaam
                    +" WHERE ID="               +ID
            );

        }catch (SQLException sqle) { sqle.printStackTrace(); }

        return filmer;

    }

    public boolean delete(Filmer filmer) {

        try(Connection con = super.getConnection()) {

            Statement stmt = con.createStatement();
            if(stmt.executeQuery("DELETE FROM filmer WHERE ID=" + filmer.getID()) != null) {
                return true;
            }

        }catch (SQLException sqle) { sqle.printStackTrace(); }
        return false;

    }
    
}

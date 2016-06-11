package boogie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by larsd on 06-Jun-16.
 */
public class DeelnemerDAO extends BaseDAO {

    InstantieDAO instantieDAO = ServiceProvider.getInstantieDAO();

    public Deelnemer getDeelnemerByID(int deelnemerID) {
        List<Deelnemer> i = select("select * from deelnemer where ID =" + deelnemerID);
        if(i.size() > 0) {
            return i.get(0);
        }
        return null;
    }

    public Deelnemer save(Deelnemer deelnemer) {

        try (Connection con = super.getConnection()) {

            int ID = deelnemer.getID();
            String naam = deelnemer.getNaam();
            String email = deelnemer.getEmail();
            String telefoonnummer = deelnemer.getTelefoonnummer();
            boolean contacteerbaar = deelnemer.isContacteerbaar();

            int instantieID = deelnemer.getInstantie().getID();

            Statement statement = con.createStatement();
            statement.executeQuery(
                    "INSERT INTO deelnemer"
                            + "("
                            + "ID,"
                            + "naam,"
                            + "email,"
                            + "telefoonnummer,"
                            + "contacteerbaar,"
                            + "instantie_ID"
                            + ")"
                            + " VALUES("
                            + ID + ","
                            + naam + ","
                            + email + ","
                            + telefoonnummer + ","
                            + contacteerbaar + ","
                            + instantieID + ")"
            );

        }catch (SQLException sqle) { sqle.printStackTrace(); }

        return deelnemer;
    }

    private List<Deelnemer> select(String query) {

        List<Deelnemer> results = new ArrayList<Deelnemer>();

        try (Connection con = super.getConnection()){

            Statement stmt = con.createStatement();
            ResultSet dbResultSet = stmt.executeQuery(query);

            while (dbResultSet.next()) {
                int ID = dbResultSet.getInt("ID");
                String naam = dbResultSet.getString("Naam");
                String email = dbResultSet.getString("Email");
                String telefoonnummer = dbResultSet.getString("telefoonnummer");
                boolean contacteerbaar = dbResultSet.getBoolean("contacteerbaar");

                int instantieID = dbResultSet.getInt("Instantie_ID");
                Instantie instantie = instantieDAO.getInstantieByID(instantieID);

                results.add(new Deelnemer(ID,naam,email,telefoonnummer,contacteerbaar,instantie));
            }
        } catch (SQLException sqle) { sqle.printStackTrace(); }

        return results;
    }

    public Deelnemer update(Deelnemer deelnemer) {

        try(Connection con = super.getConnection()) {

            int ID = deelnemer.getID();
            String naam = deelnemer.getNaam();
            String email = deelnemer.getEmail();
            String telefoonnummer = deelnemer.getTelefoonnummer();
            boolean contacteerbaar = deelnemer.isContacteerbaar();
            int instantieID = deelnemer.getInstantie().getID();

            Statement statement = con.createStatement();

            statement.executeQuery(
                    "UPDATE deelnemer SET"
                    +" naam="           +naam
                    +",email="          +email
                    +",telefoonnummer=" +telefoonnummer
                    +",contacteerbaar=" +contacteerbaar
                    +",instantie_ID="      +instantieID
                    +" WHERE ID="       +ID
            );

        }catch (SQLException sqle) { sqle.printStackTrace(); }

        return deelnemer;

    }

    public boolean delete(Deelnemer deelnemer) {

        try(Connection con = super.getConnection()) {

            Statement stmt = con.createStatement();
            if(stmt.executeQuery("DELETE FROM deelnemer WHERE ID=" + deelnemer.getID()) != null) {
                return true;
            }

        }catch (SQLException sqle) { sqle.printStackTrace(); }
        return false;

    }
    
}

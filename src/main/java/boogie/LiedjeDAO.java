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
public class LiedjeDAO extends BaseDAO {

    public Liedje getLiedjeByID(int liedjeID) {
        List<Liedje> i = select("select * from liedje where ID =" + liedjeID);
        if(i.size() > 0) {
            return i.get(0);
        }
        return null;
    }
    
    public Liedje save(Liedje liedje) {

        try (Connection con = super.getConnection()) {

            int ID = liedje.getID();
            String titel = liedje.getTitel();
            String video = liedje.getVideo();
            String opmerking = liedje.getOpmerking();
            String tekst = liedje.getTekst();

            Statement statement = con.createStatement();
            statement.executeQuery(
                    "INSERT INTO liedje "
                            + "("
                            + "ID,"
                            + "titel,"
                            + "video,"
                            + "opmerking,"
                            + "tekst"
                            + ")"
                            + "VALUES("
                            + ID + ","
                            + titel + ","
                            + video + ","
                            + opmerking + ","
                            + tekst + ")"
            );

        }catch (SQLException sqle) { sqle.printStackTrace(); }

        return liedje;
    }

    private List<Liedje> select(String query) {

        List<Liedje> results = new ArrayList<Liedje>();

        try (Connection con = super.getConnection()){

            Statement stmt = con.createStatement();
            ResultSet dbResultSet = stmt.executeQuery(query);

            while (dbResultSet.next()) {
                int ID = dbResultSet.getInt("ID");
                String titel = dbResultSet.getString("Titel");
                String video = dbResultSet.getString("Video");
                String opmerking = dbResultSet.getString("Opmerking");
                String tekst = dbResultSet.getString("Tekst");

                results.add(new Liedje(ID,titel,video,opmerking,tekst));
            }
        } catch (SQLException sqle) { sqle.printStackTrace(); }

        return results;
    }

    public Liedje update(Liedje liedje) {

        try(Connection con = super.getConnection()) {

            int ID = liedje.getID();
            String titel = liedje.getTitel();
            String video = liedje.getVideo();
            String opmerking = liedje.getOpmerking();
            String tekst = liedje.getTekst();

            Statement statement = con.createStatement();

            statement.executeQuery(
                    "UPDATE liedje SET"
                    +" titel="      +titel
                    +",video="      +video
                    +",opmerking="  +opmerking
                    +",tekst="      +tekst
                    +" WHERE ID="   +ID
            );

        }catch (SQLException sqle) { sqle.printStackTrace(); }

        return liedje;

    }

    public boolean delete(Liedje liedje) {

        try(Connection con = super.getConnection()) {

            Statement stmt = con.createStatement();
            if(stmt.executeQuery("DELETE FROM liedje WHERE ID=" + liedje.getID()) != null) {
                return true;
            }

        }catch (SQLException sqle) { sqle.printStackTrace(); }
        return false;

    }
    
}

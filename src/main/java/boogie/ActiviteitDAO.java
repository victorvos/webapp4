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
public class ActiviteitDAO extends BaseDAO {

    public Activiteit getActiviteitByID(int activiteitID) {
        List<Activiteit> i = select("select * from activiteit where ID =" + activiteitID);
        if(i.size() > 0) {
            return i.get(0);
        }
        return null;
    }

    public List<Activiteit> getAll() {
        List<Activiteit> i = select("select * from activiteit");
        if(i.size() > 0) {
            return i;
        }
        return null;
    }
    
    public Activiteit save(Activiteit activiteit) {

        try (Connection con = super.getConnection()) {

            int ID = activiteit.getID();
            String naam = activiteit.getNaam();

            Statement statement = con.createStatement();
            statement.executeQuery(
                    "INSERT INTO activiteit "
                            + "("
                            + "ID,"
                            + "naam"
                            + ")"
                            + "VALUES("
                            + ID + ","
                            + naam + ")"
            );

        }catch (SQLException sqle) { sqle.printStackTrace(); }

        return activiteit;
    }

    private List<Activiteit> select(String query) {

        List<Activiteit> results = new ArrayList<Activiteit>();

        try (Connection con = super.getConnection()){

            Statement stmt = con.createStatement();
            ResultSet dbResultSet = stmt.executeQuery(query);

            while (dbResultSet.next()) {
                int ID = dbResultSet.getInt("ID");
                String naam = dbResultSet.getString("naam");

                results.add(new Activiteit(ID,naam));
            }
        } catch (SQLException sqle) { sqle.printStackTrace(); }

        return results;
    }

    public Activiteit update(Activiteit activiteit) {

        try(Connection con = super.getConnection()) {

            int ID = activiteit.getID();
            String naam = activiteit.getNaam();

            Statement statement = con.createStatement();

            statement.executeQuery(
                    "UPDATE activiteit SET"
                            +" naam="       +naam
                            +" WHERE ID="   +ID
            );

        }catch (SQLException sqle) { sqle.printStackTrace(); }

        return activiteit;

    }

    public boolean delete(Activiteit activiteit) {

        try(Connection con = super.getConnection()) {

            Statement stmt = con.createStatement();
            if(stmt.executeQuery("DELETE FROM activiteit WHERE ID=" + activiteit.getID()) != null) {
                return true;
            }

        }catch (SQLException sqle) { sqle.printStackTrace(); }
        return false;

    }

}

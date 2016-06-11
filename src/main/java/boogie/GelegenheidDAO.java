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
public class GelegenheidDAO extends BaseDAO {

    public Gelegenheid getGelegenheidByID(int gelegenheidID) {
        List<Gelegenheid> i = select("select * from gelegenheid where ID =" + gelegenheidID);
        if(i.size() > 0) {
            return i.get(0);
        }
        return null;
    }

    public List<Gelegenheid> getAll() {
        List<Gelegenheid> i = select("select * from gelegenheid");
        if(i.size() > 0) {
            return i;
        }
        return null;
    }
    
    public Gelegenheid save(Gelegenheid gelegenheid) {

        try (Connection con = super.getConnection()) {

            int ID = gelegenheid.getID();
            String naam = gelegenheid.getNaam();

            Statement statement = con.createStatement();
            statement.executeQuery(
                    "INSERT INTO gelegenheid "
                            + "("
                            + "ID,"
                            + "naam"
                            + ")"
                            + "VALUES("
                            + ID + ","
                            + naam + ")"
            );

        }catch (SQLException sqle) { sqle.printStackTrace(); }

        return gelegenheid;
    }

    private List<Gelegenheid> select(String query) {

        List<Gelegenheid> results = new ArrayList<Gelegenheid>();

        try (Connection con = super.getConnection()){

            Statement stmt = con.createStatement();
            ResultSet dbResultSet = stmt.executeQuery(query);

            while (dbResultSet.next()) {
                int ID = dbResultSet.getInt("ID");
                String naam = dbResultSet.getString("naam");

                results.add(new Gelegenheid(ID,naam));
            }
        } catch (SQLException sqle) { sqle.printStackTrace(); }

        return results;
    }

    public Gelegenheid update(Gelegenheid gelegenheid) {

        try(Connection con = super.getConnection()) {

            int ID = gelegenheid.getID();
            String naam = gelegenheid.getNaam();

            Statement statement = con.createStatement();

            statement.executeQuery(
                    "UPDATE gelegenheid SET"
                            +" naam="       +naam
                            +" WHERE ID="   +ID
            );

        }catch (SQLException sqle) { sqle.printStackTrace(); }

        return gelegenheid;

    }

    public boolean delete(Gelegenheid gelegenheid) {

        try(Connection con = super.getConnection()) {

            Statement stmt = con.createStatement();
            if(stmt.executeQuery("DELETE FROM gelegenheid WHERE ID=" + gelegenheid.getID()) != null) {
                return true;
            }

        }catch (SQLException sqle) { sqle.printStackTrace(); }
        return false;

    }
    
}

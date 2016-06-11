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
public class GroepstypeDAO extends BaseDAO {


    public Groepstype getGroepstypeByID(int groepstypeID) {
        List<Groepstype> i = select("select * from groepstype where ID =" + groepstypeID);
        if(i.size() > 0) {
            return i.get(0);
        }
        return null;
    }

    public List<Groepstype> getAll() {
        List<Groepstype> i = select("select * from groepstype");
        if(i.size() > 0) {
            return i;
        }
        return null;
    }

    public Groepstype save(Groepstype groepstype) {

        try (Connection con = super.getConnection()) {

            int ID = groepstype.getID();
            String naam = groepstype.getNaam();

            Statement statement = con.createStatement();
            statement.executeQuery(
                    "INSERT INTO groepstype"
                            + "("
                            + "ID"
                            + "naam"
                            + ")"
                            + "VALUES("
                            + ID + ","
                            + naam + ")"
            );

        }catch (SQLException sqle) { sqle.printStackTrace(); }

        return groepstype;
    }

    private List<Groepstype> select(String query) {

        List<Groepstype> results = new ArrayList<Groepstype>();

        try (Connection con = super.getConnection()){

            Statement stmt = con.createStatement();
            ResultSet dbResultSet = stmt.executeQuery(query);

            while (dbResultSet.next()) {
                int ID = dbResultSet.getInt("ID");
                String naam = dbResultSet.getString("naam");

                results.add(new Groepstype(ID,naam));
            }
        } catch (SQLException sqle) { sqle.printStackTrace(); }

        return results;
    }

    public Groepstype update(Groepstype groepstype) {

        try(Connection con = super.getConnection()) {

            int ID = groepstype.getID();
            String naam = groepstype.getNaam();

            Statement statement = con.createStatement();

            statement.executeQuery(
                    "UPDATE groepstype SET"
                            +" naam="       +naam
                            +" WHERE ID="   +ID
            );

        }catch (SQLException sqle) { sqle.printStackTrace(); }

        return groepstype;

    }

    public boolean delete(Groepstype groepstype) {

        try(Connection con = super.getConnection()) {

            Statement stmt = con.createStatement();
            if(stmt.executeQuery("DELETE FROM groepstype WHERE ID=" + groepstype.getID()) != null) {
                return true;
            }

        }catch (SQLException sqle) { sqle.printStackTrace(); }
        return false;

    }
    
}

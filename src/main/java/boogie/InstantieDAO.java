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
public class InstantieDAO extends BaseDAO {

    GroepstypeDAO groepstypeDAO = ServiceProvider.getGroepstypeDAO();

    public Instantie getInstantieByID(int instantieID) {
        List<Instantie> i = select("select * from instantie where ID =" + instantieID);
        if(i.size() > 0) {
            return i.get(0);
        }
        return null;
    }

    public Instantie save(Instantie instantie) {

        try (Connection con = super.getConnection()) {

            int ID = instantie.getID();
            String naam = instantie.getNaam();
            int aantal = instantie.getAantal();
            int groepstypeID = instantie.getGroepstype().getID();

            Statement statement = con.createStatement();
            statement.executeQuery(
                    "INSERT INTO instantie"
                            + "("
                            + "ID,"
                            + "naam,"
                            + "aantal,"
                            + "groepstype_ID"
                            + ")"
                            + " VALUES("
                            + ID + ","
                            + naam + ","
                            + aantal + ","
                            + groepstypeID + ")"
            );

        }catch (SQLException sqle) { sqle.printStackTrace(); }

        return instantie;
    }

    private List<Instantie> select(String query) {

        List<Instantie> results = new ArrayList<Instantie>();

        try (Connection con = super.getConnection()){

            Statement stmt = con.createStatement();
            ResultSet dbResultSet = stmt.executeQuery(query);

            while (dbResultSet.next()) {
                int ID = dbResultSet.getInt("ID");
                String naam = dbResultSet.getString("Naam");
                int aantal = dbResultSet.getInt("Aantal");

                int groepstypeID = dbResultSet.getInt("Groepstype_ID");
                Groepstype groepstype = groepstypeDAO.getGroepstypeByID(groepstypeID);


                results.add(new Instantie(ID,naam,aantal,groepstype));
            }
        } catch (SQLException sqle) { sqle.printStackTrace(); }

        return results;
    }

    public Instantie update(Instantie instantie) {

        try(Connection con = super.getConnection()) {

            int ID = instantie.getID();
            String naam = instantie.getNaam();
            int aantal = instantie.getAantal();
            int groepstypeID = instantie.getGroepstype().getID();

            Statement statement = con.createStatement();

            statement.executeQuery(
                    "UPDATE instantie SET"
                    +" naam="           +naam
                    +",aantal="         +aantal
                    +",groepstype_ID="     +groepstypeID
                    +" WHERE ID="       +ID
            );

        }catch (SQLException sqle) { sqle.printStackTrace(); }

        return instantie;

    }

    public boolean delete(Instantie instantie) {

        try(Connection con = super.getConnection()) {

            Statement stmt = con.createStatement();
            if(stmt.executeQuery("DELETE FROM instantie WHERE ID=" + instantie.getID()) != null) {
                return true;
            }

        }catch (SQLException sqle) { sqle.printStackTrace(); }
        return false;

    }
    
}

package boogie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by larsd on 06-Jun-16.
 */
public class KostenDAO extends BaseDAO {

    public Kosten getKostenByID(int kostenID) {
        List<Kosten> i = select("select * from kosten where ID =" + kostenID);
        if(i.size() > 0) {
            return i.get(0);
        }
        return null;
    }
    
    public Kosten save(Kosten kosten) {

        try (Connection con = super.getConnection()) {

            int ID = kosten.getID();
            double werfing = kosten.getWerfing();
            double planning = kosten.getPlanning();
            double filmer = kosten.getFilmer();
            double edit = kosten.getEdit();
            double diverse = kosten.getDiverse();
            double reis = kosten.getReis();

            Statement statement = con.createStatement();
            statement.executeQuery(
                    "INSERT INTO kosten "
                            + "("
                            + "ID,"
                            + "werfing,"
                            + "planning,"
                            + "filmer,"
                            + "diverse,"
                            + "onvangen,"
                            + "reis"
                            + ")"
                            + "VALUES("
                            + ID + ","
                            + werfing + ","
                            + planning + ","
                            + filmer + ","
                            + diverse + ","
                            + edit + ","
                            + reis + ")"
            );

        }catch (SQLException sqle) { sqle.printStackTrace(); }

        return kosten;
    }

    private List<Kosten> select(String query) {

        List<Kosten> results = new ArrayList<Kosten>();

        try (Connection con = super.getConnection()){

            Statement stmt = con.createStatement();
            ResultSet dbResultSet = stmt.executeQuery(query);

            while (dbResultSet.next()) {
                int ID = dbResultSet.getInt("ID");
                double werfing = dbResultSet.getDouble("Werfing");
                double planning = dbResultSet.getDouble("Planning");
                double filmer = dbResultSet.getDouble("Filmer");
                double edit = dbResultSet.getDouble("Edit");
                double diverse = dbResultSet.getDouble("Diverse");
                double reis = dbResultSet.getDouble("Reis");

                results.add(new Kosten(ID,werfing,planning,filmer,edit,diverse,reis));
            }
        } catch (SQLException sqle) { sqle.printStackTrace(); }

        return results;
    }

    public Kosten update(Kosten kosten) {

        try(Connection con = super.getConnection()) {

            int ID = kosten.getID();
            double werfing = kosten.getWerfing();
            double planning = kosten.getPlanning();
            double filmer = kosten.getFilmer();
            double edit = kosten.getEdit();
            double diverse = kosten.getDiverse();
            double reis = kosten.getReis();

            Statement statement = con.createStatement();

            statement.executeQuery(
                    "UPDATE kosten SET"
                    +" werfing="                +werfing
                    +",planning="               +planning
                    +",filmer="                 +filmer
                    +",edit="                   +edit
                    +",diverse="                +diverse
                    +",reis="                   +reis
                    +" WHERE ID="               +ID
            );

        }catch (SQLException sqle) { sqle.printStackTrace(); }

        return kosten;

    }

    public boolean delete(Kosten kosten) {

        try(Connection con = super.getConnection()) {

            Statement stmt = con.createStatement();
            if(stmt.executeQuery("DELETE FROM kosten WHERE ID=" + kosten.getID()) != null) {
                return true;
            }

        }catch (SQLException sqle) { sqle.printStackTrace(); }
        return false;

    }
    
}

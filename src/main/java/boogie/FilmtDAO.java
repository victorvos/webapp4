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
public class FilmtDAO extends BaseDAO {

    EvenementDAO evenementDAO = ServiceProvider.getEvenementDAO();
    FilmerDAO filmerDAO = ServiceProvider.getFilmerDAO();

    public Filmt getFilmtByID(int eNr, int filmerID) {
        return select("select * from filmt WHERE enr=" + eNr + " AND filmer_ID=" + filmerID).get(0);
    }

    public List<Filmt> getAllByEnr(int eNr) {
        List<Filmt> filmen = select("select filmerStatus, Filmer_ID from filmt WHERE enr=" + eNr);
        List<Filmer> filmers = new ArrayList<Filmer>();

        for (Filmt filmt : filmen) {
            filmers.add(filmt.getFilmer());
        }

        return filmen;
    }

    public Filmt save(Filmt filmt) {

        try (Connection con = super.getConnection()) {

            int filmerStatus = filmt.getFilmerStatus();
            
            int enr = filmt.getEvenement().geteNr();
            int filmerID = filmt.getFilmer().getID();

            Statement statement = con.createStatement();
            statement.executeQuery(
                    "INSERT INTO filmt"
                            + "("
                            + "filmerStatus,"
                            + "enr,"
                            + "filmer_ID"
                            + ")"
                            + " VALUES("
                            + filmerStatus + ","
                            + enr + ","
                            + filmerID + ")"
            );

        }catch (SQLException sqle) { sqle.printStackTrace(); }

        return filmt;
    }

    private List<Filmt> select(String query) {

        List<Filmt> results = new ArrayList<Filmt>();

        try (Connection con = super.getConnection()){

            Statement stmt = con.createStatement();
            ResultSet dbResultSet = stmt.executeQuery(query);

            while (dbResultSet.next()) {
                
                int filmerStatus = dbResultSet.getInt("FilmerStatus");

//                int evenementID = dbResultSet.getInt("eNr");
//                Evenement evenement = evenementDAO.getEvenementByID(evenementID);
                int filmerID = dbResultSet.getInt("Filmer_ID");
                Filmer filmer = filmerDAO.getFilmerByID(filmerID);

                results.add(new Filmt(filmerStatus,null,filmer));
            }
        } catch (SQLException sqle) { sqle.printStackTrace(); }

        return results;
    }

    public Filmt update(Filmt filmt) {

        try(Connection con = super.getConnection()) {

            int filmerStatus = filmt.getFilmerStatus();
            int eNr = filmt.getEvenement().geteNr();
            int filmerID = filmt.getFilmer().getID();

            Statement statement = con.createStatement();

            statement.executeQuery(
                    "UPDATE filmt SET"
                    +" filmerStatus="   +filmerStatus
                    +" WHERE enr="      +eNr
                    +" AND filmer_ID="  +filmerID
            );

        }catch (SQLException sqle) { sqle.printStackTrace(); }

        return filmt;

    }

    public boolean delete(Filmt filmt) {

        try(Connection con = super.getConnection()) {

            Statement stmt = con.createStatement();
            if(stmt.executeQuery("DELETE FROM filmt WHERE enr=" + filmt.getEvenement().geteNr() + " AND filmer_ID=" + filmt.getFilmer().getID()) != null) {
                return true;
            }

        }catch (SQLException sqle) { sqle.printStackTrace(); }
        return false;

    }
    
}

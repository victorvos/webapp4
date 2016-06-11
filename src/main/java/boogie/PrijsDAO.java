package boogie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by larsd on 06-Jun-16.
 */
public class PrijsDAO extends BaseDAO {

    public Prijs getPrijsByID(int prijsID) {
        List<Prijs> i = select("select * from prijs where ID =" + prijsID);
        if(i.size() > 0) {
            return i.get(0);
        }
        return null;
    }
    
    public Prijs save(Prijs prijs) {

        try (Connection con = super.getConnection()) {

            int ID = prijs.getID();
            double basis = prijs.getBasis();
            double diverse = prijs.getDiverse();
            double korting = prijs.getKorting();
            double ontvangen = prijs.getOntvangen();
            Date gevraagd = prijs.getGevraagd();
            Date factuurdatum = prijs.getFactuurdatum();
            Date herinnerings_datum = prijs.getHerinnerings_datum();

            Statement statement = con.createStatement();
            statement.executeQuery(
                    "INSERT INTO prijs "
                            + "("
                            + "ID,"
                            + "basis,"
                            + "diverse,"
                            + "korting,"
                            + "gevraagd,"
                            + "onvangen,"
                            + "factuurdatum,"
                            + "herinnerings_datum,"
                            + ")"
                            + "VALUES("
                            + ID + ","
                            + basis + ","
                            + diverse + ","
                            + korting + ","
                            + gevraagd + ","
                            + ontvangen + ","
                            + factuurdatum + ","
                            + herinnerings_datum + ")"
            );

        }catch (SQLException sqle) { sqle.printStackTrace(); }

        return prijs;
    }

    private List<Prijs> select(String query) {

        List<Prijs> results = new ArrayList<Prijs>();

        try (Connection con = super.getConnection()){

            Statement stmt = con.createStatement();
            ResultSet dbResultSet = stmt.executeQuery(query);

            while (dbResultSet.next()) {
                int ID = dbResultSet.getInt("ID");
                double basis = dbResultSet.getDouble("Basis");
                double diverse = dbResultSet.getDouble("Diverse");
                double korting = dbResultSet.getDouble("Korting");
                double ontvangen = dbResultSet.getDouble("Ontvangen");
                Date gevraagd = dbResultSet.getDate("Gevraagd");
                Date factuurdatum = dbResultSet.getDate("Factuurdatum");
                Date herinnerings_datum = dbResultSet.getDate("Herinnerings_datum");

                results.add(new Prijs(ID,basis,diverse,korting,ontvangen,gevraagd,factuurdatum,herinnerings_datum));
            }
        } catch (SQLException sqle) { sqle.printStackTrace(); }

        return results;
    }

    public Prijs update(Prijs prijs) {

        try(Connection con = super.getConnection()) {

            int ID = prijs.getID();
            double basis = prijs.getBasis();
            double diverse = prijs.getDiverse();
            double korting = prijs.getKorting();
            double ontvangen = prijs.getOntvangen();
            Date gevraagd = prijs.getGevraagd();
            Date factuurdatum = prijs.getFactuurdatum();
            Date herinnerings_datum = prijs.getHerinnerings_datum();

            Statement statement = con.createStatement();

            statement.executeQuery(
                    "UPDATE prijs SET"
                    +" basis="                  +basis
                    +",diverse="                +diverse
                    +",korting="                +korting
                    +",gevraagd="               +gevraagd
                    +",ontvangen="              +ontvangen
                    +",factuurdatum="           +factuurdatum
                    +",herinnerings_datum="     +herinnerings_datum
                    +" WHERE ID="               +ID
            );

        }catch (SQLException sqle) { sqle.printStackTrace(); }

        return prijs;

    }

    public boolean delete(Prijs prijs) {

        try(Connection con = super.getConnection()) {

            Statement stmt = con.createStatement();
            if(stmt.executeQuery("DELETE FROM prijs WHERE ID=" + prijs.getID()) != null) {
                return true;
            }

        }catch (SQLException sqle) { sqle.printStackTrace(); }
        return false;

    }
    
}

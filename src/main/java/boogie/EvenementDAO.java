package boogie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by larsd on 06-Jun-16.
 */
public class EvenementDAO extends BaseDAO {
    
    InstantieDAO instantieDAO = ServiceProvider.getInstantieDAO();
    LiedjeDAO liedjeDAO = ServiceProvider.getLiedjeDAO();
    GelegenheidDAO gelegenheidDAO = ServiceProvider.getGelegenheidDAO();
    ActiviteitDAO activiteitDAO = ServiceProvider.getActiviteitDAO();
    PrijsDAO prijsDAO = ServiceProvider.getPrijsDAO();
    KostenDAO kostenDAO = ServiceProvider.getKostenDAO();
    EditDAO editDAO = ServiceProvider.getEditDAO();

    public Evenement getEvenementByID(int evenementID) {
        List<Evenement> i = select("select * from evenement where enr =" + evenementID);
        if(i.size() > 0) {
            return i.get(0);
        }
        return null;
    }

    public List<Evenement> getAll() {
        List<Evenement> i = select("select * from evenement");
        if(i.size() > 0) {
            return i;
        }
        return null;
    }
    
    public Evenement save(Evenement evenement) {

        try (Connection con = super.getConnection()) {

            int eNr = evenement.geteNr();
            int kans = evenement.getKans();
            Date datum = evenement.getDatum();
            Time begintijd = evenement.getBegintijd();
            Time eindtijd = evenement.getEindtijd();
            String locatie = evenement.getLocatie();
            int afstand = evenement.getAfstand();
            String opmerking = evenement.getOpmerking();
            String verrassing = evenement.getVerrassing();
            String binnenruimte = evenement.getBinnenruimte();
            
            int instantieID = evenement.getInstantie().getID();
            int liedjeID = evenement.getLiedje().getID();
            int gelegenheidID = evenement.getGelegenheid().getID();
            int activiteitID = evenement.getActiviteit().getID();
            int prijsID = evenement.getPrijs().getID();
            int kostenID = evenement.getKosten().getID();
            int editID = evenement.getEdit().getID();

            Statement statement = con.createStatement();
            statement.executeQuery(
                    "INSERT INTO evenement "
                            + "("
                            + "ENr,"
                            + "kans,"
                            + "datum,"
                            + "begintijd,"
                            + "eindtijd,"
                            + "locatie,"
                            + "afstand,"
                            + "opmerking,"
                            + "verrassing,"
                            + "binnenruimte,"
                            + "instantie_ID"
                            + "liedje_ID"
                            + "gelegenheid_ID"
                            + "activiteit_ID"
                            + "prijs_ID"
                            + "kosten_ID"
                            + "edit_ID"
                            + "VALUES("
                            + eNr + ","
                            + kans + ","
                            + datum + ","
                            + begintijd + ","
                            + eindtijd + ","
                            + locatie + ","
                            + afstand + ","
                            + opmerking + ","
                            + verrassing + ","
                            + binnenruimte + ","
                            + instantieID + ","
                            + liedjeID + ","
                            + gelegenheidID + ","
                            + activiteitID + ","
                            + prijsID + ","
                            + kostenID + ","
                            + editID + ")"
            );

        }catch (SQLException sqle) { sqle.printStackTrace(); }

        return evenement;
    }

    private List<Evenement> select(String query) {

        List<Evenement> results = new ArrayList<Evenement>();

        try (Connection con = super.getConnection()){

            Statement stmt = con.createStatement();
            ResultSet dbResultSet = stmt.executeQuery(query);

            while (dbResultSet.next()) {
                int eNr = dbResultSet.getInt("eNr");
                int kans = dbResultSet.getInt("kans");
                Date datum = dbResultSet.getDate("datum");
                Time begintijd = dbResultSet.getTime("begintijd");
                Time eindtijd = dbResultSet.getTime("eindtijd");
                String locatie = dbResultSet.getString("locatie");
                int afstand = dbResultSet.getInt("afstand");
                String opmerking = dbResultSet.getString("Opmerking");
                String verrassing = dbResultSet.getString("verrassing");
                String binnenruimte = dbResultSet.getString("binnenruimte");

                int instantieID = dbResultSet.getInt("Instantie_ID");
                Instantie instantie = instantieDAO.getInstantieByID(instantieID);
                int liedjeID = dbResultSet.getInt("Liedje_ID");
                Liedje liedje = liedjeDAO.getLiedjeByID(liedjeID);
                int gelegenheidID = dbResultSet.getInt("Gelegenheid_ID");
                Gelegenheid gelegenheid = gelegenheidDAO.getGelegenheidByID(gelegenheidID);
                int activiteitID = dbResultSet.getInt("Activiteit_ID");
                Activiteit activiteit = activiteitDAO.getActiviteitByID(activiteitID);
                int prijsID = dbResultSet.getInt("Prijs_ID");
                Prijs prijs = prijsDAO.getPrijsByID(prijsID);
                int kostenID = dbResultSet.getInt("Kosten_ID");
                Kosten kosten = kostenDAO.getKostenByID(kostenID);
                int editID = dbResultSet.getInt("Edit_ID");
                Edit edit = editDAO.getEditByID(editID);

                results.add(new Evenement(eNr,kans,datum,begintijd,eindtijd,locatie,afstand,verrassing,binnenruimte,opmerking,instantie,liedje,gelegenheid,activiteit,prijs,kosten,edit));
            }
        } catch (SQLException sqle) { sqle.printStackTrace(); }

        return results;
    }

    public Evenement update(Evenement evenement) {

        try(Connection con = super.getConnection()) {

            int eNr = evenement.geteNr();
            int kans = evenement.getKans();
            Date datum = evenement.getDatum();
            Time begintijd = evenement.getBegintijd();
            Time eindtijd = evenement.getEindtijd();
            String locatie = evenement.getLocatie();
            int afstand = evenement.getAfstand();
            String opmerking = evenement.getOpmerking();
            String verrassing = evenement.getVerrassing();
            String binnenruimte = evenement.getBinnenruimte();

            int instantieID = evenement.getInstantie().getID();
            int liedjeID = evenement.getLiedje().getID();
            int gelegenheidID = evenement.getGelegenheid().getID();
            int activiteitID = evenement.getActiviteit().getID();
            int prijsID = evenement.getPrijs().getID();
            int kostenID = evenement.getKosten().getID();
            int editID = evenement.getEdit().getID();


            Statement statement = con.createStatement();

            statement.executeQuery(
                    "UPDATE evenement SET"
                    +" kans="                   +kans
                    +",datum="                  +datum
                    +",begintijd="              +begintijd
                    +",eindtijd="               +eindtijd
                    +",locatie="                +locatie
                    +",afstand="                +afstand
                    +",opmerking="              +opmerking
                    +",verrassing="             +verrassing
                    +",binnenruimte="           +binnenruimte
                    +",instantie_ID="           +instantieID
                    +",gelegenheid_ID="         +gelegenheidID
                    +",activiteit_ID="          +activiteitID
                    +",liedje_ID="              +liedjeID
                    +",prijs_ID="               +prijsID
                    +",kosten_ID="              +kostenID
                    +",edit_ID="                +editID
                    +" WHERE eNr="              +eNr
            );

        }catch (SQLException sqle) { sqle.printStackTrace(); }

        return evenement;

    }

    public boolean delete(Evenement evenement) {

        try(Connection con = super.getConnection()) {

            Statement stmt = con.createStatement();
            if(stmt.executeQuery("DELETE FROM evenement WHERE eNr=" + evenement.geteNr()) != null) {
                return true;
            }

        }catch (SQLException sqle) { sqle.printStackTrace(); }
        return false;

    }
    
}

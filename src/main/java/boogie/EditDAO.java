package boogie;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by larsd on 06-Jun-16.
 */
public class EditDAO extends BaseDAO {

    public Edit getEditByID(int editID) {
        List<Edit> i = select("select * from edit where ID =" + editID);
        if(i.size() > 0) {
            return i.get(0);
        }
        return null;
    }
    
    public Edit save(Edit edit) {

        try (Connection con = super.getConnection()) {

            int ID = edit.getID();
            String tekst = edit.getTekst();
            String demoversie = edit.getDemoversie();
            String eindversie = edit.getEindversie();
            Date deadline = edit.getDeadline();

            Statement statement = con.createStatement();
            statement.executeQuery(
                    "INSERT INTO edit "
                            + "("
                            + "ID,"
                            + "tekst,"
                            + "demoversie,"
                            + "eindversie,"
                            + "deadline"
                            + ")"
                            + "VALUES("
                            + ID + ","
                            + tekst + ","
                            + demoversie + ","
                            + eindversie + ","
                            + deadline + ")"
            );

        }catch (SQLException sqle) { sqle.printStackTrace(); }

        return edit;
    }

    private List<Edit> select(String query) {

        List<Edit> results = new ArrayList<Edit>();

        try (Connection con = super.getConnection()){

            Statement stmt = con.createStatement();
            ResultSet dbResultSet = stmt.executeQuery(query);

            while (dbResultSet.next()) {
                int ID = dbResultSet.getInt("ID");
                String tekst = dbResultSet.getString("Tekst");
                String demoversie = dbResultSet.getString("Demoversie");
                String eindversie = dbResultSet.getString("Eindversie");
                Date deadline = dbResultSet.getDate("Deadline");

                results.add(new Edit(ID,tekst,demoversie,eindversie,deadline));
            }
        } catch (SQLException sqle) { sqle.printStackTrace(); }

        return results;
    }

    public Edit update(Edit edit) {

        try(Connection con = super.getConnection()) {

            int ID = edit.getID();
            String tekst = edit.getTekst();
            String demoversie = edit.getDemoversie();
            String eindversie = edit.getEindversie();
            Date deadline = edit.getDeadline();

            Statement statement = con.createStatement();

            statement.executeQuery(
                    "UPDATE edit SET"
                    +" tekst="      +tekst
                    +",demoversie="      +demoversie
                    +",eindversie="  +eindversie
                    +",deadline="      +deadline
                    +" WHERE ID="   +ID
            );

        }catch (SQLException sqle) { sqle.printStackTrace(); }

        return edit;

    }

    public boolean delete(Edit edit) {

        try(Connection con = super.getConnection()) {

            Statement stmt = con.createStatement();
            if(stmt.executeQuery("DELETE FROM edit WHERE ID=" + edit.getID()) != null) {
                return true;
            }

        }catch (SQLException sqle) { sqle.printStackTrace(); }
        return false;

    }
    
}

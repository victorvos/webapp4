package worldmap.persistence;

/**
 * Created by larsd on 23-May-16.
 */
import java.sql.Connection;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BaseDAO {
    protected final Connection getConnection() {
        Connection result = null;
        try {
            InitialContext ic = new InitialContext();
            DataSource ds = (DataSource) ic.lookup("java:comp/env/jdbc/MySQLDS");

            result = ds.getConnection();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
        return result;
    }
}
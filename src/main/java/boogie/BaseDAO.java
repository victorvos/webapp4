package boogie;

/**
 * Created by larsd on 23-May-16.
 */

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;

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
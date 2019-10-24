package context;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class DBContext {

    private String serverName;
    private String dbName;
    private String portNumber;
    private String userID;
    private String password;

    public DBContext() {
        try {
            InitialContext initialContext = new InitialContext();
            Context environmentContext = (Context) initialContext.lookup("java:comp/env");
            serverName = (String) environmentContext.lookup("serverName");
            dbName = (String) environmentContext.lookup("dbName");
            portNumber = (String) environmentContext.lookup("portNumber");
            userID = (String) environmentContext.lookup("userID");
            password = (String) environmentContext.lookup("password");
        } catch (NamingException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getImagePath() throws Exception {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            InitialContext context = new InitialContext();
            Context xmlNode = (Context) context.lookup("java:comp/env");
            String imagePath = (String) xmlNode.lookup("imagePath");
            return imagePath;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }

    public static void closeConnection(ResultSet rs, PreparedStatement ps, Connection con) throws SQLException { // đóng kết nối
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }
}

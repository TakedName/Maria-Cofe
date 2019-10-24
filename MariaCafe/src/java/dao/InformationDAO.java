
package dao;


import context.DBContext;
import entity.Cake;
import entity.Information;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class InformationDAO {
    public Information getInfomation() throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
           String query = "select * from Information";
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Information information = new Information(rs.getString("shortDescription"), 
                        rs.getString("address"), 
                        rs.getString("tel"), 
                        rs.getString("email"), 
                        rs.getString("openingHours"), 
                        rs.getString("signature"));
                return information;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            DBContext.closeConnection(rs, ps, connection);
        }
        return null;
    }
}

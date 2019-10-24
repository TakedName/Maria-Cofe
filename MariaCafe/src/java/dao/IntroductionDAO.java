
package dao;


import context.DBContext;
import entity.Information;
import entity.Introduction;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class IntroductionDAO {
    
     public Introduction getIntroduction() throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "select * from Intro";
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Introduction introduction = new Introduction(rs.getString("title"), 
                        rs.getString("picture"), 
                        rs.getString("shortDescription"), 
                        rs.getString("detailDescription"));
                return introduction;
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            DBContext.closeConnection(rs, ps, connection);
        }
        return null;
     }
    
}

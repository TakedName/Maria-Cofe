
package dao;

import context.DBContext;
import entity.Cake;
import entity.Share;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ShareDAO {

     public List<Share> getShare() throws Exception {
         Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Share> list = new ArrayList<>();
        try {
             String query = "select * from Share";
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Share share = new Share(rs.getString("icon"), 
                        rs.getString("socialNetwork"), 
                        rs.getString("URL"));
                list.add(share);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            DBContext.closeConnection(rs, ps, connection);
        }
        return null;
     }
}

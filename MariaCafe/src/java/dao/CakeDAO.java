
package dao;

import context.DBContext;
import entity.Cake;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class CakeDAO {

    public List<Cake> getTop2() throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Cake> list = new ArrayList<>();
        try {
            String query = "select top 2* from Products order by DateCreated desc";
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cake cake = new Cake(rs.getInt("id"), 
                        rs.getString("name"), 
                        rs.getString("picture"), 
                        rs.getString("shortDescription") 
                        );
                list.add(cake);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            DBContext.closeConnection(rs, ps, connection);
        }
        return null;
    }
 
    public Cake getCakeDetail(int CakeID) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "select * from Products where ID = ?";
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            ps.setInt(1, CakeID);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cake cake = new Cake(rs.getInt("id"), 
                        rs.getString("name"), 
                        rs.getString("picture"), 
                        rs.getString("DetailDescription"),
                        rs.getString("price")
                        );
                return cake;
            }

        } catch (Exception e) {
            e.printStackTrace(System.out);
        } finally {
            DBContext.closeConnection(rs, ps, connection);
        }
        return null;
    }

    public int getTotalProducts() throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int count = 0;
        try {
            String query = "select count(*) from Products";
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                count = rs.getInt(1);
            }
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        return count;
    }

    public List<Cake> getAllCakes(int pageIndex, int pageSize) throws Exception {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Cake> list = new ArrayList<>();
        try {
            String sql = "select *from("
                + "select ROW_NUMBER() over (order by ID ASC) as rn, *\n"
                + "from Products"
                + ")as x\n"
                + "where rn between (?-1)*?+1"
                + "and ?*?";
            connection = new DBContext().getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, pageIndex);
            ps.setInt(2, pageSize);
            ps.setInt(3, pageIndex);
            ps.setInt(4, pageSize);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cake cake = new Cake(rs.getInt("id"), 
                        rs.getString("name"), 
                        rs.getString("picture"), 
                        rs.getString("shortDescription")
                        );
                list.add(cake);
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

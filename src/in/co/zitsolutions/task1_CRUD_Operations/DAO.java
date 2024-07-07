package in.co.zitsolutions.task1_CRUD_Operations;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO {
    private static Connection conn;
    static{
        try {
            conn = DriverManager.getConnection(Credentials.getUrl(),Credentials.getUsername(),Credentials.getPassword());
            System.out.println("Connection established");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean insert (Pojo pojo)throws SQLException{
        PreparedStatement ps = conn.prepareStatement("insert into details values(?,?,?)");
        ps.setString(1, pojo.getName());
        ps.setInt(2, pojo.getAge());
        ps.setString(3, pojo.getJob());
        return ps.executeUpdate()>0;
    }

    public static boolean delete (String name)throws SQLException{
        PreparedStatement ps = conn.prepareStatement("delete from details where name = ?");
        ps.setString(1, name);
        return ps.executeUpdate()>0;
    }

    public static boolean update (Pojo pojo)throws SQLException{
        PreparedStatement ps = conn.prepareStatement("update details set age = ?,job=? where name = ?");
        ps.setInt(1, pojo.getAge());
        ps.setString(2, pojo.getJob());
        ps.setString(3, pojo.getName());
        return ps.executeUpdate()>0;
    }

    public static List<Pojo> getAll()throws SQLException{
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("select * from details");
        List<Pojo> list = new ArrayList<Pojo>();
        while(rs.next()){
            Pojo pojo = new Pojo();
            pojo.setName(rs.getString("name"));
            pojo.setAge(rs.getInt("age"));
            pojo.setJob(rs.getString("job"));
            list.add(pojo);
        }
        return list;
    }

}

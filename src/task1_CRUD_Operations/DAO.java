package task1_CRUD_Operations;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    public static boolean insert (String name, int age, String job)throws SQLException{
        PreparedStatement ps = conn.prepareStatement("insert into details values(?,?,?)");
        ps.setString(1, name);
        ps.setInt(2, age);
        ps.setString(3, job);
        return ps.executeUpdate()>0;
    }

    public static boolean delete (String name)throws SQLException{
        PreparedStatement ps = conn.prepareStatement("delete from details where name = ?");
        ps.setString(1, name);
        return ps.executeUpdate()>0;
    }

    public static boolean update (String name, int age, String job)throws SQLException{
        PreparedStatement ps = conn.prepareStatement("update details set age = ?,job=? where name = ?");
        ps.setInt(1, age);
        ps.setString(2, job);
        ps.setString(3, name);
        return ps.executeUpdate()>0;
    }

}

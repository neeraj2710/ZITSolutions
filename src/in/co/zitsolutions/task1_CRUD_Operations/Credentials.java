package in.co.zitsolutions.task1_CRUD_Operations;

public class Credentials {
    private static String url="jdbc:oracle:thin:@//localhost:1521/xe";
    private static String username="zitsolution";
    private static String password="zitsolution";

    public static String getUrl() {
        return url;
    }

    public static String getUsername() {
        return username;
    }

    public static String getPassword() {
        return password;
    }
}

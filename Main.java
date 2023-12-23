import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = new String("jdbc:mysql://localhost");
        String databaseName = new String("EVOL");
        int port = 3306;
        String username = new String("root");
        String password = new String(""); //Για σύνδεση στη βάση χωρίς κωδικό
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                url + ":" + port + "/" + databaseName + "?characterEncoding=UTF-8", username, password);
        } catch (Exception e) {
            System.out.println("Den douleuei bro");
            throw new RuntimeException(e);
        }

    }
}

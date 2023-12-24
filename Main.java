import javax.xml.crypto.Data;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        DataBase.initialize();
        Initializers.Category();
        Vehicle v1 = new Vehicle(10, 300, "Cobra", 30, "black", "Toyota",1);
    }
}
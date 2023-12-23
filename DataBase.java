import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.*;

public class DataBase {
    public static void initialize(){
        String url = new String("jdbc:mysql://localhost");
        String databaseName = new String("EVOL");
        int port = 3306;
        String username = new String("root");
        String password = new String(""); //Για σύνδεση στη βάση χωρίς κωδικό
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    url + ":" + port + "/" + databaseName + "?characterEncoding=UTF-8", username, password);

            Statement statement = con.createStatement();

            String createTableSQL = "CREATE TABLE IF NOT EXISTS Category (" +
                    "category_id INT PRIMARY KEY AUTO_INCREMENT," +
                    "category_name ENUM ('Car', 'Motorcycle', 'Scooter', 'Bicycle'))";
            statement.executeUpdate(createTableSQL);


            // SQL statement to create a table
             createTableSQL = "CREATE TABLE IF NOT EXISTS Vehicle (" +
                    "vehicle_id INT PRIMARY KEY AUTO_INCREMENT," +
                    "rental_cost INT," +
                    "state ENUM ('To rent', 'Rented', 'In service', 'To fix')," +
                    "km_autonomy INT," +
                    "times_rented INT," +
                    "model VARCHAR(255)," +
                    "insurance_cost INT," +
                    "color VARCHAR(255)," +
                    "brand VARCHAR(255)," +
                    "category_id INT," +
                    "FOREIGN KEY (category_id) REFERENCES Category(category_id))";
            statement.executeUpdate(createTableSQL);

            createTableSQL = "CREATE TABLE IF NOT EXISTS Customer (" +
                    "customer_id INT PRIMARY KEY AUTO_INCREMENT," +
                    "customer_name VARCHAR(255)," +
                    "license_number INT," +
                    "customer_address VARCHAR(255)," +
                    "phone_number INT," +
                    "birth_date VARCHAR(255),"+
                    "card_number INT," +
                    "card_holder VARCHAR(255)," +
                    "card_expiration VARCHAR(255)," +
                    "card_cvv INT)";
            statement.executeUpdate(createTableSQL);

            createTableSQL = "CREATE TABLE IF NOT EXISTS Rental (" +
                    "rental_id INT PRIMARY KEY AUTO_INCREMENT," +
                    "rental_date VARCHAR(255)," +
                    "rental_deadline VARCHAR(255)," +
                    "rental_duration INT," +
                    "total_cost INT," +
                    "vehicle_id INT," +
                    "category_id INT," +
                    "customer_id INT," +
                    "FOREIGN KEY (vehicle_id) REFERENCES Vehicle(vehicle_id)," +
                    "FOREIGN KEY (category_id) REFERENCES Category(category_id)," +
                    "FOREIGN KEY (customer_id) REFERENCES Customer(customer_id)," +
                    "drivers_license_number VARCHAR(255)," +
                    "birth_date VARCHAR(255))";
            statement.executeUpdate(createTableSQL);

            createTableSQL = "CREATE TABLE IF NOT EXISTS Service (" +
                    "service_id INT PRIMARY KEY AUTO_INCREMENT," +
                    "start_date VARCHAR(255)," +
                    "end_date VARCHAR(255)," +
                    "service_cost INT," +
                    "insurance_cost INT," +
                    "vehicle_id INT," +
                    "FOREIGN KEY (vehicle_id) REFERENCES Vehicle(vehicle_id))";
            statement.executeUpdate(createTableSQL);

            createTableSQL = "CREATE TABLE IF NOT EXISTS Car (" +
                    "car_registration_number INT PRIMARY KEY AUTO_INCREMENT," +
                    "num_doors INT," +
                    "category_id INT," +
                    "FOREIGN KEY (category_id) REFERENCES Category(category_id))";
            statement.executeUpdate(createTableSQL);

            createTableSQL = "CREATE TABLE IF NOT EXISTS Motorcycle (" +
                    "motorcycle_registration_number INT PRIMARY KEY AUTO_INCREMENT," +
                    "off_road BOOLEAN," +
                    "category_id INT," +
                    "FOREIGN KEY (category_id) REFERENCES Category(category_id))";
            statement.executeUpdate(createTableSQL);

            createTableSQL = "CREATE TABLE IF NOT EXISTS Scooter (" +
                    "scooter_id INT PRIMARY KEY AUTO_INCREMENT," +
                    "top_speed INT," +
                    "category_id INT," +
                    "FOREIGN KEY (category_id) REFERENCES Category(category_id))";
            statement.executeUpdate(createTableSQL);

            createTableSQL = "CREATE TABLE IF NOT EXISTS Bicycle (" +
                    "motorcycle_registration_number INT PRIMARY KEY AUTO_INCREMENT," +
                    "pedal_type VARCHAR(255)," +
                    "category_id INT," +
                    "FOREIGN KEY (category_id) REFERENCES Category(category_id))";
            statement.executeUpdate(createTableSQL);

        } catch (Exception e) {
            System.out.println("Den douleuei bro");
            throw new RuntimeException(e);
        }
    }

}

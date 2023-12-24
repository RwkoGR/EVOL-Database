import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Vehicle {
    public int vehicle_id;
    public int rental_cost;
    //State ENUM
    public int km_autonomy;
    public int times_rented;
    public String model;
    public int insurance_cost;
    public String color;
    public String brand;
    public int category_id;

    public Vehicle(int rental_cost, int km_autonomy, String model, int insurance_cost, String color, String brand, int category_id){
        PreparedStatement preparedStatement = null;
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/EVOL", "root", "");
            Class.forName("com.mysql.cj.jdbc.Driver");

            String insertVehicle = "INSERT INTO Vehicle (rental_cost, state, km_autonomy, times_rented, model, insurance_cost, color, brand, category_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

            assert(!(connection==null));
            preparedStatement = connection.prepareStatement(insertVehicle);

            preparedStatement.setInt(1, rental_cost);
            preparedStatement.setString(2, "to_rent");
            preparedStatement.setInt(3, km_autonomy);
            preparedStatement.setInt(4, 0);
            preparedStatement.setString(5, model);
            preparedStatement.setInt(6, insurance_cost);
            preparedStatement.setString(7, color);
            preparedStatement.setString(8, brand);
            preparedStatement.setInt(9, category_id);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Data inserted successfully!");
            } else {
                System.out.println("No rows affected. Data not inserted.");
            }
//            connection.close();
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("OXIIIII!!!");
        }
    }
}

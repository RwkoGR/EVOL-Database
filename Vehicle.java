public class Vehicle {
    public int vehicle_id;
    public int rental_cost;
    //State ENUM
    public int autonomy;
    public int times_rented;
    public String model;
    public int insurance_cost;
    public String color;
    public String brand;
    public int category_id;

    public Vehicle(int vehicle_id, int rental_cost, int autonomy, String model, int insurance_cost, String color, String brand, int category_id){
        this.vehicle_id = vehicle_id;
    }
}

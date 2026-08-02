import java.util.ArrayList;
import java.util.Scanner;

class Vehicle {
    private int vehicleId;
    private String vehicleName;
    private double rentPerDay;

    public Vehicle(int vehicleId, String vehicleName, double rentPerDay) {
        this.vehicleId = vehicleId;
        this.vehicleName = vehicleName;
        this.rentPerDay = rentPerDay;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public double getRentPerDay() {
        return rentPerDay;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }

    public void setRentPerDay(double rentPerDay) {
        this.rentPerDay = rentPerDay;
    }
}

public class VehicleRentalManagement {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        while (true) {
            System.out.println("\n===== Vehicle Rental Management =====");
            System.out.println("1. Add Vehicle");
            System.out.println("2. View Vehicles");
            System.out.println("3. Update Vehicle");
            System.out.println("4. Delete Vehicle");
            System.out.println("5. Exit");
            System.out.print("Enter Choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Vehicle ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Vehicle Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Rent Per Day: ");
                    double rent = sc.nextDouble();

                    vehicles.add(new Vehicle(id, name, rent));
                    System.out.println("Vehicle Added Successfully.");
                    break;

                case 2:
                    if (vehicles.isEmpty()) {
                        System.out.println("No Vehicles Available.");
                    } else {
                        for (Vehicle v : vehicles) {
                            System.out.println("Vehicle ID: " + v.getVehicleId()
                                    + " | Name: " + v.getVehicleName()
                                    + " | Rent/Day: ₹" + v.getRentPerDay());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Vehicle ID to Update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    boolean updated = false;

                    for (Vehicle v : vehicles) {
                        if (v.getVehicleId() == updateId) {

                            System.out.print("Enter New Vehicle Name: ");
                            v.setVehicleName(sc.nextLine());

                            System.out.print("Enter New Rent Per Day: ");
                            v.setRentPerDay(sc.nextDouble());

                            System.out.println("Vehicle Updated Successfully.");
                            updated = true;
                            break;
                        }
                    }

                    if (!updated) {
                        System.out.println("Vehicle Not Found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Vehicle ID to Delete: ");
                    int deleteId = sc.nextInt();

                    boolean deleted = false;

                    for (int i = 0; i < vehicles.size(); i++) {
                        if (vehicles.get(i).getVehicleId() == deleteId) {
                            vehicles.remove(i);
                            System.out.println("Vehicle Deleted Successfully.");
                            deleted = true;
                            break;
                        }
                    }

                    if (!deleted) {
                        System.out.println("Vehicle Not Found.");
                    }
                    break;

                case 5:
                    System.out.println("Thank You!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid Choice.");
            }
        }
    }
}
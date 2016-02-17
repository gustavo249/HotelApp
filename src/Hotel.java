/**
 * Created by Gustavo on 12/02/2016.
 */
public class Hotel {
    private String hotelName;
    private Apartment[] apartments;
    private String restaurantSpecific;
    private Reservation[] reservations;
    private Employee[] employees;

    public Hotel(String hotelName, Apartment[] apartments, String restaurantSpecific, Reservation[] reservations, Employee[] employees) {
        this.hotelName = hotelName;
        this.apartments = apartments;
        this.restaurantSpecific = restaurantSpecific;
        this.reservations = reservations;
        this.employees = employees;
    }

    public Hotel() {

    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getRestaurantSpecific() {
        return restaurantSpecific;
    }

    public void setRestaurantSpecific(String restaurantSpecific) {
        this.restaurantSpecific = restaurantSpecific;
    }

    public Reservation[] getReservations() {
        return reservations;
    }

    public void setReservations(Reservation[] reservations) {
        this.reservations = reservations;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    public Apartment[] getApartments() {
        return apartments;
    }

    public void setApartments(Apartment[] apartments) {
        this.apartments = apartments;
    }
}

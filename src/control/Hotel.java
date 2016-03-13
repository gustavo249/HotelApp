package control;

import business.Apartment;
import business.Client;
import business.Employee;
import business.Reservation;

import java.util.List;

/**
 * Created by Gustavo on 12/02/2016.
 */
public class Hotel {
    private static String hotelName;
    private List<Apartment> apartments;
    private String restaurantSpecific;
    private List<Reservation> reservations;
    private List<Employee> employees;
    private List<Client> clients;

    public Hotel(String hotelName, List<Apartment> apartments, String restaurantSpecific,
                 List<Reservation> reservations, List<Employee> employees) {
        this.hotelName = hotelName;
        this.apartments = apartments;
        this.restaurantSpecific = restaurantSpecific;
        this.reservations = reservations;
        this.employees = employees;
    }

    public Hotel() {

    }

    public static String getHotelName() {
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

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}

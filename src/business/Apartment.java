package business;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Gustavo on 12/02/2016.
 */
public class Apartment {
    private int apartmentNo;
    private int rooms;
    private int beds;
    private String status;
    private int price;

    public Apartment(int apartmentNo, int rooms, int beds, String status, int price) {
        this.apartmentNo = apartmentNo;
        this.rooms = rooms;
        this.beds = beds;
        this.status = status;
        this.price = price;
    }

    public int getApartmentNo() {
        return apartmentNo;
    }

    public void setApartmentNo(int apartmentNo) {
        this.apartmentNo = apartmentNo;
    }

    public int getRooms() {
        return rooms;
    }

    public void setRooms(int rooms) {
        this.rooms = rooms;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "business.Apartment{" +
                "apartmentNo=" + apartmentNo +
                ", rooms=" + rooms +
                ", beds=" + beds +
                ", status='" + status + '\'' +
                ", price=" + price +
                '}';
    }


}


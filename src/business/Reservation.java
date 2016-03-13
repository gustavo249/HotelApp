package business;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Gustavo on 12/02/2016.
 */
public class Reservation {
    private int reservationNumber;
    private int apartmentNo;
    private Client client;
    private String date;

    public Reservation(int reservationNumber, int apartmentNo, Client client, String date) {
        this.reservationNumber = reservationNumber;
        this.apartmentNo = apartmentNo;
        this.client = client;
        this.date = date;
    }

    public int getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(int reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public int getApartmentNo() {
        return apartmentNo;
    }

    public void setApartmentNo(int apartmentNo) {
        this.apartmentNo = apartmentNo;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "reservationNumber=" + reservationNumber +
                ", apartmentNo=" + apartmentNo +
                ", client=" + client.getName() + " " + client.getCnp() +
                ", date='" + date + '\'' +
                '}';
    }
}

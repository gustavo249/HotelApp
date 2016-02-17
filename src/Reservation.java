import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Gustavo on 12/02/2016.
 */
public class Reservation {
    private Apartment apartment;
    private Client client;
    private String date;

    public Reservation(Apartment apartment, Client client, String date) {
        this.apartment = apartment;
        this.client = client;
        this.date = date;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
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

    public static Reservation[] addNewReservation(Reservation[] oldReservations, Apartment apartment, Client client) {
        Reservation[] newReservations = new Reservation[oldReservations.length + 1];
        for(int i = 0; i < oldReservations.length; i++)
            newReservations[i] = oldReservations[i];
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        newReservations[oldReservations.length] = new Reservation(apartment, client, dateFormat.format(date));
        apartment.setStatus("reserved");
        return newReservations;
    }
}

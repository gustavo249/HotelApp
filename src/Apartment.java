import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

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
        return "Apartment{" +
                "apartmentNo=" + apartmentNo +
                ", rooms=" + rooms +
                ", beds=" + beds +
                ", status='" + status + '\'' +
                ", price=" + price +
                '}';
    }

    public static Apartment[] addNewApartment(Apartment[] oldApartments, Apartment apartment) {
        Apartment[] newApartments = new Apartment[oldApartments.length + 1];
        for (int i = 0;i < oldApartments.length; i++) {
            newApartments[i] = oldApartments[i];
        }
        newApartments[oldApartments.length] = apartment;
        return newApartments;
    }

    public static Apartment[] readApartments() {
        Apartment[] allApartments = new Apartment[0];

        try {
            BufferedReader br = new BufferedReader(new FileReader("apartments.txt"));
            String line;
            String[] infoApartments;

            while ((line = br.readLine()) != null) {
                infoApartments = line.split(" ");
                Apartment apartment = new Apartment(
                        Integer.parseInt(infoApartments[0]),
                        Integer.parseInt(infoApartments[1]),
                        Integer.parseInt(infoApartments[2]),
                        infoApartments[3],
                        Integer.parseInt(infoApartments[4])
                );
                allApartments = addNewApartment(allApartments, apartment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return allApartments;
    }
}


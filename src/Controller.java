import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.io.*;

/**
 * Created by Gustavo on 14/02/2016.
 */
public class Controller {
    Employee[] employees = Employee.readEmployees();
    Apartment[] apartments =  Apartment.readApartments();
    Reservation[] reservations = new Reservation[0];;
    Client[] clients = new Client[0];

    public void start() {
        Object[] options = {
                "Reserve an apartment",
                "Free an apartment",
                "EXIT"
        };
        int option = JOptionPane.showOptionDialog(null, "What do you want to do ?", "hotel", JOptionPane.YES_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
        if (option == 0)
            reserveApartment();
        else if (option == 1)
            freeApartment();
        else {
            saveData();
            System.exit(-1);
        }
    }

    private void saveData() {

    }

    private void freeApartment() {
        start();
    }

    private void reserveApartment() {
        String options =new String("NoAp   Rooms   Beds      Price\n");
        options = String.format("%-10s", options);

        for (int i = 0; i < apartments.length; i++) {
            if (apartments[i].getStatus().equals("available"))
                options = options + String.valueOf(apartments[i].getApartmentNo() +
                        "              " + apartments[i].getRooms() + "             " +
                        apartments[i].getBeds() + "             " + apartments[i].getPrice()) + " $\n";
        }
        String choice = JOptionPane.showInputDialog(null, options, "Choose an apartment", JOptionPane.INFORMATION_MESSAGE);

        int rezervedApartmentNumber = Integer.parseInt(choice) - 1;

        clients = Client.addNewClient(clients);

        reservations = Reservation.addNewReservation(reservations,  apartments[rezervedApartmentNumber],
                clients[clients.length - 1]);
        apartments[rezervedApartmentNumber].setStatus("reserved");
        updateFile(apartments);
        start();
    }

    private void updateFile(Apartment[] apartments) {
        if (apartments.length <= 0)
            return;
        File file = new File("apartments.txt");
        try {
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("ApNo    Rooms   Beds    Disponibility   Price\n");
            for (int i = 0; i < apartments.length; i++) {
                String apNo = new String("" + apartments[i].getApartmentNo());
                bw.write(String.format("%-8s", apNo));
                String roomNo = new String("" + apartments[i].getRooms());
                bw.write(String.format("%-8s", roomNo));
                String bedNo = new String("" + apartments[i].getBeds());
                bw.write(String.format("%-8s", bedNo));
                String status = new String(apartments[i].getStatus());
                bw.write(String.format("%-16s", status));
                String price = new String("" + apartments[i].getPrice());
                bw.write(price);
                bw.write(" $\n");
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

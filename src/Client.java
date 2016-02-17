import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;

/**
 * Created by Gustavo on 12/02/2016.
 */
public class Client {
    private String name;
    private String cnp;
    private String phone;

    public Client(String name, String  cnp, String phone) {
        this.name = name;
        this.cnp = cnp;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static Client[] addNewClient(Client[] oldClients) {
        Client[] newClients = new Client[oldClients.length + 1];

        for (int i = 0;i < oldClients.length; i++)
            newClients[i] = oldClients[i];
        String name = JOptionPane.showInputDialog("Enter your name");
        String cnp  = JOptionPane.showInputDialog("Enter your CNP");
        String phoneNumber = JOptionPane.showInputDialog("Enter your phone number");
        newClients[oldClients.length] = new Client(name, cnp, phoneNumber);
        return newClients;
    }
}

package business;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Created by Gustavo on 12/02/2016.
 */
public class Client {
    private String name;
    private int cnp;
    private String phone;

    public Client(String name, int  cnp, String phone) {
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

    public int getCnp() {
        return cnp;
    }

    public void setCnp(int cnp) {
        this.cnp = cnp;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static void addNewClient(List<Client> clients) {
        JTextField name = new JTextField("Name");
        JTextField cnp = new JTextField("Cnp");
        JPanel panel = new JPanel(new GridLayout(0, 1));
        panel.add(new JLabel("Name"));
        panel.add(name);
        panel.add(new JLabel("Cnp"));
        panel.add(cnp);
        clients.add(new Client(name.getText(), Integer.parseInt(cnp.getText()), "0241"));
    }

    @Override
    public String toString() {
        return "business.Client{" +
                "name='" + name + '\'' +
                ", cnp='" + cnp + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

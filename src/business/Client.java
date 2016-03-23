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

    @Override
    public String toString() {
        return String.valueOf(cnp) + "\n" + name;
    }
}

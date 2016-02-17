import javax.swing.*;

/**
 * Created by Gustavo on 12/02/2016.
 */
public class Main {

    public static <G> void printData(G[] objects) {
        for (G g : objects) {
            System.out.println(g.toString());
        }
    }

    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        hotel.setHotelName("Don's Hotel");
        hotel.setRestaurantSpecific("italian");

        Controller controller = new Controller();
        controller.start();

    }
}

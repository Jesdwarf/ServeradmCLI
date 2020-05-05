import controller.DigitalOceanController;
import model.Droplet;

public class Main {
    public static void main(String[] args) {
        DigitalOceanController controller = new DigitalOceanController();

        System.out.println("Droplets:");
        for (Droplet d : controller.getDroplets()) {
            System.out.println(d.toString());
        }

    }
}

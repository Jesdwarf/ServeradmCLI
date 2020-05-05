import controller.DigitalOceanController;
import model.Droplet;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args) {
        DigitalOceanController controller = new DigitalOceanController();
        try {
            controller.authorize("s170185", "Bamsefar");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        System.out.println("Droplets:");
        for (Droplet d : controller.getDroplets()) {
            System.out.println(d.toString());
        }

    }
}

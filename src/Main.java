import controller.DigitalOceanController;
import model.Droplet;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("username: ");
        String username = input.nextLine();
        System.out.println("password: ");
        String password = input.nextLine();

        DigitalOceanController controller = new DigitalOceanController();

        try {
            controller.authorize(username, password);
        } catch (Exception e) {
            e.printStackTrace();
        }


        System.out.println("Droplets:");
        for (Droplet d : controller.getDroplets()) {
            System.out.println(d.toString());
        }

    }
}

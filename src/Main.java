import controller.DigitalOceanController;
import model.Droplet;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        DigitalOceanController controller = new DigitalOceanController(input);

        System.out.println("Welcome to Serveradmin Reporting Tool. Please login.");

        try {
            controller.authorize();
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Press... \n1. for Digital Ocean\n   (Hetzner, Edis and Namecheap are not implemented)");
        input.nextLine();

        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.println("Digital Ocean Report");
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.println("Droplets:");

        double totalHourly = 0;
        double totalMonthly = 0;

        System.out.println("Name                 | Created at                    | IPv4              | Status    | Price monthly / hourly");
        System.out.println("---------------------+-------------------------------+-------------------+-----------+-----------------------");
        for (Droplet d : controller.getDroplets()) {
            System.out.println(d.toString());
            totalHourly += Double.parseDouble(d.size.price_hourly);
            totalMonthly += Double.parseDouble(d.size.price_monthly);
        }
        System.out.println("---------------------+-------------------------------+-------------------+-----------+-----------------------");

        System.out.println("\nDroplet count: " + controller.getDroplets().length);
        System.out.println("Droplet total hourly price: $" + totalHourly);
        System.out.println("Droplet total monthly price: $" + totalMonthly);

    }
}

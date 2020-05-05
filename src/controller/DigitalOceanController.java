package controller;

import brugerautorisation.data.Bruger;
import brugerautorisation.transport.rmi.Brugeradmin;
import com.google.gson.Gson;
import connection.DigitalOceanConnection;
import model.Droplet;
import model.Droplets;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

public class DigitalOceanController {
    Scanner input;
    private DigitalOceanConnection conn = DigitalOceanConnection.getInstance();
    private boolean isAuthorized = false;

    public DigitalOceanController(Scanner scanner) {
        input = scanner;
    }

    public Droplet[] getDroplets() {
        if (isAuthorized) {
            Droplets droplets = new Gson().fromJson(conn.getUnirest().get("digitalocean/droplets").asJson().getBody().toString(), Droplets.class);
            return droplets.droplets;
        }
        return null;
    }

    public void authorize() throws RemoteException, NotBoundException, MalformedURLException {
        Brugeradmin ba = (Brugeradmin) Naming.lookup("rmi://javabog.dk/brugeradmin");

        System.out.println("Username: ");
        String username = input.nextLine();
        System.out.println("Password: ");
        String password = input.nextLine();

        try {
            Bruger user = ba.hentBruger(username, password);
            isAuthorized = true;
            System.out.println("User authorized!");
        } catch (Exception e) {
            System.out.println("User not authorized. Please try again.");
            authorize();
        }

    }
}

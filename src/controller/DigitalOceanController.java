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

public class DigitalOceanController {
    private DigitalOceanConnection conn = DigitalOceanConnection.getInstance();

    private boolean isAuthorized = false;


    public Droplet[] getDroplets() {
        if (isAuthorized) {
            Droplets droplets = new Gson().fromJson(conn.getUnirest().get("digitalocean/droplets").asJson().getBody().toString(), Droplets.class);
            return droplets.droplets;
        }
        return null;
    }

    public void authorize(String username, String password) throws RemoteException, NotBoundException, MalformedURLException {
        Brugeradmin ba = (Brugeradmin) Naming.lookup("rmi://javabog.dk/brugeradmin");


        try {
            Bruger user = ba.hentBruger(username, password);

            isAuthorized = true;


            System.out.println("user authorized!");


        } catch (Exception e) {
            System.out.println("user not authorized");
        }

    }
}

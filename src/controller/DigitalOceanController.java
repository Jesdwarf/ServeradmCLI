package controller;

import com.google.gson.Gson;
import connection.DigitalOceanConnection;
import model.Droplet;
import model.Droplets;

public class DigitalOceanController {
    private DigitalOceanConnection conn = DigitalOceanConnection.getInstance();


    public Droplet[] getDroplets() {
        Droplets droplets = new Gson().fromJson(conn.getUnirest().get("digitalocean/droplets").asJson().getBody().toString(), Droplets.class);
        return droplets.droplets;
    }
}

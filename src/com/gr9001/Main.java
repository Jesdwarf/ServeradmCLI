package com.gr9001;

import com.google.gson.Gson;
import com.gr9001.Models.Droplet;
import kong.unirest.*;

public class Main {
    public static void main(String[] args) {
        UnirestInstance unirest;

        unirest = Unirest.spawnInstance();
        unirest.config()
                .addShutdownHook(true) // TODO: check perfomance vs manual shutdown
                .setDefaultHeader("Accept", "application/json")
                .setDefaultHeader("Content-Type", "application/json")
                .defaultBaseUrl("http://localhost:8080/");


        Droplet[] droplets = new Gson().fromJson(unirest.get("digitalocean/droplets").asJson().getBody().toString(), Droplet[].class);


        System.out.println(droplets.toString());


    }
}

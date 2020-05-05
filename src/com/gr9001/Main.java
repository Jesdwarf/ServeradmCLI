package com.gr9001;

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

        System.out.println(unirest.get("digitalocean/droplets").asJson().getBody());

    }
}

import com.google.gson.Gson;
import kong.unirest.*;
import models.Droplets;

public class Main {
    public static void main(String[] args) {
        UnirestInstance unirest;

        unirest = Unirest.spawnInstance();
        unirest.config()
                .addShutdownHook(true) // TODO: check perfomance vs manual shutdown
                .setDefaultHeader("Accept", "application/json")
                .setDefaultHeader("Content-Type", "application/json")
                .defaultBaseUrl("http://localhost:8080/");

        Droplets droplets = new Gson().fromJson(unirest.get("digitalocean/droplets").asJson().getBody().toString(), Droplets.class);

        System.out.println(droplets.droplets[0].name);

    }
}

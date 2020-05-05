package connection;

import kong.unirest.Unirest;
import kong.unirest.UnirestInstance;

public class DigitalOceanConnection {
    private static DigitalOceanConnection connection = null;
    private final String RESTURL = "http://localhost:8080/";
    private static UnirestInstance unirest;

    private DigitalOceanConnection() {
        unirest = Unirest.spawnInstance();
        unirest.config()
                .addShutdownHook(true)
                .setDefaultHeader("Accept", "application/json")
                .setDefaultHeader("Content-Type", "application/json")
                .defaultBaseUrl(RESTURL);
    }

    public static DigitalOceanConnection getInstance() {
        if (connection == null) {
            connection = new DigitalOceanConnection();
        }
        return connection;
    }

    public UnirestInstance getUnirest() {
        return unirest;
    }

}

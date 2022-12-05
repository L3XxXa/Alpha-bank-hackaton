package newthread.server.backend.Utils;

import newthread.server.backend.Entity.Card;
import springfox.documentation.builders.RequestParameterBuilder;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.http.HttpRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiConnector {
    public void findPoints(List<Card> cards, Point2D sortPoint) throws IOException {

        long time = System.currentTimeMillis();
        for (Card card : cards) {
            String name = card.getName();
            URL url = new URL("https://catalog.api.2gis.com/3.0/" +
                    "items?q=" + name +
                    "&sort_point=" + sortPoint.getX() + "," + sortPoint.getY() +
                    "&key=KEKEKE&" +
                    "sort=distance&");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            try (BufferedReader in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()))) {
                String line;
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                }
            }
        }
        System.out.println(System.currentTimeMillis() - time);

    }
}

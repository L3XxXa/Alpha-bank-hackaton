package newthread.server.backend.Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import newthread.server.backend.Entity.Card;
import newthread.server.backend.Repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;


public class ApiConnector {
    @Autowired
    CardRepository cardRepository;

    private int notNullPointers = 0;

    public Map<Double, Long> findPoints(List<Card> cards, Point2D sortPoint, List<Double> results) throws IOException {

        long time = System.currentTimeMillis();
        Map<Double, Long> distanceToId = new HashMap<>();
        for (Card card : cards) {
            String name = card.getName();
            URL url = new URL("https://catalog.api.2gis.com/3.0/" +
                    "items?q=" + name +
                    "&sort_point=" + sortPoint.getY() + "," + sortPoint.getX() +
                    "&key=ruhrcj6622&" +
                    "sort=distance&" +
                    "fields=items.point");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            try (BufferedReader in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()))) {
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                var result = parseJson(response);
                if (result != null) {
                    Double distance = Point2D.Double.distance(result.getX(), result.getY()
                            , sortPoint.getX(), sortPoint.getY());
                    distanceToId.put(distance, card.getId());
                    results.add(Math.abs(distance));
                } else {
                    distanceToId.put(Double.MAX_VALUE, card.getId());
                    results.add(Double.MAX_VALUE);
                }

            }
        }
        Collections.sort(results);
        return distanceToId;

    }

    private Point2D parseJson(StringBuilder response) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Map<String, Object>> map
                = objectMapper.readValue(response.toString(), new TypeReference<>() {
        });
        try {
            Object result = map.get("result").get("items");
            String respData = objectMapper.writeValueAsString(result);
            List<Object> respList = objectMapper.readValue(respData, List.class);
            respData = objectMapper.writeValueAsString(respList.get(0));
            Map<String, Object> respMap = objectMapper.readValue(respData, Map.class);
            respData = objectMapper.writeValueAsString(respMap.get("point"));
            Map<String, Double> res = objectMapper.readValue(respData, Map.class);
            Point2D resPoint = new Point2D.Double(res.get("lat"), res.get("lon"));
            notNullPointers++;
            return resPoint;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
}

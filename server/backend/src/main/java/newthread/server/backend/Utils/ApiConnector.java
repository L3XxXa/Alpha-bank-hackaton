package newthread.server.backend.Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
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
import java.util.ArrayList;
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
                    "&sort_point=" + sortPoint.getY() + "," + sortPoint.getX() +
                    "&key=KEY_API&" +
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
                System.out.println(result);
            }
        }
        System.out.println(System.currentTimeMillis() - time);

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
            return resPoint;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }

    }
}

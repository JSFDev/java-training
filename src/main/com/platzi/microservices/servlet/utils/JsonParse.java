package main.com.platzi.microservices.servlet.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class JsonParse {
    public static String getJsonParametersByRequest(HttpServletRequest req, ArrayList<String> parameters) {
        JSONObject outObject = new JSONObject();

        try {
            for (String param : parameters) {
                outObject.put(param, req.getParameter(param));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return outObject.toString();
    }

    /**
     * deserialization from json input reader to object class.
     *
     * @param reader     buffered from characters to read json.
     * @param objectType class type to map by data buffered reader.
     * @return String json mapped from object deserialize.
     */
    public static String getJsonMapperObjectByStream(BufferedReader reader, Class objectType) {
        Object objectMapper = null;

        try {
            StringBuilder jsonReader = new StringBuilder();
            ObjectMapper jsonMapper = new ObjectMapper();
            String newLine;

            while ((newLine = reader.readLine()) != null) {
                jsonReader.append(newLine);
            }

            objectMapper = jsonMapper.readValue(jsonReader.toString(), objectType);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return objectMapper != null ? objectMapper.toString() : new JSONObject().toString();
    }
}

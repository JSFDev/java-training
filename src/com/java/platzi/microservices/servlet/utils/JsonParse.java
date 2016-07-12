package com.java.platzi.microservices.servlet.utils;

import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

public class JsonParse {
    public static String getJsonStringByRequest(HttpServletRequest req, ArrayList<String> parameters) {
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
}

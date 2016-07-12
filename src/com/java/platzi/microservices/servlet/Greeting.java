package com.java.platzi.microservices.servlet;

import com.java.platzi.microservices.servlet.utils.JsonParse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet(
        urlPatterns = {"/greeting"},
        initParams = {
                @WebInitParam(name = "user", value = "default-user"),
                @WebInitParam(name = "age", value = "default-age"),
        })
public class Greeting extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        ArrayList<String> parameters = new ArrayList<>(Arrays.asList("message", "age"));
        PrintWriter respWriter = resp.getWriter();
        respWriter.print(JsonParse.getJsonStringByRequest(req, parameters));
        respWriter.flush();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }
}

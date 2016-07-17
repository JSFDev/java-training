package main.com.platzi.microservices.rest.servlet.jee;

import main.com.platzi.microservices.utils.JsonParse;
import main.com.platzi.simple.UserPojo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet(
        urlPatterns = {"/user"},
        initParams = {
                @WebInitParam(name = "name", value = "default-userName"),
                @WebInitParam(name = "age", value = "default-userAge"),
        })
public class UserDataServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        ArrayList<String> parameters = new ArrayList<>(Arrays.asList("name", "age"));
        PrintWriter respWriter = resp.getWriter();
        respWriter.print(JsonParse.getJsonParametersByRequest(req, parameters));
        respWriter.close();
    }

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json");
        PrintWriter respWriter = resp.getWriter();
        BufferedReader reqPost = req.getReader();
        respWriter.print(JsonParse.getJsonMapperObjectByStream(reqPost, UserPojo.class));
        respWriter.close();
        reqPost.close();
    }
}

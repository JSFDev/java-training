package main.com.platzi.microservices.rest.servlet.springBoot;

import main.com.platzi.simple.UserPojo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserDataServlet {

    @RequestMapping(value = "/user", method = RequestMethod.GET, produces = "application/json")
    public UserPojo user() {
        return new UserPojo("Pepe", "Lopera", "pepe@gmail", "taurus", 0, 1, "1972-12-15");
    }
}

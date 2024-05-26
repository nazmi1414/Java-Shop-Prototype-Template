package com.IvAssessment.IvCodeAssignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class LoginController {

    @Autowired
    LoginService service;

    @RequestMapping(value="/login", method= RequestMethod.GET)
    public String viewLoginPage(ModelMap map) {
        return "login-page";
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public String showWelcomePage(ModelMap model, @RequestParam String name, @RequestParam String password){

        boolean isValidUser = service.validateUser(name, password);

        if (!isValidUser) {
            model.put("errorMessage", "Access Denied , Invalid Credentials");
            return "login-page";
        }

        model.put("name", name);
        model.put("password", password);

        return "redirect:/shops/1";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String showLogoutPage(ModelMap model){
        return "login-page";
    }

}
package com.routefinder.spring.mvc.controller;

import com.routefinder.bean.RatingBean;
import com.routefinder.model.Route;
import com.routefinder.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.Objects;

/**
 * Created by karpukdm on 01.04.16.
 */
@ManagedBean
@SessionScoped
@Component
@Controller
public class RouteFinderController {

    private Route route;

    @Autowired
    private RouteService routeService;

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(Model model) {

        return "main";
    }

    @RequestMapping("/home")
    public String home(Model model) {

        return "home";
    }

    @RequestMapping("/route/{id}")
    public String route(@PathVariable Integer id, Model model) {

        if (id != null) {
            if (this.route == null || !Objects.equals(id, this.route.getId())) {
                this.route = routeService.findOneRouteById(id);
            }
        }

        model.addAttribute(this.route);

        return "route";

    }

    @RequestMapping("/profile")
    public String profile(Model model) {

        return "profile";
    }

    @RequestMapping("/signup")
    public String registrate(Model model) {

        return "registration";
    }

    @RequestMapping("/favorites")
    public String favorites(Model model) {

        return "favorites";
    }

    @RequestMapping("/myroutes")
    public String myroutes(Model model) {

        return "my-routes";
    }

    @RequestMapping("/reminders")
    public String reminders(Model model) {

        return "my-reminders";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {

       /* Authentication authentication = SecurityContextHolder.getContext().
                getAuthentication();
        String name = authentication.getName();
        model.addAttribute("username", name);
        model.addAttribute("message", "Welcome to Spring");*/

        return "profile";
    }

    @RequestMapping("/comments")
    public String comments(Model model) {

        return "my-comments";
    }

    @RequestMapping("/marks")
    public String marks(Model model) {

        return "my-marks";
    }

    @RequestMapping("/admin")
    public String admin(Model model) {

        return "admin";
    }

    @RequestMapping("/help")
    public String help(Model model) {

        return "help";
    }

    @RequestMapping("/settings")
    public String settings(Model model) {

        return "settings";
    }

    @RequestMapping("/createroute")
    public String createroute(Model model) {

        return "creating-route";
    }

    @RequestMapping("/search")
    public String search(Model model) {

        return "search";
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }
}

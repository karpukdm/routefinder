package com.routefinder.bean;

import com.routefinder.model.Account;
import com.routefinder.model.FavoriteRoute;
import com.routefinder.model.Route;
import com.routefinder.service.AccountService;
import com.routefinder.service.CommentService;
import com.routefinder.service.FavoriteRouteService;
import com.routefinder.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.Map;

/**
 * Created by offsp on 21.04.2016.
 */
@ManagedBean
@SessionScoped
@Component
public class RoutePageBean {

    @Autowired
    private RouteService routeService;

    @Autowired
    private AccountService accountService;

    @Autowired
    private CommentService commentService;

    @Autowired
    private FavoriteRouteService favoriteRouteService;

    private Route route;

    private FavoriteRoute favoriteRoute;

    public void deleteRoute() {

        commentService.deleteOrderByRoute_Id(route.getId());

        routeService.delete(route);
    }

    public void edit(){


    }

    public void subscribe(){

        if(favoriteRoute != null || isSubscriber()){

            return;
        }

        this.route.addSubscriber();

        FavoriteRoute favoriteRoute = new FavoriteRoute();
        favoriteRoute.setRoute(this.route);
        favoriteRoute.setAccount(accountService.findOneAccountByLogin(AccountBean.getUsername()));

        favoriteRouteService.saveAndFlush(favoriteRoute);
    }

    public void unsubscribe(){

        if(favoriteRoute != null && isSubscriber()){

            route.unsubscribe();
            routeService.saveAndFlush(route);

            favoriteRouteService.delete(favoriteRoute);
        }
    }

    public Route getRoute() {
        return this.route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public boolean isSubscriber() {

        String login = AccountBean.getUsername();

        Account account = accountService.findOneAccountByLogin(login);

        favoriteRoute = favoriteRouteService.findOneOrderByAccount_IdAndRoute_Id(account.getId(), route.getId());

        return favoriteRoute != null;
    }
}

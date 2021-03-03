package org.AirportFrontApp.contoller;

import org.AirportFrontApp.model.Airplane;
import org.AirportFrontApp.model.ResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.ModelAndView;

import javax.security.auth.login.Configuration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Controller
public class Controller {

    private WebClient.Builder webClientBuilder;

    @Autowired
    private Controller(WebClient.Builder webClient) {
        this.webClientBuilder = webClient;
    }

    @RequestMapping("home")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        return mv;
    }

    List<Airplane> listDB = new ArrayList<>();

    //The method is named addAlien like the name of the form on home.jsp
    @RequestMapping("/addAirplane")
    public ModelAndView addAirplane(Airplane airplane) {

        ModelAndView mv = new ModelAndView();
        mv.addObject("airplane", airplane);
        mv.setViewName("addAirplane");
        return mv;
    }

    @RequestMapping("/getAirplane")
    public ModelAndView getAirplane(int id) {

        ResponseService responseService = webClientBuilder.build()
                .get()
                .uri("http://localhost:8082/airplane/" + id)
                .retrieve()
                //Mono means - you'll get an object but no right away (because webClient is an asynchronous call)
                .bodyToMono(ResponseService.class)
                //block makes us wait for the response from the webClient
                .block();

        ModelAndView mv = new ModelAndView();
        if (responseService != null && responseService.getRequestedObject() instanceof Airplane) {
            Airplane airplane = Optional.ofNullable((Airplane) responseService.getRequestedObject()).orElse(new Airplane());
            if (airplane.getId() != null) {
                mv.addObject("airplane", airplane);
                mv.setViewName("getAirplane");
            }
            else{
                mv.addObject("airplane", id);
                mv.setViewName("airplaneError");
            }
        } else {
            mv.addObject("airplane", id);
            mv.setViewName("airplaneError");
        }

        return mv;
    }

}

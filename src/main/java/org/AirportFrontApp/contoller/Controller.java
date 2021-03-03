package org.AirportFrontApp.contoller;

import org.AirportFrontApp.model.Airplane;
import org.AirportFrontApp.model.ResponseService;
import org.AirportFrontApp.service.AirplaneResponseVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    private WebClient.Builder webClientBuilder;

    private AirplaneResponseVerifier airplaneResponseVerifier;

    @Autowired
    private Controller(WebClient.Builder webClient, AirplaneResponseVerifier airplaneResponseVerifier) {
        this.webClientBuilder = webClient;
        this.airplaneResponseVerifier = airplaneResponseVerifier;
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

        return airplaneResponseVerifier.verifyGetResponse(responseService) ;
    }

}

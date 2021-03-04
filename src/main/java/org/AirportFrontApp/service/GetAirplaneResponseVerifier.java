package org.AirportFrontApp.service;

import org.AirportFrontApp.model.Airplane;
import org.AirportFrontApp.model.ResponseService;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

public class GetAirplaneResponseVerifier {

    public static ModelAndView verifyGetResponse(ResponseService responseService) {
        ModelAndView frontResponse = new ModelAndView();

        if (isResponseNull(responseService)) {
            frontResponse.setViewName("responseNullError");
            return frontResponse;
        }

        if (!responseService.isOperationSuccess()) {
            frontResponse.addObject("responseService", responseService);
            frontResponse.setViewName("airplaneError");
            return frontResponse;
        }

        Airplane airplane = Optional.ofNullable((Airplane) responseService.getRequestedObject()).orElse(null);

        if (isAirplaneNull(airplane) || airplane.getId() == null) {

            responseService.setMessage("error trying to get the airplane information");
            frontResponse.addObject("responseService", responseService);
            frontResponse.setViewName("airplaneError");
            return frontResponse;
        }
        //all went right
        frontResponse.addObject("airplane", airplane);
        frontResponse.setViewName("getAirplane");
        return frontResponse;
    }

    private static boolean isResponseNull(ResponseService responseService) {
        return responseService == null;
    }

    private static boolean isAirplaneNull(Airplane airplane) {
        return airplane == null;
    }

}

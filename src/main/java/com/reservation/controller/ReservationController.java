package com.reservation.controller;

import com.reservation.dto.DateDto;
import com.reservation.entity.Reservation;
import com.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @RequestMapping(value ="restaurant/{id}/reservation.html" ,method = RequestMethod.GET)
    public String Home(Model model,@PathVariable int id){
        model.addAttribute("id" , id);
        return "reservation";
    }

    @PostMapping("/your-controller-url")
    @ResponseBody
    public int makeReservation(@RequestBody DateDto datedto) {
        return reservationService.makeReservation(datedto);
    }





}

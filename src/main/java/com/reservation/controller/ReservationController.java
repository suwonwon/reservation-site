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
        List<HashMap<String, Integer>> rs_id=  reservationService.findByRsid(id);
        model.addAttribute("time" , rs_id);
        System.out.println(reservationService.findByRsid(id));
        return "reservation";
    }

    @PostMapping("/your-controller-url")
    public String makeReservation(@RequestBody DateDto datedto) {
        // 전송된 데이터를 사용하여 예약을 처리하는 로직 수행

        int a = reservationService.makeReservation(datedto);
        System.out.println(a);

        // 예약 처리 후 응답 반환
        return "index";
    }





}

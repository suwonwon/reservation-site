package com.reservation.controller;

import com.reservation.dto.DateDto;
import com.reservation.dto.ReservationFormDto;
import com.reservation.dto.findReDto;
import com.reservation.entity.Image;
import com.reservation.entity.Restaurant;
import com.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;


    //예약페이지로가기
    @RequestMapping(value ="restaurant/{rsId}/reservation.html" ,method = RequestMethod.GET)
    public String Home(Model model,@PathVariable int rsId){
        Restaurant restaurant = reservationService.findRestaurant(rsId);
        Image image = reservationService.findImage(restaurant);
        model.addAttribute("id" , rsId);
        model.addAttribute("restaurant",restaurant);
        model.addAttribute("image",image);
        return "reservation";
    }


    //DB에서 시간확인
    @PostMapping("/reservationtime")
    @ResponseBody
    public int makeReservation(@RequestBody DateDto datedto) {
        return reservationService.findTime(datedto);
    }


    //예약하기
    @PostMapping("/reservation/save")
    public String  createReservation(@RequestBody ReservationFormDto formDto) {

       reservationService.createReservation(formDto);

       return "index";

    }

    //예약내역
    @GetMapping("/mypage/{memberId}/reservation-details.html")
    public String findReservations(Model model,@PathVariable("memberId") int memberId ){

        List<findReDto> reservations = reservationService.findReservations(memberId);
        String currentTime = reservationService.getCurrentTime();

        model.addAttribute("currentTime",currentTime);
        model.addAttribute("reservations",reservations);

        return "reservation-details";
    }

    @GetMapping("/reservation/cancel")
    @ResponseBody
    public int statusReservation(@RequestParam("re_id") int re_id){
        //예약상태=1; 예약취소상태=0;
        int status = reservationService.statusReservation(re_id);
        return status;

    }
}

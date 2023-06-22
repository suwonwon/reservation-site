package com.reservation.controller;

import com.reservation.dto.MainRestaurantDto;
import com.reservation.dto.RestaurantSearchDto;
import com.reservation.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final RestaurantService restaurantService;

    @RequestMapping(value ="/" ,method = RequestMethod.GET)
    public String Home(){
        return "index";
    }
/*
    @GetMapping(value = "/")
    public String Home(RestaurantSearchDto restaurantSearchDto, Optional<Integer> page,
                       Model model){
        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0,12); //12로 임시로 설정
        Page<MainRestaurantDto> restaurants = restaurantService.getMainRestaurantPage(restaurantSearchDto, pageable);
        model.addAttribute("restaurants", restaurants);
        model.addAttribute("restaurantSearchDto", restaurantSearchDto);
        model.addAttribute("maxPage",10);
        return "index";
    } */

}

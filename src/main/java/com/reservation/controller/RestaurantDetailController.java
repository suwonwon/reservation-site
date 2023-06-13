package com.reservation.controller;


import com.reservation.dto.RestaurantDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/restaurant/detail")
public class RestaurantDetailController {



    @GetMapping
    public String detail(Model model, RestaurantDto restaurantDto) {
        model.addAttribute("restaurantDetail", restaurantDto);
        return "property-single";
    }

    @GetMapping("/test/home")
    public String home(Model model, RestaurantDto restaurantDto){
        model.addAttribute("restaurantDetail", restaurantDto);
        return "/restaurant/detail/home";
    }

    @GetMapping("/test/menu")
    public String menu(Model model, RestaurantDto restaurantDto){
        model.addAttribute("restaurantDetail", restaurantDto);
        return "/restaurant/detail/menu";
    }
    @GetMapping("/test/photo")
    public String photo(Model model, RestaurantDto restaurantDto){
        model.addAttribute("restaurantDetail", restaurantDto);
        return "/restaurant/detail/photo";
    }
    @GetMapping("/test/review")
    public String review(Model model, RestaurantDto restaurantDto){
        model.addAttribute("restaurantDetail", restaurantDto);
        return "/restaurant/detail/review";
    }

}

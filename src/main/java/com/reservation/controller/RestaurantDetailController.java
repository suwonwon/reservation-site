package com.reservation.controller;


import com.reservation.dto.RestaurantDto;
import com.reservation.dto.ReviewDto;
import com.reservation.entity.Member;
import com.reservation.entity.Restaurant;
import com.reservation.entity.Review;
import com.reservation.service.MemberService;
import com.reservation.service.RestaurantService;
import com.reservation.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/restaurant/detail")
public class RestaurantDetailController {

    private final RestaurantService restaurantService;
    private final ReviewService reviewService;
    private final MemberService memberService;
    @GetMapping("/{rs_id}")
    public String detail(@PathVariable int rs_id, Model model, RestaurantDto restaurantDto) {
        Restaurant restaurant = restaurantService.findById(rs_id).get();


        model.addAttribute("restaurantDetail", restaurant);
        return "property-single";
    }

    @GetMapping("/{rs_id}/home")
    public String home(@PathVariable int rs_id,Model model, RestaurantDto restaurantDto){
        Restaurant restaurant = restaurantService.findById(rs_id).get();
        model.addAttribute("restaurantDetail", restaurant);
        return "/restaurant/detail/home";
    }

    @GetMapping("/{rs_id}/menu")
    public String menu(@PathVariable int rs_id,Model model, RestaurantDto restaurantDto){
        Restaurant restaurant = restaurantService.findById(rs_id).get();
        model.addAttribute("restaurantDetail", restaurant);
        return "/restaurant/detail/menu";
    }
    @GetMapping("/{rs_id}/photo")
    public String photo(@PathVariable int rs_id,Model model, RestaurantDto restaurantDto){
        Restaurant restaurant = restaurantService.findById(rs_id).get();
        model.addAttribute("restaurantDetail", restaurant);
        return "/restaurant/detail/photo";
    }
    @GetMapping("/{rs_id}/review")
    public String review(@PathVariable int rs_id, Model model, Pageable pageable, Principal principal){
        Restaurant restaurant = restaurantService.findById(rs_id).get();
        Page<Review> reviewPage = reviewService.getAllReviewsForRestaurant(restaurant, pageable);
        model.addAttribute("reviews", reviewPage.getContent());
        model.addAttribute("page", reviewPage);
        model.addAttribute("restaurantDetail", restaurant);
        return "/restaurant/detail/review";
    }

    @PostMapping("/{rs_id}/review")
    public String review(@PathVariable int rs_id, @RequestParam("contents") String contents,
                         @RequestParam("scope") String scope, Principal principal) {

        Restaurant restaurant = restaurantService.findById(rs_id).get();
        Review review = new Review();
        String memberId = principal.getName();
        Member member = memberService.findByMemberId(memberId);
        review.setM_id(member);
        review.setRs_id(restaurant);
        review.setContents(contents);
        review.setScope(Integer.parseInt(scope));
        reviewService.save(review);
        return "redirect:/restaurant/detail/{rs_id}";
    }


}

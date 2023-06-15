package com.reservation.controller;


import com.reservation.entity.Member;
import com.reservation.entity.Restaurant;
import com.reservation.service.MemberService;
import com.reservation.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/member")
public class MemberController {
    private final MemberService memberService;
    private final RestaurantService restaurantService;

    @GetMapping("/join/person")
    public String joinForm(@ModelAttribute("member") Member member) {
        return "member/addMemberForm";
    }

    @PostMapping("/join/person")
    public String memberSave(@Validated @ModelAttribute Member member, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "member/addMemberForm";
        }
        memberService.save(member);


        return "redirect:/";
    }

    @GetMapping("join/restaurant")
    public String joinRestaurantForm(@ModelAttribute("restaurant") Restaurant restaurant,
                                     @ModelAttribute("member") Member member) {
        return "restaurant/form/addRestaurantForm";
    }

    @PostMapping("/join/restaurant")
    public String restaurantSave(@Validated @ModelAttribute Restaurant restaurant
            ,@Validated @ModelAttribute Member member, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "restaurant/form/addRestaurantForm";
        }
        Member member1 = new Member();
        member1.setId(member.getPassword());
        member1.setPassword(member.getPassword());
        member1.setName(member.getName());
        member1.setE_mail(member.getE_mail());
        Restaurant restaurant1 = new Restaurant();
        restaurant1.setRs_member(member1);
        restaurant1.setCategory(restaurant.getCategory());
        restaurant1.setAddress(restaurant.getAddress());
        restaurant1.setRs_img(restaurant.getRs_img());
        restaurant1.setRs_info(restaurant.getRs_info());
        restaurant1.setIntroduction(restaurant.getIntroduction());
        restaurant1.setRs_name(restaurant.getRs_name());
        restaurantService.save(restaurant1);
        return "redirect:/";
    }


}

package com.reservation.controller;


import com.reservation.constant.ReservationStatus;
import com.reservation.constant.Role;
import com.reservation.entity.Member;
import com.reservation.entity.Restaurant;
import com.reservation.service.MemberService;
import com.reservation.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping(value = "/member")
public class MemberController {
    private final MemberService memberService;
    private final RestaurantService restaurantService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/join/person")
    public String joinForm(@ModelAttribute("member") Member member) {
        return "member/addMemberForm";
    }

    @PostMapping("/join/person")
    public String memberSave(@Validated @ModelAttribute Member member, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "member/addMemberForm";
        }
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        member.setRole(Role.USER);
        member.setStatus(ReservationStatus.VALID.toString());
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
            , @Validated @ModelAttribute Member member, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "restaurant/form/addRestaurantForm";
        }
        Member member1 = new Member();
        member1.setId(member.getPassword());
        member1.setPassword(passwordEncoder.encode(member.getPassword()));
        member1.setName(member.getName());
        member1.setE_mail(member.getE_mail());
        member1.setRole(Role.OWNER);
        member1.setStatus(ReservationStatus.VALID.toString());
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

    @GetMapping("/login")
    public String login() {
        return "member/loginForm";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.error("???");
        if (authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);

        }

        return "redirect:/";
    }
}

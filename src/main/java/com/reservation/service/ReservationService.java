package com.reservation.service;

import com.reservation.dto.DateDto;
import com.reservation.dto.ReservationFormDto;
import com.reservation.dto.findReDto;
import com.reservation.dto.findRsImg;
import com.reservation.entity.Image;
import com.reservation.entity.Reservation;
import com.reservation.entity.Restaurant;
import com.reservation.repository.ReservationRepository;
import com.reservation.repository.ReservationRepositoryImpl;
import com.reservation.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
@Transactional
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    RestaurantRepository restaurantRepository;
    @Autowired
    ReservationRepositoryImpl repository;

    //식당조회
    public Restaurant findRestaurant(int rsId){
        Restaurant restaurant = repository.findRestaurant(rsId);
        com.reservation.dto.Restaurant restaurant2 = new com.reservation.dto.Restaurant();
        restaurant2.setRs_id(restaurant.getRsId());
        restaurant2.setRs_name(restaurant2.getRs_name());
        restaurant2.setAddress(restaurant2.getAddress());
        restaurant2.setCategory(restaurant2.getAddress());
        restaurant2.setRs_info(restaurant2.getRs_info());
        restaurant2.setIntroduction(restaurant2.getIntroduction());
        restaurant2.setRs_num(restaurant2.getRs_num());
        return restaurant;
    }
    public Image findImage(Restaurant restaurant){
        Image image = repository.findImage(restaurant);
        return image;
    }

    //넘어온 식당id를 가지고 해당날짜와 시간대에 예약이있나 확인하는 서비스
    public List<HashMap<String, Integer>> findByRsid(int id){
        List<Reservation> re = reservationRepository.findByRsId(id);
        List<HashMap<String, Integer>> asd = new ArrayList<>();
        for (int i=0;i<re.size(); i++){
            HashMap<String,Integer> ss= new HashMap<>();
            ss.put("년",re.get(i).getCreate_date().getYear()+1900);
            ss.put("월",re.get(i).getCreate_date().getMonth()+1);
            ss.put("일",re.get(i).getCreate_date().getDate());
            ss.put("시",re.get(i).getCreate_date().getHours());
            asd.add(ss);
        }
        return asd;
    }


    public int findTime(@RequestBody DateDto datedto) {
        // 전송된 데이터를 사용하여 예약을 처리하는 로직 수행

        int status=0;

        int id=datedto.getId();
        int year = datedto.getYear();
        int month = datedto.getMonth();
        int day = datedto.getDay();
        int hour = datedto.getHour();
        // LocalDateTime 객체 생성
        LocalDateTime targetDateTime = LocalDateTime.of(year, month, day, hour, 0, 0);

        // DateTimeFormatter를 사용하여 형식화된 문자열 생성
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDatetime = targetDateTime.format(formatter);

        // formattedDatetime을 LocalDateTime으로 변환하여 쿼리 실행
        LocalDateTime parsedDatetime = LocalDateTime.parse(formattedDatetime, formatter);

        // LocalDateTime을 java.util.Date로 변환
        Date date = Date.from(parsedDatetime.atZone(ZoneId.systemDefault()).toInstant());

        String result = reservationRepository.findTime(date,id);
        System.out.println("asd"+result);

        if (result!=null){
            status=1;
        }

        return status;
    }

    public void createReservation(@RequestBody ReservationFormDto formDto) {
        Restaurant foundRestaurant =null;
        Reservation rv = new Reservation();
        Restaurant rs = new Restaurant();
        Optional<Restaurant> restaurant = restaurantRepository.findById(formDto.getId());
        if (restaurant.isPresent()) {
            foundRestaurant = restaurant.get();
        }


        int year = formDto.getYear();
        int month = formDto.getMonth();
        int day = formDto.getDay();
        int hour = formDto.getHour();
        // LocalDateTime 객체 생성
        LocalDateTime targetDateTime = LocalDateTime.of(year, month, day, hour, 0, 0);

        // DateTimeFormatter를 사용하여 형식화된 문자열 생성
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDatetime = targetDateTime.format(formatter);

        // formattedDatetime을 LocalDateTime으로 변환하여 쿼리 실행
        LocalDateTime parsedDatetime = LocalDateTime.parse(formattedDatetime, formatter);

        // LocalDateTime을 java.util.Date로 변환
        Date date = Date.from(parsedDatetime.atZone(ZoneId.systemDefault()).toInstant());
        //rv.setM_id(); 세션추가되면 삽입
        rv.setRsId(formDto.getId());
        rv.setCreate_date(date);
        rv.setReservation_status(1);
        rv.setRequest(formDto.getInputValue());
        rv.setPeople(formDto.getCount());
        rv.setReservation_status(1);
        rv.setRe_restaurant(foundRestaurant);
        reservationRepository.save(rv);
    }

    public List<findReDto> findReservations(int memberId){
        List<findReDto> reservations = repository.findReservations(memberId);
        return repository.findReservations(memberId);
    }

    public int statusReservation(int re_id){
        int st = repository.statusReservation(re_id);

        return st;
    }
    public String getCurrentTime() {
        // 현재 시간 가져오기
        LocalDateTime currentTime = LocalDateTime.now();

        // 시간 포맷 지정
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // 포맷에 맞게 현재 시간을 문자열로 변환
        String formattedTime = currentTime.format(formatter);

        // 프론트엔드로 현재 시간 문자열 반환
        return formattedTime;
    }




}

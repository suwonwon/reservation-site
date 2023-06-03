package com.reservation.service;

import com.reservation.entity.Reservation;
import com.reservation.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    public List<Reservation> findAll(){
        List<Reservation> re = reservationRepository.findAll();
        return reservationRepository.findAll();
    }
    //넘어온 식당id를 가지고 해당날짜와 시간대에 예약이있나 확인하는 서비스
    public List<Map<String, Integer>> findById(int id){
        List<Reservation> re = reservationRepository.findById(id);
        List<Map<String, Integer>> resultList = new ArrayList<>();
        for (int i = 0; i < re.size(); i++) {
            Map<String, Integer> dataMap = new HashMap<>();
            dataMap.put("month", re.get(i).getCreate_date().getMonth()+1);
            dataMap.put("date", re.get(i).getCreate_date().getDate());
            dataMap.put("hours", re.get(i).getCreate_date().getHours());
            resultList.add(dataMap);
        }

        return resultList;
    }





}

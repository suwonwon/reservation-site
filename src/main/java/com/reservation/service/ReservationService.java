package com.reservation.service;

import com.reservation.entity.Reservation;
import com.reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<HashMap<String, Integer>> findByRsid(int id){
        List<Reservation> re = reservationRepository.findByRsid(id);
        List<HashMap<String, Integer>> asd = new ArrayList<>();
        for (int i=0;i<re.size(); i++){
            HashMap<String,Integer> ss= new HashMap<>();
            ss.put("월",re.get(i).getCreate_date().getMonth()+1);
            ss.put("일",re.get(i).getCreate_date().getDay());
            ss.put("시간",re.get(i).getCreate_date().getHours());
            asd.add(ss);
        }
        return asd;
    }





}

package com.reservation.service;

import com.reservation.dto.DateDto;
import com.reservation.dto.ReservationFormDto;
import com.reservation.entity.Reservation;
import com.reservation.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

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
            ss.put("년",re.get(i).getCreate_date().getYear()+1900);
            ss.put("월",re.get(i).getCreate_date().getMonth()+1);
            ss.put("일",re.get(i).getCreate_date().getDate());
            ss.put("시",re.get(i).getCreate_date().getHours());
            asd.add(ss);
        }
        return asd;
    }


    public int makeReservation(@RequestBody DateDto datedto) {
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

        String result = reservationRepository.executeQuery(date,id);

        if (result!=null){
            status=1;
        }

        return status;
    }

    public void createReservation(@RequestBody ReservationFormDto formDto) {
        Reservation rv = new Reservation();

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
        rv.setRsid(formDto.getId());
        rv.setCreate_date(date);
        rv.setReservation_status(1);
        rv.setRequest(formDto.getInputValue());
        rv.setPeople(formDto.getCount());
        reservationRepository.save(rv);
    }


}

package com.ds.moon.dsproject.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ds.moon.dsproject.entity.Hb;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class HbService {
    RestTemplate restTemplate = new RestTemplate();
    String url = "";
    List<Hb> HbList = new ArrayList<>();

    public List<Hb> getListHb() {
        url = "http://localhost:8082/bt/hblist";
     
            ResponseEntity<List<Hb>> responseEntity = restTemplate.exchange(
                    url, HttpMethod.GET, null,
                    new ParameterizedTypeReference<List<Hb>>() {
                    });
            System.out.println("status : " + responseEntity.getStatusCode());
            System.out.println("body : " + responseEntity.getBody());
          
            return responseEntity.getBody();

    }

}

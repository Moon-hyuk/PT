package com.ds.moon.dsproject.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.ds.moon.dsproject.entity.Dept;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class DpService {
    RestTemplate restTemplate = new RestTemplate();
    String url = "http://localhost:8082";
    
    public List<Dept> getListDept(){
        url += "/bt/dplist";

        ResponseEntity<List<Dept>> responseEntity = restTemplate.exchange(
            url, HttpMethod.GET, null,
            new ParameterizedTypeReference<List<Dept>>() {});
        System.out.println("status : " + responseEntity.getStatusCode());
        System.out.println("body : " + responseEntity.getBody());
        return responseEntity.getBody();
    }
}



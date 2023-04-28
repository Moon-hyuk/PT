package com.ds.moon.dsproject.service;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class RestTemplateService {

    // http://localhost/api/server/hello
    public String hello() {
        URI uri = UriComponentsBuilder // 주소를 만들떄 : UriComponentBuilder를 사용
                .fromUriString("http://localhost:8082")
                .path("/api/server/hello")
                .encode()
                .build()
                .toUri();
        RestTemplate restTemplate = new RestTemplate();
        // RestTemplate Pool을 만들어서 사용해야 한다.
        // String result = restTemplate.getForObject(uri, String.class);
        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        System.out.println(result.getStatusCode());
        System.out.println(result.getBody());
        // return result;
        return result.getBody();

    }
}
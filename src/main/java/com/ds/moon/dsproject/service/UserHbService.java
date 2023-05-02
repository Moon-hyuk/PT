package com.ds.moon.dsproject.service;

import javax.transaction.Transactional;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ds.moon.dsproject.dto.HbDto;
import com.ds.moon.dsproject.dto.UserDto;
import com.ds.moon.dsproject.dto.UserHbDto;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UserHbService {
    RestTemplate restTemplate = new RestTemplate();
    String url = "";

    public void saveUserHb(UserDto userDto, HbDto hbDto) {
        UserHbDto userHbDto = new UserHbDto();
        userHbDto.setUserId(userDto.getUserId());
        userHbDto.setUserHbCd(hbDto.getHbCd());

        url = "http://localhost:8082/bt/sign/hb";
        restTemplate.postForObject(url, userHbDto, UserHbDto.class);
    }

    public void delete(UserHbDto userHbDto) {
        url = "http://localhost:8082/bt/hb/delete";
        restTemplate.postForObject(url, userHbDto, UserHbDto.class);

    }

    public String selectUserIdByHb(String userId) {
        String userHblist = "";
        
        if (userId != null) {
            url = "http://localhost:8082/bt/userhblist?userId=" + userId;
        } else {
            return userHblist;
        }
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,
                null, new ParameterizedTypeReference<String>() {
                });
        if(response.getBody()==null){
            return userHblist;
        }

        userHblist = response.getBody();
        return userHblist;

    }

}

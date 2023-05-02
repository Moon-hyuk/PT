package com.ds.moon.dsproject.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ds.moon.dsproject.dto.HbDto;
import com.ds.moon.dsproject.dto.UserDto;
import com.ds.moon.dsproject.dto.UserHbDto;
import com.ds.moon.dsproject.entity.UserHb;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UserHbService {
    RestTemplate restTemplate = new RestTemplate();
    String url = "";

    // private final userHbRepository userHbRepository;

   

    public List<UserHb> getList() {

        // return userHbRepository.findAll();
        return null;
    }

    public void saveUserHb(UserDto userDto, HbDto hbDto) {
        UserHbDto userHbDto = new UserHbDto();
        userHbDto.setUserId(userDto.getUserId());
        userHbDto.setUserHbCd(hbDto.getHbCd());

        
        url ="http://localhost:8082/bt/sign/hb";
        restTemplate.postForObject(url, userHbDto, UserHb.class);
    }

    public void delete(UserHb userHb){
        // userHbRepository.deleteByUserUserId(userHb.getUser().getUserId());
    }


    

    public List<UserHb> selectUserIdByHb(String userId) {
        // return userHbRepository.findAllByUserUserId(userId);
        return null;
    }

}

package com.ds.moon.dsproject.service;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ds.moon.dsproject.dto.UserDto;
import com.ds.moon.dsproject.entity.User;

@Service
public class UserService{

    RestTemplate restTemplate = new RestTemplate();
    String url = "";
    // private final UserRepository userRepository;
    //저장.수정
    public void saveUser(UserDto userDto){
        
        url ="http://localhost:8082/bt/sign/user";
        restTemplate.postForObject(url, userDto, User.class);
        
      
    }
    public User modifyUser(User user){
        // return userRepository.save(user);
        return null;
    }
    //사원 리스트
    public List<User> getListUser(String searchKeyword){

        if(searchKeyword !=null){
            url = "http://localhost:8082/bt/list?searchKeyword="+searchKeyword;
        }else{
            url = "http://localhost:8082/bt/list";
        }
        ResponseEntity<List<User>> response = restTemplate.exchange(url, HttpMethod.GET, 
        null, new ParameterizedTypeReference<List<User>>(){});
        return response.getBody();
    }

    //사원 
    public User getUserInfo(String userId){
        User user =new User();
        if(userId != null){
            url ="http://localhost:8082/bt/info?userId="+userId;
        }else{
            System.out.println("useruseruseruseruseruser"+user);
            return user;
        }
        System.out.println("response.getBody()response.getBody()response.getBody()");
        ResponseEntity<User> response = restTemplate.exchange(url, HttpMethod.GET, 
        null, new ParameterizedTypeReference<User>(){});
        System.out.println("status : " + response.getStatusCode());
        System.out.println("response.getBody()"+response.getBody());

        return response.getBody();
        
    }
    
    //검색
    public List<User> getListUserNm(String searchKeyword){
        // return userRepository.findByUserNmContaining(searchKeyword);
        return null;
    }

    //삭제
    public void deleteUserId(UserDto userDto){
        url = "http://localhost:8082/bt/user/delete";
        restTemplate.postForObject(url, userDto, UserDto.class);

    }
}
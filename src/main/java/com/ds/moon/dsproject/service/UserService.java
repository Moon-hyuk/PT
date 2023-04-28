package com.ds.moon.dsproject.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ds.moon.dsproject.entity.User;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService{

    // private final UserRepository userRepository;
    //저장.수정
    public void saveUser(User user){
        RestTemplate restTemplate = new RestTemplate();


        // validateDuplicateMember(user);
    //   userRepository.save(user);
      
    }
    public User modifyUser(User user){
        // return userRepository.save(user);
        return null;
    }
    //사원 리스트
    public List<User> getListUser(){
        // return userRepository.findAll();
        return null;
    }

    //사원 
    public User getUserInfo(String userId){
        // return userRepository.findByuserId(userId);
        return null;
        
    }
    
    //검색
    public List<User> getListUserNm(String searchKeyword){
        // return userRepository.findByUserNmContaining(searchKeyword);
        return null;
    }

    //삭제
    public void deleteUserId(User user){

        // userRepository.delete(user);
    }
}
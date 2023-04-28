package com.ds.moon.dsproject.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ds.moon.dsproject.entity.UserHb;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class UserHbService {

    // private final userHbRepository userHbRepository;

    public List<UserHb> getList() {

        // return userHbRepository.findAll();
        return null;
    }
    public void delete(UserHb userHb){
        // userHbRepository.deleteByUserUserId(userHb.getUser().getUserId());
    }


    public void saveUserHb(UserHb userHb) {
        // userHbRepository.save(userHb);
    }

    public List<UserHb> selectUserIdByHb(String userId) {
        // return userHbRepository.findAllByUserUserId(userId);
        return null;
    }

}

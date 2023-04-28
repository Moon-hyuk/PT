package com.ds.moon.dsproject.entity;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.ds.moon.dsproject.dto.UserHbDto;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@Entity
@Table(name ="user_hb_tb")
@IdClass(UserHbBridge.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
// @EqualsAndHashCode //필수
public class UserHb{
    
    @Id
    @ManyToOne
    @JoinColumn(name ="user_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name ="hb_cd")
    private Hb hb;

    public static UserHb createUserHb(UserHbDto userHbDto){
        UserHb userHb = new UserHb();
        User user = new User();
        Hb hb = new Hb();

        user.setUserId(userHbDto.getUserId());//유저 아이디만 담긴 테이블
        hb.setHbCd(userHbDto.getUserHbCd()); // 취미 코드만 담긴 테이블

        userHb.setUser(user);
        userHb.setHb(hb);
        
        return userHb;
    }


}

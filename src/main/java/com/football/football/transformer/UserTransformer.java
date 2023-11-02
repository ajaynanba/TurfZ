package com.football.football.transformer;

import com.football.football.dto.resDto.UserRes;
import com.football.football.entity.User;

public class UserTransformer {

    public static UserRes UserToUserResponse(User user){
        return UserRes.builder().userName(user.getUsername()).
                email(user.getEmail()).
                phone(user.getPhone()).
                build();
    }
}

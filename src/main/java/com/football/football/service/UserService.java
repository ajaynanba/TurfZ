package com.football.football.service;


import com.football.football.dto.UserReq;
import com.football.football.dto.resDto.UserRes;
import com.football.football.entity.User;
import com.football.football.repository.UserRepository;
import com.football.football.transformer.UserTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String addUser(UserReq userReq){
        User user = new User();
        user.setFirstName(userReq.getFirstName());
        user.setLastName(userReq.getLastName());
        user.setUsername(userReq.getUsername());
        user.setEmail(userReq.getEmail());
        user.setPassword(userReq.getPassword());
        user.setPhone(userReq.getPhone());

        userRepository.save(user);
        return "Completed Successfully";
    }

    public UserRes get(String email) throws Exception {
        if(!userRepository.existsByEmail(email)) throw new Exception("User does not exist");
        User user = userRepository.findByEmail(email);
        UserRes userRes = UserTransformer.UserToUserResponse(user);

        return userRes;
    }
    public String delete(String email){
        if(userRepository.existsByEmail(email)){
            User user = userRepository.findByEmail(email);
            userRepository.delete(user);
        }
        else return "User does not exist";

        return "Account deleted successfully";
    }
}

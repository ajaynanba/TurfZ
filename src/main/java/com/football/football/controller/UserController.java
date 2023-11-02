package com.football.football.controller;


import com.football.football.dto.UserReq;
import com.football.football.dto.resDto.UserRes;
import com.football.football.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody UserReq userReq){
        return userService.addUser(userReq);
    }
    @GetMapping("/get")
    public UserRes get(@RequestParam("email") String email) throws Exception {
        return userService.get(email);
    }
    @DeleteMapping("/delete")
    public String delete(@RequestParam("email")String email){
        return userService.delete(email);
    }
}

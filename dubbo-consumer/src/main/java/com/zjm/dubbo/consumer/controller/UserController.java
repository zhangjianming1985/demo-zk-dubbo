package com.zjm.dubbo.consumer.controller;

import com.zjm.dto.UserDto;
import com.zjm.service.UserService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Reference
    private UserService userService;

    @GetMapping("/findById/{id}")
    public UserDto findById(@PathVariable Integer id){
        System.out.println("start invoke Dubbo user service...");
        return userService.findById(id);
    }
    @GetMapping("/listUser")
    public List<UserDto> listUser(){
        return userService.listUser();
    }
}

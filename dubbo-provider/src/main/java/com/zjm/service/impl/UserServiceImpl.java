package com.zjm.service.impl;

import com.zjm.dto.UserDto;
import com.zjm.service.UserService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;
@Service(interfaceClass = UserService.class)
@Component
public class UserServiceImpl implements UserService {

    @SuppressWarnings("serial")
    private List<UserDto> users = new ArrayList<UserDto>(){
        {
        add(new UserDto(1, "熊大", "123"));
        add(new UserDto(2, "熊二", "234"));
        add(new UserDto(3, "熊三", "456"));
        }
    };
    @Override
    public UserDto findById(@NotBlank Integer id) {
        System.out.println("Dubbo user service been invoked : " + id);
        return users.stream().filter(user -> user.getId() == id).findFirst().get();
    }

    @Override
    public List<UserDto> listUser() {
        return users;
    }
}

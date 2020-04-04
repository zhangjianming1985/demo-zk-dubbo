package com.zjm.service;

import com.zjm.dto.UserDto;

import javax.validation.constraints.NotBlank;
import java.util.List;

public interface UserService {
    public UserDto findById(@NotBlank Integer id);

    public List<UserDto> listUser();
}

package com.company.service;

import com.company.dto.UserDto;
import com.company.entity.User;

public interface IUserRegisterService {
    User registerNewUserAccount(UserDto userDto) throws Exception;
}

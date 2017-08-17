package com.marek.springapplication.converter;

import com.marek.springapplication.model.UserRole;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToUserRoleConverter implements Converter<String, UserRole>{
    @Override
    public UserRole convert(String role){
        UserRole userRole = new UserRole();
        userRole.setRole(role);

        return userRole;
    }
}

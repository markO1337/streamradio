package com.bm.streamradio.converter;

import com.bm.streamradio.auth.user.User;

import com.bm.streamradio.response.UserWithoutPasswordResponse;
import org.springframework.core.convert.converter.Converter;

public class UserEntityToUserWithoutPasswordResponse implements Converter<User, UserWithoutPasswordResponse> {

    @Override
    public UserWithoutPasswordResponse convert(User source) {
        UserWithoutPasswordResponse userResponse = new UserWithoutPasswordResponse();
        userResponse.setId(source.getId());
        userResponse.setUsername(source.getUsername());
        userResponse.setEmail(source.getEmail());
        userResponse.setLicense(source.getLicense());
        return userResponse;
    }
}

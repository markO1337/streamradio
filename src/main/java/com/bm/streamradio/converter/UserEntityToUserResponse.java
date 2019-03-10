package com.bm.streamradio.converter;


import com.bm.streamradio.auth.user.User;
import com.bm.streamradio.response.UserResponse;
import org.springframework.core.convert.converter.Converter;

public class UserEntityToUserResponse implements Converter<User, UserResponse> {

    @Override
    public UserResponse convert(User source) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUsername(source.getUsername());
        userResponse.setEmail(source.getEmail());
        userResponse.setLicense(source.getLicense());
        return userResponse;
    }
}

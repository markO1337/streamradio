package com.bm.streamradio.auth.user;

import com.bm.streamradio.response.UserWithoutPasswordResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;
    private ConversionService conversionService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserController(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, @Qualifier("conversationService") ConversionService conversionService) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.conversionService = conversionService;
    }

    @PostMapping("/sign-up")
    public Map<String, Boolean> signUp(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        try {
            userRepository.save(user);
        } catch (Exception e) {
            return Collections.singletonMap("success", false);
        }
        return Collections.singletonMap("success", true);
    }

    @PostMapping("/register")
    public UserWithoutPasswordResponse register(@RequestBody User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        User result = userRepository.save(user);
        UserWithoutPasswordResponse response = conversionService.convert(result, UserWithoutPasswordResponse.class);
        return response;
    }

    @GetMapping(value = "/me")
    public UserWithoutPasswordResponse getUserArticles(Principal principal) {
        User user = userRepository.findByUsername(principal.getName());
        UserWithoutPasswordResponse convert = conversionService.convert(user, UserWithoutPasswordResponse.class);
        return convert;
    }
}

package com.bm.streamradio.auth.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserRepository userRepository;
    private UUID userId;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        userId = user.getId();
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        List<GrantedAuthority> list = AuthorityUtils.createAuthorityList();
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), list);
    }

    public UUID getUserId() {
        return userId;
    }
}

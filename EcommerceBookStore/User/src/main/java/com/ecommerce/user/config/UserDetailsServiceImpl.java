package com.ecommerce.user.config;

import com.ecommerce.library.model.User;
import com.ecommerce.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getUserByEmail(username);
        if(null == user) {
            throw new UsernameNotFoundException(String.format("Could not found %s", username));
        }
        return new CustomUserDetails(user);
    }
}

package com.bitirme.web.CustomUserDetails;

import com.bitirme.web.Entity.User;
import com.bitirme.web.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public org.springframework.security.core.userdetails.UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if(user ==null) {
            throw new UsernameNotFoundException("Kişi kayıtlı değil!");
        }
        return new CustomUserDetails(user);
    }

}

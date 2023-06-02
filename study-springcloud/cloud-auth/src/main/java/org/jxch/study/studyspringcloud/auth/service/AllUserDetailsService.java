package org.jxch.study.studyspringcloud.auth.service;

import org.jxch.study.studyspringcloud.auth.entity.dto.UserDetailsDto;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AllUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO 数据库查询
        return new UserDetailsDto("username", "password");
    }

}

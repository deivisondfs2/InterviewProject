package com.InterviewProject.InterviewProject.security;

import com.InterviewProject.InterviewProject.dao.IFunctionaryDao;
import com.InterviewProject.InterviewProject.model.Functionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    IFunctionaryDao functionaryDao;

    @Override
    public UserDetails loadUserByUsername(String pis) throws UsernameNotFoundException {
        Functionary functionary = functionaryDao.findByPis(pis);

        if (functionary == null) {
            throw new UsernameNotFoundException("Invalid pis or password.");
        }
        return new org.springframework.security.core.userdetails.User(functionary.getPis(),
                functionary.getPassword(),
                AuthorityUtils.createAuthorityList("ROLE_USER", "ROLE_ADMIN"));
    }
}

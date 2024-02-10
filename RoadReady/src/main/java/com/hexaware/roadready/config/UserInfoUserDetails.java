/*package com.hexaware.roadready.config;


import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.hexaware.roadready.entities.Admin;
import com.hexaware.roadready.entities.Agent;
import com.hexaware.roadready.entities.Customers;



public class UserInfoUserDetails implements UserDetails {


    private String name;
    private String password;
    private List<GrantedAuthority> authorities;

   /* public UserInfoUserDetails(UserInfo userInfo) {
        name=userInfo.getName();
        password=userInfo.getPassword();
        authorities= Arrays.stream(userInfo.getRoles().split(","))
                .map(SimpleGrantedAuthority::new) // .map(str -> new SimpleGrantedAuthority(str))
                .collect(Collectors.toList());
    }*/
    
    
   /* public UserInfoUserDetails(Customers customer) {
        this.name = customer.getUsername();
        this.password = customer.getPassword();
        this.authorities = Arrays.stream(customer.getRole().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    public UserInfoUserDetails(Agent agent) {
        this.name = agent.getUsername();
        this.password = agent.getPassword();
        this.authorities = Arrays.stream(agent.getRole().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    public UserInfoUserDetails(Admin admin) {
        this.name = admin.getUsername();
        this.password = admin.getPassword();
        this.authorities = Arrays.stream(admin.getRole().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
    
    

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

	
}*/

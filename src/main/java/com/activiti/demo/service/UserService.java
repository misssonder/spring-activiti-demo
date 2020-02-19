package com.activiti.demo.service;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public Object loign(String username,String password);
}

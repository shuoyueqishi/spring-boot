package com.example.demo.service;

import com.example.demo.model.AyRole;
import com.example.demo.repository.AyRoleRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AyRoleServiceImpl implements AyRoleService {

    @Resource
    private AyRoleRepository ayRoleRepository;

    @Override
    public AyRole find(String id){
        return ayRoleRepository.findById(id).get();
    }
}

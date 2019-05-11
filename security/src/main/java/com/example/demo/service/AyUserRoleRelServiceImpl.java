package com.example.demo.service;

import com.example.demo.model.AyUserRoleRel;
import com.example.demo.repository.AyUserRoleRelRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AyUserRoleRelServiceImpl implements AyUserRoleRelService {

    @Resource
    private AyUserRoleRelRepository ayUserRoleRelRepository;

    @Override
    public  List<AyUserRoleRel> findByUserId(String userId){
        return ayUserRoleRelRepository.findByUserId(userId);
    }
}

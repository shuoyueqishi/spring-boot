package com.example.demo.service;

import com.example.demo.model.AyUser;
import com.example.demo.repository.AyUserRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

@Service
public class AyUserServiceImpl implements AyUserService {

    @Resource
    private AyUserRepository ayUserRepository;

    @Override
    public AyUser findById(String id){
       return ayUserRepository.findById(id).get();
    }

    @Override
    public List<AyUser> findAll(){
       return ayUserRepository.findAll();
    }

    @Override
    public AyUser save(AyUser ayUser){
        return ayUserRepository.save(ayUser);
    }

    @Override
    public void delete(String id){
        ayUserRepository.deleteById(id);
    }

    @Override
    public List<AyUser> findByName(String name){
       return ayUserRepository.findByName(name);
    }

    @Override
    public AyUser findUserByName(String name){
       return ayUserRepository.findUserByName(name);
    }

    @Override
    public List<AyUser> findByNameLike(String name){
        return ayUserRepository.findByNameLike(name);
    }

    @Override
    public List<AyUser> findByIdIn(Collection<String> ids){
        return ayUserRepository.findByIdIn(ids);
    }
}

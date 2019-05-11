package com.example.demo.service;

import com.example.demo.model.AyUser;

import java.util.Collection;
import java.util.List;

public interface AyUserService {

    AyUser findById(String id);

    List<AyUser> findAll();

    AyUser save(AyUser ayUser);

    void delete(String id);

    List<AyUser> findByName(String name);

    AyUser findUserByName(String name);

    List<AyUser> findByNameLike(String name);

    List<AyUser> findByIdIn(Collection<String> ids);
}

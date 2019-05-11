package com.example.demo.service;

import com.example.demo.model.AyUser;
import com.example.demo.model.AyUserRoleRel;
import com.example.demo.myException.BusinessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CustomUserService implements UserDetailsService {

    @Resource
    private AyRoleService ayRoleService;

    @Resource
    private AyUserRoleRelService ayUserRoleRelService;

    @Resource
    private AyUserService ayUserService;
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        AyUser ayUser=ayUserService.findUserByName(name);
        if(ayUser==null){
            throw new BusinessException("数据库中该用户不存在，请重试.....");
        }

        List<AyUserRoleRel> ayUserRoleRelList=ayUserRoleRelService.findByUserId(ayUser.getId());
        List<GrantedAuthority> grantedAuthorityList=new ArrayList<GrantedAuthority>();
        if(ayUserRoleRelList!=null&&ayUserRoleRelList.size()>0){
            for(AyUserRoleRel ayUserRoleRel:ayUserRoleRelList){
                String roleName=ayRoleService.find(ayUserRoleRel.getRoleId()).getName();
                grantedAuthorityList.add(new SimpleGrantedAuthority(roleName));
            }
        }

        return new User(ayUser.getName(),ayUser.getPassword(),grantedAuthorityList);
    }
}

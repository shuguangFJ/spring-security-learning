package com.example.lab0base.controller;

import com.example.lab0base.entity.User;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PostFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/hello")
    public String hello(){
        return "hello security";
    }

    @GetMapping("/index")
    //@Secured({"ROLE_DBA"})
    //@PreAuthorize("hasAnyAuthority('admin1','ROLE_DBA')")
    //@PostAuthorize("hasAnyAuthority('admin1')")
    @PostFilter("filterObject.username == 'admin1'")
    public List<User> index(){
        System.out.println("index exec");
        List<User> users = new ArrayList<>();
        users.add(new User(1,"admin1","123"));
        users.add(new User(2,"admin2","456"));
        return users;
    }
}

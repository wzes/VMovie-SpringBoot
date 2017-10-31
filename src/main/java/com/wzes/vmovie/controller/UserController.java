package com.wzes.vmovie.controller;

import com.wzes.vmovie.dao.UserMapper;
import com.wzes.vmovie.model.Result;
import com.wzes.vmovie.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Create by xuantang
 * @date on 10/31/17
 */

@RestController
@RequestMapping({"/vmovie"})
public class UserController {

    @Autowired
    UserMapper userMapper;

    @PostMapping(value = "/register")
    public String register(@RequestParam String username, @RequestParam String password){
        User user = new User(username, password);
        int code = userMapper.addUser(user);
        return new Result(String.valueOf(code), "").toString();
    }

    @PostMapping(value = "/login")
    public String login(@RequestParam String username, @RequestParam String password){
        User user = userMapper.findUser(username, password);
        int code = 0;
        if(null == user){
            code = 1;
        }
        return new Result(String.valueOf(code), "").toString();
    }
}

package com.yicj.jwt.modules.user.controller;

import java.util.HashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yicj.jwt.common.entity.CheckToken;
import com.yicj.jwt.common.entity.LoginToken;
import com.yicj.jwt.common.util.JwtUtil;
import com.yicj.jwt.modules.user.entity.User;
import com.yicj.jwt.modules.user.service.UserService;

/**
 * @Author:jimisun
 * @Description:
 * @Date:Created in 15:04 2018/8/15
 * @Modified By:
 */
@Controller
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;
    
    @GetMapping("/hello")
    @ResponseBody
    public Map<String,Object> hello() {
    	Map<String,Object> jsonObject = new HashMap<String,Object>();
    	User user = new User() ;
    	user.setId(1000l);
    	user.setUsername("yicj");
    	user.setPassword("y123456");
    	jsonObject.put("user", user) ;
    	jsonObject.put("token", "1001") ;
    	return jsonObject ;
    }
    
  
    
    
    //登录
    @LoginToken
    @PostMapping("/login")
    @ResponseBody
    public Map<String,Object> login(@RequestBody @Valid User user) {
        Map<String,Object> jsonObject = new HashMap<String,Object>();
        User userForBase = userService.findByUsername(user);
        if (userForBase == null) {
            jsonObject.put("message", "登录失败,用户不存在");
            return jsonObject;
        } else {
            if (!userForBase.getPassword().equals(user.getPassword())) {
                jsonObject.put("message", "登录失败,密码错误");
                return jsonObject;
            } else {
                String token = JwtUtil.createJWT(6000000, userForBase);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                return jsonObject;
            }
        }
    }

    //查看个人信息
    @CheckToken
    @GetMapping("/getMessage")
    @ResponseBody
    public String getMessage() {
        return "你已通过验证";
    }
}

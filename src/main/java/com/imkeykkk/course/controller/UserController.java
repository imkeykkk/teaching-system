package com.imkeykkk.course.controller;

import com.imkeykkk.course.entity.User;
import com.imkeykkk.course.mapper.UserMapper;
import com.imkeykkk.course.service.UserService;
import com.imkeykkk.course.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @GetMapping("/users")
    public List<User> list() {
        return userService.list();
    }




    @PostMapping("/login")
    public Map<String, Object> login(@RequestParam String username, @RequestParam String password){
        Map<String,Object> result = new HashMap<>();    //Spring MVC 会自动将其序列化为 JSON 格式返回给前端

        User user = userService.findByUsername(username);
        if(user == null){
            result.put("success",false);
            result.put("message","用户不存在");
            return result;
        }
        boolean success = userService.login(username,password);
        if(success){
            String token = jwtUtil.generateToken(user.getId(), user.getUsername());//将id和username放到token中
            result.put("success",true);
            result.put("token",token);
            result.put("realName",user.getRealName());
            result.put("role",user.getRole());
        }
        else{
            result.put("success",false);
            result.put("message", "密码错误");
        }
        return result;//Map 转为 JSON  发给前端,前端解析 JSON，通过键名（Key）拿到其中的Token信息，前端在后续访问需要权限的接口时，
                        // 必须把 Token 拿出来，放到 HTTP 请求头中，所以在本代码中可以从请求头中的Token中拿到id和username。
    }

    @GetMapping("/me")
    public Map<String,Object> me(@RequestHeader("Authorization") String authHeader){//从请求头中获取Authorization字段，其中包含Token
        Map<String,Object> result = new HashMap<>();

        if(authHeader == null || !authHeader.startsWith("Bearer ")){
            result.put("success",false);
            result.put("message", "缺少token");
            return result;
        }

        String token = authHeader.substring(7);//分离出"Bearer "后剩下的就是完整的Token了
        if(!jwtUtil.validateToken(token)){
            result.put("success",false);
            result.put("message", "token无效或已过期");
            return result;
        }

        Long userId = jwtUtil.getUserIdFromToken(token);//从Token中获得id，这是在@PostMapping("/login")中传入Token中的
        User user = userService.getById(userId);

        result.put("success",true);
        result.put("id",user.getId());
        result.put("username",user.getUsername());
        result.put("realName",user.getRealName());
        result.put("role",user.getRole());
        return result;
    }


}
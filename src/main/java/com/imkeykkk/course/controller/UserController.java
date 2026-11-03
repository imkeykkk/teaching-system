package com.imkeykkk.course.controller;

import com.imkeykkk.course.common.Result;
import com.imkeykkk.course.entity.User;
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
    public Result<List<User>> getUserList() {
        return Result.success(userService.getUserList());
    }




    @PostMapping("/login")
    public Result<Map<String, Object>> login(@RequestParam String username, @RequestParam String password){
        Map<String,Object> result = new HashMap<>();    //Spring MVC 会自动将其序列化为 JSON 格式返回给前端

        User user = userService.findByUsername(username);
        if(user == null){
            result.put("success",false);
            result.put("message","用户不存在");
            return Result.error(401, "用户不存在");
        }
        boolean success = userService.login(username,password);
        if(success){
            String token = jwtUtil.generateToken(user.getId(), user.getUsername());//将id和username放到token中
            result.put("success",true);
            result.put("token",token);
            result.put("realName",user.getRealName());
            result.put("role",user.getRole());
            return Result.success("登录成功", result);
            /*return result;//Map 转为 JSON  发给前端,前端解析 JSON，通过键名（Key）拿到其中的Token信息，前端在后续访问需要权限的接口时，
            // 必须把 Token 拿出来，放到 HTTP 请求头中，所以在本代码中可以从请求头中的Token中拿到id和username。*/
        }
        else{
            result.put("success",false);
            result.put("message", "密码错误");
            return Result.error(401, "密码错误");
        }

    }

    @GetMapping("/me")
    public Result<Map<String, Object>> me(@RequestHeader(value = "Authorization", required = false) String authHeader){//从请求头中获取Authorization字段，其中包含Token
        Map<String,Object> result = new HashMap<>();

        if(authHeader == null || !authHeader.startsWith("Bearer ")){
            return Result.error(401, "缺少token");
        }

        String token = authHeader.substring(7);//分离出"Bearer "后剩下的就是完整的Token了
        if(!jwtUtil.validateToken(token)){
            return Result.error(401, "token无效或已过期");
        }

        Long userId = jwtUtil.getUserIdFromToken(token);//从Token中获得id，这是在@PostMapping("/login")中传入Token中的
        User user = userService.getUserById(userId);

        result.put("success",true);
        result.put("id",user.getId());
        result.put("username",user.getUsername());
        result.put("realName",user.getRealName());
        result.put("role",user.getRole());
        return Result.success(result);
    }


}
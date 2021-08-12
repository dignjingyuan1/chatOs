package com.sh.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sh.config.BizException;
import com.sh.dto.ResultData;
import com.sh.entity.User;
import com.sh.service.IUserService;
import com.sh.util.TokenUtil;
import com.sh.util.Validate;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author tiger
 * @since 2021-06-12
 */
@RestController
@RequestMapping("/sh/user")
public class UserController {

    @Resource
    private IUserService userService;

    @GetMapping("/login")
    public ResultData login(@RequestParam("username") String username, @RequestParam("password") String password) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getPhone, username).eq(User::getPassWord, password);
        User resUser = userService.getOne(wrapper);
        if (ObjectUtils.isNotEmpty(resUser)) {
            String token = TokenUtil.sign(resUser);
            return ResultData.success(token);
        } else {
            throw new BizException("用户名密码不正确！");
        }
    }

    @GetMapping("/info")
    public ResultData login(HttpServletRequest request) {
        String id = TokenUtil.getUserId(request.getHeader("token"));
        return ResultData.success(userService.getById(id));
    }

    @PostMapping("/register")
    public ResultData register(@RequestBody User user) {
        Validate.notBlank(user.getUserName(), "用户名");
        Validate.notBlank(user.getPassWord(), "密码");
        Validate.notBlank(user.getPhone(), "手机号");
        Validate.notMobileNo(user.getPhone(), "");
        if (userService.count(new LambdaQueryWrapper<User>().eq(User::getPhone, user.getPhone())) > 0) {
            throw new BizException("手机号已经存在");
        }
        userService.save(user);
        String token = TokenUtil.sign(user);
        return ResultData.success(token);
    }

}

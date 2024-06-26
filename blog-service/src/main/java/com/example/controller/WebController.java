package com.example.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.example.common.Result;

import com.example.entity.Account;
import com.example.enums.ResultCodeEnum;
import com.example.enums.RoleEnum;
import com.example.service.impl.AdminServiceImpl;
import com.example.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 基础前端接口
 */
@RestController
public class WebController {

    @Resource
    private AdminServiceImpl adminService;

    @Resource
    private UserServiceImpl userService;

    @GetMapping("/")
    public Result hello() {
        return Result.success("访问成功");
    }

    /**
     * 登录
     */
    @PostMapping("/login")
    public Result login(@RequestBody Account account) {
        if (ObjectUtil.isEmpty(account.getUsername()) || ObjectUtil.isEmpty(account.getPassword())
                || ObjectUtil.isEmpty(account.getRole())) {
            return Result.error(ResultCodeEnum.PARAM_LOST_ERROR);
        }
        if (RoleEnum.ADMIN.name().equals(account.getRole())) {
            account = adminService.login(account);
        }else if (RoleEnum.USER.name().equals(account.getRole())) {
            account = userService.login(account);
        }else{
            return Result.error(ResultCodeEnum.PARAM_ERROR);
        }
        return Result.success(account);
    }

    //    /**
//     * 登录
//     */
//    @PostMapping("/login")
//    public Result login(@RequestBody Account account) {
//        if (ObjectUtil.isEmpty(account.getUsername()) || ObjectUtil.isEmpty(account.getPassword())
//                || ObjectUtil.isEmpty(account.getRole())) {
//            return Result.error(ResultCodeEnum.PARAM_LOST_ERROR);
//        }
//        if (RoleEnum.ADMIN.name().equals(account.getRole())) {
//            account = adminService.login(account);
//        } else if (RoleEnum.USER.name().equals(account.getRole())) {
//            account = userService.login(account);
//        } else {
//            return Result.error(ResultCodeEnum.PARAM_ERROR);
//        }
//        return Result.success(account);
//    }

    /**
     * 注册
     */
    @PostMapping("/register")
    public Result register(@RequestBody Account account) {
        if (StrUtil.isBlank(account.getUsername()) || StrUtil.isBlank(account.getPassword())
                || ObjectUtil.isEmpty(account.getRole())) {
            return Result.error(ResultCodeEnum.PARAM_LOST_ERROR);
        }
        if (RoleEnum.USER.name().equals(account.getRole())) {
            userService.register(account);
        } else {
            return Result.error(ResultCodeEnum.PARAM_ERROR);
        }
        return Result.success();
    }

    /**
     * 修改密码
     */
    @PutMapping("/updatePassword")
    public Result updatePassword(@RequestBody Account account) {
        if (StrUtil.isBlank(account.getUsername()) || StrUtil.isBlank(account.getPassword())
                || ObjectUtil.isEmpty(account.getNewPassword())) {
            return Result.error(ResultCodeEnum.PARAM_LOST_ERROR);
        }
        if (RoleEnum.ADMIN.name().equals(account.getRole())) {
            adminService.updatePassword(account);
        } else if (RoleEnum.USER.name().equals(account.getRole())) {
            userService.updatePassword(account);
        }
        return Result.success();
    }

}

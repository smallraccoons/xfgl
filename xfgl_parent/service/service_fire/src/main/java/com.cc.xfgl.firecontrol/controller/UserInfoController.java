package com.cc.xfgl.firecontrol.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cc.xfgl.common.result.Result;
import com.cc.xfgl.firecontrol.service.UserInfoService;
import com.cc.xfgl.model.user.UserInfo;
import com.cc.xfgl.model.user.UserInfoQuery;
import com.mysql.jdbc.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "用户信息表")
@RestController
@RequestMapping("/admin/userInfo")
@CrossOrigin
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    //5、根据家庭编号查询提交信息
    @ApiOperation(value = "根据用户编号查询提交信息")
    @GetMapping("{id}")
    public Result getUserInfo(@PathVariable String id){
        UserInfo userInfo = userInfoService.getById(id);
        return  Result.ok(userInfo);
    }
    //7、批量删除用户信息
    @ApiOperation(value = "批量删除用户信息")
    @DeleteMapping("batchRemoveUserInfo")
    public Result batchRemoveUserInfo(@RequestBody List<Long> idList){
        userInfoService.removeByIds(idList);
        return Result.ok();
    }

    //3、条件查询设置 带分页
    @ApiOperation(value = "根据id,userId，查询数据，数据带分页")
    @PostMapping("findPageUserInfo/{current}/{limit}")
    public Result findPageUserInfo(@PathVariable long current,
                                            @PathVariable long limit,
                                            @RequestBody(required = false) UserInfoQuery userInfoQuery) {
        //创建page对象，传递传递当前页，每页记录数
        Page<UserInfo> page = new Page<>(current,limit);
        QueryWrapper<UserInfo> wrapper =new QueryWrapper<>();

        String id = userInfoQuery.getId();//提交编号
        String userId = userInfoQuery.getUserId();//医院编号
        if(!StringUtils.isEmptyOrWhitespaceOnly(id)){
            wrapper.eq("id",userInfoQuery.getId());
        }
        if(!StringUtils.isEmptyOrWhitespaceOnly(userId)){
            wrapper.eq("user_id",userInfoQuery.getUserId());
        }

        //调用方法实现分页查询
        Page<UserInfo> pageUserInfo = userInfoService.page(page, wrapper);
        return Result.ok(pageUserInfo);
    }

    //添加用户信息
    @ApiOperation(value = "插入用户信息")
    @PostMapping("save")
    public Result insertUserInfo(@RequestBody UserInfo userInfo){
        boolean flag = userInfoService.save(userInfo);
        if(flag){
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    //查询所有用户信息
    @ApiOperation(value = "查询所有用户信息")
    @GetMapping("findAll")
    public Result findAllUserInfo(){
        List<UserInfo> list = userInfoService.list();
        return Result.ok(list);
    }
    //逻辑删除用户信息
    @ApiOperation(value = "逻辑删除用户信息")
    @RequestMapping("{id}")
    public Result removeUserInfo(@PathVariable Long id){
        boolean flag = userInfoService.removeById(id);
        if(flag){
            return Result.ok();
        } else {
            return Result.fail();
        }
    }
    //修改用户信息
    @ApiOperation(value = "修改用户信息")
    @PostMapping("updateUserInfo")
    public Result updateUserInfo(@RequestBody UserInfo userInfo){
        boolean flag = userInfoService.updateById(userInfo);
        if(flag){
            return Result.ok();
        } else {
            return Result.fail();
        }
    }
}

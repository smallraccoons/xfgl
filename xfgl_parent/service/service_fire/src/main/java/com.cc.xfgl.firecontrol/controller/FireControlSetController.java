package com.cc.xfgl.firecontrol.controller;

import com.cc.xfgl.common.result.Result;
import com.cc.xfgl.common.utils.MD5;
import com.cc.xfgl.firecontrol.service.FireControlSetService;
import com.cc.xfgl.model.firecontrol.FireControlSet;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@Api(tags = "辅助决策安排表")
@RestController
@RequestMapping("/admin/firecontrol/firecontrolSet")
public class FireControlSetController {
    @Autowired
    private FireControlSetService fireControlSetService;

    //查询提交信息表中的所有数据信息
    @ApiOperation(value = "获取所有提交信息")
    @GetMapping("findAll")
    public List<FireControlSet> findAllFireControlSet(){
        List<FireControlSet> list = fireControlSetService.list();
        return list;
    }
    @ApiOperation(value = "加密连接确认")
    @PostMapping("")
    public Result<FireControlSet> saveFireControlSet(@RequestBody FireControlSet fireControlSet) {
        //设置状态位 1 使用 0 不能使用
        Random random = new Random();
        fireControlSet.setSignKey(MD5.encrypt(System.currentTimeMillis() + "" + random.nextInt(1000)));
        //调用service
        boolean save = fireControlSetService.save(fireControlSet);
        if(save){
            return Result.ok();
        } else {
            return Result.fail();
        }
    }
    //修改设备安排信息
    @ApiOperation(value = "修改设备安排信息")
    @PostMapping("updateFireControlSet")
    public Result updateFireControlSet(@RequestBody FireControlSet fireControlSet){
        boolean flag = fireControlSetService.updateById(fireControlSet);
        if(flag){
            return Result.ok();
        } else {
            return Result.fail();
        }
    }
}

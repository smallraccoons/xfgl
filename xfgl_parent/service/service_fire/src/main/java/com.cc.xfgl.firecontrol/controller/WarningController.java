package com.cc.xfgl.firecontrol.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cc.xfgl.common.result.Result;
import com.cc.xfgl.firecontrol.service.WarningService;
import com.cc.xfgl.model.waring.Warning;
import com.cc.xfgl.model.waring.WarningQuery;
import com.mysql.jdbc.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "家庭危险信息表")
@RestController
@RequestMapping("/admin/warning")
@CrossOrigin
public class WarningController {
    @Autowired
    WarningService warningService;

    //5、根据家庭编号查询提交信息
    @ApiOperation(value = "根据用户编号查询提交信息")
    @GetMapping("{id}")
    public Result getWarning(@PathVariable String id){
        Warning warning = warningService.getById(id);
        return  Result.ok(warning);
    }
    //7、批量删除用户信息
    @ApiOperation(value = "批量删除用户信息")
    @DeleteMapping("batchRemoveWarning")
    public Result batchRemoveWarning(@RequestBody List<Long> idList){
        warningService.removeByIds(idList);
        return Result.ok();
    }

    //3、条件查询设置 带分页
    @ApiOperation(value = "根据id,userId，查询数据，数据带分页")
    @PostMapping("findPageWarning/{current}/{limit}")
    public Result findPageUserInfo(@PathVariable long current,
                                   @PathVariable long limit,
                                   @RequestBody(required = false) WarningQuery warningQuery) {
        //创建page对象，传递传递当前页，每页记录数
        Page<Warning> page = new Page<>(current,limit);
        QueryWrapper<Warning> wrapper =new QueryWrapper<>();

        String id = warningQuery.getId();//提交编号
        String userId = warningQuery.getHomeId();//医院编号
        if(!StringUtils.isEmptyOrWhitespaceOnly(id)){
            wrapper.eq("id",warningQuery.getHomeId());
        }
        if(!StringUtils.isEmptyOrWhitespaceOnly(id)){
            wrapper.eq("user_id",warningQuery.getId());
        }

        //调用方法实现分页查询
        Page<Warning> pageWarning = warningService.page(page, wrapper);
        return Result.ok(pageWarning);
    }

    //添加用户信息
    @ApiOperation(value = "新增危险信息")
    @PostMapping("save")
    public Result insertWarning(@RequestBody Warning warning){
        boolean flag = warningService.save(warning);
        if(flag){
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    //查询所有用户信息
    @ApiOperation(value = "查询所有用户信息")
    @GetMapping("findAll")
    public Result findAllWarning(){
        List<Warning> list = warningService.list();
        return Result.ok(list);
    }
    //逻辑删除用户信息
    @ApiOperation(value = "逻辑删除用户信息")
    @RequestMapping("{id}")
    public Result removeUserInfo(@PathVariable Long id){
        boolean flag = warningService.removeById(id);
        if(flag){
            return Result.ok();
        } else {
            return Result.fail();
        }
    }
    //修改用户信息
    @ApiOperation(value = "修改用户信息")
    @PostMapping("updateWarning")
    public Result updateWarning(@RequestBody Warning warning){
        boolean flag = warningService.updateById(warning);
        if(flag){
            return Result.ok();
        } else {
            return Result.fail();
        }
    }


}

package com.cc.xfgl.firecontrol.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cc.xfgl.common.result.Result;
import com.cc.xfgl.firecontrol.service.ArrangementService;
import com.cc.xfgl.model.rescue.Arrangement;
import com.cc.xfgl.model.rescue.ArrangementQuery;
import com.mysql.jdbc.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "家庭提交信息表")
@RestController
@RequestMapping("/admin/fireControl/arrangement")
@CrossOrigin
public class ArrangementController  {
    //注入service json转换
    @Autowired
    private ArrangementService arrangementService;

    //1、查询提交信息表中的所有数据信息
    @ApiOperation(value = "获取所有提交信息")
    @GetMapping("findAll")
    public Result findAllArrangement(){
        //调用service方法
        List<Arrangement> list = arrangementService.list();
        return  Result.ok(list);
    }
//    @ApiOperation(value = "逻辑删除已经报警的信息")
//    @GetMapping("findFF")
//    public List<FireControlSubmit> findFFFireControlSubmit(){
//        List<FireControlSubmit> list = fireControlSubmitService.list();
//        return list;
//    }

    //2逻辑删除数据
    @ApiOperation(value = "逻辑删除已经报警的信息")
    @DeleteMapping("{id}")
    public Result removeArrangementService(@PathVariable Long id) {

//        try {
//            //模拟异常
//            int a = 1/0;
//        }catch (Exception e) {
//            throw new XfglException("失败",201);
//        }

        boolean flag = arrangementService.removeById(id);
        if(flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    //3、条件查询设置 带分页
    @ApiOperation(value = "根据id,homeId，查询数据，数据带分页")
    @PostMapping("findPageArrangement/{current}/{limit}")
    public Result findPageArrangement(@PathVariable long current,
                                            @PathVariable long limit,
                                            @RequestBody(required = false) ArrangementQuery arrangementQuery) {
        //创建page对象，传递传递当前页，每页记录数
        Page<Arrangement> page = new Page<>(current,limit);
        QueryWrapper<Arrangement> wrapper =new QueryWrapper<>();

        String id = arrangementQuery.getId();//提交编号
        String homeId = arrangementQuery.getHomeId();//家庭编号
        String userId = arrangementQuery.getUserId();//是否存在风险

        if(!StringUtils.isEmptyOrWhitespaceOnly(id)){
            wrapper.eq("id",arrangementQuery.getId());
        }
        if(!StringUtils.isEmptyOrWhitespaceOnly(homeId)){
            wrapper.eq("home_id",arrangementQuery.getHomeId());
        }
        if(!StringUtils.isEmptyOrWhitespaceOnly(userId)){
            wrapper.eq("user_id",arrangementQuery.getUserId());
        }

        //调用方法实现分页查询
        Page<Arrangement> pageArrangement = arrangementService.page(page, wrapper);
        return Result.ok(pageArrangement);
    }

    //5、根据id查询提交信息
    @ApiOperation(value = "根据家庭编号查询提交信息")
    @GetMapping("{id}")
    public Result findArrangement(@PathVariable String id){
        Arrangement arrangement = arrangementService.getById(id);
        return  Result.ok(arrangement);
    }

//    //5、根据家庭编号查询提交信息
//    @ApiOperation(value = "根据家庭编号查询提交信息")
//    @GetMapping("findNew/{homeId}")
//    public Result findNew(@PathVariable String homeId){
//        List<FireControlSubmit> list = arrangementService.selectByHomeId(homeId);
//        return  Result.ok(list);
//   }
//    @ApiOperation(value = "根据家庭编号查询提交的最新信息")
//    @GetMapping("findUpdate/{homeId}")
//    public Result findUpdate(@PathVariable String homeId){
//        QueryWrapper<FireControlSubmit> queryWrapper = new QueryWrapper<>();
//        queryWrapper
//                .eq("homeId",homeId);
//        FireControlSubmit fireControlSubmit = arrangementService.selectOne(queryWrapper);
//        return  Result.ok(fireControlSubmit);
//    }


    //6、修改设备提交表
    @ApiOperation(value = "修改决策信息")
    @PostMapping("updateArrangement")
    public Result updateArrangement(@RequestBody Arrangement arrangement){
        boolean flag = arrangementService.updateById(arrangement);
        if(flag){
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    //7、批量删除设备提交信息
    @ApiOperation(value = "批量删除设备提交信息")
    @DeleteMapping("batchRemoveArrangement")
    public Result batchRemoveArrangement(@RequestBody List<Long> idList){
        arrangementService.removeByIds(idList);
        return Result.ok();
    }
    //8、评论修改
    @ApiOperation(value = "家庭锁定和解锁接口")
    @PutMapping("lockArrangement/{id}/{riskLevel}")
    public Result lockArrangement (@PathVariable Long id,
                                         @PathVariable String comments) {
        Arrangement arrangement = arrangementService.getById(id);
        arrangement.setComments(comments);
        arrangementService.updateById(arrangement);
        return Result.ok();
    }


    //9、发送危险信息
    @ApiOperation(value = "发送危险信息")
    @PostMapping("sendKey/{id}")
    public Result lockFireControlSubmitSet(@PathVariable Long id){
        Arrangement arrangement = arrangementService.getById(id);
        String homId = arrangement.getHomeId();
        String riskInfo = arrangement.getComments();
        // TODO 发送短信

        return Result.ok();
    }

}
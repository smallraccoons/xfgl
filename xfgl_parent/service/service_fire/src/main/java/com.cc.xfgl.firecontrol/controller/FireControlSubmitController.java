package com.cc.xfgl.firecontrol.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cc.xfgl.common.result.Result;
import com.cc.xfgl.firecontrol.mapper.FireControlSubmitMapper;
import com.cc.xfgl.firecontrol.service.FireControlSubmitService;
import com.cc.xfgl.model.firecontrol.FireControlSubmit;
import com.cc.xfgl.model.firecontrol.FireControlSubmitQuery;
import com.mysql.jdbc.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "家庭提交信息表")
@RestController
@RequestMapping("/admin/firecontrol/fireControlSubmitSet")
@CrossOrigin
public class FireControlSubmitController {
    //注入service json转换
    @Autowired
    private FireControlSubmitService fireControlSubmitService;
    private FireControlSubmitMapper fireControlSubmitMapper;

    //http://localhost:8201/admin/firecontrol/fireControlSubmit/findAll

    //1、查询提交信息表中的所有数据信息
    @ApiOperation(value = "获取所有提交信息")
    @GetMapping("findAll")
    public Result findAllFireControlSubmit(){
        //调用service方法
        List<FireControlSubmit> list = fireControlSubmitService.list();
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
    public Result removeFireControlSubmit(@PathVariable Long id) {

//        try {
//            //模拟异常
//            int a = 1/0;
//        }catch (Exception e) {
//            throw new XfglException("失败",201);
//        }

        boolean flag = fireControlSubmitService.removeById(id);
        if(flag) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    //3、条件查询设置 带分页
    @ApiOperation(value = "根据id,homeId，查询数据，数据带分页")
    @PostMapping("findPageFireControlSubmit/{current}/{limit}")
    public Result findPageFireControlSubmit(@PathVariable long current,
                                            @PathVariable long limit,
                                            @RequestBody(required = false) FireControlSubmitQuery fireControlSubmitQuery) {
        //创建page对象，传递传递当前页，每页记录数
        Page<FireControlSubmit> page = new Page<>(current,limit);
        QueryWrapper<FireControlSubmit> wrapper =new QueryWrapper<>();

        String id = fireControlSubmitQuery.getId();//提交编号
        String homeId = fireControlSubmitQuery.getHomeId();//医院编号
        String riskLevel = fireControlSubmitQuery.getRiskLevel();//是否存在风险

        if(!StringUtils.isEmptyOrWhitespaceOnly(id)){
            wrapper.eq("id",fireControlSubmitQuery.getId());
        }
        if(!StringUtils.isEmptyOrWhitespaceOnly(homeId)){
            wrapper.eq("home_id",fireControlSubmitQuery.getHomeId());
        }
        if(!StringUtils.isEmptyOrWhitespaceOnly(riskLevel)){
            wrapper.eq("risk_level",fireControlSubmitQuery.getRiskLevel());
        }

        //调用方法实现分页查询
        Page<FireControlSubmit> pageFireControlSubmit = fireControlSubmitService.page(page, wrapper);
        return Result.ok(pageFireControlSubmit);
    }

    //5、根据id查询提交信息
    @ApiOperation(value = "根据家庭编号查询提交信息")
    @GetMapping("{id}")
    public Result findFireControlSubmit(@PathVariable String id){
        FireControlSubmit fireControlSubmit = fireControlSubmitMapper.selectById(id);
        return  Result.ok(fireControlSubmit);
    }

    //5、根据家庭编号查询提交信息
    @ApiOperation(value = "根据家庭编号查询提交信息")
    @GetMapping("findNew/{homeId}")
    public Result findNew(@PathVariable String homeId){
        List<FireControlSubmit> list = fireControlSubmitMapper.selectByHomeId(homeId);
        return  Result.ok(list);
     }
    @ApiOperation(value = "根据家庭编号查询提交的最新信息")
    @GetMapping("findUpdate/{homeId}")
    public Result findUpdate(@PathVariable String homeId){
        QueryWrapper<FireControlSubmit> queryWrapper = new QueryWrapper<>();
        queryWrapper
                .eq("homeId",homeId);
        FireControlSubmit fireControlSubmit = fireControlSubmitMapper.selectOne(queryWrapper);
        return  Result.ok(fireControlSubmit);
    }


    //6、修改设备提交表
    @ApiOperation(value = "修改设备提交信息")
    @PostMapping("updateFireControlSubmit")
    public Result updateFireControlSubmit(@RequestBody FireControlSubmit fireControlSubmit){
        boolean flag = fireControlSubmitService.updateById(fireControlSubmit);
        if(flag){
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    //7、批量删除设备提交信息
    @ApiOperation(value = "批量删除设备提交信息")
    @DeleteMapping("batchRemoveFireControlSubmit")
    public Result batchRemoveFireControlSubmit(@RequestBody List<Long> idList){
        fireControlSubmitService.removeByIds(idList);
        return Result.ok();
    }
    //8、家庭锁定和解锁接口
    @ApiOperation(value = "家庭锁定和解锁接口")
    @PutMapping("lockFireControlSubmit/{id}/{riskLevel}")
    public Result lockFireControlSubmit (@PathVariable Long id,
                                         @PathVariable String riskLevel) {
        FireControlSubmit fireControlSubmit = fireControlSubmitService.getById(id);
        fireControlSubmit.setRiskLevel(riskLevel);
        fireControlSubmitService.updateById(fireControlSubmit);
        return Result.ok();
    }


    //9、发送危险信息
    @ApiOperation(value = "发送危险信息")
    @PostMapping("sendKey/{id}")
    public Result lockFireControlSubmitSet(@PathVariable Long id){
        FireControlSubmit fireControlSubmit = fireControlSubmitService.getById(id);
        String homId = fireControlSubmit.getHomeId();
        String riskInfo = fireControlSubmit.getRiskInfo();
        // TODO 发送短信

        return Result.ok();
    }

}

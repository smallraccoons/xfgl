package com.cc.xfgl.firecontrol.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cc.xfgl.model.firecontrol.FireControlSubmit;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FireControlSubmitMapper extends BaseMapper<FireControlSubmit> {
        List<FireControlSubmit> selectByHomeId(@Param("home_Id") String homeId);
}

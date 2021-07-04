package com.cc.xfgl.firecontrol.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.xfgl.firecontrol.mapper.FireControlSubmitMapper;
import com.cc.xfgl.firecontrol.service.FireControlSubmitService;
import com.cc.xfgl.model.firecontrol.FireControlSet;
import com.cc.xfgl.model.firecontrol.FireControlSubmit;
import org.springframework.stereotype.Service;


@Service
public class FireControlSubmitServiceImpl
        extends ServiceImpl<FireControlSubmitMapper, FireControlSubmit>
        implements FireControlSubmitService {
    @Override
    public String getSignKey(String id) {
        QueryWrapper<FireControlSet> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id);
        FireControlSubmit fireControlSubmit = baseMapper.selectById(wrapper);
        return fireControlSubmit.getHomeId();
    }
}
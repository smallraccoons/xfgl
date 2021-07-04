package com.cc.xfgl.firecontrol.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cc.xfgl.firecontrol.mapper.FireControlSetMapper;
import com.cc.xfgl.firecontrol.service.FireControlSetService;
import com.cc.xfgl.model.firecontrol.FireControlSet;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public  class FireControlSetServiceImpl extends ServiceImpl<FireControlSetMapper, FireControlSet>
        implements FireControlSetService  {
    //2 根据传递过来消防编码，查询数据库，查询签名
    @Override
    public String getSignKey(String id) {
        QueryWrapper<FireControlSet> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id);
        FireControlSet fireControlSet = baseMapper.selectOne(wrapper);
        return fireControlSet.getHomeId();
    }
}

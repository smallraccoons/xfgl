package com.cc.xfgl.firecontrol.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.xfgl.firecontrol.mapper.UserInfoMapper;
import com.cc.xfgl.firecontrol.service.UserInfoService;
import com.cc.xfgl.model.firecontrol.FireControlSet;
import com.cc.xfgl.model.user.UserInfo;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo>
        implements UserInfoService {
    @Override
    public String getSignKey(String userId) {
        QueryWrapper<FireControlSet> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userId);
        UserInfo userInfo = baseMapper.selectById(wrapper);
        return userInfo.getHomeId();
    }
}

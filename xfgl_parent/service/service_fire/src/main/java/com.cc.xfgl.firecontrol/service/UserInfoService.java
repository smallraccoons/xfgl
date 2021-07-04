package com.cc.xfgl.firecontrol.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.xfgl.model.user.UserInfo;

public interface UserInfoService extends IService<UserInfo> {
    String getSignKey(String userId);
}

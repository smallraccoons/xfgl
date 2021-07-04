package com.cc.xfgl.firecontrol.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.xfgl.model.firecontrol.FireControlSubmit;

public interface FireControlSubmitService extends IService<FireControlSubmit> {
    String getSignKey(String id);
}

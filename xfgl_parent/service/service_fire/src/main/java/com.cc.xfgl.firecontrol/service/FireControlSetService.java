package com.cc.xfgl.firecontrol.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.xfgl.model.firecontrol.FireControlSet;

public interface FireControlSetService extends IService<FireControlSet> {
    //2 根据传递过来医院编码，查询数据库，查询签名
    String getSignKey(String hoscode);
}

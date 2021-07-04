package com.cc.xfgl.firecontrol.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.xfgl.firecontrol.mapper.WarningMapper;
import com.cc.xfgl.firecontrol.service.WarningService;
import com.cc.xfgl.model.waring.Warning;
import org.springframework.stereotype.Service;

@Service
public class WarningServiceImpl extends ServiceImpl<WarningMapper,Warning>
        implements WarningService {
}

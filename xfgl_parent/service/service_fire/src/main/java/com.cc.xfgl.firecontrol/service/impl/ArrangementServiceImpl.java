package com.cc.xfgl.firecontrol.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.xfgl.firecontrol.mapper.ArrangementMapper;
import com.cc.xfgl.firecontrol.service.ArrangementService;
import com.cc.xfgl.model.rescue.Arrangement;
import org.springframework.stereotype.Service;

@Service
public class ArrangementServiceImpl extends ServiceImpl<ArrangementMapper, Arrangement>
        implements ArrangementService {
}

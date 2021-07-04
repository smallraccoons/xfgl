package com.cc.xfgl.model.waring;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


    @Data
    public class WarningQuery {
        @ApiModelProperty(value = "提交编号")
        private String id;

        @ApiModelProperty(value = "家庭编号")
        private String homeId;
    }

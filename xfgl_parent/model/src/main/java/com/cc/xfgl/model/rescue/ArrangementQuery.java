package com.cc.xfgl.model.rescue;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class ArrangementQuery {
    @ApiModelProperty(value = "提交编号")
    private String id;

    @ApiModelProperty(value = "家庭编号")
    private String userId;

    @ApiModelProperty(value = "家庭编号")
    private String homeId;

//    @ApiModelProperty(value = "家庭编号")
//    private String userId;
//
//    @ApiModelProperty(value = "家庭编号")
//    private String userId;
}
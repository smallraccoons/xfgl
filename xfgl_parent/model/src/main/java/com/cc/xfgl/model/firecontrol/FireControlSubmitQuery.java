package com.cc.xfgl.model.firecontrol;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FireControlSubmitQuery {
    @ApiModelProperty(value = "提交编号")
    private String id;

    @ApiModelProperty(value = "家庭编号")
    private String homeId;

    @ApiModelProperty(value = "风险等级")
    private String riskLevel;
}

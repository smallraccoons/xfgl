package com.cc.xfgl.model.user;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


@Data
public class UserInfoQuery {
    @ApiModelProperty(value = "提交编号")
    private String id;

    @ApiModelProperty(value = "家庭编号")
    private String userId;
}
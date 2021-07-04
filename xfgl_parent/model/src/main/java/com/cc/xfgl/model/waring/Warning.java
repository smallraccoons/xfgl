package com.cc.xfgl.model.waring;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cc.xfgl.model.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * UserInfo
 * </p>
 *
 * @author qy
 */
@Data
@ApiModel(description = "UserInfo")
@TableName("warning")
public class Warning extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "家庭编号")
    @TableField("home_id")
    private String userId;

    @ApiModelProperty(value = "家庭编号")
    @TableField("home_id")
    private String homeId;

    @ApiModelProperty(value = "安全状况")
    @TableField("warning")
    private String warning;

}


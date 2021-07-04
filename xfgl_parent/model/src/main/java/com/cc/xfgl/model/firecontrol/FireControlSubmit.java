package com.cc.xfgl.model.firecontrol;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cc.xfgl.model.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * FireControlSubmit
 * </p>
 *
 * @author cc
 */
@Data
@ApiModel(description = "设备提交信息")
@TableName("submit_information")
public class FireControlSubmit extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "家庭编号")
    @TableField("home_id")
    private String homeId;

//    @ApiModelProperty(value = "提交编号")
//    @TableField("id")
//    private String Id;

    @ApiModelProperty(value = "卧室温度传感器")
    @TableField("Restroom_LineTemperature")
    private String RestroomLineTemperature;

    @ApiModelProperty(value = "卧室温度传感器")
    @TableField("Bedroom_LineTemperature")
    private String BedroomLineTemperature;

    @ApiModelProperty(value = "卧室温度传感器")
    @TableField("kitchen_LineTemperature")
    private String kitchenLineTemperature;

    @ApiModelProperty(value = "卧室温度传感器")
    @TableField("Livingroom_LineTemperature")
    private String LivingRoomLineTemperature;

    @ApiModelProperty(value = "卧室温度传感器")
    @TableField("Residual_current")
    private String ResidualCurrent;

    @ApiModelProperty(value = "卧室温度传感器")
    @TableField("Voltage")
    private String Voltage;

    @ApiModelProperty(value = "卧室温度传感器")
    @TableField("Current")
    private String Current;

    @ApiModelProperty(value = "卧室温度传感器")
    @TableField("risk_info")
    private String riskInfo;

    @ApiModelProperty(value = "卧室温度传感器")
    @TableField("risk_level")
    private String riskLevel;

//    @ApiModelProperty(value = "设备编号")
//    @TableField("equip_id")
//    private String equipId;
//
//    @ApiModelProperty(value = "设备类型")
//    @TableField("equip_type")
//    private String equipType;
//
//    @ApiModelProperty("设备数据")
//    @TableField("equip_data")
//    private String equipData;

//    @ApiModelProperty(value = "评论与备注")
//    @TableField("comments")
//    private String comments;

}

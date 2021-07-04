package com.cc.xfgl.model.rescue;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cc.xfgl.model.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


    @Data
    @ApiModel(description = "rescueArrangements")
    @TableName("rescue_arrangements")
    public class Arrangement extends BaseEntity {

        private static final long serialVersionUID = 1L;

        @ApiModelProperty(value = "家庭编号")
        @TableField("home_id")
        private String homeId;

        @ApiModelProperty(value = "户主姓名")
        @TableField("user_name")
        private String userName;

        @ApiModelProperty(value = "性别")
        @TableField("sex")
        private String sex;

        @ApiModelProperty(value = "户主手机号")
        @TableField("phone_number")
        private String phoneNumber;

        @ApiModelProperty(value = "用户身份证")
        @TableField("user_id")
        private String userId;

        @ApiModelProperty(value = "家庭地址")
        @TableField("home_address")
        private String homeAddress;

        @ApiModelProperty(value = "消防站1")
        @TableField("fire_station1")
        private String fireStation1;

        @ApiModelProperty(value = "消防站2")
        @TableField("fire_station2")
        private String fireStation2;

        @ApiModelProperty(value = "消防站3")
        @TableField("fire_station3")
        private String fireStation3;

        @ApiModelProperty(value = "关键值")
        @TableField("sign_key")
        private String signKey;

        @ApiModelProperty(value = "消防员数量")
        @TableField("rescue_man")
        private String rescueMan;

        @ApiModelProperty(value = "救援设备数量")
        @TableField("rescue_equipments")
        private String rescueEquipments;

        @ApiModelProperty(value = "救援方案")
        @TableField("rescue_plan")
        private String rescuePlan;

        @ApiModelProperty(value = "备注")
        @TableField("comments")
        private String comments;

    }

package com.cc.xfgl.model.firecontrol;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.cc.xfgl.model.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * HospitalSet
 * </p>
 *
 * @author cc
 */
@Data
@ApiModel(description = "用户表")
@TableName("rescue_arrangements")
public class FireControlSet extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	@ApiModelProperty(value = "救援编号")
	@TableField("rescue_id")
	private String rescueId;

	@ApiModelProperty(value = "家庭编号")
	@TableField("home_id")
	private String homeId;

	@ApiModelProperty(value = "key")
	@TableField("sign_key")
	private String SignKey;

	@ApiModelProperty(value = "家庭地址")
	@TableField("home_address")
	private String homeAddress;

	@ApiModelProperty(value = "家庭号码")
	@TableField("home_number")
	private String homeNumber;

	@ApiModelProperty(value = "救援者数量")
	@TableField("rescue_man")
	private String rescueMan;

	@ApiModelProperty(value = "救援工具数量")
	@TableField("rescue_equipments")
	private String rescueEquipments;

	@ApiModelProperty(value = "救援计划")
	@TableField("rescue_plan")
	private Integer rescuePlan;

	@ApiModelProperty(value = "备注")
	@TableField("comments")
	private Integer comments;

}


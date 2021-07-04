package com.cc.xfgl.model.user;

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
@TableName("user_info")
public class UserInfo extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "用户编号")
	@TableField("user_id")
	private String userId;

	@ApiModelProperty(value = "姓名")
	@TableField("user_name")
	private String userName;

	@ApiModelProperty(value = "家庭编号")
	@TableField("home_id")
	private String homeId;

	@ApiModelProperty(value = "性别")
	@TableField("sex")
	private String sex;

	@ApiModelProperty(value = "手机号")
	@TableField("phone_number")
	private String phoneNumber;

//	@ApiModelProperty(value = "证件类型")
//	@TableField("certificates_type")
//	private String certificatesType;

//	@ApiModelProperty(value = "证件编号")
//	@TableField("email")
//	private String certificatesNo;

	@ApiModelProperty(value = "邮箱")
	@TableField("email")
	private String email;

	@ApiModelProperty(value = "年龄")
	@TableField("age")
	private Integer age;

}


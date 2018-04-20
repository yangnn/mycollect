package com.collect.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * <p>
 * 
 * </p>
 *
 * @author author
 * @since 2018-04-04
 */
@TableName("user_info")
public class UserInfo extends Model<UserInfo> {

    private static final long serialVersionUID = 1L;

		@JsonFormat(shape = JsonFormat.Shape.STRING)
		private Long id;
    /**
     * 登录账号
     */
	@TableField("login_name")
		private String loginName;
    /**
     * 用户名
     */
	@TableField("user_name")
		private String userName;
    /**
     * 顾问sn
     */
	@TableField("consultant_sn")
		@JsonFormat(shape = JsonFormat.Shape.STRING)
		private Long consultantSn;
    /**
     * 是否兼职
     */
	@TableField("is_part_time")
		private Integer isPartTime;
    /**
     * 兼职顾问密码
     */
		private String password;
    /**
     * 是否删除
     */
	@TableField("is_del")
		private Integer isDel;
    /**
     * 创建人id
     */
	@TableField("creator_id")
		@JsonFormat(shape = JsonFormat.Shape.STRING)
		private Long creatorId;
    /**
     * 创建时间
     */
	@TableField("created_at")
		private Date createdAt;
    /**
     * 修改人id
     */
	@TableField("modifier_id")
		@JsonFormat(shape = JsonFormat.Shape.STRING)
		private Long modifierId;
    /**
     * 修改时间
     */
	@TableField("modified_at")
		private Date modifiedAt;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getConsultantSn() {
		return consultantSn;
	}

	public void setConsultantSn(Long consultantSn) {
		this.consultantSn = consultantSn;
	}

	public Integer getIsPartTime() {
		return isPartTime;
	}

	public void setIsPartTime(Integer isPartTime) {
		this.isPartTime = isPartTime;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getIsDel() {
		return isDel;
	}

	public void setIsDel(Integer isDel) {
		this.isDel = isDel;
	}

	public Long getCreatorId() {
		return creatorId;
	}

	public void setCreatorId(Long creatorId) {
		this.creatorId = creatorId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Long getModifierId() {
		return modifierId;
	}

	public void setModifierId(Long modifierId) {
		this.modifierId = modifierId;
	}

	public Date getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}

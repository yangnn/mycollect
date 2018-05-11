package com.collect.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yangning123
 * @since 2018-04-25
 */
public class Collect implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;
    /**
     * 标题
     */
    @TableField("title")
    private String title;
    /**
     * 链接
     */
    @TableField("url")
    private String url;
    /**
     * 描述
     */
    @TableField("description")
    private String description;
    /**
     * logo链接
     */
    @TableField("logo_url")
    private String logoUrl;
    /**
     * 类别
     */
    @TableField("type_id")
    private Integer typeId;
    /**
     * 是否删除
     */
    @TableField("is_delete")
    private String isDelete;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "Collect{" +
        "id=" + id +
        ", userId=" + userId +
        ", title=" + title +
        ", url=" + url +
        ", description=" + description +
        ", logoUrl=" + logoUrl +
        ", typeId=" + typeId +
        ", isDelete=" + isDelete +
        "}";
    }
}

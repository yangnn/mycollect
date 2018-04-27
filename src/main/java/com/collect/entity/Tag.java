package com.collect.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author yangning
 * @since 2018-04-27
 */
public class Tag implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long userId;
    /**
     * 描述
     */
    private String comment;
    private Date creatTime;
    private Date modified;


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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    @Override
    public String toString() {
        return "Tag{" +
        ", id=" + id +
        ", userId=" + userId +
        ", comment=" + comment +
        ", creatTime=" + creatTime +
        ", modified=" + modified +
        "}";
    }
}

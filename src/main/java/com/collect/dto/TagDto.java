package com.collect.dto;

import java.io.Serializable;

/**
 * Created by nina_nyang on 2018/4/27.
 */
public class TagDto implements Serializable {

    private static final long serialVersionUID = 7124047502472997827L;

    private Long userId;
    /**
     * 描述
     */
    private String comment;

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
}

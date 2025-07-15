package com.yupi.usercenter.model.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class TeamJoinRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * teamId
     */
    private Long teamId;

    /**
     * 密码
     */
    private String password;
}

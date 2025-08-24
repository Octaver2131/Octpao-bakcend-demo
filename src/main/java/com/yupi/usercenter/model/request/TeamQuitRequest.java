package com.yupi.usercenter.model.request;

import lombok.Data;
import sun.java2d.marlin.stats.StatLong;

import java.io.Serializable;
import java.util.Date;

@Data
public class TeamQuitRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    private Long teamId;
}

package com.yupi.usercenter.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class DeleteRequest implements Serializable {

    private static final long serialVersionUID = -5895406123956649433L;

    private long id;
}
package com.imooc.entity.bo;

import lombok.Data;

import java.util.Date;

@Data
public class HeadLine {

    //头条ID
    private Long lineId;

    //头条名称
    private String lineName;

    //头条链接
    private String lineLink;

    //头条图片地址
    private String lineImg;

    //展示优先级
    private Integer priority;

    //可用状态
    private Integer enableStatus;

    //创建时间
    private Date createTime;

    //最近修改时间
    private Date lastEditTime;

}

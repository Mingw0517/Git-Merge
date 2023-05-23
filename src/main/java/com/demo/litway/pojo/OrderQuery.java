package com.demo.litway.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author Litway
 * @version 1.0
 */
@Data
public class OrderQuery {

    /**
     * 表名
     */
    private String formId;

    /**
     * 待查询字段列表
     */
    private String fieldKeys;

    /**
     * 过滤条件
     */
    private String filterString;

    /**
     * 排序条件
     */
    private String orderString;

    /**
     * 最大允许查询数量, 0或者不要此属性表示不限制
     */
    private Integer topRowCount;

    /**
     * 分页取数开始行索引
     */
    private Integer startRow;

    /**
     * 每页数据
     */
    private Integer limit;

}

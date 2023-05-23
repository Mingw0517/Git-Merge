package com.demo.litway.pojo;

import cn.hutool.json.JSONSupport;
import lombok.Data;

/**
 * @author Litway
 * @version 1.0
 */
@Data
public class UserQuery extends JSONSupport {

    private Integer pageNum;

    private Integer pageSize;

}

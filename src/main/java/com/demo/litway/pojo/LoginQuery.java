package com.demo.litway.pojo;

import lombok.Data;

/**
 * @author Litway
 * @version 1.0
 */
@Data
public class LoginQuery {

    private String acctId;

    private String username;

    private String password;

    private Integer lcid;

}

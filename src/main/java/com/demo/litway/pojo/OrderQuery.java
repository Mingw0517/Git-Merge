package com.demo.litway.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author Litway
 * @version 1.0
 */
@Data
public class OrderQuery {

    List<OrderParams> parameters;

}

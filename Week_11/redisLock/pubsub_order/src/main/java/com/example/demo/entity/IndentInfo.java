package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Leeyj
 * @date 2021/3/17 15:27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class IndentInfo implements Serializable {

    private Long indentId;
    private Integer customerId;
    private Double indentPrice;
    private Date payTime;
    private String payType;
}

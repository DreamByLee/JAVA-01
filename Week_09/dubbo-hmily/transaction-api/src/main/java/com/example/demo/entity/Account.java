package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Leeyj
 * @date 2021/3/26 23:17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("account")
public class Account {
    @TableId(type = IdType.INPUT)
    private long id;

    private long customerId;

    private String currency;

    private BigDecimal balance;

    private Date updateTime;

    private Date createTime;
}

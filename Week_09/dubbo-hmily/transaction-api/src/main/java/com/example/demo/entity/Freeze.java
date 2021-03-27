package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalTime;

/**
 * @author Leeyj
 * @date 2021/3/27 12:40
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("freeze")
public class Freeze {
    @TableId(type = IdType.INPUT)
    private long id;

    private long customerId;

    private long accountId;

    private long exchangeId;

    private BigDecimal amount;

    private byte type;

    private byte state;

    private LocalTime updateTime;

    private LocalTime createTime;
}

package com.lee.topic01.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @author Leeyj
 * @date 2021/3/17 15:27
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("indnetinfo")
public class IndentInfo {

    @TableId(type = IdType.ID_WORKER)
    private Long indentId;
    private Integer customerId;
    private Double indentPrice;
    private Date payTime;
    private String payType;
}

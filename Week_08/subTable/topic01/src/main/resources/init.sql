CREATE SCHEMA db_mall_0;
CREATE SCHEMA db_mall_1;

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for indnetinfo_0
-- ----------------------------
DROP TABLE IF EXISTS `indnetinfo_0`;
CREATE TABLE `indnetinfo_0`  (
  `indent_id` bigint(64) NOT NULL COMMENT '订单ID',
  `customer_id` int(11) NULL DEFAULT NULL COMMENT '下单用户ID',
  `indent_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '订单总价',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `pay_type` int(1) NULL DEFAULT NULL COMMENT '支付状态',
  PRIMARY KEY (`indent_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for indnetinfo_1
-- ----------------------------
DROP TABLE IF EXISTS `indnetinfo_1`;
CREATE TABLE `indnetinfo_1`  (
  `indent_id` bigint(64) NOT NULL COMMENT '订单ID',
  `customer_id` int(11) NULL DEFAULT NULL COMMENT '下单用户ID',
  `indent_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '订单总价',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `pay_type` int(1) NULL DEFAULT NULL COMMENT '支付状态',
  PRIMARY KEY (`indent_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for indnetinfo_2
-- ----------------------------
DROP TABLE IF EXISTS `indnetinfo_2`;
CREATE TABLE `indnetinfo_2`  (
  `indent_id` bigint(64) NOT NULL COMMENT '订单ID',
  `customer_id` int(11) NULL DEFAULT NULL COMMENT '下单用户ID',
  `indent_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '订单总价',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `pay_type` int(1) NULL DEFAULT NULL COMMENT '支付状态',
  PRIMARY KEY (`indent_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for indnetinfo_3
-- ----------------------------
DROP TABLE IF EXISTS `indnetinfo_3`;
CREATE TABLE `indnetinfo_3`  (
  `indent_id` bigint(64) NOT NULL COMMENT '订单ID',
  `customer_id` int(11) NULL DEFAULT NULL COMMENT '下单用户ID',
  `indent_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '订单总价',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `pay_type` int(1) NULL DEFAULT NULL COMMENT '支付状态',
  PRIMARY KEY (`indent_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for indnetinfo_4
-- ----------------------------
DROP TABLE IF EXISTS `indnetinfo_4`;
CREATE TABLE `indnetinfo_4`  (
  `indent_id` bigint(64) NOT NULL COMMENT '订单ID',
  `customer_id` int(11) NULL DEFAULT NULL COMMENT '下单用户ID',
  `indent_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '订单总价',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `pay_type` int(1) NULL DEFAULT NULL COMMENT '支付状态',
  PRIMARY KEY (`indent_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for indnetinfo_5
-- ----------------------------
DROP TABLE IF EXISTS `indnetinfo_5`;
CREATE TABLE `indnetinfo_5`  (
  `indent_id` bigint(64) NOT NULL COMMENT '订单ID',
  `customer_id` int(11) NULL DEFAULT NULL COMMENT '下单用户ID',
  `indent_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '订单总价',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `pay_type` int(1) NULL DEFAULT NULL COMMENT '支付状态',
  PRIMARY KEY (`indent_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for indnetinfo_6
-- ----------------------------
DROP TABLE IF EXISTS `indnetinfo_6`;
CREATE TABLE `indnetinfo_6`  (
  `indent_id` bigint(64) NOT NULL COMMENT '订单ID',
  `customer_id` int(11) NULL DEFAULT NULL COMMENT '下单用户ID',
  `indent_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '订单总价',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `pay_type` int(1) NULL DEFAULT NULL COMMENT '支付状态',
  PRIMARY KEY (`indent_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for indnetinfo_7
-- ----------------------------
DROP TABLE IF EXISTS `indnetinfo_7`;
CREATE TABLE `indnetinfo_7`  (
  `indent_id` bigint(64) NOT NULL COMMENT '订单ID',
  `customer_id` int(11) NULL DEFAULT NULL COMMENT '下单用户ID',
  `indent_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '订单总价',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `pay_type` int(1) NULL DEFAULT NULL COMMENT '支付状态',
  PRIMARY KEY (`indent_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for indnetinfo_8
-- ----------------------------
DROP TABLE IF EXISTS `indnetinfo_8`;
CREATE TABLE `indnetinfo_8`  (
  `indent_id` bigint(64) NOT NULL COMMENT '订单ID',
  `customer_id` int(11) NULL DEFAULT NULL COMMENT '下单用户ID',
  `indent_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '订单总价',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `pay_type` int(1) NULL DEFAULT NULL COMMENT '支付状态',
  PRIMARY KEY (`indent_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for indnetinfo_9
-- ----------------------------
DROP TABLE IF EXISTS `indnetinfo_9`;
CREATE TABLE `indnetinfo_9`  (
  `indent_id` bigint(64) NOT NULL COMMENT '订单ID',
  `customer_id` int(11) NULL DEFAULT NULL COMMENT '下单用户ID',
  `indent_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '订单总价',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `pay_type` int(1) NULL DEFAULT NULL COMMENT '支付状态',
  PRIMARY KEY (`indent_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for indnetinfo_10
-- ----------------------------
DROP TABLE IF EXISTS `indnetinfo_10`;
CREATE TABLE `indnetinfo_10`  (
  `indent_id` bigint(64) NOT NULL COMMENT '订单ID',
  `customer_id` int(11) NULL DEFAULT NULL COMMENT '下单用户ID',
  `indent_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '订单总价',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `pay_type` int(1) NULL DEFAULT NULL COMMENT '支付状态',
  PRIMARY KEY (`indent_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for indnetinfo_11
-- ----------------------------
DROP TABLE IF EXISTS `indnetinfo_11`;
CREATE TABLE `indnetinfo_11`  (
  `indent_id` bigint(64) NOT NULL COMMENT '订单ID',
  `customer_id` int(11) NULL DEFAULT NULL COMMENT '下单用户ID',
  `indent_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '订单总价',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `pay_type` int(1) NULL DEFAULT NULL COMMENT '支付状态',
  PRIMARY KEY (`indent_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for indnetinfo_12
-- ----------------------------
DROP TABLE IF EXISTS `indnetinfo_12`;
CREATE TABLE `indnetinfo_12`  (
  `indent_id` bigint(64) NOT NULL COMMENT '订单ID',
  `customer_id` int(11) NULL DEFAULT NULL COMMENT '下单用户ID',
  `indent_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '订单总价',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `pay_type` int(1) NULL DEFAULT NULL COMMENT '支付状态',
  PRIMARY KEY (`indent_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for indnetinfo_13
-- ----------------------------
DROP TABLE IF EXISTS `indnetinfo_13`;
CREATE TABLE `indnetinfo_13`  (
  `indent_id` bigint(64) NOT NULL COMMENT '订单ID',
  `customer_id` int(11) NULL DEFAULT NULL COMMENT '下单用户ID',
  `indent_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '订单总价',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `pay_type` int(1) NULL DEFAULT NULL COMMENT '支付状态',
  PRIMARY KEY (`indent_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for indnetinfo_14
-- ----------------------------
DROP TABLE IF EXISTS `indnetinfo_14`;
CREATE TABLE `indnetinfo_14`  (
  `indent_id` bigint(64) NOT NULL COMMENT '订单ID',
  `customer_id` int(11) NULL DEFAULT NULL COMMENT '下单用户ID',
  `indent_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '订单总价',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `pay_type` int(1) NULL DEFAULT NULL COMMENT '支付状态',
  PRIMARY KEY (`indent_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单信息表' ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Table structure for indnetinfo_15
-- ----------------------------
DROP TABLE IF EXISTS `indnetinfo_15`;
CREATE TABLE `indnetinfo_15`  (
  `indent_id` bigint(64) NOT NULL COMMENT '订单ID',
  `customer_id` int(11) NULL DEFAULT NULL COMMENT '下单用户ID',
  `indent_price` decimal(10, 2) NULL DEFAULT NULL COMMENT '订单总价',
  `pay_time` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `pay_type` int(1) NULL DEFAULT NULL COMMENT '支付状态',
  PRIMARY KEY (`indent_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单信息表' ROW_FORMAT = DYNAMIC;

SET FOREIGN_KEY_CHECKS = 1;

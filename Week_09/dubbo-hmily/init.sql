/*
 Navicat Premium Data Transfer

 Source Server         : db
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost:3306
 Source Schema         : db_mall_0

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 27/03/2021 14:02:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT 'ID',
  `customer_id` bigint(20) UNSIGNED NOT NULL COMMENT '用户ID',
  `currency` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '货币类型（CNY-人民币，USD-美元）',
  `balance` decimal(20, 4) NOT NULL DEFAULT 0.0000 COMMENT '资产余额',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '资产账号表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for freeze
-- ----------------------------
DROP TABLE IF EXISTS `freeze`;
CREATE TABLE `freeze`  (
  `id` bigint(20) UNSIGNED NOT NULL COMMENT 'ID',
  `customer_id` bigint(20) UNSIGNED NOT NULL COMMENT '用户ID',
  `account_id` bigint(20) UNSIGNED NOT NULL COMMENT '账号ID',
  `exchange_id` bigint(20) UNSIGNED NOT NULL COMMENT '交易ID',
  `amount` decimal(20, 4) NOT NULL DEFAULT 0.0000 COMMENT '交易金额',
  `type` tinyint(2) NOT NULL COMMENT '交易类型（1-转入，2-转出）',
  `state` tinyint(2) NOT NULL COMMENT '状态（1-预处理，2-确认，3-取消）',
  `update_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `create_time` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '冻结记录表' ROW_FORMAT = Dynamic;

INSERT INTO db_mall_1.account(`id`, `user_id`, `currency`, `balance`)
VALUES
	(1, 1, 'CNY', 100.0000),
	(2, 1, 'USD', 100.0000);


INSERT INTO db_mall_0.account(`id`, `user_id`, `currency`, `balance`)
VALUES
	(3, 2, 'CNY', 100.0000),
	(4, 2, 'USD', 100.0000);

SET FOREIGN_KEY_CHECKS = 1;

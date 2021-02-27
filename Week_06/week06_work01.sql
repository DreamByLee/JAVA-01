/*
 Navicat Premium Data Transfer

 Source Server         : db
 Source Server Type    : MySQL
 Source Server Version : 50718
 Source Host           : localhost:3306
 Source Schema         : week06

 Target Server Type    : MySQL
 Target Server Version : 50718
 File Encoding         : 65001

 Date: 25/02/2021 22:51:31
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer`  (
  `cuatomerId` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `phone` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '电话',
  `sex` int(1) NULL DEFAULT NULL COMMENT '性别',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '用户登录密码',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`cuatomerId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户信息表\r\n' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for goodsinfo
-- ----------------------------
DROP TABLE IF EXISTS `goodsinfo`;
CREATE TABLE `goodsinfo`  (
  `goodsId` int(20) NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `goodsName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '商品名称',
  `goodsPrice` decimal(10, 2) NULL DEFAULT NULL COMMENT '商品起售价',
  `supplierId` int(10) NULL DEFAULT NULL COMMENT '商品供应商ID',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`goodsId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for goodssale
-- ----------------------------
DROP TABLE IF EXISTS `goodssale`;
CREATE TABLE `goodssale`  (
  `saleId` int(11) NOT NULL AUTO_INCREMENT COMMENT '规格ID',
  `goodsId` int(11) NULL DEFAULT NULL COMMENT '商品ID（关联商品ID）',
  `saleName` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '规格名称',
  `salePrice` decimal(10, 2) NULL DEFAULT NULL COMMENT '规格价格',
  `createTime` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`saleId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '商品规格表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for indentsale
-- ----------------------------
DROP TABLE IF EXISTS `indentsale`;
CREATE TABLE `indentsale`  (
  `indentId` int(11) NOT NULL COMMENT '订单ID',
  `saleId` int(11) NULL DEFAULT NULL COMMENT '规格ID',
  `num` int(11) NULL DEFAULT NULL COMMENT '下单数量',
  `payPrice` decimal(10, 2) NULL DEFAULT NULL COMMENT '下单单价',
  `payPriceTotal` decimal(10, 2) NULL DEFAULT NULL COMMENT '总价',
  `updateTime` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`indentId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单商品表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for indnetinfo
-- ----------------------------
DROP TABLE IF EXISTS `indnetinfo`;
CREATE TABLE `indnetinfo`  (
  `indentId` int(11) NOT NULL COMMENT '订单ID',
  `customerId` int(11) NULL DEFAULT NULL COMMENT '下单用户ID',
  `indentPrice` decimal(10, 2) NULL DEFAULT NULL COMMENT '订单总价',
  `payTime` datetime(0) NULL DEFAULT NULL COMMENT '支付时间',
  `payType` int(1) NULL DEFAULT NULL COMMENT '支付状态',
  PRIMARY KEY (`indentId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '订单信息表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

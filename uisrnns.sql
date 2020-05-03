/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : uisrnns

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 03/05/2020 18:25:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cnt_bell
-- ----------------------------
DROP TABLE IF EXISTS `cnt_bell`;
CREATE TABLE `cnt_bell`  (
  `LH` int(0) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '铃号',
  `Location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '地点例如“1-a”',
  `RouterID` int(0) NULL DEFAULT NULL COMMENT '路由器（多中心）例如“001”',
  PRIMARY KEY (`LH`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cnt_bell
-- ----------------------------
INSERT INTO `cnt_bell` VALUES (4, '1-a', 1);
INSERT INTO `cnt_bell` VALUES (6, '2-a', 2);
INSERT INTO `cnt_bell` VALUES (7, '3-a', 3);
INSERT INTO `cnt_bell` VALUES (8, '4-a', 4);

-- ----------------------------
-- Table structure for cnt_callbell
-- ----------------------------
DROP TABLE IF EXISTS `cnt_callbell`;
CREATE TABLE `cnt_callbell`  (
  `CID` int(0) UNSIGNED NOT NULL AUTO_INCREMENT,
  `UKEY` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `IP` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `Date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`CID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 79 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cnt_callbell
-- ----------------------------
INSERT INTO `cnt_callbell` VALUES (70, 'kqBYtU41068zNoGBVa1J', '192.168.123.160', NULL);
INSERT INTO `cnt_callbell` VALUES (71, 'l857Ag41rJ6a5DAwmKC4', '192.168.123.160', NULL);
INSERT INTO `cnt_callbell` VALUES (72, 'f62gN8XV054VYm16OSP2', '192.168.123.160', NULL);
INSERT INTO `cnt_callbell` VALUES (73, '88g39PKnPhvrTq222r8T', '192.168.123.160', NULL);
INSERT INTO `cnt_callbell` VALUES (74, 'l2c258238162S04U01g0', '192.168.123.160', NULL);
INSERT INTO `cnt_callbell` VALUES (75, '629Ly2UHyC3UTZ74YQck', '192.168.123.160', NULL);
INSERT INTO `cnt_callbell` VALUES (76, '80us7pK200PT994XdfGu', '192.168.123.160', NULL);
INSERT INTO `cnt_callbell` VALUES (77, 'h15Sp1Lg22r42860lZI8', '192.168.123.160', NULL);
INSERT INTO `cnt_callbell` VALUES (78, '2xn777H2JMt5L3zaF89Q', '192.168.123.160', NULL);
INSERT INTO `cnt_callbell` VALUES (79, '3i5Lo806bNU3Cm4mBh35', '192.168.123.160', NULL);

-- ----------------------------
-- Table structure for cnt_datatables
-- ----------------------------
DROP TABLE IF EXISTS `cnt_datatables`;
CREATE TABLE `cnt_datatables`  (
  `UID` int(0) NOT NULL AUTO_INCREMENT COMMENT '统计数据ID',
  `Location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '地点',
  `Date` datetime(0) NULL DEFAULT NULL COMMENT '日期',
  `PeopleNum` int(0) NULL DEFAULT NULL COMMENT '人数',
  PRIMARY KEY (`UID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cnt_datatables
-- ----------------------------
INSERT INTO `cnt_datatables` VALUES (7, '1-a', '2020-04-26 22:28:35', 2);
INSERT INTO `cnt_datatables` VALUES (8, '1-a', '2020-04-29 22:24:03', 2);
INSERT INTO `cnt_datatables` VALUES (9, '1-a', '2020-05-01 22:14:05', 2);
INSERT INTO `cnt_datatables` VALUES (10, '1-a', '2020-05-01 22:21:56', 2);
INSERT INTO `cnt_datatables` VALUES (11, '2-a', '2020-05-01 22:37:51', 2);
INSERT INTO `cnt_datatables` VALUES (12, '1-a', '2020-05-01 22:46:50', 2);
INSERT INTO `cnt_datatables` VALUES (13, '1-a', '2020-05-01 22:53:16', 2);

-- ----------------------------
-- Table structure for cnt_exclude
-- ----------------------------
DROP TABLE IF EXISTS `cnt_exclude`;
CREATE TABLE `cnt_exclude`  (
  `DID` int(0) NOT NULL AUTO_INCREMENT COMMENT '任务号',
  `UKEY` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'UKEY密钥。是一次响铃密钥',
  `Date` datetime(0) NULL DEFAULT NULL COMMENT '时间',
  `IFOperation` int(0) NULL DEFAULT NULL COMMENT '是否操作响铃1：已操作、0：未操作',
  PRIMARY KEY (`DID`) USING BTREE,
  UNIQUE INDEX `UKEY`(`UKEY`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cnt_exclude
-- ----------------------------
INSERT INTO `cnt_exclude` VALUES (2, 'kqBYtU41068zNoGBVa1J', '2020-04-29 15:40:30', NULL);
INSERT INTO `cnt_exclude` VALUES (3, 'J3STp8rjjr5O77B33A5e', '2020-04-30 08:33:38', NULL);
INSERT INTO `cnt_exclude` VALUES (4, 'l857Ag41rJ6a5DAwmKC4', '2020-05-01 21:44:42', NULL);
INSERT INTO `cnt_exclude` VALUES (5, 'f62gN8XV054VYm16OSP2', '2020-05-01 22:02:21', NULL);
INSERT INTO `cnt_exclude` VALUES (6, '88g39PKnPhvrTq222r8T', '2020-05-01 22:07:53', NULL);
INSERT INTO `cnt_exclude` VALUES (7, 'l2c258238162S04U01g0', '2020-05-01 22:11:09', NULL);
INSERT INTO `cnt_exclude` VALUES (8, '629Ly2UHyC3UTZ74YQck', '2020-05-01 22:19:55', NULL);
INSERT INTO `cnt_exclude` VALUES (9, '1005a1h6dR59994sg34G', '2020-05-01 22:31:56', NULL);
INSERT INTO `cnt_exclude` VALUES (10, 'YuBH9gd2lzLi1nPf6I27', '2020-05-01 22:33:51', NULL);
INSERT INTO `cnt_exclude` VALUES (11, '80us7pK200PT994XdfGu', '2020-05-01 22:36:55', NULL);
INSERT INTO `cnt_exclude` VALUES (12, 'h15Sp1Lg22r42860lZI8', '2020-05-01 22:45:55', NULL);
INSERT INTO `cnt_exclude` VALUES (13, '2xn777H2JMt5L3zaF89Q', '2020-05-01 22:52:20', NULL);
INSERT INTO `cnt_exclude` VALUES (14, '3i5Lo806bNU3Cm4mBh35', '2020-05-01 22:52:25', NULL);

-- ----------------------------
-- Table structure for cnt_router
-- ----------------------------
DROP TABLE IF EXISTS `cnt_router`;
CREATE TABLE `cnt_router`  (
  `RouterID` int(0) NOT NULL COMMENT '路由器ID',
  `IP` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'IP',
  `uis` int(0) NOT NULL COMMENT '是否执行uis',
  PRIMARY KEY (`RouterID`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cnt_router
-- ----------------------------
INSERT INTO `cnt_router` VALUES (1, '192.168.123.160', 1);
INSERT INTO `cnt_router` VALUES (2, '192.168.123.191', 0);
INSERT INTO `cnt_router` VALUES (3, '192.168.123.192', 0);
INSERT INTO `cnt_router` VALUES (4, '192.168.123.193', 0);

SET FOREIGN_KEY_CHECKS = 1;

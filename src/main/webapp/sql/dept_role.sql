/*
Navicat MySQL Data Transfer

Source Server         : sjw
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : travel

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2019-04-14 11:07:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dept_role
-- ----------------------------
DROP TABLE IF EXISTS `dept_role`;
CREATE TABLE `dept_role` (
  `rid` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `did` bigint(20) DEFAULT NULL,
  `lid` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  KEY `rid` (`rid`),
  KEY `did` (`did`),
  KEY `lid` (`lid`),
  CONSTRAINT `dept_role_ibfk_1` FOREIGN KEY (`rid`) REFERENCES `role` (`rid`),
  CONSTRAINT `dept_role_ibfk_2` FOREIGN KEY (`did`) REFERENCES `dept` (`did`),
  CONSTRAINT `dept_role_ibfk_3` FOREIGN KEY (`lid`) REFERENCES `level` (`lid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of dept_role
-- ----------------------------
INSERT INTO `dept_role` VALUES ('1', '1', '2');
INSERT INTO `dept_role` VALUES ('2', '1', '3');
INSERT INTO `dept_role` VALUES ('3', '2', '2');
INSERT INTO `dept_role` VALUES ('4', '2', '3');
INSERT INTO `dept_role` VALUES ('5', '3', '2');
INSERT INTO `dept_role` VALUES ('6', '3', '3');

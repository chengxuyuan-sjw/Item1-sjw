/*
Navicat MySQL Data Transfer

Source Server         : sjw
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : travel

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2019-04-14 11:08:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `rid` varchar(255) COLLATE utf8_bin NOT NULL,
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'personnelmanager');
INSERT INTO `role` VALUES ('2', 'personnelEmp');
INSERT INTO `role` VALUES ('3', 'financemanager');
INSERT INTO `role` VALUES ('4', 'financeemp');
INSERT INTO `role` VALUES ('5', 'marketingmanager');
INSERT INTO `role` VALUES ('6', 'marketingemp');

/*
Navicat MySQL Data Transfer

Source Server         : sjw
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : travel

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2019-04-14 11:07:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for action_role
-- ----------------------------
DROP TABLE IF EXISTS `action_role`;
CREATE TABLE `action_role` (
  `actid` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `rid` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  KEY `actid` (`actid`),
  KEY `rid` (`rid`),
  CONSTRAINT `action_role_ibfk_1` FOREIGN KEY (`actid`) REFERENCES `action` (`actid`),
  CONSTRAINT `action_role_ibfk_2` FOREIGN KEY (`rid`) REFERENCES `role` (`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of action_role
-- ----------------------------
INSERT INTO `action_role` VALUES ('1', '1');
INSERT INTO `action_role` VALUES ('3', '1');
INSERT INTO `action_role` VALUES ('4', '1');
INSERT INTO `action_role` VALUES ('5', '1');
INSERT INTO `action_role` VALUES ('2', '1');
INSERT INTO `action_role` VALUES ('1', '2');
INSERT INTO `action_role` VALUES ('7', '2');
INSERT INTO `action_role` VALUES ('6', '3');
INSERT INTO `action_role` VALUES ('7', '3');
INSERT INTO `action_role` VALUES ('6', '4');

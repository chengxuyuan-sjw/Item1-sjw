/*
Navicat MySQL Data Transfer

Source Server         : sjw
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : travel

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2019-04-14 11:07:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for action
-- ----------------------------
DROP TABLE IF EXISTS `action`;
CREATE TABLE `action` (
  `actid` varchar(255) COLLATE utf8_bin NOT NULL,
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`actid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of action
-- ----------------------------
INSERT INTO `action` VALUES ('1', 'emp:add');
INSERT INTO `action` VALUES ('2', 'emp:locked');
INSERT INTO `action` VALUES ('3', 'eid:edit');
INSERT INTO `action` VALUES ('4', 'level:fall');
INSERT INTO `action` VALUES ('5', 'level:raise');
INSERT INTO `action` VALUES ('6', 'travel:lookall');
INSERT INTO `action` VALUES ('7', 'travel:approve');

/*
Navicat MySQL Data Transfer

Source Server         : sjw
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : travel

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2019-04-14 11:07:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `did` bigint(20) NOT NULL,
  `dname` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `eid` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('1', '人事部', '1');
INSERT INTO `dept` VALUES ('2', '财务部', '2');
INSERT INTO `dept` VALUES ('3', '营销部', '3');

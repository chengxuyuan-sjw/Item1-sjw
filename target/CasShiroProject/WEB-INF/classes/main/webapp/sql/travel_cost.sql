/*
Navicat MySQL Data Transfer

Source Server         : sjw
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : travel

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2019-04-14 11:08:35
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for travel_cost
-- ----------------------------
DROP TABLE IF EXISTS `travel_cost`;
CREATE TABLE `travel_cost` (
  `tcid` bigint(20) NOT NULL AUTO_INCREMENT,
  `tpid` bigint(20) DEFAULT NULL,
  `tid` bigint(20) DEFAULT NULL,
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `price` double(10,2) DEFAULT NULL,
  PRIMARY KEY (`tcid`),
  KEY `tpid` (`tpid`),
  KEY `tid` (`tid`),
  CONSTRAINT `travel_cost_ibfk_1` FOREIGN KEY (`tpid`) REFERENCES `type` (`tpid`),
  CONSTRAINT `travel_cost_ibfk_2` FOREIGN KEY (`tid`) REFERENCES `travel` (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of travel_cost
-- ----------------------------
INSERT INTO `travel_cost` VALUES ('1', '1', '2', '去青岛学习', '1000.00');
INSERT INTO `travel_cost` VALUES ('6', '4', '3', '开车使用', '5000.00');
INSERT INTO `travel_cost` VALUES ('7', '3', '4', '坐火车去出差', '1200.00');
INSERT INTO `travel_cost` VALUES ('8', '2', '4', '餐补', '200.00');
INSERT INTO `travel_cost` VALUES ('11', '4', '4', '加点92号邮', '300.00');
INSERT INTO `travel_cost` VALUES ('13', null, '5', null, '0.00');
INSERT INTO `travel_cost` VALUES ('14', null, '9', null, '0.00');
INSERT INTO `travel_cost` VALUES ('15', '2', '9', '住宿', '1000.00');

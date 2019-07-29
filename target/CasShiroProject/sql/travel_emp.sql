/*
Navicat MySQL Data Transfer

Source Server         : sjw
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : travel

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2019-04-14 11:08:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for travel_emp
-- ----------------------------
DROP TABLE IF EXISTS `travel_emp`;
CREATE TABLE `travel_emp` (
  `teid` int(11) NOT NULL AUTO_INCREMENT,
  `tid` bigint(20) NOT NULL,
  `eid` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`teid`),
  KEY `tid` (`tid`) USING BTREE,
  KEY `eid` (`eid`) USING BTREE,
  CONSTRAINT `travel_emp_ibfk_1` FOREIGN KEY (`eid`) REFERENCES `emp` (`eid`),
  CONSTRAINT `travel_emp_ibfk_2` FOREIGN KEY (`tid`) REFERENCES `travel` (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of travel_emp
-- ----------------------------
INSERT INTO `travel_emp` VALUES ('1', '2', '1');
INSERT INTO `travel_emp` VALUES ('2', '3', '2');
INSERT INTO `travel_emp` VALUES ('3', '4', '3');

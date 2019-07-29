/*
Navicat MySQL Data Transfer

Source Server         : sjw
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : travel

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2019-04-14 11:08:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for travel
-- ----------------------------
DROP TABLE IF EXISTS `travel`;
CREATE TABLE `travel` (
  `tid` bigint(20) NOT NULL AUTO_INCREMENT,
  `seid` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `aeid` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `iid` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `title` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sdate` date DEFAULT NULL,
  `edate` date DEFAULT NULL,
  `subdate` date DEFAULT NULL,
  `dest` date DEFAULT NULL,
  `audit` int(11) DEFAULT NULL,
  `note` text COLLATE utf8_bin,
  `auddate` date DEFAULT NULL,
  `anote` text COLLATE utf8_bin,
  `ecount` int(11) DEFAULT NULL,
  `total` double DEFAULT NULL,
  PRIMARY KEY (`tid`),
  KEY `iid` (`iid`),
  CONSTRAINT `travel_ibfk_1` FOREIGN KEY (`iid`) REFERENCES `item` (`iid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of travel
-- ----------------------------
INSERT INTO `travel` VALUES ('2', '1', null, '1', '去青岛学习', '2019-06-24', '2019-09-01', '2019-04-03', '2019-04-17', '2', 0xE58EBBE99D92E5B29BE5ADA6E4B9A0, null, null, '1', '1000');
INSERT INTO `travel` VALUES ('3', '2', null, '2', '生意', '2019-05-08', '2019-05-30', '2019-04-03', '2019-04-03', '1', 0xE58EBBE4B88AE6B5B7E5928CE5AEA2E688B7E8B088E7949FE6848F, null, null, '1', '5000');
INSERT INTO `travel` VALUES ('4', '3', null, '2', '玩去', '2019-04-11', '2019-04-19', '2019-04-03', '2019-04-03', '1', 0xE58EBBE59083E7B291E7B291, '2019-04-09', null, '1', '1700');
INSERT INTO `travel` VALUES ('5', '3', null, '2', '业务', '2019-04-17', '2019-04-12', '2019-04-10', '2019-04-28', '1', 0xE58EBBE8B088E7949FE6848F, '2019-04-12', null, '1', '0');
INSERT INTO `travel` VALUES ('9', '1', null, '3', '旅游', '2019-04-12', '2019-08-09', '2019-04-09', null, '9', 0xE69785E6B8B8E694BEE69DBEE5BF83E68385, null, null, null, '1000');

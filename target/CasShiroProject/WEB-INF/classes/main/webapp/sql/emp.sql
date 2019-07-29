/*
Navicat MySQL Data Transfer

Source Server         : sjw
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : travel

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2019-04-14 11:08:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `eid` varchar(255) COLLATE utf8_bin NOT NULL,
  `did` bigint(20) DEFAULT NULL,
  `lid` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `ename` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `sal` double DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `photo` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `note` text COLLATE utf8_bin,
  `hiredate` date DEFAULT NULL,
  `ineid` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `locked` int(11) DEFAULT NULL,
  PRIMARY KEY (`eid`),
  KEY `did` (`did`),
  CONSTRAINT `emp_ibfk_1` FOREIGN KEY (`did`) REFERENCES `dept` (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES ('1', '1', '2', '盛小伟', '8500', '15621915425', '123', 'Upload/!ffbe03c5-0161-4b14-b56d-85e62b4b72ae.jpg', null, '2019-03-28', '2222', '0');
INSERT INTO `emp` VALUES ('2', '2', '2', '刘琴琴', '6000', '13274714225', '123', 'Upload/!ffbe03c5-0161-4b14-b56d-85e62b4b72ae.jpg', null, '2019-03-13', '2222', '0');
INSERT INTO `emp` VALUES ('3', '3', '2', '盛经理', '20000', '15811411858', '123', 'Upload/!ffbe03c5-0161-4b14-b56d-85e62b4b72ae.jpg', null, '2019-03-06', '2222', '0');
INSERT INTO `emp` VALUES ('4', '2', '3', '盛小员', '2500', '13681319899', '123', 'Upload/!ffbe03c5-0161-4b14-b56d-85e62b4b72ae.jpg', null, '2019-04-10', '2222', '0');
INSERT INTO `emp` VALUES ('5', '3', '3', '刘大员', '2750', '15621915425', '123', 'Upload/!ffbe03c5-0161-4b14-b56d-85e62b4b72ae.jpg', null, '2019-04-02', '2222', '0');
INSERT INTO `emp` VALUES ('6', '2', '1', '小员工', '2400', '162378491836', '123', 'Upload/!ffbe03c5-0161-4b14-b56d-85e62b4b72ae.jpg', null, '2019-04-24', '2222', '0');
INSERT INTO `emp` VALUES ('9', '1', '3', 'sheng', '120000', '15621915425', '123', 'Upload/!ffbe03c5-0161-4b14-b56d-85e62b4b72ae.jpg', null, '2019-04-10', null, '0');

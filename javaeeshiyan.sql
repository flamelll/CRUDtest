/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : javaeeshiyan

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2021-05-03 09:27:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for students
-- ----------------------------
DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `num` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of students
-- ----------------------------
INSERT INTO `students` VALUES ('101', '刘子煜');
INSERT INTO `students` VALUES ('102', '小明名');
INSERT INTO `students` VALUES ('103', '张三');
INSERT INTO `students` VALUES ('104', '李四');

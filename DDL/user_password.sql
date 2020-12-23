/*
Navicat MySQL Data Transfer

Source Server         : lianshun
Source Server Version : 80022
Source Host           : 115.159.57.187:3306
Source Database       : second

Target Server Type    : MYSQL
Target Server Version : 80022
File Encoding         : 65001

Date: 2020-12-15 21:57:06
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_password
-- ----------------------------
DROP TABLE IF EXISTS `user_password`;
CREATE TABLE `user_password` (
  `id` int NOT NULL AUTO_INCREMENT,
  `encrpt_password` varchar(128) NOT NULL DEFAULT '',
  `user_id` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

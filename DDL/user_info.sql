/*
Navicat MySQL Data Transfer

Source Server         : lianshun
Source Server Version : 80022
Source Host           : 115.159.57.187:3306
Source Database       : second

Target Server Type    : MYSQL
Target Server Version : 80022
File Encoding         : 65001

Date: 2020-12-15 21:56:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL DEFAULT '',
  `gender` tinyint NOT NULL DEFAULT '0' COMMENT '1为男，2为女',
  `age` int NOT NULL DEFAULT '0',
  `telephone` varchar(255) NOT NULL DEFAULT '',
  `register_mode` varchar(255) NOT NULL DEFAULT '',
  `third_party_id` varchar(64) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

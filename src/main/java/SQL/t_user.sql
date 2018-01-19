/*
Navicat MySQL Data Transfer

Source Server         : zhewaida
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : userinfo

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2018-01-20 01:20:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(40) NOT NULL,
  `user_email` varchar(50) NOT NULL,
  `user_pwd` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'linyue', '1050450245@qq.com', '4607E782C4D86FD5364D7E4508BB10D9');
INSERT INTO `t_user` VALUES ('3', 'yansheng', '1526232@gmail.com', 'E10ADC3949BA59ABBE56E057F20F883E');
INSERT INTO `t_user` VALUES ('4', 'linyyy', '16161@qq.com', 'E10ADC3949BA59ABBE56E057F20F883E');
INSERT INTO `t_user` VALUES ('5', 'test1', '123456@gmail.com', 'E10ADC3949BA59ABBE56E057F20F883E');

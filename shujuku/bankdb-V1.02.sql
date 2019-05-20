/*
Navicat MySQL Data Transfer

Source Server         : mysql1
Source Server Version : 50637
Source Host           : localhost:3306
Source Database       : bankdb

Target Server Type    : MYSQL
Target Server Version : 50637
File Encoding         : 65001

Date: 2019-05-20 10:37:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sys_cards`
-- ----------------------------
DROP TABLE IF EXISTS `sys_cards`;
CREATE TABLE `sys_cards` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `userName` varchar(10) DEFAULT NULL,
  `cardId` varchar(20) NOT NULL,
  `cardPassword` varchar(10) DEFAULT NULL,
  `cardStatus` varchar(5) DEFAULT NULL,
  `cardMoney` double(15,0) unsigned zerofill DEFAULT NULL,
  `startTime` datetime DEFAULT NULL,
  `startAddress` varchar(20) DEFAULT NULL,
  `accountAddress` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_cards
-- ----------------------------
INSERT INTO `sys_cards` VALUES ('1', '黄华溢', '6321000000001111', '123456', '使用', '000000000015000', '2018-12-05 11:10:36', '深圳达喜分行(清湖支行)', '深圳');
INSERT INTO `sys_cards` VALUES ('2', '朱鹏涛', '6321000000002222', '123456', '使用', '000000000012000', '2017-06-15 11:17:36', '深圳达喜分行(龙华支行)', '深圳');
INSERT INTO `sys_cards` VALUES ('3', '吕露', '6321000000003333', '123456', '使用', '000000000013000', '2010-06-17 11:19:07', '深圳达喜分行(宝安支行)', '深圳');
INSERT INTO `sys_cards` VALUES ('4', '陈总', '6321000000004444', '123456', '使用', '000000000025000', '2014-06-11 11:19:40', '深圳达喜分行(清湖支行)', '深圳');
INSERT INTO `sys_cards` VALUES ('5', '王乐', '6321000000005555', '123456', '使用', '000000000050000', '2014-06-18 11:20:21', '深圳达喜分行(深圳总行)', '深圳');
INSERT INTO `sys_cards` VALUES ('6', '王宇', '6321000000006666', '123456', '使用', '000000000080000', '2016-09-13 11:21:05', '深圳达喜分行(光明支行)', '深圳');
INSERT INTO `sys_cards` VALUES ('7', '黄华溢', '3621000000007777', '123456', '使用', '000000000050000', '2015-02-18 11:39:41', '深圳达喜分行(世界之窗支行)', '深圳');
INSERT INTO `sys_cards` VALUES ('8', '朱鹏涛', '3621000000008888', '123456', '使用', '000000000111111', '2019-01-08 11:42:07', '深圳达喜分行(福田支行)', '深圳');

-- ----------------------------
-- Table structure for `sys_card_tradelogs`
-- ----------------------------
DROP TABLE IF EXISTS `sys_card_tradelogs`;
CREATE TABLE `sys_card_tradelogs` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `card_id` int(10) NOT NULL COMMENT '卡id',
  `trade_id` int(10) NOT NULL COMMENT '交易id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_card_tradelogs
-- ----------------------------
INSERT INTO `sys_card_tradelogs` VALUES ('1', '1', '1');
INSERT INTO `sys_card_tradelogs` VALUES ('2', '2', '2');
INSERT INTO `sys_card_tradelogs` VALUES ('3', '3', '3');
INSERT INTO `sys_card_tradelogs` VALUES ('4', '4', '4');

-- ----------------------------
-- Table structure for `sys_managers`
-- ----------------------------
DROP TABLE IF EXISTS `sys_managers`;
CREATE TABLE `sys_managers` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `managerName` varchar(50) NOT NULL,
  `managerPassword` varchar(50) DEFAULT NULL,
  `jurid` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_managers
-- ----------------------------
INSERT INTO `sys_managers` VALUES ('1', 'admin', '123456', 'A');
INSERT INTO `sys_managers` VALUES ('2', 'CGB1902', '123456', 'A');
INSERT INTO `sys_managers` VALUES ('3', 'huanghuayi', '123456', 'A');

-- ----------------------------
-- Table structure for `sys_tradelogs`
-- ----------------------------
DROP TABLE IF EXISTS `sys_tradelogs`;
CREATE TABLE `sys_tradelogs` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `tradeId` varchar(20) NOT NULL,
  `currentCard` varchar(20) DEFAULT NULL COMMENT '当前卡号',
  `tradeType` varchar(20) DEFAULT NULL COMMENT '交易类型',
  `tradeMoney` decimal(10,2) DEFAULT NULL COMMENT '交易金额',
  `gatheringAccount` varchar(20) DEFAULT NULL COMMENT '收款方',
  `tradeTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_tradelogs
-- ----------------------------
INSERT INTO `sys_tradelogs` VALUES ('1', '20190312', '6321000000001111', '转账', '3000.00', '6321000000004444', '2019-03-12 11:25:29');
INSERT INTO `sys_tradelogs` VALUES ('2', '20190512', '6321000000002222', '转账', '5000.00', '6321000000006666', '2019-05-12 14:27:27');
INSERT INTO `sys_tradelogs` VALUES ('3', '20181215', '6321000000003333', '转账', '6000.00', '6321000000005555', '2018-12-15 16:28:43');
INSERT INTO `sys_tradelogs` VALUES ('4', '20180818', '6321000000004444', '转账', '3000.00', '6321000000006666', '2018-08-18 09:29:45');

-- ----------------------------
-- Table structure for `sys_users`
-- ----------------------------
DROP TABLE IF EXISTS `sys_users`;
CREATE TABLE `sys_users` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `userId` varchar(20) NOT NULL,
  `userName` varchar(50) NOT NULL,
  `userPassword` varchar(50) NOT NULL,
  `idNo` varchar(50) DEFAULT NULL,
  `userStatus` varchar(4) DEFAULT '浣跨敤',
  `userAddress` varchar(50) DEFAULT NULL,
  `startTime` datetime DEFAULT NULL,
  `startAddress` varchar(30) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_users
-- ----------------------------
INSERT INTO `sys_users` VALUES ('1', '1901', '黄华溢', '123456', '360726199408040011', '使用', '深圳', '2018-07-05 11:03:36', '深圳');
INSERT INTO `sys_users` VALUES ('2', '1902', '朱鹏涛', '123456', '360726199501050001', '使用', '深圳', '2018-10-26 15:06:55', '深圳');
INSERT INTO `sys_users` VALUES ('3', '1903', '吕露', '123456', '362725199911110012', '使用', '深圳', '2019-03-22 15:08:15', '深圳');
INSERT INTO `sys_users` VALUES ('4', '1904', '陈总', '123456', '362726198705040013', '使用', '深圳', '2019-03-07 14:08:54', '深圳');
INSERT INTO `sys_users` VALUES ('5', '1905', '王乐', '123456', '362726198804040015', '使用', '深圳', '2019-03-28 14:09:36', '深圳');
INSERT INTO `sys_users` VALUES ('6', '1906', '王宇', '123456', '362726199512120001', '使用', '深圳', '2018-08-24 09:11:23', '深圳');

-- ----------------------------
-- Table structure for `sys_user_cards`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user_cards`;
CREATE TABLE `sys_user_cards` (
  `id` varchar(10) NOT NULL DEFAULT '',
  `user_id` varchar(20) NOT NULL,
  `card-id` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user_cards
-- ----------------------------
INSERT INTO `sys_user_cards` VALUES ('1', '1', '1');
INSERT INTO `sys_user_cards` VALUES ('2', '1', '7');
INSERT INTO `sys_user_cards` VALUES ('3', '2', '2');
INSERT INTO `sys_user_cards` VALUES ('4', '3', '3');
INSERT INTO `sys_user_cards` VALUES ('5', '4', '4');
INSERT INTO `sys_user_cards` VALUES ('6', '5', '5');
INSERT INTO `sys_user_cards` VALUES ('7', '6', '6');
INSERT INTO `sys_user_cards` VALUES ('8', '2', '8');

-- ----------------------------
-- View structure for `manage`
-- ----------------------------
DROP VIEW IF EXISTS `manage`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `manage` AS select `bankdb`.`hjc_manage`.`xm` AS `xm`,`bankdb`.`hjc_manage`.`zq` AS `zq`,`bankdb`.`hjc_manage`.`money` AS `money` from `hjc_manage` ;

-- ----------------------------
-- View structure for `trade`
-- ----------------------------
DROP VIEW IF EXISTS `trade`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `trade` AS select `bankdb`.`hjc_trade`.`id` AS `id`,`bankdb`.`hjc_trade`.`money` AS `money`,`bankdb`.`hjc_trade`.`category` AS `category`,`bankdb`.`hjc_trade`.`time` AS `time` from `hjc_trade` ;

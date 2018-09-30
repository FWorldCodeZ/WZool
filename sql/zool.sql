/*
Navicat MySQL Data Transfer

Source Server         : myWork
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : zool

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-09-30 18:39:28
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `_id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `admin_name` varchar(16) DEFAULT NULL COMMENT '管理员名',
  `account` varchar(16) NOT NULL COMMENT '管理员账号',
  `admin_password` varchar(64) NOT NULL COMMENT '管理员密码',
  `salt` varchar(32) NOT NULL COMMENT '盐值',
  `state` int(11) NOT NULL COMMENT '状态：0-删除，1-正常，2-默认状态',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `phone` int(11) DEFAULT NULL COMMENT '电话号码',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `orgunit_id` int(11) NOT NULL COMMENT '外键组织id',
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for admin_role
-- ----------------------------
DROP TABLE IF EXISTS `admin_role`;
CREATE TABLE `admin_role` (
  `ad_roel_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色主键',
  `ad_id` int(11) DEFAULT NULL COMMENT '外键：用户或者管理员',
  `roel_id` int(11) DEFAULT NULL COMMENT '角色id',
  `orgunit_id` int(11) NOT NULL COMMENT '外键组织id',
  PRIMARY KEY (`ad_roel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_role
-- ----------------------------
INSERT INTO `admin_role` VALUES ('6', '6', '3', '11111');

-- ----------------------------
-- Table structure for animals
-- ----------------------------
DROP TABLE IF EXISTS `animals`;
CREATE TABLE `animals` (
  `an_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '动物id',
  `an_name` varchar(16) NOT NULL COMMENT '动物名',
  `an_description` varchar(200) DEFAULT NULL COMMENT '有关动物的描述',
  `an_age` varchar(10) DEFAULT NULL COMMENT '寿命',
  `an_type` varchar(255) DEFAULT NULL COMMENT '动物种类',
  `an_price` decimal(10,2) DEFAULT NULL COMMENT '动物售价',
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`an_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of animals
-- ----------------------------

-- ----------------------------
-- Table structure for an_zools
-- ----------------------------
DROP TABLE IF EXISTS `an_zools`;
CREATE TABLE `an_zools` (
  `relation_id` int(11) NOT NULL AUTO_INCREMENT,
  `an_id` int(11) DEFAULT NULL COMMENT '外键：动物id',
  `zool_id` int(11) DEFAULT NULL COMMENT '外键：动物园id',
  PRIMARY KEY (`relation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of an_zools
-- ----------------------------

-- ----------------------------
-- Table structure for cards
-- ----------------------------
DROP TABLE IF EXISTS `cards`;
CREATE TABLE `cards` (
  `card_id` int(11) NOT NULL AUTO_INCREMENT,
  `card_title` varchar(100) NOT NULL,
  `card_description` varchar(200) NOT NULL,
  `zool_id` int(11) NOT NULL COMMENT '动物园id',
  `card_price` int(11) NOT NULL COMMENT '门票现价',
  `card_ortginal_price` int(11) NOT NULL COMMENT '门票原始价',
  `start_time` datetime DEFAULT NULL COMMENT '开始时间',
  `end_time` datetime DEFAULT NULL COMMENT '结束时间',
  `add_time` bigint(20) DEFAULT NULL COMMENT '门票添加时间',
  `card_photo` varchar(100) DEFAULT NULL COMMENT '门票图片',
  PRIMARY KEY (`card_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cards
-- ----------------------------
INSERT INTO `cards` VALUES ('1', '火热进行中', '火热进行中，', '1', '50', '60', '2018-09-25 00:00:00', null, '1529921550750', null);
INSERT INTO `cards` VALUES ('2', '团票半价', '火热进行中，组团享优惠', '1', '50', '100', '2018-09-25 00:00:00', '2018-10-01 18:13:53', '1529921550750', '');

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `com_id` int(11) NOT NULL AUTO_INCREMENT,
  `com_details` varchar(255) NOT NULL COMMENT '评论详情',
  `creat_time` datetime DEFAULT NULL COMMENT '评论时间',
  PRIMARY KEY (`com_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comments
-- ----------------------------

-- ----------------------------
-- Table structure for permissions
-- ----------------------------
DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions` (
  `per_id` int(11) NOT NULL AUTO_INCREMENT,
  `per_name` varchar(10) NOT NULL COMMENT '权限名',
  `per_code` varchar(32) DEFAULT NULL COMMENT '权限编码',
  `url` varchar(225) DEFAULT NULL,
  `parent_code` int(11) DEFAULT NULL COMMENT '父节点',
  `child_code` int(11) DEFAULT NULL COMMENT '子节点',
  `available` tinyint(1) DEFAULT NULL COMMENT '是否启用',
  `level` int(11) DEFAULT NULL COMMENT '等级',
  `sort_description` varchar(255) DEFAULT NULL COMMENT '简短描述',
  `orgunit_id` int(11) NOT NULL COMMENT '外键组织id',
  PRIMARY KEY (`per_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permissions
-- ----------------------------
INSERT INTO `permissions` VALUES ('2', '评论', '100001', '1', '1', '1', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `role_id` int(32) NOT NULL AUTO_INCREMENT COMMENT '角色id',
  `role_name` varchar(32) NOT NULL COMMENT '角色名',
  `role_description` varchar(100) DEFAULT NULL COMMENT '角色描述',
  `available` tinyint(1) DEFAULT '1' COMMENT '是否启用',
  `orgunit_id` int(11) NOT NULL COMMENT '外键组织id',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('3', '普通用户', '操作', '1', '11');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `role_per_id` int(255) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `roel_id` int(255) DEFAULT NULL COMMENT '外键：角色id',
  `per_id` int(255) DEFAULT NULL COMMENT '外键：权限id',
  PRIMARY KEY (`role_per_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1', '3', '2');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `_id` int(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(16) DEFAULT NULL COMMENT '用户名',
  `account` varchar(16) NOT NULL COMMENT '用户账号',
  `user_password` varchar(64) NOT NULL COMMENT '用户密码',
  `salt` varchar(32) NOT NULL COMMENT '盐值',
  `state` int(1) NOT NULL COMMENT '状态：0-删除，1-正常，2-默认状态',
  `address` varchar(100) DEFAULT NULL COMMENT '地址',
  `phone` int(11) DEFAULT NULL COMMENT '电话号码',
  `email` varchar(32) DEFAULT NULL COMMENT '邮箱',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `last_time` datetime DEFAULT NULL COMMENT '最后登录时间',
  `orgunit_id` int(11) NOT NULL COMMENT '外键组织id',
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('6', 'admin', '11111', '2ac3670495d4fc218899292a775f8a72', '0b7365fbf16854d6bd50b43af57fac16', '1', '大营街', '123456', null, null, null, '1111111');

-- ----------------------------
-- Table structure for user_collection
-- ----------------------------
DROP TABLE IF EXISTS `user_collection`;
CREATE TABLE `user_collection` (
  `coll_id` int(255) NOT NULL AUTO_INCREMENT COMMENT '收藏ID',
  `user_id` int(255) NOT NULL COMMENT '收藏者id',
  `other_id` int(255) NOT NULL COMMENT '藏品id',
  `coll_type` varchar(32) DEFAULT NULL COMMENT '藏品类型',
  PRIMARY KEY (`coll_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_collection
-- ----------------------------
INSERT INTO `user_collection` VALUES ('26', '6', '1', 'zools');

-- ----------------------------
-- Table structure for user_comments
-- ----------------------------
DROP TABLE IF EXISTS `user_comments`;
CREATE TABLE `user_comments` (
  `_id` int(255) NOT NULL AUTO_INCREMENT COMMENT '用户评论id',
  `zool_id` int(255) NOT NULL COMMENT '动物园id',
  `ad_id` int(255) NOT NULL COMMENT '外键：用户管理员id',
  `is_admin` tinyint(1) DEFAULT NULL COMMENT '是否是管理员',
  `com_id` int(255) NOT NULL COMMENT '外键评论id',
  `state` varchar(1) NOT NULL COMMENT '状态',
  PRIMARY KEY (`_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_comments
-- ----------------------------

-- ----------------------------
-- Table structure for zools
-- ----------------------------
DROP TABLE IF EXISTS `zools`;
CREATE TABLE `zools` (
  `zool_id` int(255) NOT NULL AUTO_INCREMENT COMMENT '动物园ID',
  `zool_name` varchar(100) NOT NULL COMMENT '动物园名字',
  `zool_description` varchar(100) DEFAULT NULL COMMENT '动物园描述',
  `url` varchar(225) DEFAULT NULL COMMENT '动物园官方网址',
  `address` varchar(255) DEFAULT NULL COMMENT '动物园地址',
  `emial` varchar(16) DEFAULT NULL COMMENT '动物园邮件地址',
  `type` varchar(32) DEFAULT NULL COMMENT '动物园类型',
  `start_level` varchar(1) DEFAULT NULL COMMENT '星级水平',
  `creation_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`zool_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zools
-- ----------------------------
INSERT INTO `zools` VALUES ('1', '天山动物园', '这里有各种动物', 'http://tianshan.com', '昆仑山', 'tiansan@tian.com', '动物园', '1', '2018-05-01 16:24:08');
INSERT INTO `zools` VALUES ('2', '雪上动物园', '这里四季如雪', 'http://tianshan.com', '大雪山', 'tiansan@tian.com', '动物园', '1', '2018-05-07 16:51:07');
INSERT INTO `zools` VALUES ('3', '黄山动物园', '黄山奇景', 'http://tianshan.com', '黄山', 'tiansan@tian.com', '动物园', '1', '2018-02-14 16:51:12');
INSERT INTO `zools` VALUES ('4', '火山动物园', '火山', 'http://tianshan.com', '火山', 'tiansan@tian.com', '动物园', '1', '2018-05-31 16:51:22');
INSERT INTO `zools` VALUES ('5', '岩洞动物园', '水晶，地下动物', 'http://tianshan.com', '燕山', 'tiansan@tian.com', '动物园', '1', '2018-06-05 16:51:25');
INSERT INTO `zools` VALUES ('6', '海底乐园', '海洋奇珍', 'http://tianshan.com', '海底', 'tiansan@tian.com', '海洋馆', '1', '2018-03-01 16:51:30');

-- ----------------------------
-- Table structure for zool_animals
-- ----------------------------
DROP TABLE IF EXISTS `zool_animals`;
CREATE TABLE `zool_animals` (
  `za_id` int(11) NOT NULL AUTO_INCREMENT,
  `an_id` int(11) NOT NULL COMMENT '动物id',
  `zool_id` int(11) NOT NULL COMMENT '动物园ID',
  PRIMARY KEY (`za_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zool_animals
-- ----------------------------

-- ----------------------------
-- Table structure for zool_photos
-- ----------------------------
DROP TABLE IF EXISTS `zool_photos`;
CREATE TABLE `zool_photos` (
  `photo_id` int(255) NOT NULL AUTO_INCREMENT COMMENT '照片id',
  `photos` varchar(100) DEFAULT NULL COMMENT '照片路径',
  `photos_name` varchar(16) DEFAULT NULL COMMENT '照片名',
  `zool_id` int(255) NOT NULL COMMENT '动物园id',
  PRIMARY KEY (`photo_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of zool_photos
-- ----------------------------
INSERT INTO `zool_photos` VALUES ('1', 'zools/name1.jpg', 'zools/name1.jpg', '1');
INSERT INTO `zool_photos` VALUES ('2', 'zools/name2.jpg', 'zools/name2.jpg', '2');
INSERT INTO `zool_photos` VALUES ('3', 'zools/name3.jpg', 'zools/name3.jpg', '3');
INSERT INTO `zool_photos` VALUES ('4', 'zools/name4.jpg', 'zools/name4.jpg', '4');
INSERT INTO `zool_photos` VALUES ('5', 'zools/name5.jpg', 'zools/name5.jpg', '5');
INSERT INTO `zool_photos` VALUES ('6', 'zools/name6.jpg', 'zools/name6.jpg', '6');

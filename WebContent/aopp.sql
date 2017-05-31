/*
Navicat MySQL Data Transfer

Source Server         : ewe
Source Server Version : 50537
Source Host           : localhost:3306
Source Database       : meet

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2017-03-17 16:47:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `aopp`
-- ----------------------------
DROP TABLE IF EXISTS `aopp`;
CREATE TABLE `aopp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mobile` varchar(20) NOT NULL,
  `ad` int(20) NOT NULL,
  `dtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of aopp
-- ----------------------------
INSERT INTO `aopp` VALUES ('1', '19999999999', '101', '2017-03-14 17:06:47');
INSERT INTO `aopp` VALUES ('2', '19999999999', '101', '2017-03-14 17:08:58');
INSERT INTO `aopp` VALUES ('3', '19999999999', '101', '2017-03-14 17:10:54');
INSERT INTO `aopp` VALUES ('4', '19999999999', '101', '2017-03-14 17:11:57');
INSERT INTO `aopp` VALUES ('5', '19999999999', '101', '2017-03-14 17:12:39');
INSERT INTO `aopp` VALUES ('6', '19999999999', '101', '2017-03-14 17:13:06');
INSERT INTO `aopp` VALUES ('7', '19999999999', '101', '2017-03-14 17:13:24');
INSERT INTO `aopp` VALUES ('8', '19999999999', '101', '2017-03-14 17:13:58');
INSERT INTO `aopp` VALUES ('9', '19999999999', '101', '2017-03-14 17:15:58');
INSERT INTO `aopp` VALUES ('10', '19999999999', '101', '2017-03-14 17:16:30');
INSERT INTO `aopp` VALUES ('11', '19999999999', '101', '2017-03-14 17:22:17');
INSERT INTO `aopp` VALUES ('12', '19999999999', '101', '2017-03-14 17:22:29');
INSERT INTO `aopp` VALUES ('13', '19999999999', '101', '2017-03-14 17:24:12');
INSERT INTO `aopp` VALUES ('14', '19999999999', '101', '2017-03-14 17:29:22');
INSERT INTO `aopp` VALUES ('15', '19999999999', '101', '2017-03-14 17:31:09');
INSERT INTO `aopp` VALUES ('16', '19999999999', '101', '2017-03-14 17:31:38');
INSERT INTO `aopp` VALUES ('17', '19999999999', '101', '2017-03-14 17:31:47');
INSERT INTO `aopp` VALUES ('18', '19999999999', '101', '2017-03-14 17:33:36');
INSERT INTO `aopp` VALUES ('19', '19999999999', '101', '2017-03-14 17:33:41');
INSERT INTO `aopp` VALUES ('20', '19999999999', '101', '2017-03-14 17:34:34');
INSERT INTO `aopp` VALUES ('21', '19999999999', '101', '2017-03-14 17:34:48');
INSERT INTO `aopp` VALUES ('22', '19999999999', '101', '2017-03-14 17:40:50');
INSERT INTO `aopp` VALUES ('23', '19999999999', '101', '2017-03-14 17:40:56');
INSERT INTO `aopp` VALUES ('24', '19999999999', '101', '2017-03-14 17:43:06');
INSERT INTO `aopp` VALUES ('25', '19999999999', '101', '2017-03-14 17:43:12');
INSERT INTO `aopp` VALUES ('26', '19999999999', '101', '2017-03-14 17:43:40');
INSERT INTO `aopp` VALUES ('27', '19999999999', '101', '2017-03-15 09:16:32');
INSERT INTO `aopp` VALUES ('28', '19999999999', '101', '2017-03-15 09:16:37');
INSERT INTO `aopp` VALUES ('29', '19999999999', '101', '2017-03-15 09:18:01');
INSERT INTO `aopp` VALUES ('30', '19999999999', '101', '2017-03-15 09:30:51');
INSERT INTO `aopp` VALUES ('31', '19999999999', '101', '2017-03-15 11:49:06');
INSERT INTO `aopp` VALUES ('32', '19999999999', '101', '2017-03-15 11:49:12');
INSERT INTO `aopp` VALUES ('33', '19999999999', '101', '2017-03-15 11:54:38');
INSERT INTO `aopp` VALUES ('34', '19999999999', '101', '2017-03-15 12:00:00');
INSERT INTO `aopp` VALUES ('35', '19999999999', '101', '2017-03-15 12:00:39');
INSERT INTO `aopp` VALUES ('36', '19999999999', '101', '2017-03-15 12:00:52');
INSERT INTO `aopp` VALUES ('37', '19999999999', '101', '2017-03-16 10:08:13');
INSERT INTO `aopp` VALUES ('38', '19999999999', '101', '2017-03-16 10:10:09');
INSERT INTO `aopp` VALUES ('39', '19999999999', '101', '2017-03-16 10:11:34');
INSERT INTO `aopp` VALUES ('40', '19999999999', '101', '2017-03-16 10:13:02');
INSERT INTO `aopp` VALUES ('41', '19999999999', '101', '2017-03-16 10:16:42');
INSERT INTO `aopp` VALUES ('42', '19999999999', '101', '2017-03-16 10:18:21');
INSERT INTO `aopp` VALUES ('43', '19999999999', '101', '2017-03-16 10:19:01');
INSERT INTO `aopp` VALUES ('44', '19999999999', '101', '2017-03-16 10:20:29');
INSERT INTO `aopp` VALUES ('45', '19999999999', '101', '2017-03-16 10:26:16');
INSERT INTO `aopp` VALUES ('46', '19999999999', '101', '2017-03-16 10:27:28');
INSERT INTO `aopp` VALUES ('47', '19999999999', '101', '2017-03-16 10:36:37');
INSERT INTO `aopp` VALUES ('48', '19999999999', '101', '2017-03-16 10:50:56');
INSERT INTO `aopp` VALUES ('49', '19999999999', '101', '2017-03-16 10:51:29');
INSERT INTO `aopp` VALUES ('50', '19999999999', '101', '2017-03-16 10:55:30');
INSERT INTO `aopp` VALUES ('51', '19999999999', '101', '2017-03-16 10:55:42');
INSERT INTO `aopp` VALUES ('52', '19999999999', '101', '2017-03-16 11:01:48');
INSERT INTO `aopp` VALUES ('53', '19999999999', '101', '2017-03-16 11:12:09');
INSERT INTO `aopp` VALUES ('54', '19999999999', '101', '2017-03-16 13:07:42');
INSERT INTO `aopp` VALUES ('55', '19999999999', '101', '2017-03-16 13:08:48');
INSERT INTO `aopp` VALUES ('56', '19999999999', '101', '2017-03-16 13:11:18');
INSERT INTO `aopp` VALUES ('57', '19999999999', '101', '2017-03-16 13:20:57');
INSERT INTO `aopp` VALUES ('58', '19999999999', '101', '2017-03-16 13:22:29');
INSERT INTO `aopp` VALUES ('59', '19999999999', '101', '2017-03-16 13:23:03');
INSERT INTO `aopp` VALUES ('60', '19999999999', '101', '2017-03-16 13:23:27');
INSERT INTO `aopp` VALUES ('61', '19999999999', '101', '2017-03-16 13:25:05');
INSERT INTO `aopp` VALUES ('62', '19999999999', '101', '2017-03-16 13:26:02');
INSERT INTO `aopp` VALUES ('63', '19999999999', '101', '2017-03-16 13:26:16');
INSERT INTO `aopp` VALUES ('64', '19999999999', '101', '2017-03-16 13:27:56');
INSERT INTO `aopp` VALUES ('65', '19999999999', '101', '2017-03-16 13:31:29');
INSERT INTO `aopp` VALUES ('66', '19999999999', '101', '2017-03-16 13:42:15');
INSERT INTO `aopp` VALUES ('67', '19999999999', '101', '2017-03-16 13:43:43');
INSERT INTO `aopp` VALUES ('68', '19999999999', '101', '2017-03-16 13:43:50');
INSERT INTO `aopp` VALUES ('69', '19999999999', '101', '2017-03-16 13:44:07');
INSERT INTO `aopp` VALUES ('70', '19999999999', '101', '2017-03-16 13:45:11');
INSERT INTO `aopp` VALUES ('71', '19999999999', '101', '2017-03-16 13:45:23');
INSERT INTO `aopp` VALUES ('72', '19999999999', '101', '2017-03-16 13:46:13');
INSERT INTO `aopp` VALUES ('73', '19999999999', '101', '2017-03-16 14:01:57');
INSERT INTO `aopp` VALUES ('74', '19999999999', '101', '2017-03-16 14:02:17');
INSERT INTO `aopp` VALUES ('75', '19999999999', '101', '2017-03-16 14:44:06');
INSERT INTO `aopp` VALUES ('76', '19999999999', '101', '2017-03-16 14:44:27');
INSERT INTO `aopp` VALUES ('77', '19999999999', '101', '2017-03-16 14:57:11');
INSERT INTO `aopp` VALUES ('78', '19999999999', '101', '2017-03-16 14:59:18');
INSERT INTO `aopp` VALUES ('79', '19999999999', '101', '2017-03-16 16:04:18');
INSERT INTO `aopp` VALUES ('80', '19999999999', '101', '2017-03-16 16:10:30');
INSERT INTO `aopp` VALUES ('81', '19999999999', '101', '2017-03-16 16:10:44');
INSERT INTO `aopp` VALUES ('82', '19999999999', '101', '2017-03-16 16:19:30');
INSERT INTO `aopp` VALUES ('83', '19999999999', '101', '2017-03-16 16:21:11');
INSERT INTO `aopp` VALUES ('84', '19999999999', '101', '2017-03-16 17:37:08');
INSERT INTO `aopp` VALUES ('85', '19999999999', '101', '2017-03-16 17:37:43');
INSERT INTO `aopp` VALUES ('86', '19999999999', '101', '2017-03-16 17:37:50');
INSERT INTO `aopp` VALUES ('87', '19999999999', '101', '2017-03-16 17:39:34');
INSERT INTO `aopp` VALUES ('88', '19999999999', '101', '2017-03-16 17:40:20');
INSERT INTO `aopp` VALUES ('89', '19999999999', '101', '2017-03-16 17:40:27');
INSERT INTO `aopp` VALUES ('90', '19999999999', '101', '2017-03-16 17:41:28');
INSERT INTO `aopp` VALUES ('91', '19999999999', '101', '2017-03-16 17:41:34');
INSERT INTO `aopp` VALUES ('92', '19999999999', '101', '2017-03-16 17:42:46');
INSERT INTO `aopp` VALUES ('93', '19999999999', '101', '2017-03-17 10:05:49');
INSERT INTO `aopp` VALUES ('94', '19999999999', '101', '2017-03-17 10:06:06');
INSERT INTO `aopp` VALUES ('95', '19999999999', '101', '2017-03-17 10:07:29');
INSERT INTO `aopp` VALUES ('96', '19999999999', '101', '2017-03-17 10:07:56');
INSERT INTO `aopp` VALUES ('97', '19999999999', '101', '2017-03-17 10:13:26');
INSERT INTO `aopp` VALUES ('98', '19999999999', '101', '2017-03-17 10:13:40');
INSERT INTO `aopp` VALUES ('99', '19999999999', '101', '2017-03-17 10:27:07');
INSERT INTO `aopp` VALUES ('100', '19999999999', '101', '2017-03-17 10:46:29');
INSERT INTO `aopp` VALUES ('101', '19999999999', '101', '2017-03-17 10:53:56');
INSERT INTO `aopp` VALUES ('102', '19999999999', '101', '2017-03-17 11:35:56');
INSERT INTO `aopp` VALUES ('103', '19999999999', '101', '2017-03-17 11:38:22');
INSERT INTO `aopp` VALUES ('104', '19999999999', '101', '2017-03-17 12:42:24');
INSERT INTO `aopp` VALUES ('105', '19999999999', '101', '2017-03-17 12:46:33');
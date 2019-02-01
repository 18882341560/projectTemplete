/*
 Navicat Premium Data Transfer

 Source Server         : localhost_mysql
 Source Server Type    : MySQL
 Source Server Version : 80014
 Source Host           : localhost:3306
 Source Schema         : projectteplete

 Target Server Type    : MySQL
 Target Server Version : 80014
 File Encoding         : 65001

 Date: 01/02/2019 18:01:27
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for log_exception
-- ----------------------------
DROP TABLE IF EXISTS `log_exception`;
CREATE TABLE `log_exception`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `message` varchar(5000) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `requestUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `descInfo` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `parameter` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `dateTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of log_exception
-- ----------------------------
INSERT INTO `log_exception` VALUES (1, '测试错误', '/test/a', '士大夫士大夫', '{\"id\":\"但是反复\",\"type\":\"2\"}', NULL);
INSERT INTO `log_exception` VALUES (2, '测试错误', '/test/a', '士大夫士大夫', '{}', NULL);
INSERT INTO `log_exception` VALUES (3, '测试错误', '/test/a', '士大夫士大夫', '{\"id\":\"1\",\"type\":\"2\"}', '2019-02-01 15:16:39');

-- ----------------------------
-- Table structure for log_operation
-- ----------------------------
DROP TABLE IF EXISTS `log_operation`;
CREATE TABLE `log_operation`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `operateUserId` int(11) DEFAULT NULL,
  `operateMethod` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `operateUrl` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `parameter` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `operateDateTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  `operateExplain` varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_bin ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of log_operation
-- ----------------------------
INSERT INTO `log_operation` VALUES (1, 1, 'TestController.test', '/test/a', '{\"id\":\"1\",\"type\":\"2\"}', '2019-02-01 15:16:03', '测试操作1');
INSERT INTO `log_operation` VALUES (2, 1, 'TestController.test', '/test/a', '{\"id\":\"1\",\"type\":\"2\"}', '2019-02-01 15:16:39', '测试操作1');
INSERT INTO `log_operation` VALUES (3, 1, 'TestController.test', '/test/a', '{}', '2019-02-01 16:02:46', '测试操作1');
INSERT INTO `log_operation` VALUES (4, 1, 'TestController.test', '/test/a', '{}', '2019-02-01 16:05:43', '测试操作1');
INSERT INTO `log_operation` VALUES (5, 1, 'TestController.test', '/test/a', '{\"id\":\"1\",\"type\":\"2\"}', '2019-02-01 16:05:51', '测试操作1');
INSERT INTO `log_operation` VALUES (6, 1, 'TestController.test', '/test/a', '{\"id\":\"1\",\"type\":\"2\"}', '2019-02-01 16:12:42', '测试操作1');

SET FOREIGN_KEY_CHECKS = 1;

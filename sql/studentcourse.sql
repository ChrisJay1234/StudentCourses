/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80032 (8.0.32)
 Source Host           : localhost:3306
 Source Schema         : pbl

 Target Server Type    : MySQL
 Target Server Version : 80032 (8.0.32)
 File Encoding         : 65001

 Date: 11/01/2024 20:47:28
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `team_id` int NULL DEFAULT NULL,
  `time` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `room` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '课程介绍',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (1, '软件工程', 1, '星期一12节', '101', '牛逼的课', '2023-10-24 16:49:33', '2023-10-24 16:49:36');
INSERT INTO `course` VALUES (2, '数据结构', 2, '星期一12节', '101', '11111', '2023-10-24 16:50:54', '2023-10-24 16:50:57');
INSERT INTO `course` VALUES (3, '算法分析', 3, '星期一12节', '101', NULL, '2023-10-24 16:51:59', '2023-10-24 16:52:01');
INSERT INTO `course` VALUES (4, '程序设计', 4, '星期一12节', '101', NULL, '2023-10-24 16:53:48', '2023-10-24 16:53:51');

-- ----------------------------
-- Table structure for homework
-- ----------------------------
DROP TABLE IF EXISTS `homework`;
CREATE TABLE `homework`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `teacher_id` int NOT NULL,
  `course_id` int NULL DEFAULT NULL,
  `title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `content` varchar(10000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `start_time` datetime NULL DEFAULT NULL,
  `end_time` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of homework
-- ----------------------------
INSERT INTO `homework` VALUES (1, 1, NULL, '第一章测试', '请写出xxx', '2023-10-28 17:14:29', '2023-11-04 19:14:29');
INSERT INTO `homework` VALUES (2, 1, NULL, '第二章测试', '请写出xxx', '2023-10-29 16:08:50', '2023-11-05 18:08:50');
INSERT INTO `homework` VALUES (3, 1, NULL, '第二章测试', '请写出xxx', '2023-10-29 16:15:03', '2023-10-30 18:35:03');
INSERT INTO `homework` VALUES (4, 1, NULL, '第3章测试', '请写出xxx', '2023-10-29 16:20:50', '2023-10-30 16:20:50');
INSERT INTO `homework` VALUES (5, 2, NULL, '第4章测试', '请写出xxx', '2023-10-29 16:44:48', '2023-10-30 16:44:48');
INSERT INTO `homework` VALUES (6, 1, NULL, '第4章测试', '请写出xxx', '2023-10-29 17:11:16', '2023-10-30 17:11:16');
INSERT INTO `homework` VALUES (7, 1, NULL, '第4章测试', '请写出xxx', '2023-11-01 17:59:43', '2023-11-02 17:59:43');
INSERT INTO `homework` VALUES (8, 1, 1, '第4章测试', '请写出xxx', '2023-11-10 09:48:51', '2023-11-11 09:48:51');

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `team_id` int NULL DEFAULT NULL,
  `info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES (1, 'APP开发', 1, 'xxxx', '2023-09-20 16:17:08', '2023-09-20 16:17:10');
INSERT INTO `project` VALUES (2, '小程序', 2, 'xxxx', '2023-09-20 16:17:25', '2023-09-20 16:17:28');
INSERT INTO `project` VALUES (3, '人工智能', 1, 'xxxx', '2023-09-20 16:17:47', '2023-09-20 16:17:48');
INSERT INTO `project` VALUES (4, '圣诞节', 2, 'xxxx', '2023-09-20 16:18:08', '2023-09-20 16:18:10');
INSERT INTO `project` VALUES (5, '多个', 5, 'xxxx', '2023-09-20 16:18:24', '2023-09-20 16:18:25');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `course_id` int NULL DEFAULT NULL,
  `coursestatus` int NULL DEFAULT NULL,
  `project_id` int NULL DEFAULT NULL,
  `projectstatus` int NULL DEFAULT NULL,
  `info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '202110100211', '张三', '123456', 1, 0, 1, 0, '我是三好教师', '2023-09-20 12:40:11', '2023-12-12 19:50:19');
INSERT INTO `student` VALUES (2, '202110100212', '李四', '123456', 1, 1, 2, 1, '我是三好学生', '2023-09-20 16:06:57', '2023-12-05 20:05:40');
INSERT INTO `student` VALUES (3, '202110100213', '王五', '123456', NULL, NULL, 2, 1, '我是三好学生', '2023-09-20 16:07:17', '2023-12-05 21:35:28');
INSERT INTO `student` VALUES (4, '202110100214', '赵六', '123456', NULL, NULL, 1, 1, '我是三好学生', '2023-09-20 16:07:32', '2023-09-20 16:07:36');
INSERT INTO `student` VALUES (5, '202110100215', '12', '123456', NULL, NULL, NULL, NULL, '我是三好学生', '2023-10-24 16:52:59', '2023-10-24 16:53:02');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `team_id` int NULL DEFAULT NULL COMMENT '团队id',
  `info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '信息简介',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, '1000001', '李四', '123456', 1, '我是三好教师', '2023-09-20 12:41:15', '2023-12-12 19:49:55');
INSERT INTO `teacher` VALUES (2, '1000002', '张三', '123456', 2, 'xxxxxxxxxx', '2023-09-20 16:10:38', '2023-09-20 16:10:41');

-- ----------------------------
-- Table structure for team
-- ----------------------------
DROP TABLE IF EXISTS `team`;
CREATE TABLE `team`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '团队名称',
  `teacher` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '团队负责老师',
  `info` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '团队信息',
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of team
-- ----------------------------
INSERT INTO `team` VALUES (1, '李老师团队', '李四', 'xxxx', '2023-09-20 12:45:32', '2023-09-20 12:45:34');
INSERT INTO `team` VALUES (2, '王老师团队', '王五', 'xxxxx', '2023-09-20 16:10:00', '2023-09-20 16:10:02');
INSERT INTO `team` VALUES (3, '张老师团队', '张三', 'xxxx', '2023-09-20 16:19:06', '2023-09-20 16:19:08');
INSERT INTO `team` VALUES (4, '刘老师团队', '刘能', 'xxx', '2023-11-30 15:59:32', '2023-11-30 15:59:35');

SET FOREIGN_KEY_CHECKS = 1;

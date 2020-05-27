/*
 Navicat Premium Data Transfer

 Source Server         : join
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : 101.200.135.43:3306
 Source Schema         : db_exam

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 21/05/2020 09:56:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin`  (
  `aid` int(0) NOT NULL AUTO_INCREMENT COMMENT '管理员编号',
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '密码',
  `aname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  PRIMARY KEY (`aid`) USING BTREE,
  UNIQUE INDEX `EXAM`(`aid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES (1, '123', 'admin');
INSERT INTO `t_admin` VALUES (2, '1111', 'aaa');
INSERT INTO `t_admin` VALUES (3, 'g', 'tt');
INSERT INTO `t_admin` VALUES (6, 'test', 'test');
INSERT INTO `t_admin` VALUES (7, 'test', 'test');
INSERT INTO `t_admin` VALUES (8, 'test', 'test');
INSERT INTO `t_admin` VALUES (9, 'test', 'testa');
INSERT INTO `t_admin` VALUES (10, 'test', 'testa');

-- ----------------------------
-- Table structure for t_answer
-- ----------------------------
DROP TABLE IF EXISTS `t_answer`;
CREATE TABLE `t_answer`  (
  `anid` int(0) NOT NULL,
  `qid` int(0) DEFAULT NULL COMMENT '试题编号',
  `state` int(0) DEFAULT NULL COMMENT '答题情况',
  `teid` int(0) DEFAULT NULL COMMENT '考试记录编号',
  PRIMARY KEY (`anid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_answerstu
-- ----------------------------
DROP TABLE IF EXISTS `t_answerstu`;
CREATE TABLE `t_answerstu`  (
  `anid` int(0) NOT NULL AUTO_INCREMENT,
  `uid` int(0) DEFAULT NULL COMMENT '学生id',
  `pid` int(0) DEFAULT NULL COMMENT '试卷id',
  `quid` int(0) DEFAULT NULL COMMENT '试题id',
  `sanswer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '学生答案',
  `statement` tinyint(0) DEFAULT NULL COMMENT '答案是对是错',
  `teid` int(0) DEFAULT NULL COMMENT 'tests表的id',
  `corrAns` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`anid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_answerstu
-- ----------------------------
INSERT INTO `t_answerstu` VALUES (1, 1, 1, 1201, 'adaf', 1, 1, NULL);
INSERT INTO `t_answerstu` VALUES (2, 23, 2, 1, '23', 0, 2, NULL);
INSERT INTO `t_answerstu` VALUES (4, 0, 3, 1201, NULL, 1, 3, NULL);

-- ----------------------------
-- Table structure for t_blank
-- ----------------------------
DROP TABLE IF EXISTS `t_blank`;
CREATE TABLE `t_blank`  (
  `bid` int(0) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '题干',
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '答案',
  `pid` int(0) DEFAULT NULL COMMENT '试卷id',
  PRIMARY KEY (`bid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 332112 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_blank
-- ----------------------------
INSERT INTO `t_blank` VALUES (1201, 'da', 'asd', 12);
INSERT INTO `t_blank` VALUES (1211, '视图是一个虚表，它是从（）中导出的表。', '基本表', 12);

-- ----------------------------
-- Table structure for t_exam
-- ----------------------------
DROP TABLE IF EXISTS `t_exam`;
CREATE TABLE `t_exam`  (
  `Id` int(0) NOT NULL AUTO_INCREMENT,
  `course` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `date_` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name_` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `publisher` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `questionCode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `questionNumber` int(0) DEFAULT NULL,
  `time_` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `type_` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`Id`) USING BTREE
) ENGINE = MyISAM AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_pandp
-- ----------------------------
DROP TABLE IF EXISTS `t_pandp`;
CREATE TABLE `t_pandp`  (
  `rid` int(0) NOT NULL COMMENT 'id',
  `pid` int(0) DEFAULT NULL COMMENT '试卷id',
  `qid` int(0) DEFAULT NULL COMMENT '试题id',
  PRIMARY KEY (`rid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_paper
-- ----------------------------
DROP TABLE IF EXISTS `t_paper`;
CREATE TABLE `t_paper`  (
  `pid` int(0) NOT NULL AUTO_INCREMENT COMMENT '试卷id',
  `pname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '试卷名称',
  `ptime` int(0) DEFAULT NULL COMMENT '答题时长',
  `tid` int(0) DEFAULT NULL COMMENT '出题教师编号',
  `deadline` datetime(0) DEFAULT NULL COMMENT '截止时间',
  `num` int(0) DEFAULT NULL COMMENT '考试次数',
  `judscore` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '分数判断类型',
  PRIMARY KEY (`pid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1218 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_paper
-- ----------------------------
INSERT INTO `t_paper` VALUES (1, '第一章测试', 90, 0, '2020-05-29 15:59:59', NULL, NULL);
INSERT INTO `t_paper` VALUES (2, '第二章测试', 100, 0, '2020-05-22 15:59:59', 0, NULL);
INSERT INTO `t_paper` VALUES (3, '第三章测试', 120, 0, '2020-05-22 15:59:59', NULL, NULL);
INSERT INTO `t_paper` VALUES (4, '第四章测试', 120, 0, '2020-05-30 15:59:59', NULL, NULL);
INSERT INTO `t_paper` VALUES (5, '第五章测试', 120, 0, '2020-05-12 15:59:59', NULL, NULL);
INSERT INTO `t_paper` VALUES (6, '第六章测试', 80, 0, '2020-05-29 15:59:59', NULL, NULL);
INSERT INTO `t_paper` VALUES (7, '第七章测试', 120, 0, '2020-05-27 15:59:59', NULL, NULL);
INSERT INTO `t_paper` VALUES (12, '第十二章测试', 90, 0, '2020-05-18 15:59:59', NULL, NULL);
INSERT INTO `t_paper` VALUES (233, '', 33, 0, NULL, 0, NULL);

-- ----------------------------
-- Table structure for t_question
-- ----------------------------
DROP TABLE IF EXISTS `t_question`;
CREATE TABLE `t_question`  (
  `qid` int(0) NOT NULL AUTO_INCREMENT COMMENT '试题编号',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '题干',
  `aoption` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'A选项',
  `boption` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'B选项',
  `coption` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'C选项',
  `doption` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'D选项',
  `answer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '答案',
  `pid` int(0) DEFAULT NULL COMMENT '试卷编号',
  PRIMARY KEY (`qid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2323 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_question
-- ----------------------------
INSERT INTO `t_question` VALUES (301, 'fg', 'fdg', 'fdg', 'fdg', 'fdg', 'B', 12);
INSERT INTO `t_question` VALUES (1201, 'UNIQUE唯一索引的作用是（）', '保证各行在该索引上的值不得重复', '保证各行在该索引上的值不能为NULL', '保证参加唯一索引的各列，不得再参与其他的索引', '保证唯一索引不能被删除', 'A', 12);

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE IF EXISTS `t_student`;
CREATE TABLE `t_student`  (
  `uid` int(0) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `uclass` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1593918292 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO `t_student` VALUES (13, '123123', '12333', '123123', '123123', '软件工程');
INSERT INTO `t_student` VALUES (211, '123', '123', '123', '1231', '教育技术');
INSERT INTO `t_student` VALUES (222, '222', '222', '222', '222', '教育技术');

-- ----------------------------
-- Table structure for t_teacher
-- ----------------------------
DROP TABLE IF EXISTS `t_teacher`;
CREATE TABLE `t_teacher`  (
  `tid` int(0) NOT NULL AUTO_INCREMENT,
  `tname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`tid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO `t_teacher` VALUES (1, 'teacher', '123', '111', '11@');
INSERT INTO `t_teacher` VALUES (2, 'st2', 'pst2', 'phst2', 'est2');
INSERT INTO `t_teacher` VALUES (3, 'test', '1', NULL, NULL);
INSERT INTO `t_teacher` VALUES (5, 'ddd', 'gai', NULL, NULL);
INSERT INTO `t_teacher` VALUES (6, '1', NULL, NULL, NULL);
INSERT INTO `t_teacher` VALUES (7, 'aab', NULL, '11', '22');

-- ----------------------------
-- Table structure for t_tests
-- ----------------------------
DROP TABLE IF EXISTS `t_tests`;
CREATE TABLE `t_tests`  (
  `teid` int(0) NOT NULL AUTO_INCREMENT COMMENT '考试记录id',
  `uid` int(0) DEFAULT NULL COMMENT '学生id',
  `pid` int(0) DEFAULT NULL COMMENT '试卷id',
  `starttime` datetime(0) DEFAULT NULL COMMENT '考试开始时间',
  `endtime` datetime(0) DEFAULT NULL COMMENT '考试结束时间',
  `time` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '答题总时长',
  `score` int(0) DEFAULT NULL COMMENT '得分',
  PRIMARY KEY (`teid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_tests
-- ----------------------------
INSERT INTO `t_tests` VALUES (1, 1, 1, '2020-04-27 15:32:34', '2020-05-01 18:32:39', '124', 33);
INSERT INTO `t_tests` VALUES (2, NULL, 1, NULL, NULL, NULL, 0);
INSERT INTO `t_tests` VALUES (4, NULL, 221, NULL, NULL, NULL, 100);
INSERT INTO `t_tests` VALUES (5, NULL, 221, '2020-04-27 00:00:00', '2020-04-27 00:00:00', '0', 0);
INSERT INTO `t_tests` VALUES (6, NULL, 221, '2020-04-27 15:32:34', '2020-04-27 16:32:34', '-3600000', 0);
INSERT INTO `t_tests` VALUES (7, NULL, 221, '2020-04-27 15:32:34', '2020-04-27 16:32:34', '3600', 0);
INSERT INTO `t_tests` VALUES (8, NULL, 2, NULL, NULL, NULL, 1);

SET FOREIGN_KEY_CHECKS = 1;

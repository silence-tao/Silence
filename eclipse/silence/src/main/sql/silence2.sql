/*
SQLyog Ultimate v8.71 
MySQL - 5.5.27 : Database - silence
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`silence` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `silence`;

/*Table structure for table `comment` */

DROP TABLE IF EXISTS `comment`;

CREATE TABLE `comment` (
  `comment_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `content` varchar(200) NOT NULL COMMENT '评论内容',
  `father_id` bigint(20) NOT NULL,
  `user_sign` varchar(100) NOT NULL COMMENT 'user唯一标示sign',
  `owner_sign` varchar(100) NOT NULL COMMENT '评论所属的sign',
  `comment_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评论时间',
  `state` bigint(5) NOT NULL COMMENT '表示阅读状态,0表示未读,1表示已读',
  `to_sign` varchar(100) DEFAULT NULL COMMENT '给谁评论或回复谁',
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Table structure for table `history` */

DROP TABLE IF EXISTS `history`;

CREATE TABLE `history` (
  `history_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '项目进程id',
  `title` varchar(50) DEFAULT NULL COMMENT '标题',
  `content` varchar(200) NOT NULL COMMENT '此次进程内容',
  `history_sign` varchar(100) DEFAULT NULL COMMENT '唯一标识sign',
  `record_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录时间',
  `home_show` bigint(2) DEFAULT NULL COMMENT '是否在首页显示',
  PRIMARY KEY (`history_id`),
  KEY `idx_record_time` (`record_time`)
) ENGINE=InnoDB AUTO_INCREMENT=100000004 DEFAULT CHARSET=utf8;

/*Table structure for table `message` */

DROP TABLE IF EXISTS `message`;

CREATE TABLE `message` (
  `message_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `content` varchar(200) NOT NULL COMMENT '留言内容',
  `message_sign` varchar(100) NOT NULL COMMENT '唯一标示',
  `user_sign` varchar(100) NOT NULL COMMENT '留言的人',
  `message_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '留言时间',
  `state` bigint(5) NOT NULL COMMENT '表示阅读状态,0表示未读,1表示已读',
  `father_id` bigint(20) DEFAULT NULL,
  `home_show` bigint(2) DEFAULT NULL COMMENT '是否在首页显示',
  PRIMARY KEY (`message_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Table structure for table `opinion` */

DROP TABLE IF EXISTS `opinion`;

CREATE TABLE `opinion` (
  `opinion_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(50) NOT NULL COMMENT '标题',
  `content` mediumtext NOT NULL COMMENT '内容',
  `publisher` varchar(100) NOT NULL COMMENT '发布者',
  `opinion_sign` varchar(100) NOT NULL COMMENT '唯一标示',
  `publish_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  `summary` varchar(200) DEFAULT NULL COMMENT '文章简介',
  `home_show` bigint(2) DEFAULT NULL COMMENT '是否在首页显示',
  PRIMARY KEY (`opinion_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100000003 DEFAULT CHARSET=utf8;

/*Table structure for table `picture` */

DROP TABLE IF EXISTS `picture`;

CREATE TABLE `picture` (
  `picture_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '图片id',
  `pertain` varchar(100) NOT NULL COMMENT '属于哪里',
  `real_path` varchar(100) NOT NULL COMMENT '图片实际路径',
  `upload_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上传图片的时间',
  PRIMARY KEY (`picture_id`),
  KEY `idx_upload_time` (`upload_time`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Table structure for table `statistic` */

DROP TABLE IF EXISTS `statistic`;

CREATE TABLE `statistic` (
  `statistic` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '数据统计id',
  `comment_num` bigint(10) NOT NULL COMMENT '评论数',
  `visitor_num` bigint(10) NOT NULL COMMENT '浏览量',
  `praise_num` bigint(10) NOT NULL COMMENT '点赞数',
  `pertain` varchar(100) NOT NULL COMMENT '所属',
  PRIMARY KEY (`statistic`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Table structure for table `technical` */

DROP TABLE IF EXISTS `technical`;

CREATE TABLE `technical` (
  `technical_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '技术文章id',
  `title` varchar(50) NOT NULL COMMENT '技术文章标题',
  `content` mediumtext NOT NULL COMMENT '技术文章内容',
  `publisher` varchar(100) NOT NULL COMMENT '发布者',
  `technical_sign` varchar(100) NOT NULL COMMENT '技术文章唯一标示',
  `publish_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  `audit_status` bigint(2) NOT NULL COMMENT '审核状态',
  `home_show` bigint(2) NOT NULL COMMENT '是否在首页显示',
  `classify` varchar(50) NOT NULL COMMENT '类别',
  `summary` varchar(200) DEFAULT NULL COMMENT '文章简介',
  PRIMARY KEY (`technical_id`)
) ENGINE=InnoDB AUTO_INCREMENT=100000006 DEFAULT CHARSET=utf8;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '图片id',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `nikename` varchar(50) NOT NULL COMMENT '昵称',
  `PASSWORD` varchar(100) DEFAULT NULL COMMENT '密码',
  `register_ip` varchar(20) DEFAULT NULL COMMENT '注册时的ip地址',
  `register_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  `user_rank` bigint(10) NOT NULL COMMENT '用户权限',
  `user_sign` varchar(100) DEFAULT NULL COMMENT '唯一标示sign',
  `header` varchar(100) DEFAULT NULL COMMENT '用户头像',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

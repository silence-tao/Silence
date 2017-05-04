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
  `comment_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `content` VARCHAR(200) NOT NULL COMMENT '评论内容',
  `father_id` BIGINT(20) NOT NULL,
  `user_sign` VARCHAR(100) NOT NULL COMMENT 'user唯一标示sign',
  `owner_sign` VARCHAR(100) NOT NULL COMMENT '评论所属的sign',
  `comment_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '评论时间',
  `state` BIGINT(5) NOT NULL COMMENT '表示阅读状态,0表示未读,1表示已读',
  `to_sign` VARCHAR(100) DEFAULT NULL COMMENT '给谁评论或回复谁',
  PRIMARY KEY (`comment_id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

/*Table structure for table `history` */

DROP TABLE IF EXISTS `history`;

CREATE TABLE `history` (
  `history_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '项目进程id',
  `title` VARCHAR(200) DEFAULT NULL COMMENT '标题',
  `content` VARCHAR(1000) NOT NULL COMMENT '此次进程内容',
  `history_sign` VARCHAR(100) DEFAULT NULL COMMENT '唯一标识sign',
  `record_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录时间',
  PRIMARY KEY (`history_id`),
  `home_show` BIGINT(2) NOT NULL COMMENT '是否在首页显示',
  KEY `idx_record_time` (`record_time`)
) ENGINE=INNODB AUTO_INCREMENT=100000001 DEFAULT CHARSET=utf8;

/*Table structure for table `message` */

DROP TABLE IF EXISTS `message`;

CREATE TABLE `message` (
  `message_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `content` VARCHAR(200) NOT NULL COMMENT '留言内容',
  `message_sign` VARCHAR(100) NOT NULL COMMENT '唯一标示',
  `user_sign` VARCHAR(100) NOT NULL COMMENT '留言的人',
  `message_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '留言时间',
  `state` BIGINT(5) NOT NULL COMMENT '表示阅读状态,0表示未读,1表示已读',
  `father_id` BIGINT(20) DEFAULT NULL,
  `home_show` BIGINT(2) NOT NULL COMMENT '是否在首页显示',
  PRIMARY KEY (`message_id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

/*Table structure for table `opinion` */

CREATE TABLE `opinion` (
  `opinion_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` VARCHAR(200) NOT NULL COMMENT '标题',
  `content` MEDIUMTEXT NOT NULL COMMENT '内容',
  `publisher` VARCHAR(100) NOT NULL COMMENT '发布者',
  `opinion_sign` VARCHAR(100) NOT NULL COMMENT '唯一标示',
  `publish_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  `summary` VARCHAR(200) DEFAULT NULL COMMENT '文章简介',
  `home_show` BIGINT(2) NOT NULL COMMENT '是否在首页显示',
  PRIMARY KEY (`opinion_id`)
) ENGINE=INNODB AUTO_INCREMENT=100000001 DEFAULT CHARSET=utf8;

/*Table structure for table `picture` */

DROP TABLE IF EXISTS `picture`;

CREATE TABLE `picture` (
  `picture_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '图片id',
  `pertain` VARCHAR(100) NOT NULL COMMENT '属于哪里',
  `real_path` VARCHAR(100) NOT NULL COMMENT '图片实际路径',
  `upload_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上传图片的时间',
  PRIMARY KEY (`picture_id`),
  KEY `idx_upload_time` (`upload_time`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

/*Table structure for table `statistic` */

DROP TABLE IF EXISTS `statistic`;

CREATE TABLE `statistic` (
  `statistic` BIGINT(10) NOT NULL AUTO_INCREMENT COMMENT '数据统计id',
  `comment_num` BIGINT(10) NOT NULL COMMENT '评论数',
  `visitor_num` BIGINT(10) NOT NULL COMMENT '浏览量',
  `praise_num` BIGINT(10) NOT NULL COMMENT '点赞数',
  `pertain` VARCHAR(100) NOT NULL COMMENT '所属',
  PRIMARY KEY (`statistic`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

/*Table structure for table `technical` */

DROP TABLE IF EXISTS `technical`;

CREATE TABLE `technical` (
  `technical_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '技术文章id',
  `title` VARCHAR(200) NOT NULL COMMENT '技术文章标题',
  `content` MEDIUMTEXT NOT NULL COMMENT '技术文章内容',
  `publisher` VARCHAR(100) NOT NULL COMMENT '发布者',
  `technical_sign` VARCHAR(100) NOT NULL COMMENT '技术文章唯一标示',
  `publish_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '发布时间',
  `audit_status` BIGINT(2) NOT NULL COMMENT '审核状态',
  `home_show` BIGINT(2) NOT NULL COMMENT '是否在首页显示',
  `classify` VARCHAR(50) NOT NULL COMMENT '类别',
  `summary` VARCHAR(200) DEFAULT NULL COMMENT '文章简介',
  PRIMARY KEY (`technical_id`)
) ENGINE=INNODB AUTO_INCREMENT=100000001 DEFAULT CHARSET=utf8;

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `user_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '图片id',
  `username` VARCHAR(50) NOT NULL COMMENT '用户名',
  `nikename` VARCHAR(50) NOT NULL COMMENT '昵称',
  `PASSWORD` VARCHAR(100) DEFAULT NULL COMMENT '密码',
  `register_ip` VARCHAR(20) DEFAULT NULL COMMENT '注册时的ip地址',
  `register_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  `user_rank` BIGINT(10) NOT NULL COMMENT '用户权限',
  `user_sign` VARCHAR(100) DEFAULT NULL COMMENT '唯一标示sign',
  `header` VARCHAR(100) DEFAULT NULL COMMENT '用户头像',
  PRIMARY KEY (`user_id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

CREATE TABLE classify (
	`classify_id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
	`classify_name` VARCHAR(200) NOT NULL COMMENT '类别名称',
	PRIMARY KEY (`classify_id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE information (
	information_id BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
	pertain VARCHAR(100) NOT NULL COMMENT '所属',
	NAME VARCHAR(50) NOT NULL COMMENT '真实姓名',
	sex BIGINT(2) NOT NULL COMMENT '性别',
	birthday DATE NOT NULL COMMENT '生日',
	virtue VARCHAR(200) NOT NULL COMMENT '擅长技能',
	proverbs VARCHAR(500) NOT NULL COMMENT '个性签名',
	PRIMARY KEY (information_id)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

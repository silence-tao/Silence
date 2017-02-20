CREATE DATABASE `silence`;

USE `silence`;


DROP TABLE IF EXISTS `history`;

CREATE TABLE `history` (
  `history_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '项目进程id',
  `content` varchar(200) NOT NULL COMMENT '此次进程内容',
  `picture_path` varchar(50) DEFAULT NULL COMMENT '附加图片路径',
  `record_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录时间',
  `title` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`history_id`),
  KEY `idx_record_time` (`record_time`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
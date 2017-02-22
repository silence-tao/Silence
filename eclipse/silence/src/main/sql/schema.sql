CREATE DATABASE silence;

USE silence;

CREATE TABLE history (
  history_id BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '项目进程id',
  title VARCHAR(50) DEFAULT NULL COMMENT '标题',
  content VARCHAR(200) NOT NULL COMMENT '此次进程内容',
  picture_path VARCHAR(100) DEFAULT NULL COMMENT '附加图片路径',
  record_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '记录时间',
  PRIMARY KEY (history_id),
  KEY idx_record_time (record_time)
) ENGINE=INNODB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

CREATE TABLE picture (
	picture_id BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '图片id',
	pertain VARCHAR(100) NOT NULL COMMENT '属于哪里',
	real_path VARCHAR(100) NOT NULL COMMENT '图片实际路径',
	upload_time  TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上传图片的时间',
	PRIMARY KEY (picture_id),
	KEY idx_upload_time (upload_time)
) ENGINE=INNODB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
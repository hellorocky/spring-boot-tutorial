CREATE TABLE `movie` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `director` varchar(11) DEFAULT NULL COMMENT '导演',
  `actor` varchar(128) DEFAULT NULL COMMENT '演员',
  `rate` float DEFAULT NULL COMMENT '豆瓣评分',
  `name` varchar(128) DEFAULT NULL COMMENT '电影名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `activity` (
  `idactivity` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) DEFAULT NULL,
  `result` longtext,
  `datetime` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `result1` bigint(20) DEFAULT NULL,
  `result2` bigint(20) DEFAULT NULL,
  `result3` bigint(20) DEFAULT NULL,
  `strresult1` varchar(256) DEFAULT NULL,
  `strresult2` varchar(256) DEFAULT NULL,
  `strresult3` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`idactivity`)
) ENGINE=InnoDB AUTO_INCREMENT=899 DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(45) COLLATE utf8_bin NOT NULL,
  `login_pwd` varchar(128) COLLATE utf8_bin DEFAULT NULL,
  `nickname` longtext COLLATE utf8_bin,
  `createtime` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `balance` float DEFAULT NULL,
  `usertype` int(11) DEFAULT NULL,
  `openid` varchar(200) COLLATE utf8_bin DEFAULT NULL,
  PRIMARY KEY (`id`,`login_name`),
  UNIQUE KEY `login_name_UNIQUE` (`login_name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;


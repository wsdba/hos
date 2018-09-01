DROP TABLE IF EXISTS t_user ;
CREATE TABLE `t_user` (
  `id` bigint(32) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `the_name` varchar(20) NOT NULL COMMENT '姓名',
  `the_account` varchar(20) NOT NULL COMMENT '账号',
  `the_password` varchar(20) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
CREATE TABLE `user_info` (
  `id` bigint(20) NOT NULL,
  `login_name` varchar(100) NOT NULL DEFAULT '' COMMENT '登录账号',
  `user_name` varchar(100) NOT NULL DEFAULT '' COMMENT '用户名',
  `consultant_sn` bigint(20) NOT NULL DEFAULT '0' COMMENT '顾问sn',
  `is_part_time` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否兼职',
  `password` varchar(100) NOT NULL DEFAULT '' COMMENT '兼职顾问密码',
  `is_del` tinyint(2) NOT NULL DEFAULT '0' COMMENT '是否删除',
  `creator_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '创建人id',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modifier_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '修改人id',
  `modified_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_login_name` (`login_name`) USING BTREE COMMENT '用户名唯一索引'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

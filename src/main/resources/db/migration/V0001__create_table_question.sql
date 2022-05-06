-- 问题表
drop table if exists `question`;
CREATE TABLE `question` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `questioner_id` varchar(64) NOT NULL COMMENT '提问人ID',
  `title` varchar(128) NOT NULL COMMENT '标题',
  `detail` text DEFAULT NULL COMMENT '描述',
  `valid` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效：0(否)/1(是)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='问题表';
-- 问题表
drop table if exists `question`;
CREATE TABLE `question` (
  `id` varchar(64) NOT NULL COMMENT '主键',
  `questioner_id` varchar(64) NOT NULL COMMENT '提问人ID',
  `title` varchar(128) NOT NULL COMMENT '标题',
  `detail` text DEFAULT NULL COMMENT '描述',
  `created_by` varchar(64) DEFAULT NULL COMMENT '创建人',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `modified_by` varchar(64) DEFAULT NULL COMMENT '更新人',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `valid` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效：0(否)/1(是)',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='问题表';
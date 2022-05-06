-- 问题更新记录表
drop table if exists `question_updated_record`;
CREATE TABLE `question_updated_record` (
  `question_id` bigint(20) NOT NULL COMMENT '问题ID',
  `update_type` varchar(64) NOT NULL COMMENT '更新操作类型',
  `updater_id` varchar(64) NOT NULL COMMENT '更新人',
  `updated_at` datetime NOT NULL COMMENT '更新时间',

  `reason` varchar(255) DEFAULT NULL COMMENT '原因',
  `created_title` varchar(128) DEFAULT NULL COMMENT '创建时标题',
  `created_detail` text DEFAULT NULL COMMENT '创建时详情',

  `unedited_title` varchar(128) DEFAULT NULL COMMENT '修改前标题',
  `edited_title` varchar(128) DEFAULT NULL COMMENT '修改后标题',

  `unedited_detail` text DEFAULT NULL COMMENT '修改前详情',
  `edited_detail` text DEFAULT NULL COMMENT '修改后详情',

  `valid` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否有效：0(否)/1(是)',
  KEY `idx_question_id_updated_at` (`question_id`, `updated_at`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='问题更新记录表';
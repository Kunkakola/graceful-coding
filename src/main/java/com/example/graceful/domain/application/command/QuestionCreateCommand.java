package com.example.graceful.domain.application.command;

/**
 * description question 创建 command
 *
 * @author jiangyu-045
 * @date 2022-04-27 14:37
 **/
public record QuestionCreateCommand(
        // 提问人
        String questionerId,
        // 标题
        String title,
        // 详情
        String detail
) {
}

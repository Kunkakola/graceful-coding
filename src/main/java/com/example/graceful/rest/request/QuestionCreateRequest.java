package com.example.graceful.rest.request;

/**
 * description question 创建 request
 *
 * @param questionerId 提问人
 * @param title 标题
 * @param detail 详情
 * @author jiangyu-045
 * @date 2022-04-27 14:37
 **/
public record QuestionCreateRequest(
        // 提问人
        String questionerId,
        // 标题
        String title,
        // 详情
        String detail
) {
}

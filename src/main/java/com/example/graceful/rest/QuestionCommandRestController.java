package com.example.graceful.rest;

import com.example.graceful.domain.application.QuestionApplicationService;
import com.example.graceful.domain.application.command.QuestionCreateCommand;
import com.example.graceful.domain.application.result.QuestionCreateResult;
import com.example.graceful.rest.request.QuestionCreateRequest;
import com.example.graceful.rest.response.QuestionCreateResponse;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * description Question restful 写请求
 *
 * @author jiangyu-045
 * @date 2022-04-27 15:59
 **/
@RestController
@RequestMapping("/question")
public class QuestionCommandRestController {

    private final QuestionApplicationService questionApplicationService;

    public QuestionCommandRestController(QuestionApplicationService questionApplicationService) {
        this.questionApplicationService = questionApplicationService;
    }

    @PostMapping("/create")
    public QuestionCreateResponse createQuestion(@RequestBody QuestionCreateRequest request) {
        QuestionCreateCommand command = new QuestionCreateCommand(request.questionerId(), request.title(), request.detail());
        QuestionCreateResult result = questionApplicationService.createQuestion(command);
        return new QuestionCreateResponse(result.questionId());
    }
}

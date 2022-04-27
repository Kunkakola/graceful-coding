package com.example.graceful.domain.application;

import com.example.graceful.domain.application.command.QuestionCreateCommand;
import com.example.graceful.domain.application.result.QuestionCreateResult;
import com.example.graceful.domain.model.Question;
import com.example.graceful.domain.repository.QuestionRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * description Question domain 对外提供的服务
 *
 * @author jiangyu-045
 * @date 2022-04-27 14:08
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class QuestionApplicationService {

    private final QuestionRepository questionRepository;

    public QuestionApplicationService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public QuestionCreateResult createQuestion(QuestionCreateCommand command) {
        Question question = new Question(command.questionerId(), command.title(), command.detail());
        questionRepository.save(question);
        return new QuestionCreateResult(question.getId());
    }
}

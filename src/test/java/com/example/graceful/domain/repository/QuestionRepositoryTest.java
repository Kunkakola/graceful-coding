package com.example.graceful.domain.repository;

import com.example.graceful.core.JpaRepositoryTest;
import com.example.graceful.domain.model.Question;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * description
 *
 * @author jiangyu-045
 * @date 2022-04-25 13:50
 **/
@JpaRepositoryTest
class QuestionRepositoryTest {

    @Autowired
    private QuestionRepository questionRepository;

    @Test
    void saveShouldSuccess() {
        Question question = new Question("UID_001", "a test title", "a test detail");
        Question savedQuestion = questionRepository.save(question);
        Assertions.assertThat(savedQuestion.getId()).isNotNull();
        Assertions.assertThat(savedQuestion.getQuestionerId()).isEqualTo(question.getQuestionerId());
        Assertions.assertThat(savedQuestion.getTitle()).isEqualTo(question.getTitle());
        Assertions.assertThat(savedQuestion.getDetail()).isEqualTo(question.getDetail());
    }


}

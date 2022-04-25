package com.example.graceful.domain.repository;

import com.example.graceful.domain.model.Question;

import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * description
 * DataJpaTest 注解仅启动 jpa 相关
 * 若不声明 AutoConfigureTestDatabase 注解 replace 属性为 NONE 则 spring 会默认使用自带的 H2 内存数据库替换数据源
 *
 * @author jiangyu-045
 * @date 2022-04-25 13:50
 **/
//@JpaRepositoryTest
class QuestionRepositoryTest {

    @Autowired
    private QuestionRepository questionRepository;

    //@Test
    void save_should_success() {
        Question question = new Question("UID_001", "a test title", "a test detail");
        Question savedQuestion = questionRepository.save(question);
        Assertions.assertThat(savedQuestion.getId()).isNotNull();
        Assertions.assertThat(savedQuestion.getQuestionerId()).isEqualTo(question.getQuestionerId());
        Assertions.assertThat(savedQuestion.getTitle()).isEqualTo(question.getTitle());
        Assertions.assertThat(savedQuestion.getDetail()).isEqualTo(question.getDetail());
    }


}

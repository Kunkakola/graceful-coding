package com.example.graceful.domain.repository;

import javax.persistence.EntityManager;

import com.example.graceful.core.JpaRepositoryTest;
import com.example.graceful.domain.model.entity.Question;

import junit.framework.AssertionFailedError;
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

    @Autowired
    private EntityManager entityManager;

    @Test
    void saveShouldSuccess() {
        Question question = new Question("UID_001", "a test title", "a test detail");
        question.editTitle("UID_002", "for test", "a new test title");
        Question savedQuestion = questionRepository.save(question);
        Assertions.assertThat(savedQuestion.getId()).isNotNull();
        assertSameQuestion(savedQuestion, question);
    }

    @Test
    void findByIdShouldSuccess() {
        Question question = new Question("UID_001", "a test title", "a test detail");
        question.editTitle("UID_002", "for test", "a new test title");
        Question savedQuestion = questionRepository.saveAndFlush(question);

        // 手动 detach 避免命中 JPA 的缓存机制直接返回对象
        entityManager.detach(savedQuestion);

        Question foundQuestion = questionRepository.findById(savedQuestion.getId()).orElseThrow(AssertionFailedError::new);
        assertSameQuestion(foundQuestion, question);
    }

    /**
     * description 断言两个 question 相同
     *
     * @param actualQuestion actualQuestion
     * @param expectQuestion expectQuestion
     * @author jiangyu-045
     * @date 2022/4/29 15:21
     */
    private void assertSameQuestion(Question actualQuestion, Question expectQuestion) {
        Assertions.assertThat(actualQuestion.getQuestionerId()).isEqualTo(expectQuestion.getQuestionerId());
        Assertions.assertThat(actualQuestion.getTitle()).isEqualTo(expectQuestion.getTitle());
        Assertions.assertThat(actualQuestion.getDetail()).isEqualTo(expectQuestion.getDetail());
        // 更新记录的判断
        Assertions.assertThat(actualQuestion.getUpdatedRecordList().size()).isEqualTo(expectQuestion.getUpdatedRecordList().size());
        for (int i = 0; i < actualQuestion.getUpdatedRecordList().size(); i++) {
            // Question 类重写过 equals 方法
            Assertions.assertThat(actualQuestion.getUpdatedRecordList().get(i)).isEqualTo(expectQuestion.getUpdatedRecordList().get(i));
        }
    }


}

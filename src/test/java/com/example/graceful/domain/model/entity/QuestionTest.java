package com.example.graceful.domain.model.entity;

import java.util.List;

import com.example.graceful.domain.model.vo.QuestionUpdatedRecord;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

/**
 * description
 *
 * @author jiangyu-045
 * @date 2022-05-05 15:28
 **/
class QuestionTest {

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateQuestion() {
        Question question = new Question("UID_001", "a test title", "a test detail");
        List<QuestionUpdatedRecord> updatedRecordList = question.getUpdatedRecordList();

        Assertions.assertNotNull(updatedRecordList);
        Assertions.assertEquals(1, updatedRecordList.size());
        QuestionUpdatedRecord questionUpdatedRecord = updatedRecordList.get(0);
        Assertions.assertEquals(QuestionUpdatedRecord.UpdateType.CREATED, questionUpdatedRecord.getUpdateType());
        Assertions.assertEquals(question.getTitle(), questionUpdatedRecord.getCreatedTitle());
        Assertions.assertEquals(question.getDetail(), questionUpdatedRecord.getCreatedDetail());

    }

    @Test
    void testEditQuestion() {
        String testTitle = "a test title";
        String testDetail = "a test detail";
        Question question = new Question("UID_001", testTitle, testDetail);
        String newTestTitle = "a new test title";
        question.editTitle("UID_002", "for test", newTestTitle);
        String newTestDetail = "a new test detail";
        question.editDetail("UID_003", "for test", newTestDetail);

        List<QuestionUpdatedRecord> updatedRecordList = question.getUpdatedRecordList();
        Assertions.assertNotNull(updatedRecordList);
        Assertions.assertEquals(3, updatedRecordList.size());

        QuestionUpdatedRecord questionCreatedRecord = updatedRecordList.get(0);
        Assertions.assertEquals(QuestionUpdatedRecord.UpdateType.CREATED, questionCreatedRecord.getUpdateType());
        Assertions.assertEquals(testTitle, questionCreatedRecord.getCreatedTitle());
        Assertions.assertEquals(testDetail, questionCreatedRecord.getCreatedDetail());

        QuestionUpdatedRecord questionEditTitleRecord = updatedRecordList.get(1);
        Assertions.assertEquals(QuestionUpdatedRecord.UpdateType.TITLE_EDITED, questionEditTitleRecord.getUpdateType());
        Assertions.assertEquals(testTitle, questionEditTitleRecord.getUneditedTitle());
        Assertions.assertEquals(newTestTitle, questionEditTitleRecord.getEditedTitle());

        QuestionUpdatedRecord questionEditDetailRecord = updatedRecordList.get(2);
        Assertions.assertEquals(QuestionUpdatedRecord.UpdateType.DETAIL_EDITED, questionEditDetailRecord.getUpdateType());
        Assertions.assertEquals(testDetail, questionEditDetailRecord.getUneditedDetail());
        Assertions.assertEquals(newTestDetail, questionEditDetailRecord.getEditedDetail());

        Assertions.assertEquals(newTestTitle, question.getTitle());
        Assertions.assertEquals(newTestDetail, question.getDetail());

    }

}

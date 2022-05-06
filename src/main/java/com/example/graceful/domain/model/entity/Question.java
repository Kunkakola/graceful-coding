package com.example.graceful.domain.model.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OrderBy;

import com.example.graceful.domain.model.vo.QuestionUpdatedRecord;

import org.springframework.data.annotation.PersistenceConstructor;

/**
 * description
 *
 * @author jiangyu-045
 * @date 2022-04-25 10:24
 **/
@Entity
public class Question {

    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 提问人
     */
    @Column(name = "questioner_id")
    private String questionerId;

    /**
     * 标题
     */
    private String title;

    /**
     * 详情
     */
    private String detail;

    /**
     * 更新记录
     */
    @ElementCollection
    @CollectionTable(name = "question_updated_record")
    @OrderBy("updatedAt asc")
    private List<QuestionUpdatedRecord> updatedRecordList;

    @PersistenceConstructor
    protected Question() {
    }

    public Question(String questionerId, String title, String detail) {
        this.questionerId = questionerId;
        this.title = title;
        this.detail = detail;
        this.updatedRecordList = new ArrayList<>();
        updatedRecordList.add(QuestionUpdatedRecord.ofCreated(questionerId, title, detail));
    }

    public Long getId() {
        return id;
    }

    public String getQuestionerId() {
        return questionerId;
    }

    public String getTitle() {
        return title;
    }

    public String getDetail() {
        return detail;
    }

    public List<QuestionUpdatedRecord> getUpdatedRecordList() {
        // 返回不可修改的副本
        return Collections.unmodifiableList(updatedRecordList);
    }

    public void editTitle(String updater, String reason, String title) {
        updatedRecordList.add(QuestionUpdatedRecord.ofTitleEdited(updater, reason, this.title, title));
        this.title = title;
    }

    public void editDetail(String updater, String reason, String detail) {
        updatedRecordList.add(QuestionUpdatedRecord.ofDetailEdited(updater, reason, this.detail, detail));
        this.detail = detail;
    }
}

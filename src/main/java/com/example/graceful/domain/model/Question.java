package com.example.graceful.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

    protected Question() {
    }

    public Question(String questionerId, String title, String detail) {
        this.questionerId = questionerId;
        this.title = title;
        this.detail = detail;
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
}

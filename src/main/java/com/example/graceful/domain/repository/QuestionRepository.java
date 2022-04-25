package com.example.graceful.domain.repository;

import com.example.graceful.domain.model.Question;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * description
 *
 * @author jiangyu-045
 * @date 2022-04-25 13:47
 **/
public interface QuestionRepository extends JpaRepository<Question, String> {
}

package com.example.graceful.rest;

import com.example.graceful.domain.application.QuestionApplicationService;
import com.example.graceful.domain.application.result.QuestionCreateResult;

import org.apache.commons.compress.utils.IOUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

/**
 * description
 *
 * @author jiangyu-045
 * @date 2022-04-27 16:12
 **/
@WebMvcTest
class QuestionCommandRestControllerTest {
    @MockBean
    QuestionApplicationService questionApplicationService;
    @InjectMocks
    QuestionCommandRestController questionCommandRestController;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createQuestionShouldSuccess() throws Exception {
        Long questionId = 1L;
        when(questionApplicationService.createQuestion(any())).thenReturn(new QuestionCreateResult(questionId));

        // 读入请求 json
        byte[] requestBody = IOUtils.toByteArray(new ClassPathResource("request/question/create/success.json").getInputStream());

        mockMvc.perform(MockMvcRequestBuilders.post("/question/create")
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.questionId").value(questionId));
    }
}

package com.prosperity.pas.policy.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;

/** JPA entity for policy.form_response (generated from the contract data model ERD). */
@Entity
@Table(schema = "policy", name = "form_response")
public class FormResponse {

    @Id
    @Column(name = "id")
    private UUID id;

    @Column(name = "form_instance_id")
    private UUID formInstanceId;

    @Column(name = "question_number")
    private String questionNumber;

    @Column(name = "question_text")
    private String questionText;

    @Column(name = "question_type")
    private String questionType;

    @Column(name = "response_code")
    private String responseCode;

    @Column(name = "response_text")
    private String responseText;

    @Column(name = "response_data")
    private String responseData;

    public FormResponse() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getFormInstanceId() {
        return formInstanceId;
    }

    public void setFormInstanceId(UUID formInstanceId) {
        this.formInstanceId = formInstanceId;
    }

    public String getQuestionNumber() {
        return questionNumber;
    }

    public void setQuestionNumber(String questionNumber) {
        this.questionNumber = questionNumber;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseText() {
        return responseText;
    }

    public void setResponseText(String responseText) {
        this.responseText = responseText;
    }

    public String getResponseData() {
        return responseData;
    }

    public void setResponseData(String responseData) {
        this.responseData = responseData;
    }

}

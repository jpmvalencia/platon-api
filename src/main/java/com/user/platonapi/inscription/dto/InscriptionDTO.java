package com.user.platonapi.inscription.dto;

public class InscriptionDTO {
    private String student;
    private Integer document;
    private String career;
    private String subject;
    private String semester;
    private String enrollmentDate;
    private String status;

    public InscriptionDTO(String student, Integer document, String career, String subject, String semester, String enrollmentDate, String status) {
        this.student = student;
        this.document = document;
        this.career = career;
        this.subject = subject;
        this.semester = semester;
        this.enrollmentDate = enrollmentDate;
        this.status = status;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public Integer getDocument() {
        return document;
    }

    public void setDocument(Integer document) {
        this.document = document;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(String enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

package com.devincubator.project.hibernate.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "question")
public class Question {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer questionId;
    @Column
    private String description;

    @OneToMany(mappedBy = "question",fetch = FetchType.EAGER)
    private List<Answer> answers;

    @OneToMany(mappedBy = "question",fetch = FetchType.EAGER)
    private List<Literature> literature;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    @JoinColumn(name="testId",nullable = false)
    private Test test;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    @JoinColumn(name="questionId",nullable = false)
    private Statistic statistic;

    public Question() {
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Question that = (Question) o;

        if (questionId != null ? !questionId.equals(that.questionId) : that.questionId != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = questionId != null ? questionId.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", description='" + description + '\'' +
                '}';
    }
}

package com.devincubator.project.hibernate.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
@Table(name = "answer")
public class Answer {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer answerId;
    @Column
    private String description;
    @Column
    private Byte correct;


    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    @JoinColumn(name="questionId",nullable = false,insertable=false, updatable=false)
    private Question question;


    public Answer() {
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Byte getCorrect() {
        return correct;
    }

    public void setCorrect(Byte correct) {
        this.correct = correct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Answer that = (Answer) o;

        if (answerId != null ? !answerId.equals(that.answerId) : that.answerId != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (correct != null ? !correct.equals(that.correct) : that.correct != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = answerId != null ? answerId.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (correct != null ? correct.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Answer{" +
                "answerId=" + answerId +
                ", description='" + description + '\'' +
                ", correct=" + correct +
                '}';
    }
}

package com.devincubator.project.hibernate.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "statistic")
public class Statistic {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer statisticId;
    @Column
    private Date date;
    @Column
    private Byte correct;


    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    @JoinColumn(name="userId",nullable = false)
    private User user;

    @OneToMany(mappedBy = "statistic",fetch = FetchType.EAGER)
    private List<Question> questions;

    public Statistic() {
    }

    public Integer getStatisticId() {
        return statisticId;
    }

    public void setStatisticId(Integer statisticId) {
        this.statisticId = statisticId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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

        Statistic that = (Statistic) o;

        if (statisticId != null ? !statisticId.equals(that.statisticId) : that.statisticId != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (correct != null ? !correct.equals(that.correct) : that.correct != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = statisticId != null ? statisticId.hashCode() : 0;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (correct != null ? correct.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Statistic{" +
                "statisticId=" + statisticId +
                ", date=" + date +
                ", correct=" + correct +
                '}';
    }
}

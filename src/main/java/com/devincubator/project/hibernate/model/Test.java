package com.devincubator.project.hibernate.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "test")
public class Test {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer testId;
    @Column
    private String name;
    @Column
    private String description;

    @OneToMany(mappedBy = "test",fetch = FetchType.EAGER)
    private List<Question> questions;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    @JoinColumn(name="topicId",nullable = false)
    private Topic topic;

    public Test() {
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

        Test that = (Test) o;

        if (testId != null ? !testId.equals(that.testId) : that.testId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = testId != null ? testId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Test{" +
                "testId=" + testId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

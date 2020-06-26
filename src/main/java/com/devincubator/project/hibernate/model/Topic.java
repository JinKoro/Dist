package com.devincubator.project.hibernate.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="topic")
public class Topic {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer topicId;
    @Column
    private String description;
    @Column
    private String name;

    @OneToMany(mappedBy = "topic",fetch = FetchType.EAGER)
    private List<Test> tests;

    public Topic() {
    }

    public Integer getTopicId() {
        return topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Topic that = (Topic) o;

        if (topicId != null ? !topicId.equals(that.topicId) : that.topicId != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = topicId != null ? topicId.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Topic{" +
                "topicId=" + topicId +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

package com.devincubator.project.hibernate.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "literature")
public class Literature {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer literatureId;
    @Column
    private String description;

    @OneToMany(mappedBy = "literature",fetch = FetchType.EAGER)
    private List<Link> links;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    @JoinColumn(name="questionId",nullable = false)
    private Question question;

    public Literature() {
    }

    public Integer getLiteratureId() {
        return literatureId;
    }

    public void setLiteratureId(Integer literatureId) {
        this.literatureId = literatureId;
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

        Literature that = (Literature) o;

        if (literatureId != null ? !literatureId.equals(that.literatureId) : that.literatureId != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = literatureId != null ? literatureId.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Literature{" +
                "literatureId=" + literatureId +
                ", description='" + description + '\'' +
                '}';
    }
}

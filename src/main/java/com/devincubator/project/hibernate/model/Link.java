package com.devincubator.project.hibernate.model;

import javax.persistence.*;

@Entity
@Table(name = "link")
public class Link {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer linkId;

    @Column
    private String link;

    @ManyToOne(fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    @JoinColumn(name="literatureId",nullable = false)
    private Literature literature;

    public Link() {
    }

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link that = (Link) o;

        if (linkId != null ? !linkId.equals(that.linkId) : that.linkId != null) return false;
        if (link != null ? !link.equals(that.link) : that.link != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = linkId != null ? linkId.hashCode() : 0;
        result = 31 * result + (link != null ? link.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Link{" +
                "linkId=" + linkId +
                ", link='" + link + '\'' +
                '}';
    }
}

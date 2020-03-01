package ru.ok.journal.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
public class Comment implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String data;
    private Date time;
    @ManyToOne(fetch = FetchType.EAGER,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "post_comments",
            joinColumns = @JoinColumn(name = "comment_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "post_id", referencedColumnName = "id"))
    private Post post;
    @ManyToOne(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "comment_author",
            joinColumns = @JoinColumn(name = "comment_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"))
    private User author;

}

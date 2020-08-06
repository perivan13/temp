package com.webshop.model;



import com.webshop.model.util.MessageHelper;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String filename;

    @NotBlank(message = "Please fill the message")
    @Length (max= 2048, message = "Message too long (more than 2kB)")
    private String text;
    @Length (max= 255, message = "Tag too long (more than 255B)")
    private String tag;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    @ManyToMany
    @JoinTable(
            name="message_likes",
            joinColumns = { @JoinColumn(name="message_id")},
            inverseJoinColumns = {@JoinColumn(name="user_id")}
    )
    private Set<User> likes = new HashSet<>();

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Message() {
    }

    public Message(String text, String tag, User author) {
        this.text = text;
        this.tag = tag;
        this.author = author;
    }

    public String getAuthorName(){
        return MessageHelper.getAuthorName(author);
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getTag() {
        return tag;
    }

    public Set<User> getLikes() {
        return likes;
    }

    public void setLikes(Set<User> likes) {
        this.likes = likes;
    }
}

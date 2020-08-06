package com.webshop.model.dto;

import com.webshop.model.Message;
import com.webshop.model.User;
import com.webshop.model.util.MessageHelper;

public class MessageDto {
    private Integer id;
    private String filename;
    private String text;
    private String tag;
    private User author;
    private Long likes;
    private boolean meLiked;

    public MessageDto(Message message, Long likes, boolean meLiked) {
        this.id = message.getId();
        this.author = message.getAuthor();
        this.filename = message.getFilename();
        this.text = message.getText();
        this.tag = message.getTag();
        this.likes = likes;
        this.meLiked = meLiked;
    }

    public String getAuthorName(){
        return MessageHelper.getAuthorName(author);
    }


    public Integer getId() {
        return id;
    }

    public String getFilename() {
        return filename;
    }

    public String getText() {
        return text;
    }

    public String getTag() {
        return tag;
    }

    public User getAuthor() {
        return author;
    }

    public Long getLikes() {
        return likes;
    }

    public boolean isMeLiked() {
        return meLiked;
    }

    @Override
    public String toString() {
        return "MessageDto{" +
                "id=" + id +
                "author=" + author +
                ", likes=" + likes +
                ", meLiked=" + meLiked +
                '}';
    }
}

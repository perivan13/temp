package com.webshop.model.util;

import com.webshop.model.User;

public abstract class MessageHelper {
    public static String getAuthorName(User user){
        return user != null ? user.getUsername() : "<none>";
    }
}

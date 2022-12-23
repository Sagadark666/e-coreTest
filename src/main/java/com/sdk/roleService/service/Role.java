package com.sdk.roleService.service;

public class Role {

    private final long id;
    private final String content;

    public Role(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

}

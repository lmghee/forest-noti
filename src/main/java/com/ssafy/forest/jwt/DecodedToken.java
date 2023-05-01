package com.ssafy.forest.jwt;

public class DecodedToken {
    private Long userId;

    public DecodedToken(Long userId) {
        this.userId = userId;
    }

    public Long getId() {
        return userId;
    }

    @Override
    public String toString() {
        return "DecodedToken {" + "userId=" + userId + "}";
    }
}
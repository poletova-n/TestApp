package com.github.oauth2.server.pojo;

public enum Error {

    INVALID_REQUEST(400, "Request is not well-formatted,\n" +
            "syntactically incorrect or violates schema"),
    AUTHENTIFICATION_FAILURE(401, "Authentication failed due to invalid\n" +
            "authentication credentials"),
    UNSUPPORTED_MEDIA_TYPE(415, "The server does not support the request\n" +
            "payload media type"),
    INTERNAL_SERVER_ERROR(500, "An internal server error has occurred");

    private final int code;

    private final String desc;

    private Error(int code, String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}

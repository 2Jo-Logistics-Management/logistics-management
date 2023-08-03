package com.douzon.smartlogistics.domain.member.interceptor;

public class AuthException extends RuntimeException {
    public AuthException(String msg) {
        super(msg);
    }
}


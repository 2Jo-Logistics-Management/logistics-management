//package com.douzon.smartlogistics.domain.member.interceptor;
//
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@RestControllerAdvice
//public class ExceptionAdviceHandler {
//
//    @ResponseStatus(HttpStatus.UNAUTHORIZED)
//    @ExceptionHandler(AuthException.class)
//    public ResponseEntity<String> authException(AuthException e) {
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("인증오류: " + e.getLocalizedMessage());
//    }
//}
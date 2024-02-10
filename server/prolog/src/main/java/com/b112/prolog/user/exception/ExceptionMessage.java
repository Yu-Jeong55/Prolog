package com.b112.prolog.user.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ExceptionMessage {
    USER_NOT_FOUND("User Not Found"),
    NOT_AUTHENTICATED("Not Authenticated"),
    ACCESS_TOKEN_EXPIRED("Access Token Expired"),
    REFRESH_TOKEN_EXPIRED("Refresh Token Expired");

    private final String message;
}

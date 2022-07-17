package com.example.demo.user.jpa;

public class LoginStatus {

    enum Status {
        Success,    //登入成功
        Fail        //登入失敗
    }

    /**
     * 登入成功後驗證的 Token
     */
    private String token;

    /**
     * 登入是否成功
     */
    private Status status;

    /**
     * 登入失敗的原因
     */
    private String errorMessage;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}

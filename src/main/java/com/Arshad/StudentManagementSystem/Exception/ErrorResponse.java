package com.Arshad.StudentManagementSystem.Exception;

import java.time.LocalDateTime;

public class ErrorResponse {
    private LocalDateTime timestamp ;
    private int status ;
    private String message;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public ErrorResponse() {
    }

    public ErrorResponse(LocalDateTime timestamp, String message, int status) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

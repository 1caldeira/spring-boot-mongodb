package com.caldeira.demo.resources.exceptions;

import java.time.Instant;

public class StandardError {
    private Instant timestamp;
    private int value;
    private String error;
    private String path;


    public StandardError() {
    }

    public StandardError(Instant timestamp, int value, String error, String path) {
        this.timestamp = timestamp;
        this.value = value;
        this.error = error;
        this.path = path;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}

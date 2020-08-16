package dev.ldelelis.devoffchallenge.scytale;

public class Scytale {
    private String message;
    private Integer length;

    public Scytale(String message, Integer length) {
        this.message = message;
        this.length = length;
    }

    public String getMessage() {
        return this.message;
    }

    public Integer getLength() {
        return this.length;
    }

    public String toString() {
        // return getClass().getName() + this.message + String.format("(%d)", this.length);
        return String.format("%s: %s (%d)", getClass().getName(), this.message, this.length);
    }
}
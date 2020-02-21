package com.example.movie101.data;

public class users {
    String username;
    String email;
    String genre;

    public users(String username, String email, String genre) {
        this.username = username;
        this.email = email;
        this.genre = genre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}

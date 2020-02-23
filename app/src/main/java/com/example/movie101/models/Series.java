package com.example.movie101.models;

public class Series {
    private String title;
    private String genre;
    private int poster;

    public Series(String title, String genre, int poster) {
        this.title = title;
        this.genre = genre;
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getPoster() {
        return poster;
    }

    public void setPoster(int poster) {
        this.poster = poster;
    }
}

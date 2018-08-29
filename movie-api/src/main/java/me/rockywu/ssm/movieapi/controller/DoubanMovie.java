package me.rockywu.ssm.movieapi.controller;

import java.util.Date;

public class DoubanMovie {
    private int id;
    private String name;
    private String director;
    private Date originRelease;

    public DoubanMovie() {}

    public DoubanMovie(int id, String name, String director, Date originRelease) {
        this.id = id;
        this.name = name;
        this.director = director;
        this.originRelease = originRelease;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public Date getOriginRelease() {
        return originRelease;
    }

    public void setOriginRelease(Date originRelease) {
        this.originRelease = originRelease;
    }



}

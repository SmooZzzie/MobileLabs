package com.example.nicko.shchepetslab1.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Task {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @PrimaryKey(autoGenerate =  true)
    private long id;
    private String level;
    private String type;

    public Task(String level, String type) {
        this.level = level;
        this.type = type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

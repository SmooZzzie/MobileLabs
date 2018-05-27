package com.example.nicko.shchepetslab1.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.nicko.shchepetslab1.models.Task;

import java.util.List;

@Dao
public interface TaskDao {

    @Query("SELECT * FROM Task")
    List<Task> getAll();

    @Insert
    void insert(Task task);
}

package com.example.nicko.shchepetslab1.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.nicko.shchepetslab1.dao.TaskDao;
import com.example.nicko.shchepetslab1.models.Task;

@Database(entities = {Task.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
public abstract TaskDao taskDao();
}

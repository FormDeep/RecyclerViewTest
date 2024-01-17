package com.toporead.recyclerviewtest;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {ItemText.class},version = 1)

public abstract class TodoDatabase extends RoomDatabase{
    public abstract ItemDao itemDao();
}

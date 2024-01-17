package com.toporead.recyclerviewtest;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;

@Dao
public interface ItemDao {
    @Insert
    long InsertItemText(ItemText itemText);
    @Delete
    void DeleteItemText(ItemText itemText);
}

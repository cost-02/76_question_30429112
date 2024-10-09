package main.java.prova76;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface MyDao {
    @Insert
    void insertAll(MyEntity... entities);

    @Query("SELECT * FROM myentity")
    List<MyEntity> getAll();
}
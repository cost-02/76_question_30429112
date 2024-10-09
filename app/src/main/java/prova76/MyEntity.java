package main.java.prova76;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MyEntity {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String data;
}



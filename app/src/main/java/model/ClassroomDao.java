package model;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import objects.Classroom;

@Dao
public interface ClassroomDao {
    @Insert
    void insert(Classroom classroom);

    @Insert
    void insertAll(List<Classroom> classroom);

    @Query("DELETE FROM classroom")
    void deleteAll();

    @Query("SELECT * from classroom ORDER BY idClassroom ASC")
    LiveData<List<Classroom>> getAllClassrooms();
}

package model;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import objects.Player;

@Dao
public interface PlayerDao {
    @Insert
    void insert(Player players);

    @Query("DELETE FROM players")
    void deleteAll();

    @Query("SELECT * from players ORDER BY id ASC")
    LiveData<List<Player>> getAllPlayers();
}

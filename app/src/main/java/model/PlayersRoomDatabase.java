package model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import objects.Player;

@Database(entities = {Player.class}, version = 1)
public abstract class PlayersRoomDatabase extends RoomDatabase {
    public abstract PlayerDao playerDao();
    private static PlayersRoomDatabase INSTANCE;

    public static PlayersRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (PlayersRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            PlayersRoomDatabase.class, "players")
                            .fallbackToDestructiveMigration()
                            .build();

                }
            }
        }
        return INSTANCE;
    }
}

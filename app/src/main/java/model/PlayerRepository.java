package model;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import objects.Player;

public class PlayerRepository {
    private PlayerDao mPlayerDao;
    private LiveData<List<Player>> mAllPlayers;

    PlayerRepository(Application application) {
        PlayersRoomDatabase db = PlayersRoomDatabase.getDatabase(application);
        mPlayerDao = db.playerDao();
        mAllPlayers = mPlayerDao.getAllPlayers();
    }

    LiveData<List<Player>> getmAllPlayers() {
        return getmAllPlayers();
    }

    public void insert(Player player) {
        new insertAsyncTask(mPlayerDao).execute(player);

    }

        private static class insertAsyncTask extends AsyncTask<Player, Void, Void> {

            private PlayerDao mAsyncTaskDao;

            insertAsyncTask(PlayerDao dao) {
                mAsyncTaskDao = dao;
            }

            @Override
            protected Void doInBackground(final Player... players) {
                mAsyncTaskDao.insert(players[0]);
                return null;
            }
        }
}


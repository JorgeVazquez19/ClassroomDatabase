package model;


import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import objects.Classroom;



@Database(entities = {Classroom.class}, version = 1)
public abstract class ClassroomRoomDatabase extends RoomDatabase{
    public abstract ClassroomDao classroomDao();
    private static ClassroomRoomDatabase INSTANCE;

    public static ClassroomRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ClassroomRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                             ClassroomRoomDatabase.class, "classroom")
                            .fallbackToDestructiveMigration()
                            .addCallback(new Callback() {
                                @Override
                                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                                    super.onOpen(db);
                                    new classroomAsyncTask(INSTANCE).execute();

                                }
                            })
                            .build();

                }
            }
        }
        return INSTANCE;

    }
    private static class classroomAsyncTask extends AsyncTask<Void, Void, Void> {

        private ClassroomDao mAsyncTaskDao;

        classroomAsyncTask(ClassroomRoomDatabase dao) {
            mAsyncTaskDao = INSTANCE.classroomDao();
        }

        protected Void doInBackground(Void... voids) {
            List<Classroom> data = new ArrayList<>();
            Classroom firstClassroom = new Classroom(1,"DAMP",24,"Pepe",5);
            data.add(firstClassroom);
            Classroom secondClassroom = new Classroom(2,"DAMP",30,"Luis",1);
            data.add(secondClassroom);
            Classroom thirdClassroom = new Classroom(3,"DAMP",15,"Carlos",3);
            data.add(thirdClassroom);
            Classroom forthClassroom = new Classroom(4,"DAMP",20,"Juanma",8);
            data.add(forthClassroom);
            Classroom fithClassroom = new Classroom(5,"DAMP",23,"Robertp",19);
            data.add(fithClassroom);
            mAsyncTaskDao.deleteAll();
            mAsyncTaskDao.insertAll(data);
            return null;
        }
    }
}

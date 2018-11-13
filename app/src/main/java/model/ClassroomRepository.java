package model;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import objects.Classroom;

public class ClassroomRepository {
    private ClassroomDao mClassroomDao;
    private LiveData<List<Classroom>> mAllClassrooms;

    public ClassroomRepository(Application application) {
        ClassroomRoomDatabase db = ClassroomRoomDatabase.getDatabase(application);
        mClassroomDao = db.classroomDao();
        mAllClassrooms = (LiveData<List<Classroom>>) mClassroomDao.getAllClassrooms();
    }

    LiveData<List<Classroom>> getmAllClassrooms() {
        return getmAllClassrooms();
    }

    public void insert(Classroom classroom) {
        new ClassroomRepository.insertAsyncTask(mClassroomDao).execute(classroom);

    }

    private static class insertAsyncTask extends AsyncTask<Classroom, Void, Void> {

        private ClassroomDao mAsyncTaskDao;

        insertAsyncTask(ClassroomDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Classroom... classrooms) {
            mAsyncTaskDao.insert(classrooms[0]);
            return null;
        }
    }
}

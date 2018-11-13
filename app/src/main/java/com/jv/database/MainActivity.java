package com.jv.database;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

import model.ClassroomRoomDatabase;
import objects.Classroom;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ClassroomRoomDatabase.getDatabase(this).classroomDao().getAllClassrooms().observe(this, new Observer<List<Classroom>>() {
            @Override
            public void onChanged(@Nullable List<Classroom> classrooms) {
                if(classrooms != null){
                    Log.v("LISTA", classrooms.size()+"");
                }else{
                    Log.v("EmptyList", "No hay datos");
                }
            }
        });
    }
}

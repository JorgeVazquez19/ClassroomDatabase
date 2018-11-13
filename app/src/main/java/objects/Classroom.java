package objects;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "classroom")

public class Classroom {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "idClassroom")
    private int idClassroom;
    @NonNull
    @ColumnInfo(name = "classroomName")
    private String classroomName;
    @NonNull
    @ColumnInfo(name = "studentNumber")
    private int studentNumber;
    @NonNull
    @ColumnInfo(name = "tutor")
    private String tutor;
    @NonNull
    @ColumnInfo(name = "classNumber")
    private int classNumber;

    public Classroom(@NonNull int idClassroom, String classroomName, int studentNumber, String tutor, int classNumber) {this.idClassroom = 0; this.classroomName = classroomName; this.studentNumber = studentNumber; this.tutor = tutor; this.classNumber = classNumber;}
    public String getClassroomName(){
        return this.classroomName;
    }
    public int getIdClassroom() {
        return this.idClassroom;
    }
    public int getStudentNumber() {
        return this.studentNumber;
    }
    public String getTutor() {
        return this.tutor;
    }
    public int getClassNumber() {
        return this.classNumber;
    }
}

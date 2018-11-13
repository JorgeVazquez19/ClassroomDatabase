package objects;

import android.support.annotation.NonNull;
import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "players")

public class Player {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private int id;
    @NonNull
    @ColumnInfo(name = "name")
    private String name;
    @NonNull
    @ColumnInfo(name = "country")
    private String country;
    @NonNull
    @ColumnInfo(name = "team")
    private String team;

    public Player(@NonNull int id, String name, String country, String team) {this.id = 0; this.name = name; this.country = country; this.team = team;}
    public String getName(){
        return this.name;
    }
    public int getId() {
        return this.id;
    }
    public String getCountry() {
        return this.country;
    }
    public String getTeam() {
        return this.team;
    }
}

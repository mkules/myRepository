package hr.tvz.android.kazedocsmusicquiz.Songs;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface SongDao {
    @Query("SELECT * FROM song WHERE year=:year")
    List<Song> getAllByYear(int year);


    @Query("SELECT * FROM song WHERE name LIKE :name LIMIT 1")
    Song findByName(String name);



    @Query("SELECT name FROM song")
    List<String> getAllNames();



    @Insert
    void insertAll(Song... songs);


}

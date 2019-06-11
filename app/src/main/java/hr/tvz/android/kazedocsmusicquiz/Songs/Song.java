package hr.tvz.android.kazedocsmusicquiz.Songs;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Song {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "artist")
    public String artist;

    @ColumnInfo(name = "year")
    public int year;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSongLink() {
        return songLink;
    }

    public void setSongLink(String songLink) {
        this.songLink = songLink;
    }

    @ColumnInfo(name = "song_link")
    public String songLink;

    public Song(String name, String artist, int year, String songLink) {
        this.name = name;
        this.artist = artist;
        this.year = year;
        this.songLink = songLink;
    }

    public static Song[] populateData() {
        return new Song[] {
                new Song("Dream On", "Aerosmith", 1970 , "https://vocaroo.com/media_command.php?media=s1U3ZWgDpyJD&command=download_mp3"),
                new Song("War", "Edwin Starr", 1970 , "https://vocaroo.com/media_command.php?media=s13FXGwUIfuN&command=download_mp3"),
                new Song("All Right Now", "Free", 1970 , "https://vocaroo.com/media_command.php?media=s1rm9EtS37Tb&command=download_mp3"),
                new Song("Sex Machine", "James Brown", 1970 , "https://vocaroo.com/media_command.php?media=s08yBzCVU06V&command=download_mp3"),
                new Song("Stairway To Heaven", "Led Zeppelin", 1970 , "https://vocaroo.com/media_command.php?media=s1ApG3eX39ou&command=download_mp3"),
                new Song("Killer Queen", "Queen", 1970 , "https://vocaroo.com/media_command.php?media=s1otky6aGA27&command=download_mp3"),
                new Song("YMCA", "Village People", 1970 , "https://vocaroo.com/media_command.php?media=s1vOlIyPNUto&command=download_mp3"),
                new Song("Mamma Mia", "Abba", 1970 , "https://vocaroo.com/media_command.php?media=s1LVOQTyfjXZ&command=download_mp3"),
                new Song("Take A Chance On Me", "Abba", 1970 , "https://vocaroo.com/media_command.php?media=s1r3Ji3KsRnm&command=download_mp3"),
                new Song("Voulez-Vous", "Abba", 1970 , "https://vocaroo.com/media_command.php?media=s0vjkUrep9ae&command=download_mp3"),
                new Song("A horse with no name", "America", 1970 , "https://vocaroo.com/media_command.php?media=s1zJBsBzKxuI&command=download_mp3"),
                new Song("Stayin Alive", "Bee Gees", 1970 , "https://vocaroo.com/media_command.php?media=s0nIRjGiraev&command=download_mp3"),
                new Song("Gotta Go Home", "Boney M", 1970 , "https://vocaroo.com/media_command.php?media=s072wTpoJfSe&command=download_mp3"),
                new Song("Stumblin In", "Chris Norman ", 1970 , "https://vocaroo.com/media_command.php?media=s1jaOvIxVQQx&command=download_mp3"),
                new Song("Smoke On The Water", "Deep Purple ", 1970 , "https://vocaroo.com/media_command.php?media=s1i6rsG8uaL1&command=download_mp3"),
                new Song("Boogie Wonderland", "Earth Wind & Fire", 1970 , "https://vocaroo.com/media_command.php?media=s0wurjHmPdi1&command=download_mp3"),
                new Song("Dont Go Breaking My Heart", "Elton John ", 1970 , "https://vocaroo.com/media_command.php?media=s1SkT33SIKpb&command=download_mp3"),
                new Song("I Will Survive", "Gloria Gaynor", 1970 , "https://vocaroo.com/media_command.php?media=s1qupEbByfAk&command=download_mp3"),
                new Song("Don’t Stop Til You Get Enough", "Michael Jackson ", 1970 , "https://vocaroo.com/media_command.php?media=s0ysy93c4KQN&command=download_mp3"),
                new Song("In The Summertime", "Mungo Jerry", 1970 , "https://vocaroo.com/media_command.php?media=s119vj67pqvi&command=download_mp3"),
                new Song("Born to Be Alive", "Patrick Hernandez", 1970 , "https://vocaroo.com/media_command.php?media=s1fxpcNhbQMh&command=download_mp3"),
                new Song("Hold The Line", "Toto ", 1970 , "https://vocaroo.com/media_command.php?media=s1mLx40dAH0V&command=download_mp3"),


                new Song("You Shook Me All Night Long", "AC/DC", 1980 , "https://vocaroo.com/media_command.php?media=s1kOsGpGa6MN&command=download_mp3"),
                new Song("Take On Me", "A-ha", 1980 , "https://vocaroo.com/media_command.php?media=s1YXThQ02u1B&command=download_mp3"),
                new Song("Cars", "Gary Numan", 1980 , "https://vocaroo.com/media_command.php?media=s0JLEBPDwD75&command=download_mp3"),
                new Song("Funky Town", "Lipps Inc", 1980 , "https://vocaroo.com/media_command.php?media=s1hUs8p9y41O&command=download_mp3"),
                new Song("In The Air Tonight", "Phil Collins", 1980 , "https://vocaroo.com/media_command.php?media=s03csiRmr1ry&command=download_mp3"),
                new Song("Livin On A Prayer", "Bon Jovi", 1980 , "https://vocaroo.com/media_command.php?media=s0Q5xU8zheOi&command=download_mp3"),
                new Song("Girls Just Want To Have Fun", "Cyndi Lauper", 1980 , "https://vocaroo.com/media_command.php?media=s01Z01Spn0SG&command=download_mp3"),
                new Song("Time After Time", "Cyndi Lauper", 1980 , "https://vocaroo.com/media_command.php?media=s0ltDMsfBg5C&command=download_mp3"),
                new Song("The Final Countdown", "Europe", 1980 , "https://vocaroo.com/media_command.php?media=s1VWoRpZH2hp&command=download_mp3"),
                new Song("Careless Whisper", "George Michael", 1980 , "https://vocaroo.com/media_command.php?media=s13ST1A3ZsJ3&command=download_mp3"),
                new Song("Another Day In Paradise", "Phil Collins", 1980 , "https://vocaroo.com/media_command.php?media=s0tGGXkwY7eh&command=download_mp3"),
                new Song("Eye Of The Tiger", "Survivor ", 1980 , "https://vocaroo.com/media_command.php?media=s06sIKlno62K&command=download_mp3"),
                new Song(" Every Breath You Take", "The Police", 1980 , "https://vocaroo.com/media_command.php?media=s03pRoCTD8Oz&command=download_mp3"),
                new Song("Africa", "Toto", 1980 , "https://vocaroo.com/media_command.php?media=s1ubr9HVBJJN&command=download_mp3"),
                new Song("Wake Me Up Before You Go-Go", "Wham!", 1980 , "https://vocaroo.com/media_command.php?media=s0akC6VCzPXf&command=download_mp3"),



                new Song("Gangsta Paradise", "Coolio", 1990 , "https://vocaroo.com/media_command.php?media=s1mcRd0zE6cz&command=download_mp3"),
                new Song("Blue", "Eiffel 65", 1990 , "https://vocaroo.com/media_command.php?media=s0siu6QQjr1e&command=download_mp3"),
                new Song("Tears In Heaven", "Eric Clapton", 1990 , "https://vocaroo.com/media_command.php?media=s09yI8M3pb12&command=download_mp3"),
                new Song("Under The Bridge", "Red Hot Chili Peppers", 1990 , "https://vocaroo.com/media_command.php?media=s1fGDCYwowmj&command=download_mp3"),
                new Song("Losing My Religion", "R.E.M", 1990 , "https://vocaroo.com/media_command.php?media=s0u3MvLCJLlh&command=download_mp3"),
                new Song("Smooth", "Santana", 1990 , "https://vocaroo.com/media_command.php?media=s1cHhzgSzANq&command=download_mp3"),

                new Song("Take me out", "Franz Ferdinand", 2000 , "https://vocaroo.com/media_command.php?media=s1uPUYP4CdjT&command=download_mp3"),
                new Song("All Good Things", "Nelly Furtado", 2000 , "https://vocaroo.com/media_command.php?media=s0wOKcX69bQk&command=download_mp3"),
                new Song("By The Way", "Red Hot Chili Peppers", 2000 , "https://vocaroo.com/media_command.php?media=s1ojXr6m6Pv4&command=download_mp3"),
                new Song("You're Gonna Go Far Kid", "The Offspring", 2000 , "https://vocaroo.com/media_command.php?media=s0MOD5Jlzd6C&command=download_mp3"),
                new Song("Hips Don't Lie", "Shakira", 2000 , "https://vocaroo.com/media_command.php?media=s1N6UN5aHT1r&command=download_mp3"),

                new Song("Cups", "Anna Kendrick", 2010 , "https://vocaroo.com/media_command.php?media=s0FjTskEOxn6&command=download_mp3"),
                new Song("Party Rock Anthem", "LMFAO", 2010 , "https://vocaroo.com/media_command.php?media=s0F6I9T7hRdU&command=download_mp3"),
                new Song("Can't Hold Us", "Macklemore", 2010 , "https://vocaroo.com/media_command.php?media=s1dKAcB2Q86j&command=download_mp3"),
                new Song("Counting Stars", "One Republic", 2010 , "https://vocaroo.com/media_command.php?media=s1GzgySN3o81&command=download_mp3"),
                new Song("Moves Like Jagger", "Maroon 5", 2010 , "https://vocaroo.com/media_command.php?media=s0z0T6FKu7Dq&command=download_mp3"),


        };
    }
}

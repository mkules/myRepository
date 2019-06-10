package hr.tvz.android.kazedocsmusicquiz.Game.View;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;

import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import hr.tvz.android.kazedocsmusicquiz.Bonus.BonusRoundActivity;
import hr.tvz.android.kazedocsmusicquiz.Category.View.MainActivity;
import hr.tvz.android.kazedocsmusicquiz.Points;
import hr.tvz.android.kazedocsmusicquiz.R;
import hr.tvz.android.kazedocsmusicquiz.Songs.AppDatabase;
import hr.tvz.android.kazedocsmusicquiz.Songs.Song;

public class GameActivity extends AppCompatActivity implements MediaPlayer.OnPreparedListener, MediaPlayer.OnErrorListener, View.OnClickListener, GameView {
    private TextView timer;
    private List<Button> buttonList=new ArrayList<>();
    private int correct_answer_possition=4;
    private int category_year;
    private AppDatabase baza;
    private List<Song> listaPjesama;
    private Song song;
    private List<String> listaNazivaPjesama;
    private Random rand=new Random();
    private MediaPlayer mp;
    private CountDownTimer countDownTimer;
    private static final int[] BUTTON_IDS = {
            R.id.button1,
            R.id.button2,
            R.id.button3,
            R.id.button4
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);
        if(Points.getInstance().getRepeat()==0)
        {
            Points.getInstance().setBodovi(0);
            Points.getInstance().setTitle("Bodovi: 0");
        }
        setTitle(Points.getInstance().getTitle());
        category_year=getIntent().getIntExtra("year", 0);
        mp=new MediaPlayer();
        mp.setAudioAttributes(new AudioAttributes.Builder().setLegacyStreamType(AudioManager.STREAM_MUSIC).build());
        baza=Room.databaseBuilder(this,AppDatabase.class,"songs").allowMainThreadQueries().build();
        if(baza.songDao().getAllByYear(1970).get(0)==null)baza.songDao().insertAll();
        timer = findViewById(R.id.timer);
        listaPjesama=baza.songDao().getAllByYear(category_year);
        listaNazivaPjesama=baza.songDao().getAllNames();
        Collections.shuffle(listaNazivaPjesama);
        song=randomSong(listaPjesama, rand.nextInt(listaPjesama.size()));
        correct_answer_possition=rand.nextInt(4);
        buttonList=setButtons();

        playSong();
        countDownTimer=startTimer();




    }

    private Song randomSong(List<Song> listaPjesama, int id) {

    if (!Points.getInstance().getRandomId().contains(id))
    {
        Points.getInstance().setRandomId(id);
        return listaPjesama.get(id);
    }
        else if(id!=0)
    return randomSong(listaPjesama,id-1);
        else return randomSong(listaPjesama, listaPjesama.size()-1);


    }


    public List<Button> setButtons() {
        List<Button> buttons = new ArrayList<>();
        for(int i=0; i< BUTTON_IDS.length; i++) {
            Button button = findViewById(BUTTON_IDS[i]);
            if(i==correct_answer_possition) button.setText(song.getName());
            else if (listaNazivaPjesama.get(i).equals(song.getName())) button.setText(listaNazivaPjesama.get(i+3));
                else button.setText(listaNazivaPjesama.get(i));
            button.setOnClickListener(this);
            buttons.add(button);
        }
        return buttons;
    }

    @Override
    public void onClick(View v) {
        int id=4;
        for (Button button:buttonList) {
            button.setEnabled(false);
        }
        countDownTimer.cancel();
        switch (v.getId())
        {

            case R.id.button1:
            id=0;
                break;

            case R.id.button2:
            id=1;
                break;

            case R.id.button3:
            id=2;
                break;

            case R.id.button4:
            id=3;
                break;

            default:
                break;
        }
        if (id==correct_answer_possition) awardPoints(true);
            else awardPoints(false);


    }

    @Override
    public void playSong() {

        try {
            mp.setDataSource(song.getSongLink());
        } catch (IOException e) {
            Log.e("Online player", e.getMessage(), e);

        }

        if(mp.isPlaying()) { // ako je inicijaliziran, vjerojatno nešto svira.
            mp.stop();
        }
        else {
            mp.setOnPreparedListener(this);
            mp.prepareAsync(); // zapocni bufferanje u novoj dretvi
        }
    }

    @Override
    public CountDownTimer startTimer() {


       return new CountDownTimer(15000, 1000) {
            int vrijeme = 15;
            public void onTick(long millisUntilFinished) {
                timer.setText(String.valueOf(vrijeme));
                vrijeme--;
            }

            public void onFinish() {
                timer.setText("0");
                awardPoints(false);
            }
        }.start();

    }



    @Override
    public void awardPoints(boolean flag) {

        int bodovi =Points.getInstance().getBodovi();
        int noviBodovi=0;
        if(flag) noviBodovi=Integer.parseInt((String) timer.getText())*Points.getInstance().getKoef();
            else noviBodovi=Integer.parseInt((String) timer.getText())*(-1)*(Points.getInstance().getKoef()-1);
        Points.getInstance().setBodovi(bodovi+noviBodovi);
        bodovi =Points.getInstance().getBodovi();
        Points.getInstance().setTitle("Bodovi: " + bodovi);
        mp.stop();
        buttonList.get(correct_answer_possition).setBackgroundDrawable(getDrawable(R.drawable.correct_button));
        int repeat=Points.getInstance().getRepeat();

        Intent intent;
       if(flag)
        {
            intent = new Intent(this, BonusRoundActivity.class);

            intent.putExtra("year", category_year);
            intent.putExtra("artist", listaPjesama.get(0).getArtist());
            startActivity(intent);
            finish();
        }
        else {

            if (repeat < 4) {
                intent = new Intent(this, GameActivity.class);

                intent.putExtra("year", category_year);
                Points.getInstance().setRepeat(repeat + 1);
            } else {
                intent = new Intent(this, MainActivity.class);
                Points.getInstance().setRepeat(0);

            }
            startActivity(intent);
            finish();
       }
    }

    @Override
    public boolean onError(MediaPlayer mp, int what, int extra) {
        mp.reset();
        Log.e("Online player", "Što: " + what + " ekstra: " + extra);
        return false;
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
    }

    @Override
    public void onBackPressed() {
        if(mp != null)
            if(mp.isPlaying()) {
                mp.stop();
                mp.release();
            }
        super.onBackPressed();
    }
}

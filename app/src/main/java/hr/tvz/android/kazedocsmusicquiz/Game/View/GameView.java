package hr.tvz.android.kazedocsmusicquiz.Game.View;

import android.os.CountDownTimer;

public interface GameView {
    void playSong();
    CountDownTimer startTimer();
    void awardPoints(boolean flag);
}

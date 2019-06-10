package hr.tvz.android.kazedocsmusicquiz.Category.View;

import android.widget.Button;

import java.util.List;

public interface MainView {
    List<Button> setButtons();
    void startGame(int id);
}

package hr.tvz.android.kazedocsmusicquiz.Category.Model;

import android.widget.Button;

import java.util.List;

public interface FindButtonsInteractor {
    interface OnFinishedListener {
        void onFinished(List<Button> buttons);
    }

    void findButtons(OnFinishedListener listener);
}

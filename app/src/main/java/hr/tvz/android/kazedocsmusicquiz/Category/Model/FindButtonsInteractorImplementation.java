package hr.tvz.android.kazedocsmusicquiz.Category.Model;

import android.app.Activity;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class FindButtonsInteractorImplementation implements FindButtonsInteractor {
    @Override
    public void findButtons(final OnFinishedListener listener) {
        listener.onFinished(createButtonList());
    }

    private List<Button> createButtonList()
    {
        List<Button> buttonList = new ArrayList<>();
        return buttonList;
    }


}

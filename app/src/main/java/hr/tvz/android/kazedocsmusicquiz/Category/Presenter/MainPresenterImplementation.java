package hr.tvz.android.kazedocsmusicquiz.Category.Presenter;


import hr.tvz.android.kazedocsmusicquiz.Category.Model.FindButtonsInteractor;
import hr.tvz.android.kazedocsmusicquiz.Category.Model.FindButtonsInteractorImplementation;
import hr.tvz.android.kazedocsmusicquiz.Category.View.MainView;

public class MainPresenterImplementation implements MainPresenter {



    private MainView mainView;
    private FindButtonsInteractor findButtonsInteractor;

    public MainPresenterImplementation(MainView mainView) {
        this.mainView = mainView;
        findButtonsInteractor = new FindButtonsInteractorImplementation();
    }



    @Override
    public void onButtonClicked(int id) {
        mainView.startGame(id);
    }

    @Override
    public void onDestroy() {
    this.mainView=null;
    }
}

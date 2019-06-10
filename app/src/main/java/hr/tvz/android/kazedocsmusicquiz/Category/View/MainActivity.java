package hr.tvz.android.kazedocsmusicquiz.Category.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import hr.tvz.android.kazedocsmusicquiz.Category.Presenter.MainPresenter;
import hr.tvz.android.kazedocsmusicquiz.Category.Presenter.MainPresenterImplementation;
import hr.tvz.android.kazedocsmusicquiz.Game.View.GameActivity;
import hr.tvz.android.kazedocsmusicquiz.Points;
import hr.tvz.android.kazedocsmusicquiz.R;



public class MainActivity extends AppCompatActivity implements MainView, View.OnClickListener {
    private List<Button> buttonList;
    private MainPresenter presenter;

    private static final int[] BUTTON_IDS = {
        R.id.button70s,
        R.id.button80s,
        R.id.button90s,
        R.id.button00s,
        R.id.button10s

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle(Points.getInstance().getTitle());
        buttonList=new ArrayList<>();
        buttonList=setButtons();

        presenter=new MainPresenterImplementation(this);



    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId())
        {

            case R.id.button70s:
                presenter.onButtonClicked(0);
                break;

            case R.id.button80s:
                if(Points.getInstance().getBodovi()<35)
                {
                    Toast.makeText(this, "Premalo bodova za ovaj level.", Toast.LENGTH_LONG).show();
                }
                else
                {
                    presenter.onButtonClicked(1);
                }
                break;

            case R.id.button90s:
                if(Points.getInstance().getBodovi()<70)
                {
                    Toast.makeText(this, "Premalo bodova za ovaj level.", Toast.LENGTH_LONG).show();
                }
                else {
                    presenter.onButtonClicked(2);
                }
                break;

            case R.id.button00s:
                if(Points.getInstance().getBodovi()<105)
                {
                    Toast.makeText(this, "Premalo bodova za ovaj level.", Toast.LENGTH_LONG).show();
                }
                else {
                    presenter.onButtonClicked(3);
                }
                break;

            case R.id.button10s:
                if(Points.getInstance().getBodovi()<140)
                {
                    Toast.makeText(this, "Premalo bodova za ovaj level.", Toast.LENGTH_LONG).show();
                }
                else {
                    presenter.onButtonClicked(4);
                }
                break;

            default:
                break;
        }


    }


    public List<Button> setButtons() {
    List<Button> buttons = new ArrayList<>();
        for(int id : BUTTON_IDS) {
            Button button = findViewById(id);
            button.setOnClickListener(this);
            if(Points.getInstance().getBodovi()<35*buttons.size())
            if(id!= R.id.button70s)button.setBackgroundDrawable(getDrawable(R.drawable.locked_button));
            buttons.add(button);

        }
    return buttons;
    }

    @Override
    public void startGame(int id) {
        Points.getInstance().setKoef(id+1);
        Points.getInstance().emptyRandomId();
        Intent intent = new Intent(this, GameActivity.class);
        intent.putExtra("year", Integer.parseInt(((String) buttonList.get(id).getText()).replace("s", "")));
        startActivity(intent);

    }


}

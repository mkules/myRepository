package hr.tvz.android.kazedocsmusicquiz.Bonus;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import hr.tvz.android.kazedocsmusicquiz.Category.View.MainActivity;
import hr.tvz.android.kazedocsmusicquiz.Game.View.GameActivity;
import hr.tvz.android.kazedocsmusicquiz.Points;
import hr.tvz.android.kazedocsmusicquiz.R;

public class BonusRoundActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText editText;
    private Button button;
    private String artist;
    private int category_year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.bonus_activity);
        setTitle(Points.getInstance().getTitle());
        button=findViewById(R.id.gumb);
        button.setOnClickListener(this);
        category_year = getIntent().getIntExtra("year", 0);
        artist = getIntent().getStringExtra("artist");
        artist = artist.replaceAll("[^a-zA-Z]", "");
        editText = findViewById(R.id.unos);



    }

    @Override
    public void onClick(View v) {
        if (editText.getText().toString().matches(""))
            Toast.makeText(this, "Unesi nekog izvođača", Toast.LENGTH_SHORT).show();
        else {
            String unos = String.valueOf(editText.getText());
            unos = unos.replaceAll("[^a-zA-Z]", "");
            artist = artist.toUpperCase();
            unos = unos.toUpperCase();
            boolean flag = false;

            if (artist.equals(unos)) flag = true;

            if (flag) {
                Toast.makeText(this, "CORRECT", Toast.LENGTH_SHORT).show();

                int bodovi = Points.getInstance().getBodovi();
                int noviBodovi = 0;

                noviBodovi = 3 * Points.getInstance().getKoef();

                Points.getInstance().setBodovi(bodovi + noviBodovi);
                bodovi = Points.getInstance().getBodovi();
                Points.getInstance().setTitle("Bodovi: " + bodovi);
            }
            else   Toast.makeText(this, "WRONG", Toast.LENGTH_SHORT).show();
            
            int repeat = Points.getInstance().getRepeat();

            Intent intent;
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
}

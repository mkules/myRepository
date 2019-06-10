package hr.tvz.android.kazedocsmusicquiz;

import java.util.ArrayList;
import java.util.List;

public class Points {
    private static Points instance;

    public static Points getInstance() {
        if (instance == null)
            instance = new Points();
        return instance;
    }

    private Points() {
    }

    private int bodovi = 0;
    private int repeat = 0;
    private int koef = 0;

    public int getKoef() {
        return koef;
    }

    public void setKoef(int koef) {
        this.koef = koef;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String title = "Bodovi: 0";

    private List<Integer> randomId = new ArrayList<>();

    public int getRepeat() {
        return repeat;
    }

    public void setRepeat(int repeat) {
        this.repeat = repeat;
    }

    public int getBodovi() {
        return bodovi;
    }

    public void setBodovi(int bodovi) {
        this.bodovi = bodovi;
    }

    public List<Integer> getRandomId() {
        return randomId;
    }
    public void emptyRandomId()
    {
        this.randomId=new ArrayList<>();
    }

    public void setRandomId(Integer randomId) {
        this.randomId.add(randomId);
    }
}

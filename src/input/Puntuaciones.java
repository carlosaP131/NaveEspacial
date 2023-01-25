package input;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Puntuaciones {

    private String date;
    private int score;

    public Puntuaciones(int score) {
        this.score = score;

        Date today = new Date(System.currentTimeMillis());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        date = format.format(today);

    }

    public Puntuaciones() {

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}

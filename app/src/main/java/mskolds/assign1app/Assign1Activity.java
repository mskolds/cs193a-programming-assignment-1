package mskolds.assign1app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


/* Max Skolds <mskolds@stanford.edu>
 * Rock, Paper, Scissors Game -- This app recreates the game using buttons and pictures
 * The computer randomly picks one of the three options, and once the user chooses his/her option
 * the two picks are compared and the user's score is then added, subtracted, or remains the same
 * */
public class Assign1Activity extends AppCompatActivity {

    int comGuess;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign1);
        setup();
    }

    private void setup() {
        score = 0;
        TextView statusView = (TextView) findViewById(R.id.statusText);
        statusView.setText("Make Your Choice!");
        TextView scoreView = (TextView) findViewById(R.id.scoreText);
        scoreView.setText("Score: " + score);
    }

    private void comChoose() {
        Random randNum = new Random();
        comGuess = randNum.nextInt(3);
        ImageView comView = (ImageView) findViewById(R.id.computerGuess);
        if (comGuess == 0) {
            comView.setImageResource(R.drawable.rock);
        } else if (comGuess == 1) {
            comView.setImageResource(R.drawable.paper);
        } else {
            comView.setImageResource(R.drawable.scissors);
        }
    }

    private void makeCalculations(int wrong, int draw) {
        comChoose();
        TextView statusView = (TextView) findViewById(R.id.statusText);
        if (comGuess == wrong) {
            statusView.setText("Wrong Choice, Try Again!");
            score--;

        } else if (comGuess == draw) {
            statusView.setText("It's a Draw, Try Again!");
        } else {
            statusView.setText("You Won, Try Again!");
            score++;
        }
        TextView scoreView = (TextView) findViewById(R.id.scoreText);
        scoreView.setText("Score: " + score);
    }

    public void rockClick(View view) {
        ImageView humanView = (ImageView) findViewById(R.id.humanGuess);
        humanView.setImageResource(R.drawable.rock);
        makeCalculations(1, 0);
    }

    public void paperClick(View view) {
        ImageView humanView = (ImageView) findViewById(R.id.humanGuess);
        humanView.setImageResource(R.drawable.paper);
        makeCalculations(2, 1);
    }

    public void scissorsClick(View view) {
        ImageView humanView = (ImageView) findViewById(R.id.humanGuess);
        humanView.setImageResource(R.drawable.scissors);
        makeCalculations(0, 2);

    }
}

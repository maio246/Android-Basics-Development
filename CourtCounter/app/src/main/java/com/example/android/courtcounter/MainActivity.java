package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int currentTeamAScore = 0;
    int currentTeamBScore = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        displayForTeamA(currentTeamAScore);
        displayForTeamB(currentTeamBScore);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView1 = (TextView) findViewById(R.id.team_a_score);
        scoreView1.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * increases Team A scores with 3
     */
    public void increaseScoreAByThree(View view) {
        currentTeamAScore += 3;
        displayForTeamA(currentTeamAScore);
    }

    /**
     * increases Team A scores with 2
     */
    public void increaseScoreAByTwo(View view) {
        currentTeamAScore += 2;
        displayForTeamA(currentTeamAScore);
    }

    /**
     * increases Team A scores with 1
     */
    public void increaseScoreAByOne(View view) {
        currentTeamAScore += 1;
        displayForTeamA(currentTeamAScore);
    }

    /**
     * increases Team B scores with 3
     */
    public void increaseScoreBByThree(View view) {
        currentTeamBScore += 3;
        displayForTeamB(currentTeamBScore);
    }

    /**
     * increases Team B scores with 2
     */
    public void increaseScoreBByTwo(View view) {
        currentTeamBScore += 2;
        displayForTeamB(currentTeamBScore);
    }

    /**
     * increases Team B scores with 1
     */
    public void increaseScoreBByOne(View view) {
        currentTeamBScore += 1;
        displayForTeamB(currentTeamBScore);
    }

    /**
     * resets both teams scores
     */
    public void resetScores(View view) {
        currentTeamAScore = 0;
        currentTeamBScore = 0;
        displayForTeamA(currentTeamAScore);
        displayForTeamB(currentTeamBScore);
    }
}

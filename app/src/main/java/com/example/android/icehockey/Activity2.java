package com.example.android.icehockey;


import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;


public class Activity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    String givenPenalty;
    int penaltyTime = 0;


    static final String stateScoreTeamA = "playerScoreA";
    static final String stateScoreTeamB = "playerScoreB";
    static final String stateShotTeamA = "playerShotA";
    static final String stateShotTeamB = "playerShotB";
    static final String stateStreakTeamA = "playerStreakA";
    static final String stateStreakTeamB = "playerStreakB";
    static final String statePenaltyA = "playerPenaltyA";
    static final String statePenaltyB = "playerPenaltyB";

    int scoreTeamA = 0;
    int streakTeamA = 0;
    int shotOnGoalTeamA = 0;
    int penaltyTeamA = 0;

    int scoreTeamB = 0;
    int streakTeamB = 0;
    int shotOnGoalTeamB = 0;
    int penaltyTeamB = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);

        spinner = (Spinner) findViewById(R.id.penalty);
        adapter = ArrayAdapter.createFromResource(this, R.array.penalty, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
    }


    /**
     * save and restore score
     */

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current game state
        savedInstanceState.putInt(stateScoreTeamA, scoreTeamA);
        savedInstanceState.putInt(stateScoreTeamB, scoreTeamB);
        savedInstanceState.putInt(stateShotTeamA, shotOnGoalTeamA);
        savedInstanceState.putInt(stateShotTeamB, shotOnGoalTeamB);
        savedInstanceState.putInt(stateStreakTeamA,streakTeamA);
        savedInstanceState.putInt(stateStreakTeamB,streakTeamB);
        savedInstanceState.putInt(statePenaltyA, penaltyTeamA);
        savedInstanceState.putInt(statePenaltyB, penaltyTeamB);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Always call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);

        // Restore state members from saved instance
        scoreTeamA = savedInstanceState.getInt(stateScoreTeamA);
        scoreTeamB = savedInstanceState.getInt(stateScoreTeamB);
        shotOnGoalTeamA = savedInstanceState.getInt(stateShotTeamA);
        shotOnGoalTeamB = savedInstanceState.getInt(stateShotTeamB);
        streakTeamA = savedInstanceState.getInt(stateStreakTeamA);
        streakTeamB = savedInstanceState.getInt(stateStreakTeamB);
        penaltyTeamA = savedInstanceState.getInt(statePenaltyA);
        penaltyTeamB = savedInstanceState.getInt(statePenaltyB);



        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);

        displayShotForTeamA(shotOnGoalTeamA);
        displayShotForTeamB(shotOnGoalTeamB);

        displayStreakForTeamA(streakTeamA);
        displayStreakForTeamB(streakTeamB);

        displayPenaltyTeamA(penaltyTeamA);
        displayPenaltyTeamB(penaltyTeamB);
    }

    /**
     * Displays the given score for Team A and B.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays shot on goal for Team A and B.
     */
    public void displayShotForTeamA(int shot) {
        TextView shotView = (TextView) findViewById(R.id.shotOnGoalTeamA);
        shotView.setText(String.valueOf(shot));
    }

    public void displayShotForTeamB(int shot) {
        TextView shotView = (TextView) findViewById(R.id.shotOnGoalTeamB);
        shotView.setText(String.valueOf(shot));
    }

    /**
     * Displays winning streak for Team A and B.
     */
    public void displayStreakForTeamA(int streak) {
        TextView streakView = (TextView) findViewById(R.id.winnigStreakTeamA);
        streakView.setText(String.valueOf(streak));
    }

    public void displayStreakForTeamB(int streak) {
        TextView streakView = (TextView) findViewById(R.id.winnigStreakTeamB);
        streakView.setText(String.valueOf(streak));
    }

    /**
     * Displays penalty streak for Team A and B.
     */

    public void displayPenaltyTeamA(int penalty) {
        TextView penaltyView = (TextView) findViewById(R.id.penaltyTeamA);
        penaltyView.setText(String.valueOf(penalty));
    }

    public void displayPenaltyTeamB(int penalty) {
        TextView penaltyView = (TextView) findViewById(R.id.penaltyTeamB);
        penaltyView.setText(String.valueOf(penalty));
    }


    /**
     * Count score for teams.
     */

    public void goalTeamA(View v) {
        scoreTeamA = scoreTeamA + 1;
        displayForTeamA(scoreTeamA);
    }

    public void goalTeamB(View v) {
        scoreTeamB = scoreTeamB + 1;
        displayForTeamB(scoreTeamB);
    }


    /**
     * Count shot on goal for teams.
     */
    public void ShotOnGoalA(View v) {
        shotOnGoalTeamA = shotOnGoalTeamA + 1;
        displayShotForTeamA(shotOnGoalTeamA);
    }

    public void ShotOnGoalB(View v) {
        shotOnGoalTeamB = shotOnGoalTeamB + 1;
        displayShotForTeamB(shotOnGoalTeamB);
    }


    /**
     * Count streaks for teams.
     */
    public void StreakTeamA(View v) {
        streakTeamA = streakTeamA + 1;
        displayStreakForTeamA(streakTeamA);
    }


    public void StreakTeamB(View v) {
        streakTeamB = streakTeamB + 1;
        displayStreakForTeamB(streakTeamB);
    }

    /**
     * Set penalty time.
     */

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

        givenPenalty = parent.getItemAtPosition(pos).toString();

        switch (pos) {

            case 0:
                penaltyTime = 2;

                break;

            case 1:
                penaltyTime = 4;
                break;
            case 2:
                penaltyTime = 6;
                break;
        }
    }

    /**
     * Count penalty time for teams.
     */
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void penaltyAplus(View view) {
        penaltyTeamA = penaltyTeamA + penaltyTime;
        displayPenaltyTeamA(penaltyTeamA);
    }

    public void penaltyBplus(View view) {
        penaltyTeamB = penaltyTeamB + penaltyTime;
        displayPenaltyTeamB(penaltyTeamB);

    }

    /**
     * Reset score.
     */
    public void reset(View v) {
        int scoreTeamA = 0;
        int streakTeamA = 0;
        int shotOnGoalTeamA = 0;
        int penaltyTeamA = 0;

        int scoreTeamB = 0;
        int streakTeamB = 0;
        int shotOnGoalTeamB = 0;
        int penaltyTeamB = 0;


        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);

        displayShotForTeamA(shotOnGoalTeamA);
        displayShotForTeamB(shotOnGoalTeamB);

        displayStreakForTeamA(streakTeamA);
        displayStreakForTeamB(streakTeamB);

        displayPenaltyTeamA(penaltyTeamA);
        displayPenaltyTeamB(penaltyTeamB);

    }

}

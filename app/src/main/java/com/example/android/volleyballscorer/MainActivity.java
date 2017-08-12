package com.example.android.volleyballscorer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static com.example.android.volleyballscorer.R.id.current_set;
import static com.example.android.volleyballscorer.R.id.winning_team;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int setsWonTeamA = 0;
    int setsWonTeamB = 0;
    int currentSet = 1;
    int gameEndedFlag = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* Adds 1 pt to team A score*/
    public void addPointTeamA(View v){
        scoreTeamA += 1;

        if(gameEndedFlag == 0) {
            // first 4 sets are played up to 25 pts, 5th set only played up to 15 pts
            // set is won if score is 25 and score is at least 2 pts greater than the other team
            if(currentSet < 5) {
                if(scoreTeamA >= 25 && scoreTeamA - scoreTeamB >= 2){
                    // increment sets won by teamA
                    setsWonTeamA += 1;

                    // display sets won
                    displaySetsWonTeamA(setsWonTeamA);

                    // if team A wins 3 sets before team B
                    if(setsWonTeamA == 3){
                        // display winner
                        displayWinningTeam("Team A Wins!");
                        // display scores
                        displayScoreTeamA(scoreTeamA);
                        displayScoreTeamB(scoreTeamB);
                        //set flag so no input will be accepted until reset button is pressed
                        gameEndedFlag = 1;
                    }
                    else{
                        // reset scores, increment current set
                        scoreTeamA = 0;
                        scoreTeamB = 0;
                        currentSet += 1;

                        // display scores and current set
                        displayScoreTeamA(scoreTeamA);
                        displayScoreTeamB(scoreTeamB);
                        displayCurrentSet(currentSet);

                    }
                }
                else{
                    displayScoreTeamA(scoreTeamA);
                }
            }
            else{
                if(scoreTeamA >= 15 && scoreTeamA - scoreTeamB >= 2){
                    // increment sets won by teamA
                    setsWonTeamA += 1;
                    // display sets won
                    displaySetsWonTeamA(setsWonTeamA);
                    // display scores
                    displayScoreTeamA(scoreTeamA);
                    displayScoreTeamB(scoreTeamB);
                    // display winner
                    displayWinningTeam("Team A Wins!");
                    //set flag so no input will be accepted until reset button is pressed
                    gameEndedFlag = 1;
                }
                else{
                    displayScoreTeamA(scoreTeamA);
                }
            }
        }


    }

    /* Deducts 1 pt from team A score*/
    public void deductPointTeamA(View v){
        if(gameEndedFlag == 0){
            if(scoreTeamA > 0){
                scoreTeamA -= 1;
                displayScoreTeamA(scoreTeamA);
            }
        }
    }

    /* Adds 1 pt to team B score*/
    public void addPointTeamB(View v){
        scoreTeamB += 1;

        if(gameEndedFlag == 0){
            if(currentSet < 5) {
                if(scoreTeamB >= 25 && scoreTeamB - scoreTeamA >= 2){
                    // increment sets won by teamB
                    setsWonTeamB += 1;

                    // display sets won and current set
                    displaySetsWonTeamB(setsWonTeamB);

                    // if team B wins 3 sets before team A
                    if(setsWonTeamB == 3){
                        // display winner
                        displayWinningTeam("Team B Wins!");
                        // display scores
                        displayScoreTeamA(scoreTeamA);
                        displayScoreTeamB(scoreTeamB);
                        //set flag so no input will be accepted until reset button is pressed
                        gameEndedFlag = 1;
                    }
                    else{
                        // reset scores, increment current set
                        scoreTeamA = 0;
                        scoreTeamB = 0;
                        currentSet += 1;
                        // display scores and current set
                        displayScoreTeamA(scoreTeamA);
                        displayScoreTeamB(scoreTeamB);
                        displayCurrentSet(currentSet);
                    }
                }
                else{
                    displayScoreTeamB(scoreTeamB);
                }
            }
            else{
                if(scoreTeamB >= 15 && scoreTeamB - scoreTeamA >= 2){
                    // increment sets won by teamB
                    setsWonTeamB += 1;
                    // display sets won
                    displaySetsWonTeamB(setsWonTeamB);
                    // display scores
                    displayScoreTeamA(scoreTeamA);
                    displayScoreTeamB(scoreTeamB);
                    // display winner
                    displayWinningTeam("Team B Wins!");
                    //set flag so no input will be accepted until reset button is pressed
                    gameEndedFlag = 1;
                }
                else{
                    displayScoreTeamB(scoreTeamB);
                }
            }
        }


    }

    /* Deducts 1 pt from team B score*/
    public void deductPointTeamB(View v){
        if(gameEndedFlag == 0){
            if(scoreTeamB > 0){
                scoreTeamB -= 1;
                displayScoreTeamB(scoreTeamB);
            }
        }
    }


    /*Resets all scores and sets */
    public void resetAll(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        setsWonTeamA = 0;
        setsWonTeamB = 0;
        currentSet = 1;
        gameEndedFlag = 0;

        displayCurrentSet(currentSet);
        displayScoreTeamA(scoreTeamA);
        displaySetsWonTeamA(setsWonTeamA);
        displayScoreTeamB(scoreTeamB);
        displaySetsWonTeamB(setsWonTeamB);
        displayWinningTeam("");
    }

    /* Displays score for team A */
    public void displayScoreTeamA(int n) {
        TextView teamScoreTextView = (TextView) findViewById(R.id.team_a_score);
        teamScoreTextView.setText(String.valueOf(n));
    }

    /* Displays sets won by team A */
    public void displaySetsWonTeamA(int n) {
        TextView teamScoreTextView = (TextView) findViewById(R.id.team_a_sets_won);
        teamScoreTextView.setText(String.valueOf(n));
    }

    /* Displays score for team B */
    public void displayScoreTeamB(int n) {
        TextView teamScoreTextView = (TextView) findViewById(R.id.team_b_score);
        teamScoreTextView.setText(String.valueOf(n));
    }

    /* Displays sets won by team B */
    public void displaySetsWonTeamB(int n) {
        TextView teamScoreTextView = (TextView) findViewById(R.id.team_b_sets_won);
        teamScoreTextView.setText(String.valueOf(n));
    }

    /* Displays current set */
    public void displayCurrentSet(int n) {
        TextView teamScoreTextView = (TextView) findViewById(current_set);
        teamScoreTextView.setText(String.valueOf(n));
    }

    /* Displays winning team */
    public void displayWinningTeam(String s) {
        TextView teamScoreTextView = (TextView) findViewById(winning_team);
        teamScoreTextView.setText(s);
    }


}

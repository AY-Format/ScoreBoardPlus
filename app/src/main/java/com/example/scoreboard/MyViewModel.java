package com.example.scoreboard;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    private MutableLiveData<Integer> teamA,teamB;
    private Integer scoreA,scoreB;

    public MutableLiveData<Integer> getTeamA() {
        if (teamA==null) {
            teamA = new MutableLiveData<>();
            teamA.setValue(0);
        }
        return teamA;
    }

    public MutableLiveData<Integer> getTeamB() {
        if (teamB==null) {
            teamB = new MutableLiveData<>();
            teamB.setValue(0);
        }
        return teamB;
    }

    public void addAScore(Integer s) {
        scoreA = teamA.getValue();
        scoreB = teamB.getValue();
        teamA.setValue(teamA.getValue()+s);
    }

    public void addBScore(Integer s) {
        scoreA = teamA.getValue();
        scoreB = teamB.getValue();
        teamB.setValue(teamB.getValue()+s);
    }

    public void resetScore() {
        scoreA = teamA.getValue();
        scoreB = teamB.getValue();
        teamA.setValue(0);
        teamB.setValue(0);
    }

    public void undo() {
        teamA.setValue(scoreA);
        teamB.setValue(scoreB);
    }
}

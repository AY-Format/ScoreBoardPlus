package com.example.scoreboard;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    private SavedStateHandle savedStateHandle;
    private Integer scoreA,scoreB;

    public MyViewModel(SavedStateHandle savedStateHandle){
        this.savedStateHandle = savedStateHandle;
    }

    public MutableLiveData<Integer> getTeamA() {
        if (!savedStateHandle.contains(MainActivity.TEAMA)) {
           savedStateHandle.set(MainActivity.TEAMA,0);
        }
        return savedStateHandle.getLiveData(MainActivity.TEAMA);
    }

    public MutableLiveData<Integer> getTeamB() {
        if (!savedStateHandle.contains(MainActivity.TEAMB)) {
            savedStateHandle.set(MainActivity.TEAMB,0);
        }
        return savedStateHandle.getLiveData(MainActivity.TEAMB);
    }

    public void addAScore(Integer s) {
        scoreA = getTeamA().getValue();
        scoreB = getTeamB().getValue();
        getTeamA().setValue(getTeamA().getValue()+s);
    }

    public void addBScore(Integer s) {
        scoreA = getTeamA().getValue();
        scoreB = getTeamB().getValue();
        getTeamB().setValue(getTeamB().getValue()+s);
    }

    public void resetScore() {
        scoreA = getTeamA().getValue();
        scoreB = getTeamB().getValue();
        getTeamA().setValue(0);
        getTeamB().setValue(0);
    }

    public void undo() {
        getTeamA().setValue(scoreA);
        getTeamB().setValue(scoreB);
    }
}

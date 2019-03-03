package com.esiea.masterapp;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class DataActivity2 extends AndroidViewModel {
    private MonsterRepository monRepository;
    private LiveData<List<MonsterActivity>> allGet;
    public DataActivity2(@NonNull Application monsterApp) {
        super(monsterApp);
        monRepository = new MonsterRepository(monsterApp);
        allGet = monRepository.allGet();
    }
    public void insertion (MonsterActivity monActivity){
        monRepository.insertion(monActivity);

    }
    public void suppression (MonsterActivity monActivity){
        monRepository.suppression(monActivity);
    }

    public void actualisation (MonsterActivity monActivity){
        monRepository.actualisation(monActivity);
    }
    public void allSuppression (){
        monRepository.allSuppression();
    }
    public LiveData<List<MonsterActivity>> getAllGet() {
        return allGet;
    }
}

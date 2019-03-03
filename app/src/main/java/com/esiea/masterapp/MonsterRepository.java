package com.esiea.masterapp;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class MonsterRepository {
    private MonsterInterface monsterI;
    private LiveData<List<MonsterActivity>> monsterGet;
    public MonsterRepository(Application monsterApp){
        MonsterSQL databaseSQL = MonsterSQL.getInstance(monsterApp);
        monsterI = databaseSQL.monInterface();
        monsterGet = monsterI.allGet();
    }
    public void insertion(MonsterActivity monActivity){
        new MonsterAsynchroneInsertion(monsterI).execute(monActivity);
    }
    public void actualisation(MonsterActivity monActivity){
        new MonsterAsynchroneActualisation(monsterI).execute(monActivity);
    }
    public void suppression(MonsterActivity monActivity){
        new MonsterAsynchroneSuppression(monsterI).execute(monActivity);
    }
    public void allSuppression(){
        new MonsterAsynchroneTotalSuppression(monsterI).execute();
    }
    public LiveData<List<MonsterActivity>> allGet(){
        return monsterGet;
    }
    private static class MonsterAsynchroneInsertion extends AsyncTask<MonsterActivity, Void, Void> {
        private MonsterInterface monsterI2;
        private MonsterAsynchroneInsertion(MonsterInterface monsterI2){
            this.monsterI2 = monsterI2;
        }
        @Override
        protected Void doInBackground(MonsterActivity... monsterActivities) {
            monsterI2.insertion(monsterActivities[0]);
            return null;
        }
    }
    private static class MonsterAsynchroneActualisation extends AsyncTask<MonsterActivity, Void, Void> {
        private MonsterInterface monsterI2;
        private MonsterAsynchroneActualisation(MonsterInterface monsterI2){
            this.monsterI2 = monsterI2;
        }
        @Override
        protected Void doInBackground(MonsterActivity... monsterActivities) {
            monsterI2.actualisation(monsterActivities[0]);
            return null;
        }
    }
    private static class MonsterAsynchroneSuppression extends AsyncTask<MonsterActivity, Void, Void> {
        private MonsterInterface monsterI2;
        private MonsterAsynchroneSuppression(MonsterInterface monsterI2){
            this.monsterI2 = monsterI2;
        }
        @Override
        protected Void doInBackground(MonsterActivity... monsterActivities) {
            monsterI2.suppression(monsterActivities[0]);
            return null;
        }
    }
    private static class MonsterAsynchroneTotalSuppression extends AsyncTask<Void, Void, Void> {
        private MonsterInterface monsterI2;
        private MonsterAsynchroneTotalSuppression(MonsterInterface monsterI2){
            this.monsterI2 = monsterI2;
        }
        @Override
        protected Void doInBackground(Void...voids) {
            monsterI2.allSuppression();
            return null;
        }
    }
}

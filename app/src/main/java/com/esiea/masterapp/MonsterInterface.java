package com.esiea.masterapp;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface MonsterInterface {

    @Insert
    void insertion (MonsterActivity monster);

    @Update
    void actualisation (MonsterActivity monster);

    @Delete
    void suppression (MonsterActivity monster);

    @Query("DELETE FROM monster_table")
    void allSuppression ();

    @Query("SELECT * FROM monster_table ORDER BY id ASC")
    LiveData<List<MonsterActivity>> allGet();
}

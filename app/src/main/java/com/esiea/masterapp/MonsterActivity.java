package com.esiea.masterapp;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "monster_table")
public class MonsterActivity {

    @PrimaryKey(autoGenerate = true)
    private int eid;

    private int id;

    private String name;

    private String group;

    private String elements;

    private String weaknesses;

    private int danger;

    private String description;

    public MonsterActivity(int id, String name, String group, String elements, String weaknesses, int danger, String description) {
        this.id = id;
        this.name = name;
        this.group = group;
        this.elements = elements;
        this.weaknesses = weaknesses;
        this.danger = danger;
        this.description = description;
    }

    public void setEid(int eid) {
        this.eid = eid;
    }

    public int getEid() {
        return eid;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public String getElements() {
        return elements;
    }

    public String getWeaknesses() {
        return weaknesses;
    }

    public int getDanger() {
        return danger;
    }

    public String getDescription() {
        return description;
    }
}

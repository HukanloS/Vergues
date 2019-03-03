package com.esiea.masterapp;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private DataActivity2 dataActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton addButton = findViewById(R.id.add_monster_button);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ModifyMonsterActivity.class);
                startActivityForResult(intent,1);
            }
        });
        RecyclerView monsterList = findViewById(R.id.monster_list);
        monsterList.setLayoutManager(new LinearLayoutManager(this));
        monsterList.setHasFixedSize(true);
        final RecycleViewAdapter monAdapter = new RecycleViewAdapter();
        monsterList.setAdapter(monAdapter);
        dataActivity = ViewModelProviders.of(this).get(DataActivity2.class);
        dataActivity.getAllGet().observe(this, new Observer<List<MonsterActivity>>() {
            @Override
            public void onChanged(@Nullable List<MonsterActivity> monsterActivities) {
                monAdapter.monsterPlant(monsterActivities);
            }
        });
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT
                | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder,
                                  @NonNull RecyclerView.ViewHolder viewHolder1) {
                return false;
            }
            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
                dataActivity.suppression(monAdapter.getMonster(viewHolder.getAdapterPosition()));
            }
        }).attachToRecyclerView(monsterList);
        monAdapter.setItemSelectionListener(new RecycleViewAdapter.ItemSelectionListener() {
            @Override
            public void itemSelection(MonsterActivity monActivity) {
                Intent monIntent = new Intent(MainActivity.this, ModifyMonsterActivity.class);
                monIntent.putExtra(ModifyMonsterActivity.EXTRA_EID, monActivity.getEid());
                monIntent.putExtra(ModifyMonsterActivity.EXTRA_ID, monActivity.getId());
                monIntent.putExtra(ModifyMonsterActivity.EXTRA_NAME, monActivity.getName());
                monIntent.putExtra(ModifyMonsterActivity.EXTRA_GROUP, monActivity.getGroup());
                monIntent.putExtra(ModifyMonsterActivity.EXTRA_ELEMENT, monActivity.getElements());
                monIntent.putExtra(ModifyMonsterActivity.EXTRA_WEAKNESS, monActivity.getWeaknesses());
                monIntent.putExtra(ModifyMonsterActivity.EXTRA_DANGER, monActivity.getDanger());
                monIntent.putExtra(ModifyMonsterActivity.EXTRA_DESCRIPTION, monActivity.getDescription());
                startActivityForResult(monIntent, 2);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == RESULT_OK){
            int newId = data.getIntExtra(ModifyMonsterActivity.EXTRA_ID,1);
            String newName = data.getStringExtra(ModifyMonsterActivity.EXTRA_NAME);
            String newGroup = data.getStringExtra(ModifyMonsterActivity.EXTRA_GROUP);
            String newElement = data.getStringExtra(ModifyMonsterActivity.EXTRA_ELEMENT);
            String newWeakness = data.getStringExtra(ModifyMonsterActivity.EXTRA_WEAKNESS);
            int newDanger = data.getIntExtra(ModifyMonsterActivity.EXTRA_DANGER,1);
            String newDescription = data.getStringExtra(ModifyMonsterActivity.EXTRA_DESCRIPTION);
            MonsterActivity monActivity = new MonsterActivity(newId,newName,newGroup,newElement,newWeakness,newDanger
                    ,newDescription);
            dataActivity.insertion(monActivity);
            Toast.makeText(this, "Modifications sauvegardées", Toast.LENGTH_SHORT).show();
        } else if(requestCode == 2 && resultCode == RESULT_OK){
            int eid = data.getIntExtra(ModifyMonsterActivity.EXTRA_EID, -1);
            if(eid == -1){
                Toast.makeText(this, "Modification impossible", Toast.LENGTH_SHORT).show();
                return;
            }
            int newId = data.getIntExtra(ModifyMonsterActivity.EXTRA_ID,1);
            String newName = data.getStringExtra(ModifyMonsterActivity.EXTRA_NAME);
            String newGroup = data.getStringExtra(ModifyMonsterActivity.EXTRA_GROUP);
            String newElement = data.getStringExtra(ModifyMonsterActivity.EXTRA_ELEMENT);
            String newWeakness = data.getStringExtra(ModifyMonsterActivity.EXTRA_WEAKNESS);
            int newDanger = data.getIntExtra(ModifyMonsterActivity.EXTRA_DANGER,1);
            String newDescription = data.getStringExtra(ModifyMonsterActivity.EXTRA_DESCRIPTION);
            MonsterActivity monActivity = new MonsterActivity(newId,newName,newGroup,newElement,newWeakness,newDanger
                    ,newDescription);
            monActivity.setEid(eid);
            dataActivity.actualisation(monActivity);
            Toast.makeText(this, "Modifications sauvegardées", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Sauvegarde compromise", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater monInflator = getMenuInflater();
        monInflator.inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.tout_brûler:
                dataActivity.allSuppression();
                Toast.makeText(this, "Annihilation des données accomplie", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}



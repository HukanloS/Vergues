package com.esiea.masterapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class ModifyMonsterActivity extends AppCompatActivity {
    public static final String EXTRA_EID = "com.esiea.masterapp.EXTRA_EID";
    public static final String EXTRA_ID = "com.esiea.masterapp.EXTRA_ID";
    public static final String EXTRA_NAME = "com.esiea.masterapp.EXTRA_NAME";
    public static final String EXTRA_GROUP = "com.esiea.masterapp.EXTRA_GROUP";
    public static final String EXTRA_ELEMENT = "com.esiea.masterapp.EXTRA_ELEMENT";
    public static final String EXTRA_WEAKNESS = "com.esiea.masterapp.EXTRA_WEAKNESS";
    public static final String EXTRA_DANGER = "com.esiea.masterapp.EXTRA_DANGER";
    public static final String EXTRA_DESCRIPTION = "com.esiea.masterapp.EXTRA_DESCRIPTION";
    private NumberPicker modifyId;
    private EditText modifyName;
    private EditText modifyGroup;
    private EditText modifyElements;
    private EditText modifyWeaknesses;
    private NumberPicker modifyDanger;
    private EditText modifyDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_monster);
        modifyId = findViewById(R.id.number_picker_entry);
        modifyName = findViewById(R.id.new_monster_name);
        modifyGroup = findViewById(R.id.new_monster_group);
        modifyElements = findViewById(R.id.new_monster_elements);
        modifyWeaknesses = findViewById(R.id.new_monster_weaknesses);
        modifyDanger = findViewById(R.id.number_picker_danger);
        modifyDescription = findViewById(R.id.new_monster_description);
        modifyId.setMinValue(1);
        modifyId.setMaxValue(150);
        modifyDanger.setMinValue(1);
        modifyDanger.setMaxValue(7);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close_white_cross);
        Intent monIntent = getIntent();
        if(monIntent.hasExtra(EXTRA_EID)){
            setTitle("Modifier les Caractéristiques");
            modifyId.setValue(monIntent.getIntExtra(EXTRA_ID,1));
            modifyName.setText(monIntent.getStringExtra(EXTRA_NAME));
            modifyGroup.setText(monIntent.getStringExtra(EXTRA_GROUP));
            modifyElements.setText(monIntent.getStringExtra(EXTRA_ELEMENT));
            modifyWeaknesses.setText(monIntent.getStringExtra(EXTRA_WEAKNESS));
            modifyDanger.setValue(monIntent.getIntExtra(EXTRA_DANGER,1));
            modifyDescription.setText(monIntent.getStringExtra(EXTRA_DESCRIPTION));
        }else {
            setTitle("Ajouter un Nouveau Monstre");
        }
    }
    private void saveChanges(){
        int newId = modifyId.getValue();
        String newName = modifyName.getText().toString();
        String newGroup = modifyGroup.getText().toString();
        String newElements = modifyElements.getText().toString();
        String newWeaknesses = modifyWeaknesses.getText().toString();
        int newDanger = modifyDanger.getValue();
        String newDescription = modifyDescription.getText().toString();
        if (newName.trim().isEmpty()||newGroup.trim().isEmpty()||newElements.trim().isEmpty()||
                newWeaknesses.trim().isEmpty()||newDescription.trim().isEmpty()){
            Toast.makeText(this, "Données incomplètes", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent data = new Intent();
        data.putExtra(EXTRA_ID,newId);
        data.putExtra(EXTRA_NAME,newName);
        data.putExtra(EXTRA_GROUP,newGroup);
        data.putExtra(EXTRA_ELEMENT,newElements);
        data.putExtra(EXTRA_WEAKNESS,newWeaknesses);
        data.putExtra(EXTRA_DANGER,newDanger);
        data.putExtra(EXTRA_DESCRIPTION,newDescription);
        int eid = getIntent().getIntExtra(EXTRA_EID,-1);
        if(eid != -1){
            data.putExtra(EXTRA_EID, eid);
        }
        setResult(RESULT_OK, data);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater infMenu = getMenuInflater();
        infMenu.inflate(R.menu.new_monster, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_changes:
                saveChanges();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}

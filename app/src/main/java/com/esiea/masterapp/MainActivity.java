package com.esiea.masterapp;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import com.esiea.masterapp.databinding.ActivityMainBinding;

public class MainActivity extends Activity {

    public ObservableField<String> subTitle = new ObservableField<>();
    public ObservableField<String> startButton = new ObservableField<>();

    public void startClick() {
        Intent intent = new Intent(MainActivity.this,DataActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((ActivityMainBinding)DataBindingUtil
                .setContentView(this,R.layout.activity_main))
                .setViewModel(this);

        subTitle.set(getString(R.string.main_title));
        startButton.set(getString(R.string.start_button));
    }
}



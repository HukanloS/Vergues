package com.esiea.masterapp;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.databinding.ObservableField;
import android.os.Bundle;
import com.esiea.masterapp.databinding.ActivityDataBinding;

public class DataActivity extends Activity {

    public ObservableField<String> addButton = new ObservableField<>();

    public void addClick() {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((ActivityDataBinding)DataBindingUtil
                .setContentView(this,R.layout.activity_data))
                .setViewModel(this);

        addButton.set(getString(R.string.add_button));
    }
}

package com.example.nicko.shchepetslab1;

import android.app.Dialog;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebViewFragment;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.level_radio)
    protected RadioGroup levelRadioGroup;
    @BindView(R.id.task_radio)
    protected RadioGroup taskRadioGroup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    public void sendMessage(String message) {
        ((ResultFragment) getSupportFragmentManager().findFragmentById(R.id.result)).showMessage(message);
    }

}

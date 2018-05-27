package com.example.nicko.shchepetslab1;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class TaskFragment extends Fragment {

    @BindView(R.id.level_radio)
    protected RadioGroup levelRadioGroup;
    @BindView(R.id.task_radio)
    protected RadioGroup taskRadioGroup;


    public TaskFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_task, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @OnClick(R.id.ok)
    protected void onOkClicked() {
        ((MainActivity) getActivity()).sendMessage("Ви обрали "
                + getStringFromRadioGroup(taskRadioGroup)
                + " завдання " +
                getStringFromRadioGroup(levelRadioGroup) +
                " рівня складності.");
    }


    private String getStringFromRadioGroup(RadioGroup radioGroup) {
        return ((RadioButton) getActivity().findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();
    }
}

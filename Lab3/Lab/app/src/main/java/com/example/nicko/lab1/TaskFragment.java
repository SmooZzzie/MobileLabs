package com.example.nicko.shchepetslab1;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.nicko.shchepetslab1.dao.TaskDao;
import com.example.nicko.shchepetslab1.models.Task;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class TaskFragment extends Fragment {

    private final TaskDao taskDao = App.getInstance().getDatabase().taskDao();
    @BindView(R.id.level_radio)
    protected RadioGroup levelRadioGroup;
    @BindView(R.id.task_radio)
    protected RadioGroup taskRadioGroup;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_task, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @OnClick(R.id.ok)
    protected void onOkClicked() {
        String type = getStringFromRadioGroup(taskRadioGroup);
        String level = getStringFromRadioGroup(levelRadioGroup);
        final Task task = new Task(level, type);

        taskDao.insert(task);

        sendMessage(task);
    }

    @OnClick(R.id.get_from_db)
    protected void getFromDb() {
        final List<Task> all = taskDao.getAll();
        if (all.isEmpty()) {
            showError();
            return;
        }
        sendMessage(all.get(all.size() - 1));
    }

    private void sendMessage(Task task) {
        ((MainActivity) getActivity()).sendMessage("Ви обрали " + task.getType() + " завдання "
                + task.getLevel() + " рівня складності.");
    }

    private void showError() {
        Toast.makeText(getActivity(), "Error", Toast.LENGTH_SHORT).show();
    }

    private String getStringFromRadioGroup(RadioGroup radioGroup) {
        return ((RadioButton) getActivity().findViewById(radioGroup.getCheckedRadioButtonId())).getText().toString();
    }
}

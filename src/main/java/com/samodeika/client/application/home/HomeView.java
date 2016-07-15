package com.samodeika.client.application.home;

import com.gwtplatform.mvp.client.View;
import com.samodeika.shared.model.TaskModel;

import java.util.List;

public interface HomeView extends View {

    void addTasks(List<TaskModel> tasks);
}

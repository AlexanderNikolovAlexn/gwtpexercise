package com.samodeika.client.application.home;

import com.gwtplatform.mvp.client.View;
import com.samodeika.shared.model.Hello;
import com.samodeika.shared.model.TaskModel;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface HomeView extends View {

    void addTasks(Map<Date, List<TaskModel>> tasks);
}

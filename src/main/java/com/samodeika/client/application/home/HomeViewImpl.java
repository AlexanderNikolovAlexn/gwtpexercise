package com.samodeika.client.application.home;

import javax.inject.Inject;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.*;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.gwtplatform.mvp.client.ViewImpl;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import com.samodeika.shared.utils.DateUtils;
import com.samodeika.shared.model.TaskModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class HomeViewImpl extends ViewWithUiHandlers<HomeUiHandlers> implements HomeView {
    interface Binder extends UiBinder<Widget, HomeViewImpl> {
    }

    private static final String today = "Today is ";
    private static final String selected = "Selected date is ";

    @Inject
    HomeViewImpl(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));
        selectedDate.setText(today + DateUtils.getCurrentDate());
        datePicker.addValueChangeHandler(new ValueChangeHandler<Date>() {
            @Override
            public void onValueChange(ValueChangeEvent<Date> valueChangeEvent) {
                String dateString = DateUtils.getDate(valueChangeEvent.getValue());
                selectedDate.setText(selected + dateString);
                getUiHandlers().loadTasks(dateString);
            }
        });
    }

    @UiField
    DatePicker datePicker;

    @UiField
    Label selectedDate;

    @UiField
    StackPanel stackPanel;

    @UiField
    FlowPanel dayTask;

    @Override
    public void addTasks(Map<Date, List<TaskModel>> tasks) {
        for (Date taskDate : tasks.keySet()) {
            FlowPanel flowPanel = new FlowPanel();
            List<TaskModel> list = tasks.get(taskDate);
            for (int i = 0; i < list.size(); i++) {
                flowPanel.add(new Label(list.get(i).getMessage()));
            }
            stackPanel.add(flowPanel, DateUtils.getDate(taskDate));
        }
    }

    @Override
    public void displayTask(List<TaskModel> tasks) {
        dayTask.clear();
        if (tasks == null || tasks.isEmpty()) {
            return;
        }
        for (TaskModel task : tasks) {
            dayTask.add(new Label(task.getMessage()));
        }
    }
}

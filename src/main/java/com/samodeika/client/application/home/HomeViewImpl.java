package com.samodeika.client.application.home;

import javax.inject.Inject;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.StackPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.gwtplatform.mvp.client.ViewImpl;
import com.samodeika.shared.utils.DateUtils;
import com.samodeika.shared.model.TaskModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class HomeViewImpl extends ViewImpl implements HomeView {
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
            }
        });
    }

    @UiField
    DatePicker datePicker;

    @UiField
    Label selectedDate;

    @UiField
    StackPanel stackPanel;

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

}

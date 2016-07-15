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
import com.samodeika.client.utils.DateUtils;
import java.util.Date;

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
        addTasks();
    }

    @UiField
    DatePicker datePicker;

    @UiField
    Label selectedDate;

    @UiField
    StackPanel stackPanel;

    void addTasks() {
        FlowPanel flowPanel = new FlowPanel();
        flowPanel.add(new Label("task 1 1 list"));
        flowPanel.add(new Label("task 1 2 list"));
        flowPanel.add(new Label("task 1 3 list"));
        stackPanel.add(flowPanel, "task 1");
        stackPanel.add(new Label("task 2 list"), "task 2");
        stackPanel.add(new Label("task 3 list"), "task 3");
    };
}

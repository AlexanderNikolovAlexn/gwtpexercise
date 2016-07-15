package com.samodeika.client.application.home;

import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.datepicker.client.DatePicker;
import com.samodeika.client.application.ApplicationPresenter;
import com.samodeika.client.application.ServiceFactory;
import com.samodeika.client.place.NameTokens;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.samodeika.shared.model.TaskModel;

import java.util.List;

public class HomePresenter extends Presenter<HomeView, HomePresenter.MyProxy> {

    @ProxyStandard
    @NameToken(NameTokens.HOME)
    interface MyProxy extends ProxyPlace<HomePresenter> {
    }

    @Inject
    HomePresenter(
            EventBus eventBus,
            HomeView view,
            MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_MAIN);
    }

    @Inject
    ServiceFactory serviceFactory;

    @Override
    protected void onReveal() {
        super.onReveal();
        serviceFactory.getTaskService().getTasks(initTaskCallback);
    }

    AsyncCallback<List<TaskModel>> initTaskCallback = new AsyncCallback<List<TaskModel>>() {
        @Override
        public void onFailure(Throwable throwable) {

        }

        @Override
        public void onSuccess(List<TaskModel> taskModels) {
            getView().addTasks(taskModels);
        }
    };
}

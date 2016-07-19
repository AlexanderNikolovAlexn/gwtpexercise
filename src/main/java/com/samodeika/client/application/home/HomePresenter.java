package com.samodeika.client.application.home;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.samodeika.client.application.ApplicationPresenter;
import com.samodeika.client.application.ServiceFactory;
import com.samodeika.client.place.NameTokens;
import com.samodeika.shared.model.TaskModel;
import org.fusesource.restygwt.client.Method;
import org.fusesource.restygwt.client.MethodCallback;

import java.util.Date;
import java.util.List;
import java.util.Map;

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

    MethodCallback<Map<Date, List<TaskModel>>> initTaskCallback = new MethodCallback<Map<Date, List<TaskModel>>>() {
        @Override
        public void onFailure(Method method, Throwable throwable) {

        }

        @Override
        public void onSuccess(Method method, Map<Date, List<TaskModel>> taskModels) {
            getView().addTasks(taskModels);
        }
    };
}

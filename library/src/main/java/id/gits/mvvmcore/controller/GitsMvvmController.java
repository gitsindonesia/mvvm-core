package id.gits.mvvmcore.controller;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import id.gits.mvvmcore.viewmodel.GitsMvvmVM;
import rx.Scheduler;
import rx.Subscription;

/**
 * Created by ibun on 18/03/16.
 */
public abstract class GitsMvvmController<VM extends GitsMvvmVM, B extends ViewDataBinding> {
    protected AppCompatActivity mActivity;
    protected VM mViewModel;

    private List<Subscription> subscriptions = new ArrayList<>();
    protected Scheduler scheduler;

    protected void addSubscription(Subscription subscription) {
        subscriptions.add(subscription);
    }

    public void finishSubscriber() {
        for (Subscription sub : subscriptions) {
            sub.unsubscribe();
        }
    }

    public void initController(AppCompatActivity activity, B binding, Bundle savedInstanceState) {
        //init activity and view model
        mActivity = activity;
        mViewModel = createViewModel(activity, binding);
        bindViewModel(binding, mViewModel);

        onCreateController(activity, binding, savedInstanceState);
    }

    public abstract VM createViewModel(AppCompatActivity activity, B binding);

    public abstract void bindViewModel(B binding, VM viewModel);

    public abstract void onCreateController(AppCompatActivity activity, B binding, Bundle savedInstanceState);

    public void pauseController() {

    }

    public void resumeController() {

    }

    public void destroyController() {
        finishSubscriber();
    }


    public void onSaveInstanceState(Bundle outState) {

    }
}

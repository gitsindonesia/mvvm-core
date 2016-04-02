package id.gits.mvvmcore.controller;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import id.gits.mvvmcore.viewmodel.GitsVM;
import rx.Scheduler;
import rx.Subscription;

/**
 * Created by ibun on 18/03/16.
 */
public abstract class GitsController<VM extends GitsVM, B extends ViewDataBinding> {
    protected AppCompatActivity mActivity;
    protected VM mViewModel;

    private List<Subscription> subscriptions = new ArrayList<>();
    protected Scheduler scheduler;
    private Fragment mFragment;


    protected void addSubscription(Subscription subscription) {
        subscriptions.add(subscription);
    }

    public void finishSubscriber() {
        for (Subscription sub : subscriptions) {
            sub.unsubscribe();
        }
    }

    public void initController(AppCompatActivity activity, B binding, Bundle savedInstanceState) {
        mActivity = activity;
        mViewModel = getmViewModel(binding);
        bindViewModel(binding, mViewModel);
        onCreateController(activity, binding, savedInstanceState);
    }

    public void initController(Fragment fragment, B binding, Bundle savedInstanceState) {
        mFragment= fragment;
        mViewModel = getmViewModel(binding);
        bindViewModel(binding, mViewModel);

        onCreateController(fragment, binding, savedInstanceState);
    }

    public abstract VM getmViewModel(B binding);

    public abstract void bindViewModel(B binding, VM viewModel);

    /**
     * Digunakan untuk class yang extends AppCompatActivity
     * @param activity
     * @param binding
     * @param savedInstanceState
     */
    public void onCreateController(AppCompatActivity activity, B binding, Bundle savedInstanceState) {

    }

    /**
     * Digunakan untuk class yang extends Fragment
     * @param fragment
     * @param binding
     * @param savedInstanceState
     */
    public void onCreateController(Fragment fragment, B binding, Bundle savedInstanceState) {

    }

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

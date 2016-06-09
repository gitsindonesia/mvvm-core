package id.gits.mvvmcore.viewmodel;

import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;

import id.gits.mvvmcore.controller.GitsController;

/**
 * Created by ibun on 18/03/16.
 */
public class GitsVM<C extends GitsController, B extends ViewDataBinding> {
    protected AppCompatActivity mActivity;
    protected B mBinding;
    protected C mController;

    public GitsVM(AppCompatActivity activity, C controller, B binding) {
        mActivity = activity;
        mBinding = binding;
        mController = controller;

    }

    public B getBinding() {
        return mBinding;
    }
}

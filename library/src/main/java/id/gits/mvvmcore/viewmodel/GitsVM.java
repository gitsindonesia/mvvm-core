package id.gits.mvvmcore.viewmodel;

import android.app.Activity;
import android.databinding.ViewDataBinding;

import id.gits.mvvmcore.controller.GitsController;

/**
 * Created by ibun on 18/03/16.
 */
public class GitsVM<C extends GitsController, B extends ViewDataBinding> {
    protected Activity mActivity;
    protected B mBinding;
    protected C mController;

    public GitsVM(Activity activity, C controller, B binding) {
        mActivity = activity;
        mBinding = binding;
        mController = controller;

    }

    public B getBinding() {
        return mBinding;
    }
}

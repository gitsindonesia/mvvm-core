package id.gits.mvvmcore.base;

import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ibun on 18/03/16.
 */
public class BaseVM<C extends BaseController> {
    protected AppCompatActivity mActivity;
    protected ViewDataBinding mBinding;
    protected C mController;

    public BaseVM(AppCompatActivity activity, C controller, ViewDataBinding binding) {
        mActivity = activity;
        mBinding = binding;
        mController = controller;
    }

    public ViewDataBinding getBinding() {
        return mBinding;
    }
}

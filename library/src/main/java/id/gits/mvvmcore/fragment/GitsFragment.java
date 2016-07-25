package id.gits.mvvmcore.fragment;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.gits.mvvmcore.controller.GitsController;

/**
 * Created by ibun on 21/03/16.
 */
public abstract class GitsFragment<C extends GitsController> extends Fragment {
    protected C mController;
    ViewDataBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, getFragmentLayout(), container, false);
        mController = createController();
        mController.initController(this, mBinding, savedInstanceState);

        return mBinding.getRoot();
    }


    protected abstract C createController();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mController != null)
            mController.destroyController();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mController != null)
            mController.resumeController();
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mController != null)
            mController.pauseController();
    }

    public abstract
    @LayoutRes
    int getFragmentLayout();
}

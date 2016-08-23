package id.gits.mvvmcore.fragment;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import id.gits.mvvmcore.MvvmView;
import id.gits.mvvmcore.viewmodel.GitsVM;

/**
 * Created by ibun on 21/03/16.
 */
public abstract class GitsFragment<VM extends GitsVM, B extends ViewDataBinding> extends Fragment
        implements MvvmView<VM, B> {
    B mBinding;
    protected VM mViewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = DataBindingUtil.inflate(inflater, getResLayout(), container, false);

        mViewModel = getViewModel();
        bindViewModel(mBinding, mViewModel);

        return mBinding.getRoot();
    }
}

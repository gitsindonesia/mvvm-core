package id.gits.mvvmcore;

import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;

import id.gits.mvvmcore.viewmodel.GitsVM;

public interface MvvmView<VM extends GitsVM, B extends ViewDataBinding> {

    @LayoutRes
    int getResLayout();

    VM getViewModel();

    void bindViewModel(B binding, VM viewModel);
}

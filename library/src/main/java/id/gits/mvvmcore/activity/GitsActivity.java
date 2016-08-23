package id.gits.mvvmcore.activity;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import id.gits.mvvmcore.MvvmView;
import id.gits.mvvmcore.viewmodel.GitsVM;

/**
 * Created by ibun on 18/03/16.
 */
public abstract class GitsActivity<VM extends GitsVM, B extends ViewDataBinding> extends AppCompatActivity implements MvvmView<VM, B> {
    protected B mBinding;
    protected Toolbar mToolbar;
    protected VM mViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getResLayout(), getToolbarId());
    }

    protected void setContentView(@LayoutRes int idLayout, @IdRes int idToolbar) {
        mBinding = DataBindingUtil.setContentView(this, getResLayout());

        mViewModel = getViewModel();
        bindViewModel(mBinding, mViewModel);

        mToolbar = (Toolbar) findViewById(getToolbarId());
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);
        }
    }

    protected abstract
    @IdRes
    int getToolbarId();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        } else
            return super.onOptionsItemSelected(item);
    }

}

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

import id.gits.mvvmcore.controller.GitsController;

/**
 * Created by ibun on 18/03/16.
 */
public abstract class GitsActivity<C extends GitsController> extends AppCompatActivity {
    protected C mController;
    ViewDataBinding mBinding;
    protected Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getResLayout(), getToolbarId());
        mController = createController();
        mController.initController(this, mBinding, savedInstanceState);
    }

    protected void setContentView(@LayoutRes int idLayout, @IdRes int idToolbar) {
        mBinding = DataBindingUtil.setContentView(this, getResLayout());

        mToolbar = (Toolbar) findViewById(getToolbarId());
        if (mToolbar != null) {
            setSupportActionBar(mToolbar);

        }
    }

    protected abstract
    @IdRes
    int getToolbarId();

    protected abstract
    @LayoutRes
    int getResLayout();

    protected abstract C createController();

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        } else
            return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mController.destroyController();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mController.pauseController();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mController.resumeController();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mController.onSaveInstanceState(outState);
    }
}

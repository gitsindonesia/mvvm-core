package id.gits.mvvmcore.activity;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import butterknife.ButterKnife;
import id.gits.mvvmcore.controller.GitsMvvmController;

/**
 * Created by ibun on 18/03/16.
 */
public abstract class GitsMvvmActivity<C extends GitsMvvmController> extends AppCompatActivity {
    protected C mController;
    ViewDataBinding mBinding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = createContentViewBinding();

        ButterKnife.bind(this);

        Toolbar toolbar = getToolbar();
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }

        mController = createController();
        mController.initController(this, mBinding, savedInstanceState);
    }

    protected abstract Toolbar getToolbar();

    protected abstract ViewDataBinding createContentViewBinding();

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
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        mController.onSaveInstanceState(outState);
    }
}

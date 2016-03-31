package id.gits.mvvmsample.main;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.Toolbar;

import id.gits.mvvmcore.activity.GitsMvvmActivity;
import id.gits.mvvmsample.R;

/**
 * Created by ibun on 30/03/16.
 */
public class MainActivity extends GitsMvvmActivity<MainController> {
    @Override
    protected Toolbar getToolbar() {
        return (Toolbar) findViewById(R.id.toolbar);
    }

    @Override
    protected ViewDataBinding createContentViewBinding() {
        return DataBindingUtil.setContentView(this, R.layout.main_activity);
    }

    @Override
    protected MainController createController() {
        return new MainController();
    }
}

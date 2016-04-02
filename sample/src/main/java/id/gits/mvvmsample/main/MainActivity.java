package id.gits.mvvmsample.main;

import id.gits.mvvmcore.activity.GitsActivity;
import id.gits.mvvmsample.R;

/**
 * Created by ibun on 30/03/16.
 */
public class MainActivity extends GitsActivity<MainController> {

    @Override
    protected int getToolbarId() {
        return R.id.toolbar;
    }

    @Override
    protected int getResLayout() {
        return R.layout.main_activity;
    }

    @Override
    protected MainController createController() {
        return new MainController();
    }
}

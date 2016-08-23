package id.gits.mvvmsample.main;

import id.gits.mvvmcore.activity.GitsActivity;
import id.gits.mvvmsample.R;
import id.gits.mvvmsample.databinding.MainActivityBinding;

/**
 * Created by ibun on 30/03/16.
 */
public class MainActivity extends GitsActivity<MainActivityVM, MainActivityBinding> {
    @Override
    protected int getToolbarId() {
        return R.id.toolbar;
    }

    @Override
    public int getResLayout() {
        return R.layout.main_activity;
    }

    @Override
    public MainActivityVM getViewModel() {
        return new MainActivityVM(this);
    }

    @Override
    public void bindViewModel(MainActivityBinding binding, MainActivityVM viewModel) {
        binding.setVm(viewModel);
    }

}

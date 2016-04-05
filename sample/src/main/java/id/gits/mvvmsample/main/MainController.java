package id.gits.mvvmsample.main;

import android.os.Bundle;

import id.gits.mvvmcore.controller.GitsController;
import id.gits.mvvmsample.databinding.MainActivityBinding;

/**
 * Created by ibun on 30/03/16.
 */
public class MainController extends GitsController<MainActivityVM, MainActivityBinding> {

    @Override
    public MainActivityVM getmViewModel(MainActivityBinding binding) {
        return new MainActivityVM(mActivity, this, binding);
    }

    @Override
    public void bindViewModel(MainActivityBinding binding, MainActivityVM viewModel) {
        binding.setVm(viewModel);
    }

    @Override
    public void onCreateController(Bundle savedInstanceState) {
        //TODO

    }
}

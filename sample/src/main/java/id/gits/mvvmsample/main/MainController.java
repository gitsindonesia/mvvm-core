package id.gits.mvvmsample.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import id.gits.mvvmcore.controller.GitsController;
import id.gits.mvvmsample.databinding.MainActivityBinding;

/**
 * Created by ibun on 30/03/16.
 */
public class MainController extends GitsController<MainActivityVM, MainActivityBinding> {
    /*@Override
    public MainActivityVM createViewModel(AppCompatActivity activity, MainActivityBinding binding) {
        return new MainActivityVM(activity, this, binding);
    }*/

    @Override
    public MainActivityVM getmViewModel(MainActivityBinding binding) {
        return new MainActivityVM(mActivity, this, binding);
    }

    @Override
    public void bindViewModel(MainActivityBinding binding, MainActivityVM viewModel) {
        binding.setVm(viewModel);
    }

    @Override
    public void onCreateController(AppCompatActivity activity, MainActivityBinding binding, Bundle savedInstanceState) {
        //TODO

    }
}

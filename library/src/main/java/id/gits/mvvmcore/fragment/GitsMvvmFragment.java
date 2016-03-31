package id.gits.mvvmcore.fragment;

import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import id.gits.mvvmcore.controller.GitsMvvmController;

/**
 * Created by ibun on 21/03/16.
 */
public abstract class GitsMvvmFragment<C extends GitsMvvmController> extends Fragment {
    protected C mController;
    ViewDataBinding mBinding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mBinding = createViewBinding(inflater);

        ButterKnife.bind(this, mBinding.getRoot());

        mController = createController();

        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mController.initController((AppCompatActivity) getActivity(), mBinding, savedInstanceState);
    }

    protected abstract ViewDataBinding createViewBinding(LayoutInflater inflater);

    protected abstract C createController();

    @Override
    public void onDestroy() {
        super.onDestroy();
        mController.destroyController();
    }

    @Override
    public void onResume() {
        super.onResume();
        mController.resumeController();
    }

    @Override
    public void onPause() {
        super.onPause();
        mController.pauseController();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mController.onSaveInstanceState(outState);
    }
}

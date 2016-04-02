package id.gits.mvvmsample.main;

import android.support.v7.app.AppCompatActivity;

import java.util.List;

import id.gits.mvvmcore.adapter.GitsAdapter;
import id.gits.mvvmsample.R;
import id.gits.mvvmsample.databinding.DummyRowBinding;

/**
 * Created by ibun on 31/03/16.
 */
public class DummyAdapter extends GitsAdapter<DummyDao, DummyRowVM, DummyRowBinding> {
    public DummyAdapter(List<DummyDao> collection) {
        super(collection);
    }

    @Override
    public DummyRowVM createViewModel(AppCompatActivity activity, DummyRowBinding binding, DummyDao item) {
        return new DummyRowVM(activity, binding, item);
    }

    @Override
    public int getLayoutRes() {
        return R.layout.dummy_row;
    }

    @Override
    public void render(DummyRowBinding binding, DummyRowVM viewModel, DummyDao item) {
        binding.setVm(viewModel);
    }

    @Override
    public void onRowClick(DummyDao data, int position) {

    }
}

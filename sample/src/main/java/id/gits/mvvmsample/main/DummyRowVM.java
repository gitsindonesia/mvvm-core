package id.gits.mvvmsample.main;

import android.content.Context;
import android.databinding.ObservableField;

import id.gits.mvvmcore.viewmodel.GitsMvvmRowVM;
import id.gits.mvvmsample.databinding.DummyRowBinding;

/**
 * Created by ibun on 31/03/16.
 */
public class DummyRowVM extends GitsMvvmRowVM<DummyDao, DummyRowBinding> {
    public ObservableField<String> bTextDummy = new ObservableField<>();

    public DummyRowVM(Context context, DummyRowBinding binding, DummyDao data) {
        super(context, binding, data);

        bTextDummy.set(data.getText());
    }
}

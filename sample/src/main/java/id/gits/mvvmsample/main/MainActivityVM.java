package id.gits.mvvmsample.main;

import android.databinding.ObservableField;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;

import id.gits.mvvmcore.base.BaseVM;

/**
 * Created by ibun on 30/03/16.
 */
public class MainActivityVM extends BaseVM<MainController> {
    public ObservableField<String> bTextHello = new ObservableField<>();

    public MainActivityVM(AppCompatActivity activity, MainController controller, ViewDataBinding binding) {
        super(activity, controller, binding);
    }

    public void initTextView(String text) {
        bTextHello.set(text);
    }
}

package id.gits.mvvmsample.main;

import android.databinding.ObservableField;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

import id.gits.mvvmcore.viewmodel.GitsVM;
import id.gits.mvvmsample.databinding.MainActivityBinding;

/**
 * Created by ibun on 30/03/16.
 */
public class MainActivityVM extends GitsVM<MainController, MainActivityBinding> {
    private final List<DummyDao> mList = new ArrayList<>();
    public ObservableField<String> bTextHello = new ObservableField<>();
    public DummyAdapter bAdapter;
    public LinearLayoutManager bLayoutManager;

    public MainActivityVM(AppCompatActivity activity, MainController controller, MainActivityBinding binding) {
        super(activity, controller, binding);

        //create dummy data
        mList.add(new DummyDao("Hello World"));
        mList.add(new DummyDao("Lorem Ipsum"));

        bAdapter = new DummyAdapter(mList);
        bLayoutManager = new LinearLayoutManager(activity);
    }

}

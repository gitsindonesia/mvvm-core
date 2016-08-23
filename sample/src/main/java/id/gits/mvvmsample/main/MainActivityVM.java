package id.gits.mvvmsample.main;

import android.content.Context;
import android.databinding.ObservableField;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import id.gits.mvvmcore.viewmodel.GitsVM;
import id.gits.mvvmsample.api.main.MainRequest;
import id.gits.mvvmsample.api.main.MainResponse;
import id.gits.mvvmsample.dagger.Injector;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by ibun on 30/03/16.
 */
public class MainActivityVM extends GitsVM {
    private final List<DummyDao> mList = new ArrayList<>();
    public ObservableField<String> bTextHello = new ObservableField<>();
    public DummyAdapter bAdapter;
    public LinearLayoutManager bLayoutManager;

    @Inject
    MainRequest mRequest;

    public MainActivityVM(Context context) {
        super(context);
        Injector.component.inject(this);

//        mRequest = new MainRequestImpl();
        mRequest.requestLogin("asd", "asd")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Subscriber<MainResponse.LoginResponse>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(MainResponse.LoginResponse loginResponse) {
                        Toast.makeText(mContext, loginResponse.getMessage(), Toast.LENGTH_SHORT).show();
                        //create dummy data
                        mList.add(new DummyDao("Hello World"));
                        mList.add(new DummyDao("Lorem Ipsum"));
                        bAdapter.notifyDataSetChanged();
                    }
                });

        bAdapter = new DummyAdapter(mList);
        bLayoutManager = new LinearLayoutManager(context);
    }

}

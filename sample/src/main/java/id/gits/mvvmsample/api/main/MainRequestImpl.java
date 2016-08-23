package id.gits.mvvmsample.api.main;

import javax.inject.Singleton;

import id.gits.mvvmsample.api.BaseRequest;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by ibun on 8/23/16.
 */
@Singleton
public class MainRequestImpl extends BaseRequest implements MainRequest {

    @Override
    public Observable<MainResponse.LoginResponse> requestLogin(final String username, String password) {
        Observable<MainResponse.LoginResponse> myObservable =
                Observable.create(new Observable.OnSubscribe<MainResponse.LoginResponse>() {
                    @Override
                    public void call(Subscriber<? super MainResponse.LoginResponse> subscriber) {
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        if (username.equals("asd")) {
                            subscriber.onNext(new MainResponse.LoginResponse("Ibun Keren"));
                            subscriber.onCompleted();
                        } else {
                            subscriber.onError(new Throwable("Wrong username"));
                        }
                    }
                });

        mApiClient.toString();
        return myObservable;
    }
}

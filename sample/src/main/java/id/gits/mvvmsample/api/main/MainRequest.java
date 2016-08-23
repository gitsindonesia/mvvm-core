package id.gits.mvvmsample.api.main;

import rx.Observable;

/**
 * Created by ibun on 8/23/16.
 */
public interface MainRequest {
    Observable<MainResponse.LoginResponse> requestLogin(String username, String password);
}

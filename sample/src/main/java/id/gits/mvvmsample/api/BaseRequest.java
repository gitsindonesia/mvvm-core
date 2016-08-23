package id.gits.mvvmsample.api;

import id.gits.mvvmsample.dagger.Injector;

/**
 * Created by ibun on 8/23/16.
 */
public class BaseRequest {
    protected ApiClient mApiClient;

    public BaseRequest() {
        mApiClient = Injector.component.apiClient();
    }
}

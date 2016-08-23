package id.gits.mvvmsample.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import id.gits.mvvmsample.api.ApiClient;
import id.gits.mvvmsample.api.main.MainRequest;
import id.gits.mvvmsample.api.main.MainRequestImpl;

/**
 * Created by ibun on 8/22/16.
 */
@Module
public class NetModule {
    @Singleton
    @Provides
    ApiClient provideApiClient() {
        return new ApiClient("http://gits.co.id");
    }

    @Singleton
    @Provides
    MainRequest provideMainReq() {
        return new MainRequestImpl();
    }
}
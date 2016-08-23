package id.gits.mvvmsample.dagger;

import javax.inject.Singleton;

import dagger.Component;
import id.gits.mvvmsample.api.ApiClient;
import id.gits.mvvmsample.main.MainActivityVM;

/**
 * Created by ibun on 8/22/16.
 */
@Singleton
@Component(modules = {
        AppModule.class,
        NetModule.class})
public interface DiComponent {
    ApiClient apiClient();

    void inject(MainActivityVM viewModel);
}

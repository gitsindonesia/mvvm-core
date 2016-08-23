package id.gits.mvvmsample;

import android.app.Application;

import id.gits.mvvmsample.dagger.Injector;


/**
 * Created by ibun on 8/22/16.
 */
public class GitsApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Injector.initialize(this);
    }
}

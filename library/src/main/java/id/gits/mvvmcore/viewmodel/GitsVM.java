package id.gits.mvvmcore.viewmodel;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import rx.Subscription;

/**
 * Created by ibun on 18/03/16.
 */
public class GitsVM implements Subscribable {
    protected Context mContext;

    public GitsVM(Context context) {
        mContext = context;
    }

    private List<Subscription> subscriptions = new ArrayList<>();

    @Override
    public void addSubscription(Subscription subscription) {
        subscriptions.add(subscription);
    }

    @Override
    public void finishSubscriber() {
        for (Subscription sub : subscriptions) {
            sub.unsubscribe();
        }
    }
}

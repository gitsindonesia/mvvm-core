package id.gits.mvvmcore.viewmodel;

import rx.Subscription;

public interface Subscribable {

    void addSubscription(Subscription subscription);

    void finishSubscriber();
}

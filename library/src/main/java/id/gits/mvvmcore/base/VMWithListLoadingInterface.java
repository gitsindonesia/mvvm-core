package id.gits.mvvmcore.base;

/**
 * Created by ibun on 18/03/16.
 */
public interface VMWithListLoadingInterface {
    public void startLoading();

    public void stopLoading();

    public void showErrorLoading(String errorMessage);
    public void notifyAdapter();
}

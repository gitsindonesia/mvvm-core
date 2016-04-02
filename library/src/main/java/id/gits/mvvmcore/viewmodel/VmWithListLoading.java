package id.gits.mvvmcore.viewmodel;

/**
 * Created by ibun on 18/03/16.
 */
public interface VmWithListLoading {
    public void startLoading();
    public void stopLoading();
    public void showErrorLoading(String errorMessage);
    public void notifyAdapter();
}

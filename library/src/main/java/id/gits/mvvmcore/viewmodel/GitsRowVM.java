package id.gits.mvvmcore.viewmodel;

import android.content.Context;
import android.databinding.ViewDataBinding;


/**
 * Created by ibun on 18/03/16.
 */
public class GitsRowVM<T, B extends ViewDataBinding> {
    protected Context mContext;
    protected B mBinding;
    protected T mData;

    public GitsRowVM(Context context, B binding, T data) {
        mContext = context;
        mBinding = binding;
        mData = data;
    }

    public B getBinding() {
        return mBinding;
    }
}

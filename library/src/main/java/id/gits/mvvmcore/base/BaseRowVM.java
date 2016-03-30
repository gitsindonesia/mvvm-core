package id.gits.mvvmcore.base;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.databinding.ViewDataBinding;
import android.text.TextUtils;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import id.gits.mvvmcore.R;


/**
 * Created by ibun on 18/03/16.
 */
public class BaseRowVM<T> {
    protected Context mContext;
    protected ViewDataBinding mBinding;
    protected T mData;

    public BaseRowVM(Context context, ViewDataBinding binding, T data) {
        mContext = context;
        mBinding = binding;
        mData = data;
    }

    public ViewDataBinding getBinding() {
        return mBinding;
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String url) {
        if (!TextUtils.isEmpty(url))
            Picasso.with(view.getContext()).load(url).placeholder(R.color.placeholder)
                    .resize(300, 300).centerCrop()
                    .error(R.color.error_placeholder).into(view);
    }
}

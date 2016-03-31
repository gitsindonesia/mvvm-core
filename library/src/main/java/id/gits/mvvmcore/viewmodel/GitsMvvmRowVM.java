package id.gits.mvvmcore.viewmodel;

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
public class GitsMvvmRowVM<T, B extends ViewDataBinding> {
    protected Context mContext;
    protected B mBinding;
    protected T mData;

    public GitsMvvmRowVM(Context context, B binding, T data) {
        mContext = context;
        mBinding = binding;
        mData = data;
    }

    public B getBinding() {
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

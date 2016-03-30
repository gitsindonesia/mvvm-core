package id.gits.mvvmcore.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by ibun on 22/03/16.
 */
public abstract class BaseAdapter<T, B extends ViewDataBinding> extends RecyclerView.Adapter<BaseAdapter.BindingHolder<B>> {
    protected Context mContext;

    protected List<T> mCollection;

    public BaseAdapter(List<T> collection) {
        mCollection = collection;
    }

    @Override
    public BindingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ButterKnife.bind(this, parent);

        mContext = parent.getContext();
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.
                from(parent.getContext()), getLayoutRes(), parent, false);
        return new BindingHolder(binding);
    }


    public abstract
    @LayoutRes
    int getLayoutRes();

    public abstract void render(B binding, T data);

    public abstract void onRowClick(T data, int position);

    @Override
    public void onBindViewHolder(final BindingHolder<B> holder, int position) {
        final T item = mCollection.get(position);
        //render
        render(holder.getBinding(), item);

        holder.getBinding().getRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onRowClick(item, holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mCollection.size();
    }

    public static class BindingHolder<B extends ViewDataBinding> extends RecyclerView.ViewHolder {
        private B binding;

        public BindingHolder(B binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public B getBinding() {
            return this.binding;
        }
    }
}

package id.gits.mvvmcore.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gits on 4/2/16.
 */
public class GitsPagerAdapter extends FragmentPagerAdapter {

    public List<GitsModelFragmentAdapter> items = new ArrayList<>();

    public GitsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return items.get(position).fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return items.get(position).title;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    public void addItem(String title,Fragment fragment) {
        items.add(new GitsModelFragmentAdapter(title,fragment));
    }

    class GitsModelFragmentAdapter {
        String title;
        Fragment fragment;

        public GitsModelFragmentAdapter(String title, Fragment fragment) {
            this.title = title;
            this.fragment = fragment;
        }
    }
}

package com.parity.assignment.adaptor;

import com.parity.assignment.fragment.FeaturedDealsFragment;
import com.parity.assignment.fragment.PopularDealsFragment;
import com.parity.assignment.fragment.TopDealsFragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    private CharSequence[] titles;

    public ViewPagerAdapter(FragmentManager fm, CharSequence[] titles) {
        super(fm);
        this.titles = titles;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new TopDealsFragment();

            case 1:
                return new PopularDealsFragment();

            case 2:
                return new FeaturedDealsFragment();
        }
        return new TopDealsFragment();
        /*TopDealsFragment topDealsFragment = new TopDealsFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(Const.FRAGMENT_POSITION, position);
        topDealsFragment.setArguments(bundle);
        return topDealsFragment;*/
    }

    @Override
    public int getCount() {
        return titles.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}

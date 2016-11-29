package com.gosuncn.sample.module.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.gosuncn.sample.module.ui.fragment.ItemFragment;

import java.util.List;


/**
 * @author Tong
 * @time 2016/11/25
 * @apiNote
 */
public class PagerAdapter extends FragmentStatePagerAdapter {

    List<Fragment> fragments;

    public PagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments!=null?fragments.size():0;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).getArguments().getString(ItemFragment.PARAM);
    }

}

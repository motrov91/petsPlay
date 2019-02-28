package com.example.ingmanuel.petsplay.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;

import com.example.ingmanuel.petsplay.UI.MainViewPager;

import java.util.List;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    List<Fragment> fragmentList;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {



        return MainViewPager.PlaceholderFragment.newInstance(i+1);
        //fragmentList.get(i)
    }

    @Override
    public int getCount() {
        return 5;
    }
}

package com.example.newsapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class ViewPageAdapter extends FragmentStatePagerAdapter {
    public ViewPageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new NewsFragment();
            case 1:
                return new UserFragment();
            case 2:
                return new SearchFragment();
            default:
                return  new NewsFragment();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title="";
        switch (position) {
            case 1:
                title = "Tài khoản";
                break;
            case 0:
                title = "Tin nổi bật";
            case 2:
                title = "Tìm kiếm";
                break;
        }
        return title;
    }
}

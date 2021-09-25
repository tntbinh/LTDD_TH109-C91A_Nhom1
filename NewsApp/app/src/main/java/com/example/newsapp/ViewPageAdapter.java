package com.example.newsapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.newsapp.fragment.VideoFragment;

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
            case 2:
                return new UserFragment();
            case 1:
                return new SearchFragment();
            case 3:
                return new VideoFragment();
            default:
                return  new NewsFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title="";
        switch (position) {
            case 2:
                title = "Podcast";
                break;
            case 3:
                title = "Giới thiệu";
                break;
            case 0:
                title = "Tin nổi bật";
                break;
            case 1:
                title = "Tìm kiếm";
                break;
        }
        return title;
    }
}

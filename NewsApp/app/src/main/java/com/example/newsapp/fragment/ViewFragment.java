package com.example.newsapp.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newsapp.R;
import com.example.newsapp.The_Slide_items_Pager_Adapter;
import com.example.newsapp.object.The_Slide_Items_Model_Class;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;


public class ViewFragment extends Fragment {
    private List<The_Slide_Items_Model_Class> listItems;
    private ViewPager page;
    private TabLayout tabLayout;


    public ViewFragment(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view, container, false);
        page = view.findViewById(R.id.my_pager) ;
        tabLayout = view.findViewById(R.id.my_tablayout);

        listItems=new ArrayList<>();

        listItems.add(new The_Slide_Items_Model_Class(R.drawable.hinh1, "Tim Cook chưa 'lên đời' iPhone 13",
                "https://vnexpress.net/tim-cook-chua-len-doi-iphone-13-4360203.html"));
        listItems.add(new The_Slide_Items_Model_Class(R.drawable.hinh2, "Thế giới chạy đua công nghệ metaverse",
                "https://vnexpress.net/the-gioi-chay-dua-cong-nghe-metaverse-4359951.html"));
        listItems.add(new The_Slide_Items_Model_Class(R.drawable.hinh3, "Xiaomi tạo 'bạn gái ảo'",
                "https://vnexpress.net/xiaomi-tao-ban-gai-ao-4359333.html"));
        listItems.add(new The_Slide_Items_Model_Class(R.drawable.hinh4, "Chip giả tuồn vào chuỗi cung ứng",
                "https://vnexpress.net/chip-gia-tuon-vao-chuoi-cung-ung-4358866.html"));
        listItems.add(new The_Slide_Items_Model_Class(R.drawable.hinh5, "Nhân lực công nghệ đã thay đổi thế nào vì Covid-19",
                "https://vnexpress.net/nhan-luc-cong-nghe-da-thay-doi-the-nao-vi-covid-19-4358393.html"));

        The_Slide_items_Pager_Adapter itemsPager_adapter = new The_Slide_items_Pager_Adapter(getActivity(), listItems);
        page.setAdapter(itemsPager_adapter);
        tabLayout.setupWithViewPager(page,true);
        return view;
    }

}
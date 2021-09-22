package com.example.newsapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class SearchFragment extends Fragment {

    ListView lvTieuDe;
    ArrayList<String> arrayTitle, arrayLink;
    ArrayAdapter adapter;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);

        lvTieuDe = (ListView) view.findViewById(R.id.listviewTieuDe);
        arrayTitle = new ArrayList<>();
        arrayLink = new ArrayList<>();

        adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, arrayTitle);
        lvTieuDe.setAdapter(adapter);


//        new ReadRSS().execute("https://vnexpress.net/rss/giao-duc.rss");
//        lvTieuDe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                Intent intent = new Intent(getActivity(), DetailItemSearchActivity.class);
//                intent.putExtra("linkTinTuc",arrayLink.get(i));
//                startActivity(intent);
//            }
//        });

        return view;
    }
}
package com.example.newsapp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.AboutActivity;
import com.example.newsapp.DetailItemSearchActivity;
import com.example.newsapp.MainActivity;
import com.example.newsapp.NewsActivity;
import com.example.newsapp.object.Article;
import com.example.newsapp.ArticleAdapter;
import com.example.newsapp.R;

import java.util.ArrayList;

public class NewsFragment extends Fragment {


    RecyclerView recyclerView;
    ArrayList<Article> listSanPham;
    ArticleAdapter sanPhamAdapter;

    public NewsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news, container, false);

        recyclerView = view.findViewById(R.id.recyclerview);
        listSanPham=new ArrayList<>();

        listSanPham.add(new Article("Tim Cook chưa 'lên đời' iPhone 13",R.drawable.hinh1,
                "Nhiều người dùng Trung Quốc tỏ ra ngạc nhiên khi phát hiện CEO Apple vẫn dùng chiếc iPhone 12 Pro Max để viết lời chúc mừng Trung thu.",
                "https://vnexpress.net/tim-cook-chua-len-doi-iphone-13-4360203.html"));
        listSanPham.add(new Article("Thế giới chạy đua công nghệ metaverse",R.drawable.hinh2,
                "Từ nhà sản xuất chip đến công ty giải trí khắp thế giới đều đang lên kế hoạch xây dựng metaverse - vũ trụ ảo được xem là tương lai công nghệ.",
                "https://vnexpress.net/the-gioi-chay-dua-cong-nghe-metaverse-4359951.html"));
        listSanPham.add(new Article("Xiaomi tạo 'bạn gái ảo'",R.drawable.hinh3,
                "Xiaomi lấn sân vào lĩnh vực bạn gái ảo khi đăng ký bản quyền cho Xiaoai Girlfriend, tích hợp AI tương tác với người dùng. ",
                "https://vnexpress.net/xiaomi-tao-ban-gai-ao-4359333.html"));
        listSanPham.add(new Article("Chip giả tuồn vào chuỗi cung ứng",R.drawable.hinh4,
                "Tình trạng khan hiếm chip toàn cầu khiến một số nhà sản xuất công nghệ lớn phải chấp nhận rủi ro, mua chip từ nguồn hàng không rõ chất lượng. ",
                "https://vnexpress.net/chip-gia-tuon-vao-chuoi-cung-ung-4358866.html"));
        listSanPham.add(new Article("Nhân lực công nghệ đã thay đổi thế nào vì Covid-19",R.drawable.hinh5,
                "18 tháng dịch bệnh toàn cầu đã thay đổi nhiều mặt cuộc sống, trong đó, Thung lũng Silicon buộc phải chấm dứt sự ám ảnh với tối ưu hóa công việc. ",
                "https://vnexpress.net/nhan-luc-cong-nghe-da-thay-doi-the-nao-vi-covid-19-4358393.html"));
        sanPhamAdapter=new ArticleAdapter(getActivity(), listSanPham);
        recyclerView.setAdapter(sanPhamAdapter);

        return view;
    }
}
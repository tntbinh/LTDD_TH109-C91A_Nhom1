package com.example.newsapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsapp.fragment.NewsFragment;
import com.example.newsapp.object.Article;

import java.util.ArrayList;


class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnLongClickListener // Implement 2 sự kiện onClick và onLongClick
{
    public WebView txt_description; // Khai báo biến=

    public RecyclerViewHolder(View itemView) {
        super(itemView);
        txt_description = (WebView) itemView.findViewById(R.id.webviewTinTuc); // tiến hành tìm view và assign địa chỉ

        itemView.setOnClickListener(this); // Mấu chốt ở đây , set sự kiên onClick cho View
        itemView.setOnLongClickListener(this); // Mấu chốt ở đây , set sự kiên onLongClick cho View
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public boolean onLongClick(View view) {
        return false;
    }
}

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {
    Context context;
    ArrayList<Article> listSanPham;
    private Context mContext;

    public ArticleAdapter(Context context, ArrayList<Article> listSanPham) {
        this.context = context;
        this.listSanPham = listSanPham;
        this.mContext=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // gán view
        View view = LayoutInflater.from(context).inflate(R.layout.article_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // Gán dữ liêuk
        final Article sanPham = listSanPham.get(position);
        if (sanPham == null){
            return;
        }

        holder.txtTenSanPham.setText(sanPham.getTieuDe());
        holder.txtGiaSanPham.setText(sanPham.getNoiDungChinh());
        holder.imgAvatar.setImageResource(sanPham.getHinhAnh());

        holder.layoutItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGoToDetail(sanPham);
            }
        });
    }

    private void onClickGoToDetail(Article article){
        Intent intent = new Intent(mContext, DetailItemSearchActivity.class);
        intent.putExtra("linkTinTuc", article.getLinkBaiBao());
        mContext.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return listSanPham.size(); // trả item tại vị trí postion
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAvatar;
        TextView txtTenSanPham, txtGiaSanPham;
        RelativeLayout layoutItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Ánh xạ view
            imgAvatar = itemView.findViewById(R.id.imgAvatar);
            txtGiaSanPham = itemView.findViewById(R.id.txtGiaSanPham);
            txtTenSanPham = itemView.findViewById(R.id.txtTenSanPham);
            layoutItem = itemView.findViewById(R.id.layoutItem);

        }
    }
}
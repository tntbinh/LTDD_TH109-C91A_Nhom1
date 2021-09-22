package com.example.newsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {
    Context context;
    ArrayList<Article> listSanPham;

    public ArticleAdapter(Context context, ArrayList<Article> listSanPham) {
        this.context = context;
        this.listSanPham = listSanPham;
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
        Article sanPham = listSanPham.get(position);
        holder.txtTenSanPham.setText(sanPham.getTieuDe());
        holder.txtGiaSanPham.setText(sanPham.getNoiDungChinh());
        holder.imgAvatar.setImageResource(sanPham.getHinhAnh());
    }

    @Override
    public int getItemCount() {
        return listSanPham.size(); // trả item tại vị trí postion
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgAvatar;
        TextView txtTenSanPham, txtGiaSanPham;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            // Ánh xạ view
            imgAvatar = itemView.findViewById(R.id.imgAvatar);
            txtGiaSanPham = itemView.findViewById(R.id.txtGiaSanPham);
            txtTenSanPham = itemView.findViewById(R.id.txtTenSanPham);

        }
    }
}
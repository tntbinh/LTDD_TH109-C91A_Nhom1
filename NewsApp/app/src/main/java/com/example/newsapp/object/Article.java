package com.example.newsapp.object;

import java.io.Serializable;

public class Article implements Serializable {
    String tieuDe, noiDungChinh, linkBaiBao;
    int hinhAnh;

    public Article(String tieuDe, int hinhAnh, String noiDungChinh, String linkBaiBao){
        this.tieuDe = tieuDe;
        this.hinhAnh = hinhAnh;
        this.noiDungChinh = noiDungChinh;
        this.linkBaiBao = linkBaiBao;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public int getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getNoiDungChinh() {
        return noiDungChinh;
    }

    public void setNoiDungChinh(String noiDungChinh) {
        this.noiDungChinh = noiDungChinh;
    }

    public String getLinkBaiBao() {
        return linkBaiBao;
    }

    public void setLinkBaiBao(String linkBaiBao) {
        this.linkBaiBao = linkBaiBao;
    }
}

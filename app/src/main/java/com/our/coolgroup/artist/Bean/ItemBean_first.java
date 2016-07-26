package com.our.coolgroup.artist.Bean;

import java.util.List;

/**
 * Created by Administrator on 2016/7/26.
 */
public class ItemBean_first {

    /**
     * id : 254
     * title : 盘PAN·容器
     * thumb : http://assets.jiangwoo.com/uploads%2Feffaec6d6ab98a01117de7329a869f21-400x400__.jpg
     * favs_count : 1
     * view_count : 45
     * source : jiangwoo
     */

    private List<ProductsBean> products;

    public List<ProductsBean> getProducts() {
        return products;
    }

    public void setProducts(List<ProductsBean> products) {
        this.products = products;
    }

    public static class ProductsBean {
        private int id;
        private String title;
        private String thumb;
        private int favs_count;
        private int view_count;
        private String source;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public int getFavs_count() {
            return favs_count;
        }

        public void setFavs_count(int favs_count) {
            this.favs_count = favs_count;
        }

        public int getView_count() {
            return view_count;
        }

        public void setView_count(int view_count) {
            this.view_count = view_count;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }
    }
}

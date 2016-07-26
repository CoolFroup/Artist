package com.our.coolgroup.artist.Bean;

import java.util.List;

/**
 * Created by Administrator on 2016/7/26.
 */
public class TitleBean_first {

    /**
     * title : 器皿
     * image : http://assets.jiangwoo.com/uploads%2Fca8f71bb98a7a523cb0e5fcfda52eac4-qimin_3x_2.png
     * image_black : http://assets.jiangwoo.com/uploads%2Fd83e3609b49e2781c52b74de9fbc6783-Rectangle.png
     */

    private List<CategoriesBean> categories;

    public List<CategoriesBean> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoriesBean> categories) {
        this.categories = categories;
    }

    public static class CategoriesBean {
        private String title;
        private String image;
        private String image_black;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getImage_black() {
            return image_black;
        }

        public void setImage_black(String image_black) {
            this.image_black = image_black;
        }
    }
}

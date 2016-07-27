package com.our.coolgroup.artist.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/7/26.
 */
public class SecondBean {
    /**
     * id : 84
     * name : 唐坊主题酒店
     * thumb : assets.jiangwoo.com/production/spaces/bb36c33d-b2d5-42a1-9042-a34192767e02
     * favs_count : 19
     * comments_count : 1
     * position : 6
     * shares_count : 19
     * username : 小匠
     */

    private List<SpacesBean> spaces;

    public List<SpacesBean> getSpaces() {
        return spaces;
    }

    public void setSpaces(List<SpacesBean> spaces) {
        this.spaces = spaces;
    }

    public static class SpacesBean {
        private int id;
        private String name;
        private String thumb;
        private int favs_count;
        private int comments_count;
        private int position;
        private int shares_count;
        private String username;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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

        public int getComments_count() {
            return comments_count;
        }

        public void setComments_count(int comments_count) {
            this.comments_count = comments_count;
        }

        public int getPosition() {
            return position;
        }

        public void setPosition(int position) {
            this.position = position;
        }

        public int getShares_count() {
            return shares_count;
        }

        public void setShares_count(int shares_count) {
            this.shares_count = shares_count;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}


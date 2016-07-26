package com.our.coolgroup.artist.Bean;

import java.util.List;

/**
 * Created by Administrator on 2016/7/26.
 */
public class Header_firstBean {

    /**
     * id : 6
     * title : 川RIVER
     * url : /products/253
     * description : 川RIVER
     * target_id : 253
     * target_type : Product
     * created_at : 2016-03-31T07:26:03.806Z
     * updated_at : 2016-07-26T02:39:19.721Z
     * thumb : http://assets.jiangwoo.com/uploads%2F50f99ae105f09271bc26dc795d72f976-banner.jpg
     */

    private List<HeadlinesBean> headlines;

    public List<HeadlinesBean> getHeadlines() {
        return headlines;
    }

    public void setHeadlines(List<HeadlinesBean> headlines) {
        this.headlines = headlines;
    }

    public static class HeadlinesBean {
        private int id;
        private String title;
        private String url;
        private String description;
        private int target_id;
        private String target_type;
        private String created_at;
        private String updated_at;
        private String thumb;

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

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getTarget_id() {
            return target_id;
        }

        public void setTarget_id(int target_id) {
            this.target_id = target_id;
        }

        public String getTarget_type() {
            return target_type;
        }

        public void setTarget_type(String target_type) {
            this.target_type = target_type;
        }

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }
    }
}

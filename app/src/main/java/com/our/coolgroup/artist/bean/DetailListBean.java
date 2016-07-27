package com.our.coolgroup.artist.bean;

import java.util.List;

/**
 * Created by samsung on 2016/7/27.
 */
public class DetailListBean {

    /**
     * id : 37
     * user_id : 8
     * content : 在哪里？？？
     * target_id : 84
     * target_type : Space
     * num_of_reports : 0
     * created_at : 2016-06-28T09:49:53.289Z
     * updated_at : 2016-06-28T09:49:53.289Z
     * username : Yue
     * user_thumb : http://assets.jiangwoo.com/uploads%2F6a701c6eff73229371543202abf80af0-thumb.jpg
     */

    private List<CommentsBean> comments;

    public List<CommentsBean> getComments() {
        return comments;
    }

    public void setComments(List<CommentsBean> comments) {
        this.comments = comments;
    }

    public static class CommentsBean {
        private int id;
        private int user_id;
        private String content;
        private int target_id;
        private String target_type;
        private int num_of_reports;
        private String created_at;
        private String updated_at;
        private String username;
        private String user_thumb;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUser_id() {
            return user_id;
        }

        public void setUser_id(int user_id) {
            this.user_id = user_id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
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

        public int getNum_of_reports() {
            return num_of_reports;
        }

        public void setNum_of_reports(int num_of_reports) {
            this.num_of_reports = num_of_reports;
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

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getUser_thumb() {
            return user_thumb;
        }

        public void setUser_thumb(String user_thumb) {
            this.user_thumb = user_thumb;
        }
    }
}

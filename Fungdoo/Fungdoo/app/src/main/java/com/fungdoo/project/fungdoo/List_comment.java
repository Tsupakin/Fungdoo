package com.fungdoo.project.fungdoo;

import java.util.List;

/**
 * Created by warawat on 10/13/2016.
 */

public class List_comment {
    /**
     * output : [{"restaurant_id":"9","user_comment":"นาตฤดี ฟูแสง","comment_detail":"เยี่ยม","created":"2016-05-17 11:30:33"},{"restaurant_id":"9","user_comment":"ภัทราวดี พรหมาลาศ ","comment_detail":"ขอบคุณครูที่ปรึกษานะคะ","created":"2016-05-17 11:29:51"}]
     * status : true
     */

    private boolean status;
    /**
     * restaurant_id : 9
     * user_comment : นาตฤดี ฟูแสง
     * comment_detail : เยี่ยม
     * created : 2016-05-17 11:30:33
     */

    private List<OutputBean> output;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<OutputBean> getOutput() {
        return output;
    }

    public void setOutput(List<OutputBean> output) {
        this.output = output;
    }

    public static class OutputBean {
        private String restaurant_id;
        private String user_comment;
        private String comment_detail;
        private String created;

        public String getRestaurant_id() {
            return restaurant_id;
        }

        public void setRestaurant_id(String restaurant_id) {
            this.restaurant_id = restaurant_id;
        }

        public String getUser_comment() {
            return user_comment;
        }

        public void setUser_comment(String user_comment) {
            this.user_comment = user_comment;
        }

        public String getComment_detail() {
            return comment_detail;
        }

        public void setComment_detail(String comment_detail) {
            this.comment_detail = comment_detail;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }
    }
}

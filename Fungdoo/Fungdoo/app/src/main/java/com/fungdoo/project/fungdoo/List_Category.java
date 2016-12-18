package com.fungdoo.project.fungdoo;

import java.util.List;

/**
 * Created by warawat on 12/14/2016.
 */

public class List_Category
{

    /**
     * output : [{"category_id":"19","category_name":"สติง","category_detail":"สติง","category_icon":"http://projectandroid.top/Travel/uploads/category/_Travel-Beach-icon.png"},{"category_id":"23","category_name":"แจส","category_detail":"แจส","category_icon":"http://projectandroid.top/Travel/uploads/category/"},{"category_id":"20","category_name":"ลูกทุ่ง","category_detail":"ลูกทุ่ง","category_icon":"http://projectandroid.top/Travel/uploads/category/_building.png"},{"category_id":"21","category_name":"แด้น","category_detail":"แด้น","category_icon":"http://projectandroid.top/Travel/uploads/category/_4.png"},{"category_id":"22","category_name":"โบราณสถานโบราณวัตถุ","category_detail":"โบราณสถานโบราณวัตถุ","category_icon":"http://projectandroid.top/Travel/uploads/category/_36982.jpg"}]
     * status : true
     */

    private boolean status;
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
        /**
         * category_id : 19
         * category_name : สติง
         * category_detail : สติง
         * category_icon : http://projectandroid.top/Travel/uploads/category/_Travel-Beach-icon.png
         */

        private String category_id;
        private String category_name;
        private String category_detail;
        private String category_icon;

        public String getCategory_id() {
            return category_id;
        }

        public void setCategory_id(String category_id) {
            this.category_id = category_id;
        }

        public String getCategory_name() {
            return category_name;
        }

        public void setCategory_name(String category_name) {
            this.category_name = category_name;
        }

        public String getCategory_detail() {
            return category_detail;
        }

        public void setCategory_detail(String category_detail) {
            this.category_detail = category_detail;
        }

        public String getCategory_icon() {
            return category_icon;
        }

        public void setCategory_icon(String category_icon) {
            this.category_icon = category_icon;
        }
    }
}

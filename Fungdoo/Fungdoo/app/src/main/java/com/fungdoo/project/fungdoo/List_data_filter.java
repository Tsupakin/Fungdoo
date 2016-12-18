package com.fungdoo.project.fungdoo;

import java.util.List;

/**
 * Created by warawat on 10/13/2016.
 */

public class List_data_filter {


    /**
     * output : [{"travel_id":"67","category_id":"19","category_name":"สติง","travel_name":"อ้าว","travel_detail":"Atom ชนกันต์","travel_address":"Atom ชนกันต์","travel_menu":"0","url_share":"https://www.youtube.com/watch?v=QyhrOruvT1c","latitude":"0","longitude":"0","telephone":"0","date":"2016-12-18","image_product":[]}]
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
         * travel_id : 67
         * category_id : 19
         * category_name : สติง
         * travel_name : อ้าว
         * travel_detail : Atom ชนกันต์
         * travel_address : Atom ชนกันต์
         * travel_menu : 0
         * url_share : https://www.youtube.com/watch?v=QyhrOruvT1c
         * latitude : 0
         * longitude : 0
         * telephone : 0
         * date : 2016-12-18
         * image_product : []
         */

        private String travel_id;
        private String category_id;
        private String category_name;
        private String travel_name;
        private String travel_detail;
        private String travel_address;
        private String travel_menu;
        private String url_share;
        private String latitude;
        private String longitude;
        private String telephone;
        private String date;
        private List<?> image_product;

        public String getTravel_id() {
            return travel_id;
        }

        public void setTravel_id(String travel_id) {
            this.travel_id = travel_id;
        }

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

        public String getTravel_name() {
            return travel_name;
        }

        public void setTravel_name(String travel_name) {
            this.travel_name = travel_name;
        }

        public String getTravel_detail() {
            return travel_detail;
        }

        public void setTravel_detail(String travel_detail) {
            this.travel_detail = travel_detail;
        }

        public String getTravel_address() {
            return travel_address;
        }

        public void setTravel_address(String travel_address) {
            this.travel_address = travel_address;
        }

        public String getTravel_menu() {
            return travel_menu;
        }

        public void setTravel_menu(String travel_menu) {
            this.travel_menu = travel_menu;
        }

        public String getUrl_share() {
            return url_share;
        }

        public void setUrl_share(String url_share) {
            this.url_share = url_share;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public List<?> getImage_product() {
            return image_product;
        }

        public void setImage_product(List<?> image_product) {
            this.image_product = image_product;
        }
    }
}

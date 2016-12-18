package com.fungdoo.project.fungdoo;

import java.util.List;

/**
 * Created by warawat on 10/13/2016.
 */

public class List_User {
    /**
     * output : [{"id":"27","reg_username":"warawat","reg_pass":"warawat","reg_identification":"1420500059553","reg_name":"warawat sonchang","reg_address":"wa","reg_telephone":"0892810449","reg_email":"warawatsonchang@gmail.com","bank_name":"0","bank_number":"---","bank_account_name":"0"},{"id":"28","reg_username":"wa","reg_pass":"wa","reg_identification":"1420500059557","reg_name":"wa","reg_address":"65","reg_telephone":"0892810449","reg_email":"wa","bank_name":"wa","bank_number":"wa","bank_account_name":"wa"}]
     * status : true
     */

    private boolean status;
    /**
     * id : 27
     * reg_username : warawat
     * reg_pass : warawat
     * reg_identification : 1420500059553
     * reg_name : warawat sonchang
     * reg_address : wa
     * reg_telephone : 0892810449
     * reg_email : warawatsonchang@gmail.com
     * bank_name : 0
     * bank_number : ---
     * bank_account_name : 0
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
        private String id;
        private String reg_username;
        private String reg_pass;
        private String reg_identification;
        private String reg_name;
        private String reg_address;
        private String reg_telephone;
        private String reg_email;
        private String bank_name;
        private String bank_number;
        private String bank_account_name;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getReg_username() {
            return reg_username;
        }

        public void setReg_username(String reg_username) {
            this.reg_username = reg_username;
        }

        public String getReg_pass() {
            return reg_pass;
        }

        public void setReg_pass(String reg_pass) {
            this.reg_pass = reg_pass;
        }

        public String getReg_identification() {
            return reg_identification;
        }

        public void setReg_identification(String reg_identification) {
            this.reg_identification = reg_identification;
        }

        public String getReg_name() {
            return reg_name;
        }

        public void setReg_name(String reg_name) {
            this.reg_name = reg_name;
        }

        public String getReg_address() {
            return reg_address;
        }

        public void setReg_address(String reg_address) {
            this.reg_address = reg_address;
        }

        public String getReg_telephone() {
            return reg_telephone;
        }

        public void setReg_telephone(String reg_telephone) {
            this.reg_telephone = reg_telephone;
        }

        public String getReg_email() {
            return reg_email;
        }

        public void setReg_email(String reg_email) {
            this.reg_email = reg_email;
        }

        public String getBank_name() {
            return bank_name;
        }

        public void setBank_name(String bank_name) {
            this.bank_name = bank_name;
        }

        public String getBank_number() {
            return bank_number;
        }

        public void setBank_number(String bank_number) {
            this.bank_number = bank_number;
        }

        public String getBank_account_name() {
            return bank_account_name;
        }

        public void setBank_account_name(String bank_account_name) {
            this.bank_account_name = bank_account_name;
        }
    }
}

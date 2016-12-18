package com.fungdoo.project.fungdoo;

import java.util.List;

/**
 * Created by warawat on 10/20/2016.
 */

public class Check_Booking {
    /**
     * output : [{"active":"2"}]
     * status : true
     */

    private boolean status;
    /**
     * active : 2
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
        private String active;

        public String getActive() {
            return active;
        }

        public void setActive(String active) {
            this.active = active;
        }
    }
}

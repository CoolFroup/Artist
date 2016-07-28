package com.our.coolgroup.artist.bean;

import java.util.List;

/**
 * Created by samsung on 2016/7/28.
 */
public class SpaceFeesBean {

    /**
     * id : 1
     * range_low : 0
     * range_high : 99
     */

    private List<SpaceDesignFeesBean> space_design_fees;

    public List<SpaceDesignFeesBean> getSpace_design_fees() {
        return space_design_fees;
    }

    public void setSpace_design_fees(List<SpaceDesignFeesBean> space_design_fees) {
        this.space_design_fees = space_design_fees;
    }

    public static class SpaceDesignFeesBean {
        private int id;
        private int range_low;
        private int range_high;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getRange_low() {
            return range_low;
        }

        public void setRange_low(int range_low) {
            this.range_low = range_low;
        }

        public int getRange_high() {
            return range_high;
        }

        public void setRange_high(int range_high) {
            this.range_high = range_high;
        }
    }
}

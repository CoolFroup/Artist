package com.our.coolgroup.artist.bean;

import java.util.List;

/**
 * Created by samsung on 2016/7/28.
 */
public class SpaceSizeBean {

    /**
     * id : 1
     * range_low : 0
     * range_high : 99
     */

    private List<SpaceSizesBean> space_sizes;

    public List<SpaceSizesBean> getSpace_sizes() {
        return space_sizes;
    }

    public void setSpace_sizes(List<SpaceSizesBean> space_sizes) {
        this.space_sizes = space_sizes;
    }

    public static class SpaceSizesBean {
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

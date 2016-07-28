package com.our.coolgroup.artist.bean;

import java.util.List;

/**
 * Created by samsung on 2016/7/28.
 */
public class DesignTypeBean {

    /**
     * id : 3
     * type_id : 1
     * name : 餐饮
     */

    private List<SpaceTypesBean> space_types;

    public List<SpaceTypesBean> getSpace_types() {
        return space_types;
    }

    public void setSpace_types(List<SpaceTypesBean> space_types) {
        this.space_types = space_types;
    }

    public static class SpaceTypesBean {
        private int id;
        private int type_id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getType_id() {
            return type_id;
        }

        public void setType_id(int type_id) {
            this.type_id = type_id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

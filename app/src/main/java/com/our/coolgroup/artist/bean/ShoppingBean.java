package com.our.coolgroup.artist.bean;

import java.util.List;

/**
 * Created by Administrator on 2016/7/28.
 */
public class ShoppingBean {

    /**
     * id : 240
     * seller_id : 2601
     * title : 凹面椅AOchair
     * category : 座椅
     * brand : but design
     * size :
     * intro : #AOchair# 最后一步塑性，需要你来参与。

     第一位使用者，在落座的过程中，椅面上具有延展性的图案将会贴合臀部产生变形，慢慢向下凹陷，从而得到独一无二专属的椅面，并且充分契合使用者的身体，以达到最佳的舒适状态。亲身参与设计并且仅有一次的机会，使TA有趣且珍贵。
     * location :
     * material :
     * design_detail : 材料：不锈钢/碳钢
     颜色：拉丝原色/黑色亚光
     尺寸：380*320*450（mm）
     * craft_detail :
     * life_detail :
     * favs_count : 2
     * lead_time : 7
     * featured : true
     * source : jiangwoo
     * external_url :
     * external_vendor :
     * external_code :
     * status : open
     * designer_rate : 90
     * sample_rate : 100
     * affiliate_available : false
     * created_at : 2016-07-21T05:06:17.118Z
     * updated_at : 2016-07-22T07:50:30.424Z
     * tag_list : []
     * view_count : 281
     * thumb : http://assets.jiangwoo.com/uploads%2Fb148c5e7f87242b9c32f8cdaa719ad04-400x400.jpg
     * video_thumb : null
     * video : null
     * price : 1350.00
     * comments : null
     * product_items : [{"id":365,"title":"黑色（左一）","price":"950.0","thumb":"http://assets.jiangwoo.com/uploads%2F053bd7c648bcde2a091a1c7f36fc37ab-cxcxc.jpg","status":"open","stock":1000},{"id":364,"title":"原色","price":"1350.0","thumb":"http://assets.jiangwoo.com/uploads%2Fc3229e2928fb06b6d5fa2ddde2b3e6ac-400x400.jpg","status":"open","stock":1000}]
     * labels : {"designer":"设计师认证","postage":"包邮","days15":"7天无理由"}
     * image_labels : {"designer":{"text":"设计师认证","kind":"mark","image":"http://assets.jiangwoo.com/uploads%2F7a05942f5674f99e720b67c67f60d8f9-icon_certification_designer_small_2x.png"},"postage":{"text":"包邮","kind":"tag","image":"http://assets.jiangwoo.com/uploads%2F57a9a10c2ddc422a8dd3cb8d52ce31e7-__.png"},"days15":{"text":"7天无理由","kind":"tag","image":"http://assets.jiangwoo.com/uploads%2Ff396acf698d8a3e74e27f55d0531c1c5-15____.png"}}
     * photos : [{"id":2866,"image":"http://assets.jiangwoo.com/uploads%2F313e7a30db50e45b99738f58d71b8543-1000x500.jpg"}]
     * design_photos : [{"id":2865,"image":"http://assets.jiangwoo.com/uploads%2Fcb34bd16e8d6b1907214bf0cfcdc0f89-1__6_.jpg"},{"id":2866,"image":"http://assets.jiangwoo.com/uploads%2F313e7a30db50e45b99738f58d71b8543-1000x500.jpg"},{"id":2867,"image":"http://assets.jiangwoo.com/uploads%2Fcf3e1adeb27eba6c307942b6b1c4a079-1__5_.jpg"}]
     * craft_photos : [{"id":2868,"image":"http://assets.jiangwoo.com/uploads%2F8aaee50f1686e9201609df8ca822a8f2-1__9_.jpg"},{"id":2869,"image":"http://assets.jiangwoo.com/uploads%2F15d4ea23e777f17340ec3868659f71b2-1__10_.jpg"}]
     * life_photos : [{"id":2870,"image":"http://assets.jiangwoo.com/uploads%2F7e05da1e620209a2701dfbe87ad467e6-____1_.jpg"},{"id":2871,"image":"http://assets.jiangwoo.com/uploads%2F32fd90e1ea2b6db4933c24c551ef3f15-20140408043717_.jpg"}]
     */

    private ProductBean product;

    public ProductBean getProduct() {
        return product;
    }

    public void setProduct(ProductBean product) {
        this.product = product;
    }

    public static class ProductBean {
        private int id;
        private int seller_id;
        private String title;
        private String category;
        private String brand;
        private String size;
        private String intro;
        private String location;
        private String material;
        private String design_detail;
        private String craft_detail;
        private String life_detail;
        private int favs_count;
        private int lead_time;
        private boolean featured;
        private String source;
        private String external_url;
        private String external_vendor;
        private String external_code;
        private String status;
        private int designer_rate;
        private int sample_rate;
        private boolean affiliate_available;
        private String created_at;
        private String updated_at;
        private int view_count;
        private String thumb;
        private Object video_thumb;
        private Object video;
        private String price;
        private Object comments;
        /**
         * designer : 设计师认证
         * postage : 包邮
         * days15 : 7天无理由
         */

        private LabelsBean labels;
        /**
         * designer : {"text":"设计师认证","kind":"mark","image":"http://assets.jiangwoo.com/uploads%2F7a05942f5674f99e720b67c67f60d8f9-icon_certification_designer_small_2x.png"}
         * postage : {"text":"包邮","kind":"tag","image":"http://assets.jiangwoo.com/uploads%2F57a9a10c2ddc422a8dd3cb8d52ce31e7-__.png"}
         * days15 : {"text":"7天无理由","kind":"tag","image":"http://assets.jiangwoo.com/uploads%2Ff396acf698d8a3e74e27f55d0531c1c5-15____.png"}
         */

        private ImageLabelsBean image_labels;
        private List<?> tag_list;
        /**
         * id : 365
         * title : 黑色（左一）
         * price : 950.0
         * thumb : http://assets.jiangwoo.com/uploads%2F053bd7c648bcde2a091a1c7f36fc37ab-cxcxc.jpg
         * status : open
         * stock : 1000
         */

        private List<ProductItemsBean> product_items;
        /**
         * id : 2866
         * image : http://assets.jiangwoo.com/uploads%2F313e7a30db50e45b99738f58d71b8543-1000x500.jpg
         */

        private List<PhotosBean> photos;
        /**
         * id : 2865
         * image : http://assets.jiangwoo.com/uploads%2Fcb34bd16e8d6b1907214bf0cfcdc0f89-1__6_.jpg
         */

        private List<DesignPhotosBean> design_photos;
        /**
         * id : 2868
         * image : http://assets.jiangwoo.com/uploads%2F8aaee50f1686e9201609df8ca822a8f2-1__9_.jpg
         */

        private List<CraftPhotosBean> craft_photos;
        /**
         * id : 2870
         * image : http://assets.jiangwoo.com/uploads%2F7e05da1e620209a2701dfbe87ad467e6-____1_.jpg
         */

        private List<LifePhotosBean> life_photos;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getSeller_id() {
            return seller_id;
        }

        public void setSeller_id(int seller_id) {
            this.seller_id = seller_id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getBrand() {
            return brand;
        }

        public void setBrand(String brand) {
            this.brand = brand;
        }

        public String getSize() {
            return size;
        }

        public void setSize(String size) {
            this.size = size;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getMaterial() {
            return material;
        }

        public void setMaterial(String material) {
            this.material = material;
        }

        public String getDesign_detail() {
            return design_detail;
        }

        public void setDesign_detail(String design_detail) {
            this.design_detail = design_detail;
        }

        public String getCraft_detail() {
            return craft_detail;
        }

        public void setCraft_detail(String craft_detail) {
            this.craft_detail = craft_detail;
        }

        public String getLife_detail() {
            return life_detail;
        }

        public void setLife_detail(String life_detail) {
            this.life_detail = life_detail;
        }

        public int getFavs_count() {
            return favs_count;
        }

        public void setFavs_count(int favs_count) {
            this.favs_count = favs_count;
        }

        public int getLead_time() {
            return lead_time;
        }

        public void setLead_time(int lead_time) {
            this.lead_time = lead_time;
        }

        public boolean isFeatured() {
            return featured;
        }

        public void setFeatured(boolean featured) {
            this.featured = featured;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getExternal_url() {
            return external_url;
        }

        public void setExternal_url(String external_url) {
            this.external_url = external_url;
        }

        public String getExternal_vendor() {
            return external_vendor;
        }

        public void setExternal_vendor(String external_vendor) {
            this.external_vendor = external_vendor;
        }

        public String getExternal_code() {
            return external_code;
        }

        public void setExternal_code(String external_code) {
            this.external_code = external_code;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getDesigner_rate() {
            return designer_rate;
        }

        public void setDesigner_rate(int designer_rate) {
            this.designer_rate = designer_rate;
        }

        public int getSample_rate() {
            return sample_rate;
        }

        public void setSample_rate(int sample_rate) {
            this.sample_rate = sample_rate;
        }

        public boolean isAffiliate_available() {
            return affiliate_available;
        }

        public void setAffiliate_available(boolean affiliate_available) {
            this.affiliate_available = affiliate_available;
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

        public int getView_count() {
            return view_count;
        }

        public void setView_count(int view_count) {
            this.view_count = view_count;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public Object getVideo_thumb() {
            return video_thumb;
        }

        public void setVideo_thumb(Object video_thumb) {
            this.video_thumb = video_thumb;
        }

        public Object getVideo() {
            return video;
        }

        public void setVideo(Object video) {
            this.video = video;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public Object getComments() {
            return comments;
        }

        public void setComments(Object comments) {
            this.comments = comments;
        }

        public LabelsBean getLabels() {
            return labels;
        }

        public void setLabels(LabelsBean labels) {
            this.labels = labels;
        }

        public ImageLabelsBean getImage_labels() {
            return image_labels;
        }

        public void setImage_labels(ImageLabelsBean image_labels) {
            this.image_labels = image_labels;
        }

        public List<?> getTag_list() {
            return tag_list;
        }

        public void setTag_list(List<?> tag_list) {
            this.tag_list = tag_list;
        }

        public List<ProductItemsBean> getProduct_items() {
            return product_items;
        }

        public void setProduct_items(List<ProductItemsBean> product_items) {
            this.product_items = product_items;
        }

        public List<PhotosBean> getPhotos() {
            return photos;
        }

        public void setPhotos(List<PhotosBean> photos) {
            this.photos = photos;
        }

        public List<DesignPhotosBean> getDesign_photos() {
            return design_photos;
        }

        public void setDesign_photos(List<DesignPhotosBean> design_photos) {
            this.design_photos = design_photos;
        }

        public List<CraftPhotosBean> getCraft_photos() {
            return craft_photos;
        }

        public void setCraft_photos(List<CraftPhotosBean> craft_photos) {
            this.craft_photos = craft_photos;
        }

        public List<LifePhotosBean> getLife_photos() {
            return life_photos;
        }

        public void setLife_photos(List<LifePhotosBean> life_photos) {
            this.life_photos = life_photos;
        }

        public static class LabelsBean {
            private String designer;
            private String postage;
            private String days15;

            public String getDesigner() {
                return designer;
            }

            public void setDesigner(String designer) {
                this.designer = designer;
            }

            public String getPostage() {
                return postage;
            }

            public void setPostage(String postage) {
                this.postage = postage;
            }

            public String getDays15() {
                return days15;
            }

            public void setDays15(String days15) {
                this.days15 = days15;
            }
        }

        public static class ImageLabelsBean {
            /**
             * text : 设计师认证
             * kind : mark
             * image : http://assets.jiangwoo.com/uploads%2F7a05942f5674f99e720b67c67f60d8f9-icon_certification_designer_small_2x.png
             */

            private DesignerBean designer;
            /**
             * text : 包邮
             * kind : tag
             * image : http://assets.jiangwoo.com/uploads%2F57a9a10c2ddc422a8dd3cb8d52ce31e7-__.png
             */

            private PostageBean postage;
            /**
             * text : 7天无理由
             * kind : tag
             * image : http://assets.jiangwoo.com/uploads%2Ff396acf698d8a3e74e27f55d0531c1c5-15____.png
             */

            private Days15Bean days15;

            public DesignerBean getDesigner() {
                return designer;
            }

            public void setDesigner(DesignerBean designer) {
                this.designer = designer;
            }

            public PostageBean getPostage() {
                return postage;
            }

            public void setPostage(PostageBean postage) {
                this.postage = postage;
            }

            public Days15Bean getDays15() {
                return days15;
            }

            public void setDays15(Days15Bean days15) {
                this.days15 = days15;
            }

            public static class DesignerBean {
                private String text;
                private String kind;
                private String image;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getKind() {
                    return kind;
                }

                public void setKind(String kind) {
                    this.kind = kind;
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }
            }

            public static class PostageBean {
                private String text;
                private String kind;
                private String image;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getKind() {
                    return kind;
                }

                public void setKind(String kind) {
                    this.kind = kind;
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }
            }

            public static class Days15Bean {
                private String text;
                private String kind;
                private String image;

                public String getText() {
                    return text;
                }

                public void setText(String text) {
                    this.text = text;
                }

                public String getKind() {
                    return kind;
                }

                public void setKind(String kind) {
                    this.kind = kind;
                }

                public String getImage() {
                    return image;
                }

                public void setImage(String image) {
                    this.image = image;
                }
            }
        }

        public static class ProductItemsBean {
            private int id;
            private String title;
            private String price;
            private String thumb;
            private String status;
            private int stock;

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

            public String getPrice() {
                return price;
            }

            public void setPrice(String price) {
                this.price = price;
            }

            public String getThumb() {
                return thumb;
            }

            public void setThumb(String thumb) {
                this.thumb = thumb;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public int getStock() {
                return stock;
            }

            public void setStock(int stock) {
                this.stock = stock;
            }
        }

        public static class PhotosBean {
            private int id;
            private String image;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }
        }

        public static class DesignPhotosBean {
            private int id;
            private String image;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }
        }

        public static class CraftPhotosBean {
            private int id;
            private String image;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }
        }

        public static class LifePhotosBean {
            private int id;
            private String image;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }
        }
    }
}

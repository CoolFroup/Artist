package com.our.coolgroup.artist.bean;

/**
 * Created by ZAN on 2016/7/27.
 */
public class RegistBackBean {


    /**
     * error_code : 409
     * error : record_already_exists
     * error_message : 对不起，服务器已有此信息 用户已存在
     */

    private int error_code;
    private String error;
    private String error_message;
    /**
     * id : 2817
     * username : 18310821030
     * bank_name : null
     * bank_account : null
     * email : 8618310821030@jiangwoo.com
     * phone : 8618310821030
     * role : common
     * status : normal
     * brand_name : null
     * brand_detail : null
     * real_name : null
     * display_name : 18310821030
     * company : null
     * contact_address : null
     * intro : null
     * certifications : null
     * display_address : null
     * display_email : null
     * display_phone : null
     * display_homepage : null
     * gender : null
     * location : null
     * country : CN
     * referral_code : WSEPCPUN
     * created_at : 2016-07-27T09:31:25.913Z
     * updated_at : 2016-07-27T09:31:25.953Z
     * thumb : null
     * coupon : null
     * auth_token : xukgWgosWL98jL_RhczE
     */

    private UserBean user;

    public int getError_code() {
        return error_code;
    }

    public void setError_code(int error_code) {
        this.error_code = error_code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }


    public static class UserBean {
        private int id;
        private String username;
        private Object bank_name;
        private Object bank_account;
        private String email;
        private String phone;
        private String role;
        private String status;
        private Object brand_name;
        private Object brand_detail;
        private Object real_name;
        private String display_name;
        private Object company;
        private Object contact_address;
        private Object intro;
        private Object certifications;
        private Object display_address;
        private Object display_email;
        private Object display_phone;
        private Object display_homepage;
        private Object gender;
        private Object location;
        private String country;
        private String referral_code;
        private String created_at;
        private String updated_at;
        private Object thumb;
        private Object coupon;
        private String auth_token;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public Object getBank_name() {
            return bank_name;
        }

        public void setBank_name(Object bank_name) {
            this.bank_name = bank_name;
        }

        public Object getBank_account() {
            return bank_account;
        }

        public void setBank_account(Object bank_account) {
            this.bank_account = bank_account;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getRole() {
            return role;
        }

        public void setRole(String role) {
            this.role = role;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Object getBrand_name() {
            return brand_name;
        }

        public void setBrand_name(Object brand_name) {
            this.brand_name = brand_name;
        }

        public Object getBrand_detail() {
            return brand_detail;
        }

        public void setBrand_detail(Object brand_detail) {
            this.brand_detail = brand_detail;
        }

        public Object getReal_name() {
            return real_name;
        }

        public void setReal_name(Object real_name) {
            this.real_name = real_name;
        }

        public String getDisplay_name() {
            return display_name;
        }

        public void setDisplay_name(String display_name) {
            this.display_name = display_name;
        }

        public Object getCompany() {
            return company;
        }

        public void setCompany(Object company) {
            this.company = company;
        }

        public Object getContact_address() {
            return contact_address;
        }

        public void setContact_address(Object contact_address) {
            this.contact_address = contact_address;
        }

        public Object getIntro() {
            return intro;
        }

        public void setIntro(Object intro) {
            this.intro = intro;
        }

        public Object getCertifications() {
            return certifications;
        }

        public void setCertifications(Object certifications) {
            this.certifications = certifications;
        }

        public Object getDisplay_address() {
            return display_address;
        }

        public void setDisplay_address(Object display_address) {
            this.display_address = display_address;
        }

        public Object getDisplay_email() {
            return display_email;
        }

        public void setDisplay_email(Object display_email) {
            this.display_email = display_email;
        }

        public Object getDisplay_phone() {
            return display_phone;
        }

        public void setDisplay_phone(Object display_phone) {
            this.display_phone = display_phone;
        }

        public Object getDisplay_homepage() {
            return display_homepage;
        }

        public void setDisplay_homepage(Object display_homepage) {
            this.display_homepage = display_homepage;
        }

        public Object getGender() {
            return gender;
        }

        public void setGender(Object gender) {
            this.gender = gender;
        }

        public Object getLocation() {
            return location;
        }

        public void setLocation(Object location) {
            this.location = location;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getReferral_code() {
            return referral_code;
        }

        public void setReferral_code(String referral_code) {
            this.referral_code = referral_code;
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

        public Object getThumb() {
            return thumb;
        }

        public void setThumb(Object thumb) {
            this.thumb = thumb;
        }

        public Object getCoupon() {
            return coupon;
        }

        public void setCoupon(Object coupon) {
            this.coupon = coupon;
        }

        public String getAuth_token() {
            return auth_token;
        }

        public void setAuth_token(String auth_token) {
            this.auth_token = auth_token;
        }
    }
}

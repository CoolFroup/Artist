package com.our.coolgroup.artist.bean;

/**
 * Created by ZAN on 2016/7/27.
 */
public class RegistPostBean {

    /**
     * device : Android
     * version : 1.3.0
     * valid_code : 8763
     * user : {"email":"13643811924","password":"huzan0415","username":"13643811924","country":"CN"}
     */

    private String device;
    private String version;
    private String valid_code;
    /**
     * email : 13643811924
     * password : huzan0415
     * username : 13643811924
     * country : CN
     */

    private UserBean user;

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getValid_code() {
        return valid_code;
    }

    public void setValid_code(String valid_code) {
        this.valid_code = valid_code;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public static class UserBean {
        private String email;
        private String password;
        private String username;
        private String country;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }
}

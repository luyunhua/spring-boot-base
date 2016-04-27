package com.luyh.projectv1.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Created by luyh on 16/4/27.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Member implements Serializable{

        private Long uid;

        private String emplyee_id;

        private Integer gender;

        private String nickname;

        private String uname;

        private String passwd;

        private String email;

        private String portrait;

        private String phone;

        private Integer reg_time;

        private Integer login_num;

        private Integer last_login;

        private String last_ip;

        private Short is_supper;

        public Long getUid() {
            return uid;
        }

        public String getEmplyee_id() {
            return emplyee_id;
        }

        public Integer getGender() {
            return gender;
        }

        public String getNickname() {
            return nickname;
        }

        public String getUname() {
            return uname;
        }

        public String getPasswd() {
            return passwd;
        }

        public String getEmail() {
            return email;
        }

        public String getPortrait() {
            return portrait;
        }

        public String getPhone() {
            return phone;
        }

        public Integer getReg_time() {
            return reg_time;
        }

        public Integer getLogin_num() {
            return login_num;
        }

        public Integer getLast_login() {
            return last_login;
        }

        public String getLast_ip() {
            return last_ip;
        }

        public Short getIs_supper() {
            return is_supper;
        }

        public void setUid(Long uid) {
            this.uid = uid;
        }

        public void setEmplyee_id(String emplyee_id) {
            this.emplyee_id = emplyee_id;
        }

        public void setGender(Integer gender) {
            this.gender = gender;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public void setUname(String uname) {
            this.uname = uname;
        }

        public void setPasswd(String passwd) {
            this.passwd = passwd;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public void setPortrait(String portrait) {
            this.portrait = portrait;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setReg_time(Integer reg_time) {
            this.reg_time = reg_time;
        }

        public void setLogin_num(Integer login_num) {
            this.login_num = login_num;
        }

        public void setLast_login(Integer last_login) {
            this.last_login = last_login;
        }

        public void setLast_ip(String last_ip) {
            this.last_ip = last_ip;
        }

        public void setIs_supper(Short is_supper) {
            this.is_supper = is_supper;
        }

}

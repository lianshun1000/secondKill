package com.miaoshaproject.service.model;

public class UserModel {
    private Integer id;
    private String name;
    private String telephone;
    private Byte gender;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private Integer age;
    private String registerMode;
    private String thirdPartyId;
    private String encrptPassword;

    public String getEncrptPassword() {
        return encrptPassword;
    }

    public void setEncrptPassword(String encrptPassword) {
        this.encrptPassword = encrptPassword;
    }



    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }


    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setRegisterMode(String registerMode) {
        this.registerMode = registerMode;
    }

    public void setThirdPartyId(String thirdPartyId) {
        this.thirdPartyId = thirdPartyId;
    }



    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Byte getGender() {
        return gender;
    }


    public String getTelephone() {
        return telephone;
    }

    public String getRegisterMode() {
        return registerMode;
    }

    public String getThirdPartyId() {
        return thirdPartyId;
    }



}

package com.crab.entity;

/**
 * ClassName: com.crab.entity
 * Function: TODO
 * Reason: TODO
 * Date: 2020/9/16
 *
 * @author zfd
 * @version v0.0.1
 * @since JDK 1.8
 */
public class Address {
    private String province;
    private String city;
    private String town;

    @Override
    public String toString() {
        return "Address{" +
                "province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", town='" + town + '\'' +
                '}';
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Address(String province, String city, String town) {
        this.province = province;
        this.city = city;
        this.town = town;
    }

    public Address() {
        System.out.println("address被创建了");
    }
    public void init(){
        System.out.println("对象被初始化");
    }

    public void destory(){
        System.out.println("对象被销毁");
    }
}

package com.alibaba.ssm.domain;

import com.alibaba.ssm.utils.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author ZhangPeng
 * @Email ZhangPeng1853093@126.com
 * @date 2020/1/28 - 16:10
 */
public class Product {
    // 主键
    private String id;
    // 编号 唯一
    private String productNum;
    // 名称
    private String productName;
    // 出发城市
    private String cityName;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    // 出发时间
    private Date departureTime;
    private String departureTimeStr;
    // 产品价格
    private double productPrice;
    // 产品描述
    private String productDesc;
    private Integer productStatus;
    // 状态 0 关闭 1 开启
    private String productStatusStr;

    public Product(String id, String productNum, String productName, String cityName, Date departureTime, String departureTimeStr, double productPrice, String productDesc, Integer productStatus, String productStatusStr) {
        this.id = id;
        this.productNum = productNum;
        this.productName = productName;
        this.cityName = cityName;
        this.departureTime = departureTime;
        this.departureTimeStr = departureTimeStr;
        this.productPrice = productPrice;
        this.productDesc = productDesc;
        this.productStatus = productStatus;
        this.productStatusStr = productStatusStr;
    }

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProductNum() {
        return productNum;
    }

    public void setProductNum(String productNum) {
        this.productNum = productNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public String getDepartureTimeStr() {
        if(departureTime!=null){
            departureTimeStr= DateUtils.date2String(departureTime, "yyyy-MM-dd HH:mm:ss");
        }
        return departureTimeStr;
    }

    public void setDepartureTimeStr(String departureTimeStr) {
        this.departureTimeStr = departureTimeStr;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public String getProductStatusStr() {
        if(productStatus!=null){
            if(productStatus==0){
                productStatusStr="关闭";
            }
            if(productStatus==1){
                productStatusStr="开启";
            }
        }
        return productStatusStr;
    }

    public void setProductStatusStr(String productStatusStr) {
        this.productStatusStr = productStatusStr;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", productNum='" + productNum + '\'' +
                ", productName='" + productName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", departureTime=" + departureTime +
                ", departureTimeStr='" + departureTimeStr + '\'' +
                ", productPrice=" + productPrice +
                ", productDesc='" + productDesc + '\'' +
                ", productStatus=" + productStatus +
                ", productStatusStr='" + productStatusStr + '\'' +
                '}';
    }

}

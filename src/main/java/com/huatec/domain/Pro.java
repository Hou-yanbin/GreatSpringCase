package com.huatec.domain;

public class Pro {
    private Long id;
    private String productNum;
    private String productName;
    private String productCity;
    private String proDescription;
    private Long numbers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getProductCity() {
        return productCity;
    }

    public void setProductCity(String productCity) {
        this.productCity = productCity;
    }

    public String getProDescription() {
        return proDescription;
    }

    public void setProDescription(String proDescription) {
        this.proDescription = proDescription;
    }

    public Long getNumbers() {
        return numbers;
    }

    public void setNumbers(Long numbers) {
        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return "Pro{" +
                "id=" + id +
                ", productNum='" + productNum + '\'' +
                ", productName='" + productName + '\'' +
                ", productCity='" + productCity + '\'' +
                ", proDescription='" + proDescription + '\'' +
                ", numbers=" + numbers +
                '}';
    }


//    @Override
//    public String toString() {
//        return "Pro{" +
//                "productNum='" + productNum + '\'' +
//                ", productName='" + productName + '\'' +
//                ", productCity='" + productCity + '\'' +
//                ", proDescription='" + proDescription + '\'' +
//                ", numbers=" + numbers +
//                '}';
//    }
}

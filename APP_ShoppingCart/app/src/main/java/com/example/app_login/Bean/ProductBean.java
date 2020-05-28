package com.example.app_login.Bean;

import androidx.annotation.NonNull;

import java.io.Serializable;
/*
* 对象的寿命通常随着生成该对象的程序的终止而终止。
* 有时候，可能需要将对象的状态保存下来，在需要时再将对象恢复。
* 我们把对象的这种能记录自己的状态以便将来再生的能力。叫作对象的持续性(persistence)。
* 对象通过写出描述自己状态的数值来记录自己，这个过程叫对象的串行化(Serialization) 。
* 串行化的主要任务是写出对象实例变量的数值。如果交量是另一对象的引用，则引用的对象也要串行化。
* 这个过程是递归的，串行化可能要涉及一个复杂树结构的单行化，包括原有对象、对象的对象、对象的对象的对象等等。
* 对象所有权的层次结构称为图表(graph)。
*/

public class ProductBean implements Serializable {

    private int imgUrl;
    private double price;
    private String description;


    public ProductBean(int imgUrl, String description, double price) {
        this.imgUrl = imgUrl;
        this.price = price;
        this.description = description;
    }

    public int getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(int imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getPrice() {
        return (int) price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NonNull
    @Override
    public String toString() {     // 串行化机制实现什么接口？java.io.Serializable/Parcelable
        return  "Product{" +
                "imgUrl='" + imgUrl + '\'' +
                "description='"+ description+'\''+
                ", price='" + price + '\'' +
                '}';
    }
}

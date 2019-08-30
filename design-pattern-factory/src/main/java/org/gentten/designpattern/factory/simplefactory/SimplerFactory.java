package org.gentten.designpattern.factory.simplefactory;

import org.gentten.designpattern.factory.product.Product;
import org.gentten.designpattern.factory.product.Product1;
import org.gentten.designpattern.factory.product.Product2;
import org.gentten.designpattern.factory.product.Product3;

/**
 * 简单工厂
 * 隐藏对象创建的复杂性，只关心创建的结果
 * 特点
 * 1、所有产品创建逻辑都包含在里面
 * 2、负责所有产品对象的创建
 * 缺点；随着产品种类的增加以及创建对象越加复杂，代码量越大，越不易维护
 * 所有创建功能都有对现实生活来说是不现实的
 * 无法动态配置
 *
 * @author : duanzhiqiang
 * @date : 2019-08-29 21:18
 */
public class SimplerFactory {

    public static Product getProduct(String productType) {
        switch (productType) {
            case "type1":
                //balabala一一大堆逻辑


                return new Product1();
            case "type2":
                //balabala一一大堆逻辑


                return new Product2();
            case "type3":
                //balabala一一大堆逻辑


                return new Product3();
            default:
                //balabala一一大堆逻辑


                return new Product() {
                };
        }

    }
}

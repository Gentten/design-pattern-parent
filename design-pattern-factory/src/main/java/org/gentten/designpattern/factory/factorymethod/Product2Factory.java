package org.gentten.designpattern.factory.factorymethod;

import org.gentten.designpattern.factory.product.Product;
import org.gentten.designpattern.factory.product.Product1;

/**
 * 产品2工厂
 *
 * @author : duanzhiqiang
 * @date : 2019-08-29 22:41
 */
public class Product2Factory implements ProductFactory {
    @Override
    public Product getProduct() {
        //balabala 一大堆逻辑
        return new Product1();
    }
}

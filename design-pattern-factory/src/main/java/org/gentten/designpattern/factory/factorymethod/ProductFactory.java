package org.gentten.designpattern.factory.factorymethod;

import org.gentten.designpattern.factory.product.Product;

/**
 * 产品工厂（工厂方法，只定义统一的规则）
 * 将不同产品的创建，分发给不同产品工厂去是实现，便于维护（延迟实现，将对象的创建推迟到子类）
 * 符合程序逻辑单一性原则
 *
 * @author : duanzhiqiang
 * @date : 2019-08-29 22:40
 */
public interface ProductFactory {
    /**
     * 创建产品（工厂方法）
     *
     * @return 产品
     */
    Product getProduct();
}

package org.gentten.designpattern.factory.abstractfactory;

import org.gentten.designpattern.factory.factorymethod.Product1Factory;
import org.gentten.designpattern.factory.factorymethod.Product2Factory;
import org.gentten.designpattern.factory.factorymethod.Product3Factory;
import org.gentten.designpattern.factory.product.Product;


/**
 * @author : duanzhiqiang
 * @date : 2019-08-29 22:46
 */
public class AbstractFactory {
    /**
     * 随着产品类型的增多只需要在这里增加case分支就行，而具体的创建逻辑交给对应的工厂去实现了
     * 此处相当于动态配置
     *
     * @param productType
     * @return
     */
    public static Product getProduct(String productType) {
        switch (productType) {
            case "type1":
                //new 一个工厂只是为了简单的说明抽象工厂的模式，而并不是固定这样子
                return new Product1Factory().getProduct();
            case "type2":
                return new Product2Factory().getProduct();
            case "type3":
                //由具体的工厂去实现产品的创建，进一步隐藏
                return new Product3Factory().getProduct();
            default:

                return new Product() {
                };
        }

    }
}
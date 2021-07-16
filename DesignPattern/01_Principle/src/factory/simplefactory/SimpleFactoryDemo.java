package factory.simplefactory;

import java.io.*;

/**
 * 简单工厂模式
 *
 * @author Chenyang
 * @create 2021-07-16-19:38
 */
public class SimpleFactoryDemo {
    public static void main(String[] args) {
        OrderPizza order = new OrderPizza();
        System.out.println("exit from system");
    }
}

abstract class Pizza {
    protected String name;

    public abstract void prepare();

    public void bake() {
        System.out.println(name + "is baking");
    }

    public void box() {
        System.out.println(name + "is boxing");
    }

    public void setName(String name) {
        this.name = name;
    }
}

class GreekPizza extends Pizza {

    @Override
    public void prepare() {
        setName("GreekPizza");
        System.out.println(name + "is preparing");
    }

}

class PepperPizza extends Pizza {

    @Override
    public void prepare() {
        setName("PepperPizza");
        System.out.println(name + "is preparing");
    }

}

class OrderPizza {

    public OrderPizza() {
        Pizza pizza = null;
        String pizzaStr = "";
        do {
            pizzaStr = getType();
            pizza = PizzaFactory.createPizza(pizzaStr);
            if (pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.box();
                System.out.println();
            } else break;
        } while (true);
    }

    public String getType() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("input the pizza style");
            String typeStr = bufferedReader.readLine();
            return typeStr;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

class PizzaFactory {
    public static Pizza createPizza(String pizzaStr) {
        if ("greek".equalsIgnoreCase(pizzaStr)) {
            return new GreekPizza();
        } else if ("pepper".equalsIgnoreCase(pizzaStr)) {
            return new PepperPizza();
        } else {
            return null;
        }
    }
}
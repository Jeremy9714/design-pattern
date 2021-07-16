package factory.absfactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 抽象工厂模式
 *
 * @author Chenyang
 * @create 2021-07-16-20:56
 */
public class AbsFactoryDemo {
    public static void main(String[] args) {
        OrderPizza orderFromItaly = new OrderPizza(new ItalianFactory());
        OrderPizza orderFromSpain = new OrderPizza(new SpanishFactory());
    }
}

abstract class Pizza {
    String name;

    protected abstract void prepare();

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

class ItalianPepperPizza extends Pizza {
    @Override
    protected void prepare() {
        setName("italian pepper pizza");
        System.out.println(name + "is preparing");
    }
}

class ItalianSweatPizza extends Pizza {
    @Override
    protected void prepare() {
        setName("italian sweat pizza");
        System.out.println(name + "is preparing");
    }
}

class SpanishPepperPizza extends Pizza {
    @Override
    protected void prepare() {
        setName("spanish pepper pizza");
        System.out.println(name + "is preparing");
    }
}

class SpanishSweatPizza extends Pizza {
    @Override
    protected void prepare() {
        setName("spanish sweat pizza");
        System.out.println(name + "is preparing");
    }
}

interface Factory {
    Pizza createPizza(String pizzaType);
}

class ItalianFactory implements Factory {
    @Override
    public Pizza createPizza(String pizzaType) {
        if ("pepper".equalsIgnoreCase(pizzaType)) {
            return new ItalianPepperPizza();
        } else if ("sweat".equalsIgnoreCase(pizzaType)) {
            return new ItalianSweatPizza();
        } else return null;
    }
}

class SpanishFactory implements Factory {
    @Override
    public Pizza createPizza(String pizzaType) {
        if ("pepper".equalsIgnoreCase(pizzaType)) {
            return new SpanishPepperPizza();
        } else if ("sweat".equalsIgnoreCase(pizzaType)) {
            return new SpanishSweatPizza();
        } else return null;
    }
}

class OrderPizza {
    Factory factory;

    public OrderPizza(Factory factory) {
        setFactory(factory);
    }

    public void setFactory(Factory factory) {
        this.factory = factory;
        Pizza pizza = null;
        String pizzaType = "";
        do {
            pizzaType = getType();
            pizza = factory.createPizza(pizzaType);
            if (pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.box();
                System.out.println();
            } else break;
        } while (true);
    }

    public String getType() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("input pizza style");
            String pizzaType = bufferedReader.readLine();
            return pizzaType;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
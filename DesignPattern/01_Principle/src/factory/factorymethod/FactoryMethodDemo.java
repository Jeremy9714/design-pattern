package factory.factorymethod;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 工厂方法模式
 *
 * @author Chenyang
 * @create 2021-07-16-20:33
 */
public class FactoryMethodDemo {
    public static void main(String[] args) {
        Factory italianFactory = new ItalianFactory();
        Factory spanishFactory = new SpanishFactory();
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

abstract class Factory {

    public Factory() {
        String pizzaType = "";
        Pizza pizza = null;
        do {
            pizzaType = getType();
            pizza = createPizza(pizzaType);
            if (pizza != null) {
                pizza.prepare();
                pizza.bake();
                pizza.box();
                System.out.println();
            } else break;
        } while (true);
    }

    abstract Pizza createPizza(String pizzaType);

    public String getType() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("input pizza type");
            String line = bufferedReader.readLine();
            return line;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

class ItalianFactory extends Factory {

    @Override
    Pizza createPizza(String pizzaType) {
        if ("pepper".equalsIgnoreCase(pizzaType)) {
            return new ItalianPepperPizza();
        } else if ("sweat".equalsIgnoreCase(pizzaType)) {
            return new ItalianSweatPizza();
        } else return null;
    }
}

class SpanishFactory extends Factory {

    @Override
    Pizza createPizza(String pizzaType) {
        if ("pepper".equalsIgnoreCase(pizzaType)) {
            return new SpanishPepperPizza();
        } else if ("sweat".equalsIgnoreCase(pizzaType)) {
            return new SpanishSweatPizza();
        } else return null;
    }
}
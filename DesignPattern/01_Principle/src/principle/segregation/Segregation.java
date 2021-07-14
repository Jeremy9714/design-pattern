package principle.segregation;

/**
 * 接口隔离原则
 *
 * @author Chenyang
 * @create 2021-07-14-16:17
 */
public class Segregation {
    public static void main(String[] args) {
        A a = new A();
        a.method1(new B());
        a.method2(new B());
        a.method3(new B());

        C c = new C();
        c.method1(new D());
        c.method4(new D());
        c.method5(new D());
    }
}

interface Interface1 {
    void operation1();
}

interface Interface2 {
    void operation2();

    void operation3();
}

interface Interface3 {
    void operation4();

    void operation5();
}

class A {
    void method1(Interface1 b) {
        b.operation1();
    }

    void method2(Interface2 b) {
        b.operation2();
    }

    void method3(Interface2 b) {
        b.operation3();
    }
}

class C {
    void method1(Interface1 d) {
        d.operation1();
    }

    void method4(Interface3 d) {
        d.operation4();
    }

    void method5(Interface3 d) {
        d.operation5();
    }
}

class B implements Interface1, Interface2 {

    @Override
    public void operation1() {
        System.out.println("B is calling operation1");
    }

    @Override
    public void operation2() {
        System.out.println("B is calling operation2");
    }

    @Override
    public void operation3() {
        System.out.println("B is calling operation3");
    }
}

class D implements Interface1, Interface3 {
    @Override
    public void operation1() {
        System.out.println("D is calling operation1");
    }

    @Override
    public void operation4() {
        System.out.println("D is calling operation4");
    }

    @Override
    public void operation5() {
        System.out.println("D is calling operation5");
    }
}
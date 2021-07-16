package principle.composite;

/**
 * 合成复用原则
 *
 * @author Chenyang
 * @create 2021-07-16-11:29
 */
public class Composite {
}

class A {
    private B b = new B(); //组合

//    //聚合
//    private B b;
//    public void setB(B b) {
//        this.b = b;
//    }

    public void method1() {
        b.method2();
    }
}

class B {
    public void method2() {
    }
}
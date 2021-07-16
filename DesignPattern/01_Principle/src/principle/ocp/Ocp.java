package principle.ocp;

/**
 * 开闭原则
 *
 * @author Chenyang
 * @create 2021-07-16-10:12
 */
public class Ocp {
    public static void main(String[] args) {
        GraphicEditor graphicEditor = new GraphicEditor();
        graphicEditor.drawShape(new Rectangle());
        graphicEditor.drawShape(new Triangle());
    }
}

class GraphicEditor {
    public void drawShape(Shape s) {
        s.draw();
    }
}

abstract class Shape {
    int m_type;

    public abstract void draw();
}

class Rectangle extends Shape {
    public Rectangle() {
        super.m_type = 1;
    }

    @Override
    public void draw() {
        System.out.println("draw a rectangle");
    }
}

class Triangle extends Shape {
    public Triangle() {
        super.m_type = 2;
    }

    @Override
    public void draw() {
        System.out.println("draw a triangle");
    }
}
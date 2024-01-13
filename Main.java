// Group:
// Moahamed Ahmed Mohamed Osman (SW01082449)
// Abbas Mohammad Khaled Ali (SW01081578)

abstract class Marks {
    abstract double getPercentage();
}

class A extends Marks {
    private int sub1;
    private int sub2;
    private int sub3;

    public A(int sub1, int sub2, int sub3) {
        this.sub1 = sub1;
        this.sub2 = sub2;
        this.sub3 = sub3;
    }

    double getPercentage() {
        return ((sub1 + sub2 + sub3) / 300.0) * 100;
    }
}

class B extends Marks {
    private int sub1;
    private int sub2;
    private int sub3;
    private int sub4;

    public B(int sub1, int sub2, int sub3, int sub4) {
        this.sub1 = sub1;
        this.sub2 = sub2;
        this.sub3 = sub3;
        this.sub4 = sub4;
    }

    double getPercentage() {
        return ((sub1 + sub2 + sub3 + sub4) / 400.0) * 100;
    }
}

public class Main {
    public static void main(String[] args) {
        A studentA = new A(85, 75, 95);
        B studentB = new B(90, 80, 70, 85);

        System.out.println("Percentage of student A: " + studentA.getPercentage() + "%");
        System.out.println("Percentage of student B: " + studentB.getPercentage() + "%");
    }
}
package models;

public class ClasseA {
    public final ClasseB classeB;

    private int y = 5;

    public ClasseA(ClasseB classeB){
        this.classeB = classeB;
    }

    public int somarValores(){
        int x = this.classeB.getX();
        return x + y;
    }
}

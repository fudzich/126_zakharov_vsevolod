package task;

public class Triangle {
    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA(){
        return a;
    }
    public double getB(){
        return b;
    }
    public double getC(){
        return c;
    }
    public boolean isValid(){
        if ((a<b+c)&&(b<a+c)&&(c<a+b)){
            return true;
        }
        else{
            return false;
        }
    }
    public double square(){
        if ((a<b+c)&&(b<a+c)&&(c<a+b)) {
            double p = (a + b + c) / 2;
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        else{
            return -1;
        }
    }
    public double perimeter(){
        if ((a<b+c)&&(b<a+c)&&(c<a+b)) {
            return (a + b + c);
        }
        else{
            return -1;
        }
    }

}

package ch06클래스;

class Earth {
    static final double EARTH_RADIUS = 64000;
    static final double SURFACE_AREA;
    static{
        SURFACE_AREA = 4*Math.PI*EARTH_RADIUS * EARTH_RADIUS;
    }
}
public class EarthExample {
    public static void main(String[] args) {
        System.out.println(Earth.EARTH_RADIUS);
        System.out.println(Earth.SURFACE_AREA);
        }
}

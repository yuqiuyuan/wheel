package chapter2;

/**
 * Coordinate
 *
 * @author drebander
 * @since 2021-01-04 3:14 上午
 **/
public class Coordinate {
    int x;
    int y;
    String value;

    public Coordinate(int x, int y, String value) {
        this.x = x;
        this.y = y;
        this.value = value;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

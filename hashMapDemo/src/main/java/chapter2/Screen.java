package chapter2;

import java.util.List;

/**
 * Screen
 *
 * @author drebander
 * @since 2021-01-04 3:15 上午
 **/
public class Screen {
    char[][] pixelMatrix = new char[1][];
    private final List<Coordinate> coordinates;

    public Screen(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public void show() {
        coordinates.forEach(coordinate -> {

        });
    }
}

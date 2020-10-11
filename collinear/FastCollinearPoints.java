/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import java.util.Arrays;

public class FastCollinearPoints {
    public FastCollinearPoints(Point[] points) {
        Arrays.sort(points);
        for (int i = 0; i < points.length - 3; i++) {
            for (int j = i + 1; j < points.length - 2; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    points[i].slopeTo(points[j]);
                }
            }
        }
    }

    public int numberOfSegments() {

    }

    public LineSegment[] segments() {

    }

    public static void main(String[] args) {

    }
}

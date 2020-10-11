/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {
    private ArrayList<LineSegment> ls = new ArrayList<LineSegment>();

    public BruteCollinearPoints(Point[] points) {
        int numOfPoints = points.length;
        for (int i = 0; i < numOfPoints; i++) {
            if (points[i] == null) throw new IllegalArgumentException("Not valid input");
        }
        Arrays.sort(points);
        for (int i = 0; i < numOfPoints - 1; i++) {
            for (int j = i + 1; j < numOfPoints; j++) {
                for (int m = i; m < numOfPoints - 1; m++) {
                    for (int k = j + 1; k < numOfPoints; k++) {
                        double slope1 = points[i].slopeTo(points[j]);
                        double slope2 = points[m].slopeTo(points[k]);
                        if (slope1 == slope2) {
                            ls.add(new LineSegment(points[i], points[m]));
                        }
                    }
                }
            }
        }
    }

    public int numberOfSegments() {
        return ls.size();
    }

    public LineSegment[] segments() {
        LineSegment[] segments = ls.toArray(new LineSegment[ls.size()]);
        return segments;
    }
}

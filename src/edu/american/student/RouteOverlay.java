package edu.american.student;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.Projection;

/**
 * Route overlay provides a way to define lines on the mapview
 * @author Cam Cook
 *
 */
public class RouteOverlay extends Overlay 
{

    private GeoPoint gp1;// start point
    private GeoPoint gp2;// end point
    private int color; //color of the line
    
    /**
     * Initializes a new line
     * @param gp1 start point
     * @param gp2 end point 
     * @param color color of the line
     */
    public RouteOverlay(GeoPoint gp1, GeoPoint gp2, int color)
    {
        this.gp1 = gp1;
        this.gp2 = gp2;
        this.color = color;
    }
    
    @Override
    public void draw(Canvas canvas, MapView mapView, boolean shadow) {
        Projection projection = mapView.getProjection();
        Paint paint = new Paint();
        Point point = new Point();
        projection.toPixels(gp1, point);
        paint.setColor(color);
        Point point2 = new Point();
        projection.toPixels(gp2, point2);
        paint.setStrokeWidth(5);
        paint.setAlpha(120);
        canvas.drawLine(point.x, point.y, point2.x, point2.y, paint);
        super.draw(canvas, mapView, shadow);
    }
    
}


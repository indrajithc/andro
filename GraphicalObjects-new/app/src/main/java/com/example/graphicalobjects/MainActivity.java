package com.example.graphicalobjects;


import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    Bitmap bg;
    Canvas canvas;
    Paint paint;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = (ImageView) findViewById(R.id.img);
        bg = Bitmap.createBitmap(720, 1280, Bitmap.Config.ARGB_8888);
        img.setBackgroundDrawable(new BitmapDrawable(bg));

    }
    private void onStartNow (){
        try {

            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        } catch (Exception e){}
        canvas = new Canvas(bg);
        paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setTextSize(50);
    }

    public void Line(View view) {
        onStartNow();
        canvas.drawText("Line", 120, 150, paint);
        canvas.drawLine(50, 250, 520, 1150, paint);
        img.invalidate();

    }

    public void Square(View view) {
        onStartNow();
        canvas.drawText("Square", 120, 150, paint);
        canvas.drawRect(100, 200, 600, 700, paint);
        img.invalidate();

    }

    public void Circle(View view) {
        onStartNow();
        canvas.drawText("Circle", 120, 150, paint);
        canvas.drawCircle(300, 600, 300, paint);
        img.invalidate();


    }

    public void Rectangle(View view) {
        onStartNow();
        canvas.drawText("Rectangle", 120, 150, paint);
        canvas.drawRect(50, 200, 600, 700, paint);
        img.invalidate();
    }

    public void Triangle(View view) {
        onStartNow();
        canvas.drawText("Triangle", 120, 150, paint);



        paint.setColor(Color.WHITE);
        canvas.drawPaint(paint);

        paint.setStrokeWidth(4);
        paint.setColor(android.graphics.Color.RED);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setAntiAlias(true);

        Point a = new Point(0, 0);
        Point b = new Point(0, 100);
        Point c = new Point(87, 50);

        Path path = new Path();
        path.setFillType(Path.FillType.EVEN_ODD);
        path.lineTo(b.x, b.y);
        path.lineTo(c.x, c.y);
        path.lineTo(a.x, a.y);
        path.close();

        canvas.drawPath(path, paint);


        img.invalidate();
    }
}

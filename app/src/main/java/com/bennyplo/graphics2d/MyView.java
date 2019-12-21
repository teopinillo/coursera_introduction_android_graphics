package com.bennyplo.graphics2d;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by benlo on 09/05/2018.
 */

public class MyView extends View {
    private Paint redPaint;
    private Paint bluePaint;
    private Paint greenPaint;
    private Paint rosePaint;
    private Paint blackPaint;
    private Paint gradientPaint;
    private Paint turquoisePaint;
    private Paint orangePaint;
    private Paint yellowPaint;
    private Paint hotPinkPaint;

    private LinearGradient linearGradient;

    private float[] triangle = {100, 100, 200, 200, 200, 200, 100, 200, 100, 200, 100, 100};

    public MyView(Context context) {
        super(context, null);
        //Add your initialisation code here
        initPaints();
    }

    void initGradients(int x0, int y0, int xl, int yl, Shader.TileMode tileMode) {
        linearGradient = new LinearGradient(x0, y0, xl, yl, Color.BLUE, Color.RED, tileMode);
        gradientPaint = new Paint();
        gradientPaint.setStyle(Paint.Style.FILL);
        gradientPaint.setShader(linearGradient);
    }

    void initPaints() {
        //https://www.color-hex.com/color-names.html
        redPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        redPaint.setStyle(Paint.Style.STROKE);//stroke only no fill
        redPaint.setColor(0xffff0000);//color red
        redPaint.setStrokeWidth(5);//set the line stroke width to 5

        bluePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        bluePaint.setStyle(Paint.Style.STROKE);
        bluePaint.setColor(Color.BLUE); //color blue
        bluePaint.setStrokeWidth(5);//set the line stroke width to 5

        greenPaint = new Paint();
        greenPaint.setStyle(Paint.Style.STROKE);
        greenPaint.setARGB(255, 0, 255, 0);
        greenPaint.setStrokeWidth(5);//set the line stroke width to 5

        rosePaint = new Paint();
        rosePaint.setStyle(Paint.Style.FILL);
        rosePaint.setARGB(180, 233, 33, 227);

        blackPaint = new Paint();
        blackPaint.setColor(Color.BLACK);
        blackPaint.setStyle(Paint.Style.STROKE);

        turquoisePaint = new Paint();
        turquoisePaint.setARGB(250, 64, 224, 208);
        turquoisePaint.setStyle(Paint.Style.FILL);

        orangePaint = new Paint();
        orangePaint.setARGB(250, 255, 69, 0);
        orangePaint.setStyle(Paint.Style.FILL);

        yellowPaint = new Paint();
        yellowPaint.setARGB(238, 238, 0, 0);
        yellowPaint.setStyle(Paint.Style.FILL);

        hotPinkPaint = new Paint();
        hotPinkPaint.setARGB(238, 169, 184, 0);
        hotPinkPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //drawPolyine2(canvas);
        //drawPolylineObjectTask(canvas);
        //drawPolyline_1(canvas, Shader.TileMode.CLAMP);
        //drawPolyline_2(canvas, Shader.TileMode.MIRROR);
        //drawPolyline_3(canvas, Shader.TileMode.REPEAT);
        //drawPolyline_4(canvas, Shader.TileMode.MIRROR);
        //drawPolyline_5(canvas, Shader.TileMode.MIRROR);

        //===AFFINE TRANSFORMATION===
        /*
         Affine transformation is a linear transformation on
         the mapping of points and lines without modifying its vertex coordinates.
         For example, these functions allow us to move or rotate a 2D object.
         To convert a vector to homogeneous coordinates, we simply increase the
         dimension of a 2D vector to 3, and assigned the value 1 to the new dimension.Start
         By using homogeneous coordinates, we can perform translation, rotation, scaling, and shear.
         By simply multiplying the homogeneous coordinates with a 3 by 3 transformation matrix.
         */
        //affineTransformationDemo(canvas);

        //===AFFINE TRANSFORMATION QUIZ 1
        //Answer: Bottom-left corner of the screen
        //affineTransformationQuiz_1(canvas);

        //===AFFINE TRANSFORMATION QUIZ 2
        //affineTransformationQuiz_2(canvas);

        //Plotting data and Graphs Quizzes
        //plotting_data_and_graphs(canvas);
        //plotting_data_and_graphs_quiz_1(canvas);

        //#2
        /*
        Plot a sine graph of y = 10*sin(i) using Math.sin() function,
        where i lies between 0 and 50. How many peaks can you found in the plot?
        Answer: 8
        */
        //plotting_data_and_graphs_quiz_2 (canvas);

        //+++++ WEEK 2 ++++++++++++++
        //
    }

    void firstLesson(Canvas canvas) {
        //Add your drawing code here
        //canvas.drawRect(10,30,200,200,redPaint);
        //canvas.drawLines(triangle,bluePaint);
        //canvas.drawCircle (250,250,50, bluePaint);
        //homework 1
        //Modify the sample program to draw 2 circles, with the parameters below, on the screen using the canvas drawing functions.
        //
        //    Circle 1 - Centre at (300,300) with radius 250
        //    Circle 2 - Centre at (500,450) with radius 50
        canvas.drawCircle(300, 300, 250, bluePaint);
        canvas.drawCircle(500, 450, 50, bluePaint);

        //Draw a circle and a square, with the parameters below, on the screen using the canvas drawing functions.
        //
        //1. Square - top left (500,500), bottom right (700,700)
        //
        //2. Circle - Centre at (600,600) with radius X.
        //
        //The output is shown below. Try to figure out what the value of X is.
        canvas.drawRect(500, 500, 700, 700, redPaint);
        //canvas.drawCircle (600,600,120, bluePaint);
        canvas.drawCircle(600, 600, 145, bluePaint);
    }

    void drawPolyine(Canvas canvas) {
        int[] x = {20, 60, 80, 140, 250};
        int[] y = {220, 360, 300, 400, 160};
        Path myLines = new Path();
        myLines.moveTo(x[0], y[0]);
        for (int i = 1; i < x.length; i++) {
            myLines.lineTo(x[i], y[i]);
        }
        myLines.close();
        canvas.drawPath(myLines, rosePaint);
        canvas.drawPath(myLines, blackPaint);
    }

    void drawPolyine2(Canvas canvas) {
        int[] x = {20, 60, 80, 140, 250};
        int[] y = {220, 360, 300, 400, 160};
        Path myLines = new Path();
        myLines.moveTo(x[4], y[4]);
        myLines.lineTo(x[1], y[1]);
        myLines.lineTo(x[3], y[3]);
        myLines.lineTo(x[2], y[2]);
        myLines.lineTo(x[0], y[0]);
        myLines.close();
        canvas.drawPath(myLines, rosePaint);
        canvas.drawPath(myLines, blackPaint);
    }

    //draw polyline using gradient
    //TileMode.MIRROR => Repeat the shader's image horizontally and vertically.

    void drawPolyline_3(Canvas canvas, Shader.TileMode tileMode) {
        int[] x = {20, 160, 250, 370, 550};
        int[] y = {220, 360, 250, 360, 160};
        Path myLines = new Path();
        myLines.moveTo(x[0], y[0]);
        myLines.lineTo(x[1], y[1]);
        myLines.lineTo(x[2], y[2]);
        myLines.lineTo(x[3], y[3]);
        myLines.lineTo(x[4], y[4]);
        myLines.close();
        initGradients(x[0], y[0], x[4], y[4], tileMode);
        canvas.drawPath(myLines, gradientPaint);
    }

    //Excersise: ...change the end point of the linear gradient object to coordinate
    //(150,240). What is the colour in the top-right vertex (ccrner) of the polygon?
    //Answer: BLUE
    //
    void drawPolyline_4(Canvas canvas, Shader.TileMode tileMode) {
        int[] x = {20, 160, 250, 370, 550};
        int[] y = {220, 360, 250, 360, 160};
        Path myLines = new Path();
        myLines.moveTo(x[0], y[0]);
        myLines.lineTo(x[1], y[1]);
        myLines.lineTo(x[2], y[2]);
        myLines.lineTo(x[3], y[3]);
        myLines.lineTo(x[4], y[4]);
        myLines.close();
        initGradients(x[0], y[0], 150, 240, tileMode);
        canvas.drawPath(myLines, gradientPaint);
    }

    //Exercise: change tje end point of the linear gradinet object to coordinate
    //(1000,1000), which lies outside the polygon. How many colours can be found in the polygon
    //in this case?
    //Answer:
    //
    void drawPolyline_5(Canvas canvas, Shader.TileMode tileMode) {
        int[] x = {20, 160, 250, 370, 550};
        int[] y = {220, 360, 250, 360, 160};
        Path myLines = new Path();
        myLines.moveTo(x[0], y[0]);
        myLines.lineTo(x[1], y[1]);
        myLines.lineTo(x[2], y[2]);
        myLines.lineTo(x[3], y[3]);
        myLines.lineTo(x[4], y[4]);
        myLines.close();
        initGradients(x[0], y[0], 1000, 1000, tileMode);
        canvas.drawPath(myLines, gradientPaint);
    }

    void drawPolylineObjectTask(Canvas canvas) {

        Path myLines = new Path();
        myLines.moveTo(50, 300);
        myLines.lineTo(160, 280);
        myLines.lineTo(300, 380);
        myLines.lineTo(380, 370);
        myLines.lineTo(280, 450);
        myLines.lineTo(100, 390);
        myLines.lineTo(160, 380);
        myLines.lineTo(50, 300);
        myLines.close();

        canvas.drawPath(myLines, rosePaint);
        canvas.drawPath(myLines, blackPaint);

        int centerX = (50 + 160 + 300 + 380 + 280 + 100 + 160 + 50) / 8;
        int centerY = (300 + 280 + 380 + 370 + 450 + 390 + 380 + 300) / 8;
        Paint circlePaint = new Paint();
        circlePaint.setARGB(100, 204, 102, 0);
        canvas.drawCircle(centerX, centerY, 250, circlePaint);
        canvas.drawCircle(centerX, centerY, 250, blackPaint);
    }

    Path createPath(Point[] points) {
        Path path = new Path();
        path.moveTo(points[0].x, points[0].y);
        for (int i = 1; i < points.length; i++) {
            path.lineTo(points[i].x, points[i].y);
        }
        path.close();
        return path;
    }

    void affineTransformationDemo(Canvas canvas) {
        Point[] points;
        Point[] newPoints;
        Path object;

        points = new Point[5];
        points[0] = new Point(50, 300);
        points[1] = new Point(150, 400);
        points[2] = new Point(180, 340);
        points[3] = new Point(240, 420);
        points[4] = new Point(300, 200);

        object = createPath(points);
        initGradients(points[0].x, points[0].y, points[4].x, points[4].y, Shader.TileMode.CLAMP);
        canvas.drawPath(object, gradientPaint);

        //do transaltion
        newPoints = translate(points, 20, 40);
        object = createPath(newPoints);
        canvas.drawPath(object, blackPaint);

        //do Shear
        newPoints = shear(points, 30, 30);
        object = createPath(newPoints);
        canvas.drawPath(object, rosePaint);

        //do rotation
        newPoints = rotation(points, 45);
        object = createPath(newPoints);
        canvas.drawPath(object, greenPaint);

        //do Scaling
        newPoints = scaling(points, 1.5, 1.5);
        object = createPath(newPoints);
        canvas.drawPath(object, redPaint);


    }

    /*
        |  m00    m01    m02  |  | xi |
        |  m10    m11    m12  |  | yi |
        |  0      0       1   |  | 1  |
     */
    private Point[] affineTransformation(Point[] vertices, double[][] matrix) {
        Point[] result = new Point[vertices.length];
        for (int i = 0; i < vertices.length; i++) {
            int xt = (int) Math.abs(((matrix[0][0] * vertices[i].x) + (matrix[0][1] * vertices[i].y) + matrix[0][2]) * 1);
            int yt = (int) Math.abs(((matrix[1][0] * vertices[i].x) + (matrix[1][1] * vertices[i].y) + matrix[1][2]) * 1);
            Log.i("Graphics2D", i + ", (" + xt + " , " + yt + " )");
            result[i] = new Point(xt, yt);
        }
        return result;
    }

    /*
       | xti |     | 1  0  a | | xi |
       | yti |  =  | 0  1  b | | yi |
       |  1  |     | 0  0  1 | | 1  |
     */
    Point[] translate(Point[] input, double px, double py) {
        double[][] matrix = new double[3][3];
        matrix[0][0] = 1;
        matrix[0][1] = 0;
        matrix[0][2] = px;
        matrix[1][0] = 0;
        matrix[1][1] = 1;
        matrix[1][2] = py;
        matrix[2][0] = 0;
        matrix[2][1] = 0;
        matrix[2][2] = 1;
        return affineTransformation(input, matrix);
    }

    /*
       | xti |    | 1   shx  0 | | xi |
       | yti |    | shy  1   0 | | yi |
       |  1  |    | 0    0   1 | | 1  |
     */
    Point[] shear(Point[] input, int shx, int shy) {
        double[][] matrix = new double[3][3];
        matrix[0][0] = 1;
        matrix[0][1] = (int) Math.tan(Math.toRadians(shx));
        matrix[0][2] = 0;

        matrix[1][0] = (int) Math.tan(Math.toRadians(shy));
        matrix[1][1] = 1;
        matrix[1][2] = 0;

        matrix[2][0] = 0;
        matrix[2][1] = 0;
        matrix[2][2] = 1;
        return affineTransformation(input, matrix);
    }

    Point[] rotation(Point[] input, double angle) {
        angle = Math.toRadians(angle);
        double[][] matrix = new double[3][3];
        matrix[0][0] = Math.cos(angle);
        matrix[0][1] = Math.sin(angle) * -1;
        matrix[0][2] = 0;

        matrix[1][0] = Math.sin(angle);
        matrix[1][1] = Math.cos(angle);
        matrix[1][2] = 0;

        matrix[2][0] = 0;
        matrix[2][1] = 0;
        matrix[2][2] = 1;
        return affineTransformation(input, matrix);
    }

    Point[] scaling(Point[] input, double xf, double yf) {
        double[][] matrix = new double[3][3];
        matrix[0][0] = xf;
        matrix[0][1] = 0;
        matrix[0][2] = 0;

        matrix[1][0] = 0;
        matrix[1][1] = yf;
        matrix[1][2] = 0;

        matrix[2][0] = 0;
        matrix[2][1] = 0;
        matrix[2][2] = 1;

        return affineTransformation(input, matrix);
    }

    /*
    Modify the example program by implementing the affine transform functions to transform
    your polygon (filled with gradient colour) as follows:
    1-Shear your polygon in the x-direction by factor of 2.
    2-Scale your polygon in the x-direction by 0.5 and y-direction by 3.
    3-Rotate your polygon by 45 degrees (Note: you need to convert to radian angle to perform the rotation).
    4-Translate your polygon by 550 pixels in the x-direction.

    Draw your polygon with the linear gradient colour (defined in our previous exercise).
    Then run your app.

    Which direction are the red tips of the polygon pointing?
    Answer: Top-right corner of the screen



     */
    void affineTransformationQuiz_1(Canvas canvas) {
        Point[] points;
        Point[] newPoints;
        Path object;

        points = new Point[5];
        points[0] = new Point(50, 300);
        points[1] = new Point(150, 400);
        points[2] = new Point(180, 340);
        points[3] = new Point(240, 420);
        points[4] = new Point(300, 200);

        newPoints = shear(points, 2, 0);
        newPoints = scaling(newPoints, 0.5, 0.5);
        newPoints = rotation(newPoints, 45);
        newPoints = translate(newPoints, 550, 0);
        object = createPath(newPoints);
        initGradients(points[0].x, points[0].y, points[4].x, points[4].y, Shader.TileMode.CLAMP);
        canvas.drawPath(object, gradientPaint);
    }

    /*
    Modify the example program by implementing the affine transform functions to transform
    your polygon (filled with gradient colour) as follows:

    1. Define a new polygon with 4 coordinates as follows:
       points[0] = new Point(500,300);
       points[1] = new Point(500,400);
       points[2] = new Point(600,400);
       points[3] = new Point(600,300);

    2. Calculate the centre of the polygon.

    3. Before rotating the polygon, minus the centre for each point to obtain the updated coordinates.

    4. Rotate your polygon by 45 degrees (Note: you need to convert to radian angle to perform the rotation).

    5. Add the centre back to each point.

    Draw your polygon with a linear gradient colour. This should have the starting and end point
    of the linear gradient object to coordinates (500,400) and (600,300) respectively.

    What does the polygon look like?
    */

    void affineTransformationQuiz_2(Canvas canvas) {
        Point[] points;
        Point[] newPoints;
        Path object;

        points = new Point[4];
        //int xc = 550;
        //int yc = 350;
        //Log.i ("Graphics2D", "xc = "+ xc);
        //Log.i ("Graphics2D", "yc = "+ yc);

        points[0] = new Point(500, 300);
        points[1] = new Point(500, 400);
        points[2] = new Point(600, 400);
        points[3] = new Point(600, 300);
        points = rotation(points, 45);
        object = createPath(points);
        //initGradients(points[0].x, points[0].y, points[3].x, points[3].y, Shader.TileMode.REPEAT);
        initGradients(500, 400, 600, 300, Shader.TileMode.REPEAT);
        canvas.drawPath(object, gradientPaint);
    }


    void plotting_data_and_graphs(Canvas canvas) {
        Path linegraph;
        //70 is the high of the bottom control bar
        int viewheight = getResources().getDisplayMetrics().heightPixels - 70;
        int viewwidth = getResources().getDisplayMetrics().widthPixels;

        int[] plotData = {11, 29, 10, 20, 12, 5, 31, 24, 21, 13};
        Point[] ptarray = new Point[plotData.length];
        int minvalue = 999999;
        int maxvalue = -99999;
        for (int i = 0; i < plotData.length; i++) {
            ptarray[i] = new Point(i, plotData[i]);
            minvalue = Math.min(minvalue, plotData[i]);
            maxvalue = Math.max(maxvalue, plotData[i]);
        }

        ptarray = translate(ptarray, 0, -minvalue);
        double yscale = viewheight / (double) (maxvalue - minvalue);
        double xscale = viewwidth / (double) (plotData.length - 1);
        ptarray = scaling(ptarray, xscale, yscale);
        Path result = new Path();
        result.moveTo(ptarray[0].x, ptarray[0].y);
        for (int i = 1; i < ptarray.length; i++) {
            result.lineTo(ptarray[i].x, ptarray[i].y);
        }
        canvas.drawPath(result, redPaint);
    }

    // plotting data like a Pastel.
    //Color are randoms

    void plotting_data_and_graphs_quiz_1(Canvas canvas) {
        //get the view size
        int viewheight = getResources().getDisplayMetrics().heightPixels - 100;
        int viewwidth = getResources().getDisplayMetrics().widthPixels;
        RectF oval = new RectF();
        int top = (viewheight - viewwidth) / 2;
        oval.set(0, top, viewwidth, top + viewwidth);

        //Random value for colors
        Random randomColor = new Random();

        int[] plotData = {20, 15, 34, 19, 38};
        //int plotData[] = {25,25,25,25,25};
        ArrayList<Float> arcs = new ArrayList<>();

        //find max value, maxV =100% = 360 grade
        int maxV = 0;
        for (int i = 0; i < plotData.length; i++) {
            maxV += plotData[i];
        }
        //adjusting data to percent
        // arc = value * 360 / maxV;
        float lastAngle = 0;

        for (int i = 0; i < plotData.length; i++) {
            float arc = plotData[i] * 360 / maxV;
            arcs.add(Float.valueOf(arc));
            lastAngle += arc;
        }
        float adjust = 360 - lastAngle;
        float startAngle = 0;
        float angle = 0;
        for (int i = 0; i < arcs.size(); i++) {
            angle = arcs.get(i);
            //Creates a Random Color
            Paint paint = new Paint();
            paint.setARGB(randomColor.nextInt(255),
                    randomColor.nextInt(255),
                    randomColor.nextInt(255),
                    randomColor.nextInt(255));

            //if the last? then add the adjust angle to end at 360
            if (i == arcs.size() - 1) angle += adjust;
            canvas.drawArc(oval, startAngle, angle, true, paint);
            startAngle += angle;
        }
    }

    void plotting_data_and_graphs_quiz_2(Canvas canvas) {
        //y = 10 * Math.sin(x);
        ArrayList<Float> points = new ArrayList<>();
        float width = 300;
        float lastX = 50;
        float incByX = lastX / width;
        int dx = 100;
        int dy = 100;
        int alt = 5;

        float x = 0;
        int i = 0;
        float[] graph = new float[(int) width * 2];
        while (x < lastX) {
            float y = (float) (10 * Math.sin(x));
            graph[i] = dx + i++;
            graph[i++] = (dy + y) * alt;
            x += incByX;
        }
        canvas.drawPoints(graph, redPaint);

    }


}


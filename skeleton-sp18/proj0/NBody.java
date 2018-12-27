public class NBody{
  public static String imgStarField = "images\\starfield.jpg";

  public static Double readRadius(String planetsTxtPath){
    In in = new In(planetsTxtPath);
    int N = in.readInt();
    Double uni_Radius = in.readDouble();
    return uni_Radius;
  }

  public static Planet[] readPlanets(String planetsTxtPath){
    In in = new In(planetsTxtPath);
    int N = in.readInt();
    in.readDouble();
    int i = 0;
    Planet[] planetsArray = new Planet[N];
    while(i < N){
      Double xPo = in.readDouble();
      Double yPo = in.readDouble();
      Double xVe = in.readDouble();
      Double yVe = in.readDouble();
      Double ma = in.readDouble();
      String imgs = "images\\" + in.readString();
      planetsArray[i] = new Planet(xPo, yPo, xVe, yVe, ma, imgs);
      i++;
    }
    return planetsArray;
  }



  public static void drawStarField(double radius) {
    /** Sets up the universe so it goes from
      * universe radius */
    StdDraw.setScale(-radius, radius);
    StdDraw.picture(0, 0, imgStarField);
    StdDraw.show();
  }

  public static void main(String[] args){
    Double T = Double.parseDouble(args[0]),
          dt = Double.parseDouble(args[1]);
    String filename = args[2];
    In in = new In(filename);
    int N = in.readInt();
    StdDraw.enableDoubleBuffering();
    Double uRadius = NBody.readRadius(filename);
    System.out.println(uRadius);

    drawStarField(uRadius);
    //draw planets
    Planet[] planetsArray = NBody.readPlanets(filename);
    // for (Planet planet : planetsArray){
    //   planet.draw();
    //   // System.out.println(planet.imgFileName);
    //   // System.out.println(planet.xxPos);
    //   // System.out.println(planet.yyPos);
    // }
    // Animation loop;
    Double timeStart = 0.0;
    while (timeStart < T){
      double[] xForces = new double[N];
      double[] yForces = new double[N];
      for (int i = 0; i < planetsArray.length; i++){
        xForces[i] = planetsArray[i].calcNetForceExertedByX(planetsArray);
        yForces[i] = planetsArray[i].calcNetForceExertedByY(planetsArray);
      }
      drawStarField(uRadius);
      for (int i = 0; i < planetsArray.length; i++){
        planetsArray[i].update(dt, xForces[i], yForces[i]);
        planetsArray[i].draw();
      }
      StdDraw.show();
      StdDraw.pause(10);
      timeStart += dt;
    }
    StdOut.printf("%d\n", planets.length);
    StdOut.printf("%.2e\n", radius);
    for (int i = 0; i < planets.length; i++) {
        StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                      planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                      planets[i].yyVel, planets[i].mass, planets[i].imgFileName);
    }
  }
}

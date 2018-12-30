public class Planet{
    public double xxPos,
                  yyPos,
                  xxVel,
                  yyVel,
                  G = 6.67e-11,
                  mass;
    public String imgFileName = "images\\jupiter.gif";

    public Planet(double xP, double yP, double xV, double yV,
                                        double m, String img){
      this.xxPos = xP;
      this.yyPos = yP;
      this.xxVel = xV;
      this.yyVel = yV;
      this.mass = m;
      this.imgFileName = img;
    }

    public Planet(Planet p){
      // Planet copyPlanet = new Planet(p.xxPos, p.yyPos, p.xxVel, p.yyVel,
      //                                p.mass, p.imgFileName);      public Planet(Planet p) {
      this.xxPos = p.xxPos;
      this.yyPos = p.yyPos;
      this.xxVel = p.xxVel;
      this.yyVel = p.yyVel;
      this.mass = p.mass;
      this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p){
      return Math.sqrt((this.xxPos - p.xxPos) * (this.xxPos - p.xxPos) +
                        (this.yyPos - p.yyPos) * (this.yyPos - p.yyPos));
    }

    public double calcForceExertedBy(Planet p){
      double distance = this.calcDistance(p);
      return this.mass * p.mass * G / (distance * distance);
    }

    public double calcForceExertedByX(Planet p){
      return this.calcForceExertedBy(p) *
             (p.xxPos - this.xxPos) / this.calcDistance(p);
    }

    public double calcForceExertedByY(Planet p){
      return this.calcForceExertedBy(p) *
             (p.yyPos - this.yyPos) / this.calcDistance(p);
    }

    public double calcNetForceExertedByX(Planet[] pArray){
      double netForceX = 0;
      for(int i = 0; i < pArray.length; i++){
        if (this.equals(pArray[i]) != true){
          netForceX += this.calcForceExertedByX(pArray[i]);
        }
      }
      return netForceX;
    }
    // less verbose for loop
    public double calcNetForceExertedByY(Planet[] pArray){
      double netForceY = 0;
      for(Planet p: pArray){
        if (this.equals(p) != true){
          netForceY += this.calcForceExertedByY(p);
        }
      }
      return netForceY;
    }
    public void update(double dt, double xxForce, double yyForce){
      double xxAcce = xxForce / this.mass;
      double yyAcce = yyForce / this.mass;
      this.xxVel = this.xxVel + dt * xxAcce;
      this.yyVel = this.yyVel + dt * yyAcce;
      this.xxPos = this.xxPos + dt * this.xxVel;
      this.yyPos = this.yyPos + dt * this.yyVel;
    }

    public void draw(){
      StdDraw.picture(this.xxPos, this.yyPos, this.imgFileName);
    }
}// End Planet

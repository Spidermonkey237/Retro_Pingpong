package pingpong;
import processing.core.PGraphics;


public class Ball implements GameEntity {
float x,y,speedX,speedY,diameter;
 int color ;
 
 public Ball(float x_fict , float y_fict, float diameter_fict ,int color) {
	 x= x_fict;
	 y= y_fict;
	 diameter= diameter_fict;
	 speedX=0;
	 speedY=0;
	 this.color= color;
}
 
 public void move() {
	 x = speedX + x;
	 y = speedY + y;
 }
  public void display(PGraphics g) {
	  g.fill(color);
	  g.noStroke();
	  g.ellipse(x,y,diameter,diameter);
  }
  
  float left(){
	    return x-diameter/2;
	  }
	  float right(){
	    return x+diameter/2;
	  }
	  float top(){
	    return y-diameter/2;
	  }
	  float bottom(){
	    return y+diameter/2;
	  }
}
 
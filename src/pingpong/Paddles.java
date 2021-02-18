package pingpong;
import processing.core.PGraphics;

public class Paddles implements GameEntity {
	float x,y,w,h,speedY,speedX;
	int color ;
	  
	  Paddles(float X_fict, float Y_fict, float W_fict, float H_fict, int color){
	    x = X_fict;
	    y = Y_fict;
	    w = W_fict;
	    h = H_fict;
	    speedY = 0;
	    speedX = 0;
	    this.color=color;
	  }

	  public void move(){
	    y += speedY;
	    x += speedX;
	  }

	  public void display(PGraphics g){
	    g.fill(color);
	    g.stroke(190,190,190);
	    g.rect(x-w/2,y-h/2,w,h,10);
	  } 
	  
	  
	  float left(){
	    return x-w/2;
	  }
	  float right(){
	    return x+w/2;
	  }
	  float top(){
	    return y-h/2;
	  }
	  float bottom(){
	    return y+h/2;
	  }
	}


package pingpong;

import processing.core.PApplet;
import processing.core.PImage;
import processing.sound.*;

public class PongGame extends PApplet {
    
    Ball ball;
    Paddles leftPaddle, rightPaddle;
    SoundFile file;
    SoundFile bounce;
    SoundFile outbound;
    SoundFile gameOver;
    int scoreLeft=0 ;
    int scoreRight=0 ;
    PImage fond;

    public static void main(String[] args) {
		PApplet.runSketch(new String[]{""}, new PongGame());
    }
    
    public void settings() {
    	size (800,600);
    }
    public void setup() {
     file = new SoundFile( this,"venus.wav");
     bounce = new SoundFile(this,"hit.wav" );
     outbound =new SoundFile(this, "coin.wav");
     gameOver = new SoundFile (this, "gameOver.wav");
     //outbound.play();
     file.loop();
    
     //fond = loadImage("Fond.png");
     ball= new Ball(width/2 , height/2 ,20 ,color(250,250,255));
     leftPaddle = new Paddles(15,height/2,20,150,color(0,0,255));
     rightPaddle = new Paddles(width-15,height/2,20,150,color(255,0,0));
     ball.speedX=6;
     ball.speedY = random(-3,7);
   }
    
    public void keyPressed(){
    	  if(keyCode == UP){
    	    rightPaddle.speedY=-6;
    	  }
    	  if(keyCode == DOWN){
    	    rightPaddle.speedY=6;
    	  }
    	  if(key == 'w' || key =='W'){
    	    leftPaddle.speedY=-6;
    	  }
    	  if(key == 's' || key == 'S'){
    	    leftPaddle.speedY=6;
    	  }
    	}

    	public void keyReleased(){
    	  if(keyCode == UP){
    	    rightPaddle.speedY=0;
    	  }
    	  if(keyCode == DOWN){
    	   rightPaddle.speedY=0;
    	  }
    	  if(key == 's' || key == 'S'){
    	    leftPaddle.speedY=0;
    	  }
    	  if(key == 'w' || key =='W'){
    		  leftPaddle.speedY=0;
    	  }
    	}
    
    public void draw() {
    	 
    	//image(fond,0,0);
    	background(0);
    	stroke(255);
    	line(width/2,0,width/2,height);
    	line(1,1,width-1,1);
    	line(1,1,1,height-1);
    	line(1,height-1,width-1,height-1);
    	line(width-1,1,width-1,height-1);
    	ball.move();
    	ball.display(g);
    	leftPaddle.move();
    	leftPaddle.display(g);
        rightPaddle.move();
        rightPaddle.display(g);
        
    //Rebonds of the Wall.
        
    if (ball.right()> width) {
    	scoreLeft = scoreLeft + 1;
        ball.x = width/2;
        ball.y = height/2;
        outbound.play();
    }   
    if ( ball.left() < 0) {
    	scoreRight = scoreRight + 1;
        ball.x = width/2;
        ball.y = height/2;
        outbound.play();
    }
    
    if(ball.bottom() > height) {
    	ball.speedY= -ball.speedY;
    	bounce.play();
    }
    if (ball.top()< 0) {
    	ball.speedY = -ball.speedY;
    	bounce.play();
    }
    
    // Damit die Schlägern nicht verschwinden.
    
    if (leftPaddle.bottom() > height) {
    	leftPaddle.y = height-leftPaddle.h/2;
      }

      if (leftPaddle.top() < 0) {
        leftPaddle.y = leftPaddle.h/2;
      }
        
      if (rightPaddle.bottom() > height) {
        rightPaddle.y = height-rightPaddle.h/2;
      }

      if (rightPaddle.top() < 0) {
        rightPaddle.y = rightPaddle.h/2;
        }
     
       
      
     // Kollision mit Schlägern und unboring
     
      if ( ball.left() < leftPaddle.right() && ball.y > leftPaddle.top() && ball.y < leftPaddle.bottom()){
           ball.speedX = -ball.speedX;//kollison boring töten
    	    ball.speedY = map(ball.y - leftPaddle.y, -leftPaddle.h/2, leftPaddle.h/2, -12, 12);
    	    bounce.play();
    	  }

    	  if ( ball.right() > rightPaddle.left() && ball.y > rightPaddle.top() && ball.y < rightPaddle.bottom()) {
    	    ball.speedX = -ball.speedX;//kollision
    	    ball.speedY = map(ball.y - rightPaddle.y, -rightPaddle.h/2, rightPaddle.h/2, -12, 12);//boring töten
    	    bounce.play();
    	}
      
      
      textSize(40);
      textAlign(CENTER);
      fill(255);
      text(scoreRight, width/2+40, 35); // Right score
      text(scoreLeft, width/2-40, 35); // Left  score
      
      if (scoreLeft == 10) {
    	  background (0);
    	  textSize (40);
    	  textAlign (CENTER);
    	  text("Player one you win",width/2,height/2);
    	  gameOver.play();
      }
       if (scoreRight == 10) {
    	   background (0);
     	  textSize (40);
     	  textAlign (CENTER);
     	  text("Player one two win",width/2,height/2);
     	  gameOver.play();
    	   
       }
     
   
    
}
    
}
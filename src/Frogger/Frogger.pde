Car c1 = new Car();
Car c2 = new Car();
Car c3 = new Car();
  //||||cary>=390||cary>=10
public class Car{
 int carx = 100;
  int cary = 70;

  int spd  = 1;
  int size = 50;
  void display() 
{
      fill(0,255,0);
      rect(carx , cary, size, 50);
}
int getX(){
  return carx;
}
int getY(){
  return cary;
}
int getSize(){
  return size;
}
void moveLeft(){
  carx=carx-spd;
  if(carx<=10){
    carx = 390;
  }
  display();
}
void moveRight(){
  carx=carx+spd;
  if(carx>=width){
    carx=10;
  }
  display();
}
}
int a=0;
void setup(){
  size(400,400);
}
int points=0;
int x=200;
int y=390;
void draw(){
  background(50,100,150);
  fill(100,150,50);
  ellipse(x,y,20,20);
  outside();
  fill(0,0,0);
  textSize(20);
    text(points, 350, 50);
c1.cary=220;

c1.moveLeft();
 c2.moveRight();
 c2.display();
if( intersects(c1)){
  exit();
}
else if( intersects(c2)){
  exit();
}

}
void outside(){
  if(x<=10||x>=395||y>=390){
    x=200;
    y=350;
  }
 else if(y<=10){
     x=200;
    y=350;
   points++;
    a = (int) random(1, 2);
   if(a==1){
     c1.spd++;
   }
   
    else if(a==2){
     c2.spd++;
   }
 
  
   
  }

}
boolean intersects(Car car) {
      if ((y > c1.getY() && y < c1.getY()+50) && (x > c1.getX() && x < c1.getX()+car.getSize()))
      {
             return true;
      }
       else if ((y > c2.getY() && y < c2.getY()+50) && (x > c2.getX() && x < c2.getX()+car.getSize()))
      {
             return true;
      }
      else 
      {
             return false;
      }
      }
void keyPressed()
{
      if(key == CODED){
            if(keyCode == UP)
            {
                  //Frog Y position goes up
                  y=y-5;
            }
            else if(keyCode == DOWN)
            {
                  //Frog Y position goes down 
                  y=y+5;
            }
            else if(keyCode == RIGHT)
            {
                  //Frog X position goes right
                  x=x+5;
            }
            else if(keyCode == LEFT)
            {
              x=x-5;
                  //Frog X position goes left
            }
      }
}
 
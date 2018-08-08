Car c1 = new Car();
Car c2 = new Car();
Car c3 = new Car();
Car c4 = new Car(); 
Car c5 = new Car();
Car c6 = new Car();
Car c7 = new Car();
 int carx = 100;
  int cary = 100;
  int spd  = 10;
  int size = 50;
  //||||cary>=390||cary>=10
public class Car{

  void display() 
{
      fill(0,255,0);
      rect(carx , cary, size, 50);
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
void setup(){
  size(400,400);
}
int x=200;
int y=390;
void draw(){
  background(50,100,150);
  fill(100,150,50);
  ellipse(x,y,20,20);
  outside();
 c1.display();
 c2.moveLeft();
 c3.moveRight();
 
}
void outside(){
  if(x<=10||x>=395||y<=10||y>=390){
    x=200;
    y=200;
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
 
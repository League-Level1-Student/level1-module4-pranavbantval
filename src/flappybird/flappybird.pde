  import ddf.minim.*;
  void setup() {
    size(1000, 1000);
    minim = new Minim (this);
    sound = minim.loadSample("OOF.mp3", 128);
  }
Minim minim;
AudioSample sound;  
  int x = 500;
  int y = 500;
  int byv = 10;
  int ph = (int) random(100, 400);
  int ph2 = (int) random(100, 400);
  int gravity = 1;
  int px = 950;
  int pw = 100;
  int points = 0;
  void draw() {

    background(250, 30, 40);
    fill(75, 85, 100);
    stroke(255, 200, 100);
    ellipse(x, y, 20, 20);
    fill(30, 350, 60);
    rect(px, 0, pw, ph);
    fill(30, 350, 60);
    rect(px, 1000 - ph2, pw, ph2);
    px = px - 5;
    y = y + gravity;
    fill(0,0,0);
    rect(00,990,1000,10);
    textSize(100);
    text(points, 800, 100);
    if (mousePressed) {
      y = y - byv;
sound.trigger();
    }
    if(px==x){
      points++;
    }
    if (px < 50) {
      px = 950;
      ph = (int) random(100, 400);
      ph2 = (int) random(100, 400);
      
    }
    boolean oof = intersectsPipes();
    if (oof||y>=990) {
    exit();
    }
   
  }

boolean intersectsPipes(){
 if(y<ph&&x>px&&x<(px+pw)){
   return true;
 }
 else if(y>1000-ph2&&x>px&&x<(px+pw)){
   return true;
  }
 else{
  return false; 
 }
}
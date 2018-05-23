// Aaron Li
// APCS2 pd8
// HW52 -- Grow & Shrink
// 2018-05-22

// vars
int value; // size of circle
boolean grow; // enlarge or shrink

// at creation, make background black and a window 800x800. 
// initialize value to 0
void setup() {
  size(800, 800);
  background(0, 0, 0);
  value = 0;
}

// when drawing, first clear to get rid of prev circles, only if value 
// is > 0 do we draw or shrink. White is my fave color :)
void draw() {
  clear();
  if (value > 0) {
    if (grow) { // enlarge
      color circle = color(255, 255, 255);
      fill(circle);
      ellipse(400, 400, value, value);
      value++;
    } else { // shrink
      ellipse(400, 400, value, value);
      value--;
    }
  }
}

// each time mouse is clicked, add 1 to value, this allows
// draw() to function. Each mouse click shifts from either enlarge
// or shrink to the other.
void mouseClicked() {
  value += 1;
  if (grow) grow = false;
  else {
    grow = true;
  }
}

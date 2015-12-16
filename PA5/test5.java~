/**
 * PA5movedot.java
 * 
 * Local vars keep track of where dot is so can move it around with DPad.  
 * Also have a local var that stores a tone value and then uses that 
 * to call toneStart when a button is pressed.
 * 
 * MMS, 2/2/11
 */

import meggy.Meggy;

class PA5movedot {

    public static void main(String[] whatever){
        new Dot().run();
    }
}

class Dot {
    byte curr_x;
    byte curr_y;
    int a;
    Meggy.Color dotcolor;
    Dot b;
    public void run() {
	Dot a;
	Dot b;
	a = new Dot();
	b = a;
	if(a == b)
	{
		Meggy.delay(5);
	}
        
    }
    
  /*  public void movedot(byte x, byte y) {
        if (this.inBounds(x, y)) {
            // darken the current location of the dot
            Meggy.setPixel(curr_x, curr_y, Meggy.Color.DARK);
            
            // light up the new location
            Meggy.setPixel(x, y, dotcolor);
            
            // update the dot's current location
            //curr_x = x;
            //curr_y = y;
            
        } else {}

    }
    
    public boolean inBounds(byte x, byte y) {
        return ((byte)(0-1) < x) && (x < (byte)8) && ((byte)(0-1) < y) && (y < (byte)8);
    } */

}

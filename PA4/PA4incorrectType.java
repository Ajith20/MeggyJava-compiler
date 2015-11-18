import meggy.Meggy;

class PA4incorrectType {
    public static void main(String[] whatever){
	   new C().setP(2,(byte)7,Meggy.Color.BLUE);
    }
}

class C {
    public void setP(Meggy.Color x, byte y, Meggy.Color c) {
        Meggy.setPixel(y, y, c);    
    }
}
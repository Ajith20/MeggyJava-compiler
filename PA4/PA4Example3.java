import meggy.Meggy;

class PA4Example3 {

    public static void main(String[] whatever){
		if(3 < 5) { Meggy.setPixel((byte)5, (byte)1, Meggy.Color.VIOLET); }
		if(5 < 3) { Meggy.setPixel((byte)1, (byte)5, Meggy.Color.VIOLET); }
    }
}

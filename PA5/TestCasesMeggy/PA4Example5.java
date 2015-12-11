import meggy.Meggy;

class PA4Example5 {

    public static void main(String[] whatever){
		if(3 < true) Meggy.setPixel((byte)5, (byte)1, Meggy.Color.VIOLET);
		if(5 < Meggy.Color.BLUE) Meggy.setPixel((byte)1, (byte)5, Meggy.Color.VIOLET);
    }
}

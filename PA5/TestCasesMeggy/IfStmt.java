import meggy.Meggy;

class Example {
    public static void main(String[] something){
	    if(Meggy.checkButton(Meggy.Button.B))
			Meggy.setPixel((byte)1, (byte)1, Meggy.Color.GREEN);
	    else
			Meggy.setPixel((byte)2, (byte)2, Meggy.Color.RED);
    }
}

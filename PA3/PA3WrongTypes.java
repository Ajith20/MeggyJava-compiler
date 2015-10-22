import meggy.Meggy;

class PA3WrongTypes
{
	public static void main(String[] string1)
	{
		Meggy.setPixel((byte)1, (byte)1, Meggy.Button.Up);
		Meggy.setPixel((byte)Meggy.Color.BLUE, (byte)1, Meggy.Color.RED);
		Meggy.delay(false);
		if(5){ Meggy.delay(2); }
		if(!5){ Meggy.delay(4); }
		if(Meggy.checkButton(Meggy.Color.GREEN)){ Meggy.delay(5); }
		while(10){ Meggy.delay(6); }
		Meggy.setPixel((byte)2, (byte)2, (Meggy.getPixel(Meggy.Color.RED, (byte)1)));
		Meggy.delay(true * 2);
		Meggy.delay(true + 1);
		Meggy.delay(true - 2);
		Meggy.delay(true + 10);
		Meggy.delay(-true + 10);
		if(true == 1) { Meggy.delay(7); }
	}
}

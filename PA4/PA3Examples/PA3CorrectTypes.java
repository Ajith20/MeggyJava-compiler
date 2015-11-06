import meggy.Meggy;

class PA3CorrecdjfklTypes
{
	public static void main(String[] string1)
	{
		Meggy.setPixel((byte)1, (byte)1, Meggy.Color.BLUE);
		Meggy.delay(1);
		if(true){ Meggy.delay(2); }
		if(false){ Meggy.delay(3); }
		if(!true){ Meggy.delay(4); }
		if(Meggy.checkButton(Meggy.Button.Up)){ Meggy.delay(5); }
		while(false){ Meggy.delay(6); }
		Meggy.setPixel((byte)2, (byte)2, (Meggy.getPixel((byte)1, (byte)1)));
		Meggy.delay(2 * 2);
		Meggy.delay(1 + 1);
		Meggy.delay(5 - 2);
		Meggy.delay(5 + 10);
		Meggy.delay(-5 + 10);
		if(1 == 1) { Meggy.delay(7); }
	}
}

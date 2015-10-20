import meggy.Meggy;

class PA3Test1
{
	public static void main(String[] string1)
	{
		Meggy.setPixel((byte)1,(byte)2,Meggy.Color.BLUE);
		Meggy.delay(500);
		if (Meggy.checkButton(Meggy.Button.Up) && (Meggy.getPixel((byte)1,(byte)2) == Meggy.Color.BLUE))
		{
			Meggy.setPixel((byte)(1+5),(byte)3,Meggy.Color.WHITE);
			Meggy.setPixel((byte)(2-1),(byte)3,Meggy.Color.WHITE);
		}
	}
}

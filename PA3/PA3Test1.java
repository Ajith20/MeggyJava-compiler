import meggy.Meggy;

class PA3Test1
{
	public static void main(String[] string1)
	{
		while(1)
		{
			Meggy.delay(4);
		}
			
		/*Meggy.delay(6-1);
		Meggy.setPixel((byte)1,(byte)2,Meggy.Color.BLUE);		
		Meggy.delay((byte)5*(byte)4);
		Meggy.delay(4);
		Meggy.setPixel((byte)1,(byte)2,Meggy.Color.RED);
		Meggy.setPixel((byte)1,(byte)2,Meggy.Color.RED);
		Meggy.delay(5);
		Meggy.setPixel((byte)1,(byte)2,Meggy.Color.RED);
		Meggy.delay(500);
		/*if (Meggy.checkButton(Meggy.Button.Up) && (Meggy.getPixel((byte)1,(byte)2) == Meggy.Color.BLUE))
		{
			Meggy.setPixel((byte)(1+5),(byte)3,Meggy.Color.WHITE);
			Meggy.setPixel((byte)(2-1),(byte)3,Meggy.Color.WHITE);
		}*/
	}
}

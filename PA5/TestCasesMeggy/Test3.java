import meggy.Meggy;

class Test3
{
	public static void main(String[] string1)
	{
		if(new sampletest2().testfun2((byte)3))
		{
			//sample obj = new sample();
			new sampletest2().testfun1(2);
			//new sampletest2().testfun3();
		}
	}
}

class sampletest2
{
	public void testfun1(int a)
	{
		Meggy.setPixel((byte)(a), (byte)(a+1), Meggy.Color.BLUE);
	}
	/* public boolean testfun2(byte a)
	{
		Meggy.setPixel((byte)(a), (byte)(a+1), Meggy.Color.BLUE);
		return true;
	}
	public void testfun3()
	{
		Meggy.setPixel((byte)(5),(byte)3,Meggy.Color.WHITE);
		while(true)
		{
		if(true)
		{
			Meggy.setPixel((byte)(8-3),(byte)3,Meggy.Color.BLUE);
		}
		else
		{
			if((Meggy.getPixel((byte)5,(byte)3) == Meggy.Color.BLUE))
			{
				Meggy.delay(300);
			}
			
		}
		}
	} */
}



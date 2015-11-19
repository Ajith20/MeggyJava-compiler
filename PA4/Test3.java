import meggy.Meggy;

class Test3
{
	public static void main(String[] string1)
	{
		
			//sample obj = new sample();
			new sampletest2().testfun1((byte)4);
			new sampletest2().testfun2((byte)4);
			//new sampletest2().testfun3();
			//new sampletest2().testfun3();
		
		/*if ((byte)1<(byte)2)
		{Meggy.delay(3);}*/
	}
}

class sampletest2
{
	public void testfun1(byte a)
	{
		Meggy.setPixel((byte)(3), (byte)(4), Meggy.Color.BLUE);
	}
	 public boolean testfun2(byte a)
	{
		Meggy.setPixel((byte)(a), (byte)(a+1), Meggy.Color.BLUE);
		return true;
	}
	public void testfun3()
	{
		Meggy.setPixel((byte)(5),(byte)3,Meggy.Color.WHITE);
		
	} 
}



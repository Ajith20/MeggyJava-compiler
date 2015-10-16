import meggy.Meggy;

 class PA2Test3
{
	public static void main(String[] box)
	{
		Meggy.setPixel((byte)2,(byte)2,Meggy.Color.RED);
		Meggy.setPixel((byte)2,(byte)3,Meggy.Color.BLUE);
		Meggy.setPixel((byte)2,(byte)4,Meggy.Color.YELLOW);

        Meggy.setPixel((byte)2,(byte)5,Meggy.Color.RED);
		Meggy.setPixel((byte)3,(byte)5,Meggy.Color.BLUE);
		Meggy.setPixel((byte)4,(byte)5,Meggy.Color.YELLOW);

		Meggy.setPixel((byte)5,(byte)5,Meggy.Color.RED);
		Meggy.setPixel((byte)5,(byte)4,Meggy.Color.BLUE);
		Meggy.setPixel((byte)5,(byte)3,Meggy.Color.YELLOW);

		Meggy.setPixel((byte)5,(byte)2,Meggy.Color.RED);
		Meggy.setPixel((byte)4,(byte)2,Meggy.Color.BLUE);
		Meggy.setPixel((byte)3,(byte)2,Meggy.Color.YELLOW);
	}
}

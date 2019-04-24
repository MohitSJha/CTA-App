package project;

public class CTAStation extends GeoLocation
{
	private String name;
	private String location;
	private boolean opened;
	private boolean wheelchair;
	private int red,green,blue,brown,purple,pink,orange,yellow;
	
	//Default constructor
	public CTAStation()
	{
		super();
		name="Default";
		location="elevated";
		opened= false;
		wheelchair=false;
		red=0;
		green=0;
		blue=0;
		brown=0;
		purple=0;
		pink=0;
		orange=0;
		yellow=0;
	}
	
	//Non default constructor
	public CTAStation(String n,double lt, double ln,String l,boolean o,boolean w,int red, int green,int blue,int brown,int purple,int pink,int orange, int yellow)
	{
		super(lt, ln);
		name=n;
		location=l;
		opened=o;
		wheelchair=w;
		this.red = red;
		this.green = green;
		this.blue=blue;
		this.brown=brown;
		this.purple=purple;
		this.pink=pink;
		this.orange=orange;
		this.yellow=yellow;
	}
	
	// Accessors and Mutators 
	public void setname(String n)
	{
		name=n;
	}
	
	public void setlocation(String l)
	{
		location=l;
	}
	
	public void setopened(boolean o)
	{
		opened=o;
	}
	
	public void setwheelchair(boolean w)
	{
		wheelchair=w;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getlocation()
	{
		return location;
	}
	
	public boolean getopened()
	{
		return opened;
	}
	
	public boolean getwheelchair()
	{
		return wheelchair;
	}
	
	public int getRed()
	{
		return red;
	}
	
	public int getGreen() 
	{
		return green;
	}
	
	public void setRed(int red) 
	{
		this.red = red;
	}
	
	public void setGreen(int green) 
	{
		this.green = green;
	}
	
	public int getBlue() 
	{
		return blue;
	}
	public int getBrown() {
		return brown;
	}
	
	public int getPurple() 
	{
		return purple;
	}
	
	public int getPink()
	{
		return pink;
	}
	
	public int getOrange() 
	{
		return orange;
	}
	
	public int getYellow() 
	{
		return yellow;
	}
	
	public void setBlue(int blue) 
	{
		this.blue = blue;
	}
	
	public void setBrown(int brown) 
	{
		this.brown = brown;
	}
	
	public void setPurple(int purple) 
	{
		this.purple = purple;
	}
	
	public void setPink(int pink) 
	{
		this.pink = pink;
	}
	
	public void setOrange(int orange) 
	{
		this.orange = orange;
	}
	
	public void setYellow(int yellow) 
	{
		this.yellow = yellow;
	}

	public String toString() 
	{
		
		return  name + ", Location=" + location + ", Opened=" + opened + ", Wheelchair="
				+ wheelchair + ", Red=" + red + ", Green=" + green + ", Blue=" + blue + ", Brown=" + brown + ", Purple="
				+ purple + ", Pink=" + pink + ", Orange=" + orange + ", Yellow=" + yellow;
	}
	
	
	
	/*
	 * When I include this equals method, the classes that use the equals don't work right.                          _       _
	 * Therefore, I decided to delete the equals method, and then all of the other classes started working correctly  \(*.*)/
	 * Also, the equals was auto-generated, and I tried modifying it but there would still be problems in other classes
	 * 
	public boolean equals(CTAStation c)
	{
		if(!this.name.equals(c.getName()))
			return false;
		else if(!this.location.equals(c.getlocation()))
			return false;
		else if(c.getopened()==this.opened)
			return false;
		else if(c.getwheelchair()==this.wheelchair)
			return false;
		else if(super.equals(c)==false)
			return false;
		else if (c.getRed() != this.red)
			return false;
		else if (c.getGreen() != this.green)
			return false;
		else if(c.getBlue()!=this.blue)
			return false;
		else if(c.getBrown()!=this.brown)
			return false;
		else if(c.getPurple()!=this.purple)
			return false;
		else if(c.getPink()!=this.pink)
			return false;
		else if(c.getOrange()!=this.orange)
			return false;
		else if(c.getYellow()!=this.yellow)
			return false;
		
		return true;
	}*/
	
	public double calcDistance(GeoLocation g)
	{
		double d=Math.sqrt(Math.pow(g.getLatitude()-this.getLatitude(), 2)+Math.pow(g.getLongitude()-this.getLongitude(), 2));
		return d;
	}

}























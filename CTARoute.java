package project;

import java.util.ArrayList;

public class CTARoute extends CTAStation
{
	private String name;
	private ArrayList<CTAStation> stops = new ArrayList<CTAStation>();
	
	// Default constructor
	public CTARoute() 
	{
		super();
		name = "";
		stops = new ArrayList<CTAStation>();
	}

	//Non-default constructor
	public CTARoute(String n, double lat, double lng, String location, boolean opened, boolean wheelchair, int red, int green, int blue, 
			int brown,int purple,int pink,int orange,int yellow,String name, ArrayList<CTAStation> stops) 
	{
		super(n, lat, lng, location, opened, wheelchair, red, green,blue,brown,purple,pink,orange,yellow);
		this.name = name;
		this.stops = stops;
	}

	// Getters and Setters
	public String getName() 
	{
		return name;
	}
	
	public void setName(String name) 
	{
		this.name = name;
	}
	
	public ArrayList<CTAStation> getStops() 
	{
		return stops;
	}
	
	public void setStops(ArrayList<CTAStation> stops) 
	{
		this.stops = stops;
	}

	@Override
	public String toString() 
	{
		return "CTARoute [name=" + name + ", stops=" + stops + "]";
	}
	
	public void addStation (CTAStation station)
	{
		stops.add(station);
	}
	
	public void removeStation (CTAStation station)
	{
		for(int i = 0; i < stops.size(); i++)
		{
			if(stops.get(i).equals(station))
				stops.remove(i);
		}
	}
	
	public void insertStation (int position, CTAStation station)
	{
		stops.add(position, station);
	}
	
	public CTAStation lookupStation (String name)
	{
		for(int i = 0; i < stops.size(); i++)
		{
			if(stops.get(i).getName().equalsIgnoreCase(name))
				return stops.get(i);
		}

		return null;
	}
	
	public CTARoute sortStations(CTARoute s)
	{
		//Storing stop numbers
		int num=-1,num2=-1;
		
		//Storing the stations to be swapped
		CTAStation r=null;
		CTAStation t=null;
		
		for(int i=0;i<s.getStops().size()-1;i++)
		{
			for(int j=0;j<s.getStops().size()-1-i;j++)
			{
				//Checks which line the station is in and stores its stop number for that route
				if(s.getName().equals("red"))
				{
					num=s.getStops().get(j).getRed();
					num2=s.getStops().get(j+1).getRed();
				}
				if(s.getName().equals("green"))
				{
					num=s.getStops().get(j).getGreen();
					num2=s.getStops().get(j+1).getGreen();
				}
				if(s.getName().equals("blue"))
				{
					num=s.getStops().get(j).getBlue();
					num2=s.getStops().get(j+1).getBlue();
				}
				if(s.getName().equals("brown"))
				{
					num=s.getStops().get(j).getBrown();
					num2=s.getStops().get(j+1).getBrown();
				}
				if(s.getName().equals("purple"))
				{
					num=s.getStops().get(j).getPurple();
					num2=s.getStops().get(j+1).getPurple();
				}
				if(s.getName().equals("pink"))
				{
					num=s.getStops().get(j).getPink();
					num2=s.getStops().get(j+1).getPink();
				}
				if(s.getName().equals("yellow"))
				{
					num=s.getStops().get(j).getYellow();
					num2=s.getStops().get(j+1).getYellow();
				}
				if(s.getName().equals("orange"))
				{
					num=s.getStops().get(j).getOrange();
					num2=s.getStops().get(j+1).getOrange();
				}
				
				//If the stop number is greater than the next stations', it swaps
				if(num>num2)
				{
					r=s.getStops().get(j);
					t=s.getStops().get(j+1);
					//s.stops.remove(j);
					s.stops.set(j, t);
					//s.stops.remove(j+1);
					s.stops.set(j+1, r);
				}
			}
		}
		
		//Return the sorted CTARoute
		return s;
	}
	
	public CTAStation nearestStation (double lat, double lng)
	{
		// Storing distances
		ArrayList<Double> distances = new ArrayList<Double>();
		
		// Index of the nearest station
		int min = 0;
				
		for (int i = 0; i < stops.size(); i++)
		{
			CTAStation a = stops.get(i);
			distances.add(a.calcDistance(lat, lng));
		}
				
		for (int i = 0; i < distances.size(); i++)
		{
			double smallest = distances.get(min);
			
			if (distances.get(i) < smallest)
			{
				smallest = distances.get(i);
				min = i;
			}
		}
		
		return stops.get(min);
	}
	
	public CTAStation nearestStation (GeoLocation location)
	{
		// Storing distances
		ArrayList<Double> distances = new ArrayList<Double>();
		
		// Index of the nearest station
		int min = 0;
				
		for (int i = 0; i < stops.size(); i++)
		{
			CTAStation a = stops.get(i);
			distances.add(a.calcDistance(location));
		}
				
		for (int i = 0; i < distances.size(); i++)
		{
			double smallest = distances.get(min);
			
			if (distances.get(i) < smallest)
			{
				smallest = distances.get(i);
				min = i;
			}
		}
		
		return stops.get(min);
	}
}

package project;

public class GeoLocation
{
	// Defining the instance variables
	private double lat;
	private double lng;

	// The default constructor
	public GeoLocation ()
	{
		//Nothing since its the default constructor...
	}

	// The non-default constructor
	public GeoLocation (double lat, double lng)
	{
		this.lat = lat;
		this.lng = lng;
	}

	// Accessor methods
	public double getLatitude()
	{
		return lat;
	}

	public double getLongitude()
	{
		return lng;
	}

	// Mutator methods
	public void setLatitude(double lat)
	{
		this.lat = lat;
	}

	public void setLongitude(double lng)
	{
		this.lng = lng;
	}

	//Defining the toString method
	public String toString ()
	{
		String latitude = Double.toString(lat);
		String longitude = Double.toString(lng);
		String location = "(" + latitude + ", " + longitude + ")";
		return location;
	}

	//The booloean methods
	public boolean checkLatitude (double lat)
	{
		if (lat < 90 && lat > -90)
			return true;

		return false;
	}

	public boolean checkLongitude (double lng)
	{
		if (lng < 180 && lat > -180)
			return true;

		return false;
	}

	public GeoLocation toGeoLocation (String s)
	{
		GeoLocation gl = new GeoLocation();

		// Assigning the instance variables
		gl.lat = Double.parseDouble(s.substring(1, s.indexOf(",")));
		gl.lng = Double.parseDouble(s.substring(s.indexOf(" "), s.indexOf(")")));

		return gl;
	}
	
	// Calculate distance
	public double calcDistance (GeoLocation a)
	{
		double distance = Math.sqrt(Math.pow(a.getLatitude() - lat, 2) + Math.pow(a.getLongitude() - lng, 2));
		return distance;
	}
	
	public double calcDistance (double a, double b)
	{
		double distance = Math.sqrt(Math.pow(a - lat, 2) + Math.pow(b - lng, 2));
		return distance;
	}
}

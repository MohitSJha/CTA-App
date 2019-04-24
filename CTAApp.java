/*
 * Due the late start, I couldn't fully get around doing the two stops route part
 * Also, because I did this project in a rush, I apologize for the terrible code you're about to see
 * I realize the code is unnecessarily long and there are many things for which I could've used functions, however, as mentioned
 * I was in a rush, so I typed whatever got the methods to work and I didn't mess it up in the end, so I left it as it is
 * 
 */

package project;

import java.io.*;
import java.util.*;

public class CTAApp
{
	//This is the number of lines on CTA
	private static final int numLines = 8;

	public static void main(String[] args) throws Exception
	{
		//CTAApp object to avoid making every method static
		CTAApp app = new CTAApp();
		
		//Variable for storing user choice
		int input = 0;
		
		//File and scanner objects to open and read files
		File stop = new File("src/project/CTAStops.csv");
		Scanner file = new Scanner(stop);
		
		//Instantiating all the lines
		CTARoute red = new CTARoute();
		CTARoute green = new CTARoute();
		CTARoute blue = new CTARoute();
		CTARoute brown = new CTARoute();
		CTARoute purple = new CTARoute();
		CTARoute pink = new CTARoute();
		CTARoute orange = new CTARoute();
		CTARoute yellow = new CTARoute();
		
		//Skips the first two rows
		file.nextLine();
		file.nextLine();
		
		// Reads the file
		while (file.hasNextLine()) 
		{
			//Read from the files and initiates the values in the class
			String[] columns = file.nextLine().split(",");
			CTAStation s = new CTAStation();
			s.setname(columns[0]);
			s.setLatitude(Double.parseDouble(columns[1]));
			s.setLongitude(Double.parseDouble(columns[2]));
			s.setlocation(columns[3]);
			s.setwheelchair(Boolean.parseBoolean(columns[4].toLowerCase()));
			s.setRed(Integer.parseInt(columns[5]));
			s.setGreen(Integer.parseInt(columns[6]));
			s.setBlue(Integer.parseInt(columns[7]));
			s.setBrown(Integer.parseInt(columns[8]));
			s.setPurple(Integer.parseInt(columns[9]));
			s.setPink(Integer.parseInt(columns[10]));
			s.setOrange(Integer.parseInt(columns[11]));
			s.setYellow(Integer.parseInt(columns[12]));
			
			//Choosing which stations to add to what lines
			if (Integer.parseInt(columns[5]) >= 0)
				red.addStation(s);
			
			if (Integer.parseInt(columns[6]) >= 0)
				green.addStation(s);
			
			if(Integer.parseInt(columns[7])>=0) 
				blue.addStation(s);
			
			if(Integer.parseInt(columns[8])>=0)
				brown.addStation(s);
			
			if(Integer.parseInt(columns[9])>=0)
				purple.addStation(s);
			
			if(Integer.parseInt(columns[10])>=0)
				pink.addStation(s);
			
			if(Integer.parseInt(columns[11])>=0)
				orange.addStation(s);
			
			if(Integer.parseInt(columns[12])>=0)
				yellow.addStation(s);
		}
		
		//Sorting the stops
		app.setNameandsort(red, green, blue, brown, purple, pink, orange, yellow);
		
		//Reading user input
		Scanner sc = new Scanner(System.in);
		
		//Prompting the user
		do
		{
			//Main menu prompt
			System.out.println("\nWelcome to the CTA Stop App\n");
			System.out.println("1. Display names of all stations\n2. Display the stations with wheelchair access\n"
					+ "3. Display the nearest station to a location\n4. Display information for a station with a specific name\n"
					+ "5. Display information for all stations\n6. Add a new station\n7. Delete an existing station\n"
					+ "8. Modify an existing station\n9. Find Route between two stations\n10. Exit\n");
			System.out.print("Option number: ");
			
			String in=sc.nextLine();
		
			if(in.matches("[0-9][0-9]")||in.matches("[0-9]")) 
			{
				input=Integer.parseInt(in);
				
				if(input==1)
				{
					System.out.println("RED LINE-");
					app.displayStationNames(red);
					System.out.println("\nGREEN LINE-");
					app.displayStationNames(green);	
					System.out.println("\nBLUE LINE-");
					app.displayStationNames(blue);
					System.out.println("\nBROWN LINE-");
					app.displayStationNames(brown);	
					System.out.println("\nPURPLE LINE-");
					app.displayStationNames(purple);
					System.out.println("\nPINK LINE-");
					app.displayStationNames(pink);	
					System.out.println("\nORANGE LINE-");
					app.displayStationNames(orange);
					System.out.println("\nYELLOW LINE-");
					app.displayStationNames(yellow);	
				}
				else if(input==2)
				{
					System.out.println("RED LINE-");
					app.displayWheelchairStations(red);
					System.out.println("\nGREEN LINE-");
					app.displayWheelchairStations(green);
					System.out.println("\nBLUE LINE-");
					app.displayWheelchairStations(blue);
					System.out.println("\nBROWN LINE-");
					app.displayWheelchairStations(brown);	
					System.out.println("\nPURPLE LINE-");
					app.displayWheelchairStations(purple);
					System.out.println("\nPINK LINE-");
					app.displayWheelchairStations(pink);
					System.out.println("\nORANGE LINE-");
					app.displayWheelchairStations(orange);
					System.out.println("\nYELLOW LINE-");
					app.displayWheelchairStations(yellow);
				}
				else if(input==3)
				{
					app.nearestStation(red, green,blue,brown,purple,pink,orange,yellow);
				}
				else if(input==4)
				{
					System.out.print("Input station name: ");
					String n=sc.nextLine();
					app.stationInfo(red, green,blue,brown,purple,pink,orange,yellow,n);
				}
				else if(input==5)
				{
					System.out.println("RED LINE-");
					app.displayStationInfo(red);
					System.out.println("\nGREEN LINE-");
					app.displayStationInfo(green);
					System.out.println("\nBLUE LINE-");
					app.displayStationInfo(blue);
					System.out.println("\nBROWN LINE-");
					app.displayStationInfo(brown);	
					System.out.println("\nPURPLE LINE-");
					app.displayStationInfo(purple);
					System.out.println("\nPINK LINE-");
					app.displayStationInfo(pink);
					System.out.println("\nORANGE LINE-");
					app.displayStationInfo(orange);
					System.out.println("\nYELLOW LINE-");
					app.displayStationInfo(yellow);
				}
				
				else if(input==6)
					app.addNewStation(red, green,blue,brown,purple,pink,orange,yellow);
				
				else if(input==7)
					app.removeStation(red, green,blue,brown,purple,pink,orange,yellow);
				
				else if(input==8)
					app.modifyStation(red, green, blue, brown, purple, pink, orange, yellow);
				
				else if(input==9)				
					app.generateRoute(red, green, blue, brown, purple, pink, orange, yellow);
				
				else if(input==10)
					System.out.println("Thanks for using the CTA App");
				
				else
					System.out.println("\nInvalid number\n");
			}
			else
				System.out.println("\nInput a number and try again\n");	
			
		} while(input != 10);
					
		file.close();
		sc.close();
	}
	
	public void setNameandsort(CTARoute red,CTARoute green,CTARoute blue,CTARoute brown,CTARoute purple,CTARoute pink,
			CTARoute orange,CTARoute yellow)
	{
		red.setName("red");
		green.setName("green");
		blue.setName("blue");
		brown.setName("brown");
		purple.setName("purple");
		pink.setName("pink");
		orange.setName("orange");
		yellow.setName("yellow");
		
		red=red.sortStations(red);
		green=green.sortStations(green);
		blue=blue.sortStations(blue);
		brown=brown.sortStations(brown);
		purple=purple.sortStations(purple);
		pink=pink.sortStations(pink);
		orange=orange.sortStations(orange);
		yellow=yellow.sortStations(yellow);
	}
	
	public void displayStationNames(CTARoute s)
	{
		for(int i=0;i<s.getStops().size();i++)
		{
			System.out.println(s.getStops().get(i).getName());
		}
	}
	
	public void displayWheelchairStations(CTARoute s)
	{
		for(int i=0;i<s.getStops().size();i++)
		{
			//System.out.println(s.getwheelchair());
			if(s.getStops().get(i).getwheelchair())
			System.out.println(s.getStops().get(i).getName());
		}
	}
	
	public void nearestStation(CTARoute red,CTARoute green,CTARoute blue,CTARoute brown,CTARoute purple,
			CTARoute pink,CTARoute orange,CTARoute yellow)
	{
		CTAStation[] a = new CTAStation[numLines];
		
		//Suppress warning to not show error for not closing input object (the program doesn't work if I close the input object :/)
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		//Prompting the user
		System.out.print("Input your latitude: ");
		double lat = sc.nextDouble();
		System.out.print("Input your longitude: ");
		double lon = sc.nextDouble();
		
		//Calculating nearest stations on each route
		a[0] = red.nearestStation(lat,lon);
		a[1] = green.nearestStation(lat,lon);
		a[2] = blue.nearestStation(lat, lon);
		a[3] = brown.nearestStation(lat, lon);
		a[4] = purple.nearestStation(lat, lon);
		a[5] = pink.nearestStation(lat, lon);
		a[6] = orange.nearestStation(lat, lon);
		a[7] = yellow.nearestStation(lat, lon);
		
		double min=a[0].calcDistance(lat, lon);
		int minIndex = 0;
		
		for(int i = 0; i < numLines; i++)
		{
			if(a[i].calcDistance(lat, lon)<min)
			{
				min=a[i].calcDistance(lat, lon);
				minIndex = i;
			}
		}
		
		System.out.println("Nearest station : \n" + a[minIndex].toString());
		
	}
	
	public void stationInfo(CTARoute red,CTARoute green,CTARoute blue,CTARoute brown,CTARoute purple,CTARoute pink,
			CTARoute orange,CTARoute yellow,String n)
	{
		
		//To display all the stations with same name, separate if statements have been used
		if(red.lookupStation(n) != null)
			System.out.println(red.lookupStation(n).toString());
		
		//Checks if the station has already been printed in red line
		if(green.lookupStation(n) != null && !green.lookupStation(n).equals(red.lookupStation(n)))
			System.out.println(green.lookupStation(n).toString());
		
		//Checks if the station has already been printed in red AND green lines
		if(blue.lookupStation(n) != null && !(blue.lookupStation(n).equals(green.lookupStation(n)) || 
				blue.lookupStation(n).equals(red.lookupStation(n))))
			System.out.println(blue.lookupStation(n).toString());
		
		//Checks if the station has already been printed in red AND green AND blue lines
		if (brown.lookupStation(n) != null && !(brown.lookupStation(n).equals(red.lookupStation(n)) || 
				brown.lookupStation(n).equals(green.lookupStation(n)) || brown.lookupStation(n).equals(blue.lookupStation(n))))
			System.out.println(brown.lookupStation(n).toString());
		
		//And so on....
		if (purple.lookupStation(n) != null && !(purple.lookupStation(n).equals(red.lookupStation(n)) || 
				purple.lookupStation(n).equals(green.lookupStation(n)) || purple.lookupStation(n).equals(blue.lookupStation(n)) ||
				purple.lookupStation(n).equals(brown.lookupStation(n))))
			System.out.println(purple.lookupStation(n).toString());
		
		if (pink.lookupStation(n) != null && !(pink.lookupStation(n).equals(red.lookupStation(n)) || 
				pink.lookupStation(n).equals(green.lookupStation(n)) || pink.lookupStation(n).equals(blue.lookupStation(n)) ||
				pink.lookupStation(n).equals(brown.lookupStation(n)) || pink.lookupStation(n).equals(purple.lookupStation(n))))
			System.out.println(pink.lookupStation(n).toString());
		
		if (orange.lookupStation(n) != null && !(orange.lookupStation(n).equals(red.lookupStation(n)) || 
				orange.lookupStation(n).equals(green.lookupStation(n)) || orange.lookupStation(n).equals(blue.lookupStation(n)) ||
				orange.lookupStation(n).equals(brown.lookupStation(n)) || orange.lookupStation(n).equals(purple.lookupStation(n)) ||
				orange.lookupStation(n).equals(pink.lookupStation(n))))
			System.out.println(orange.lookupStation(n).toString());
		
		//Yellow line only intersects with red line, so no need to compare with every other line
		if (yellow.lookupStation(n) != null && !yellow.lookupStation(n).equals(red.lookupStation(n)))
			System.out.println(yellow.lookupStation(n).toString());
		
		//If station lookup fails
		if(red.lookupStation(n) == null && green.lookupStation(n) == null && blue.lookupStation(n) == null &&
				brown.lookupStation(n) == null && purple.lookupStation(n) == null && pink.lookupStation(n) == null &&
				orange.lookupStation(n) == null && yellow.lookupStation(n) == null)
			System.out.println("The station was not found\nReturning to main menu...");
		
	}
	
	public void displayStationInfo(CTARoute s)
	{
		for(int i=0;i<s.getStops().size();i++)
		{
			CTAStation station = s.getStops().get(i);
			System.out.println(station.toString());
		}
	}
	
	public void addNewStation(CTARoute red, CTARoute green,CTARoute blue,CTARoute brown,CTARoute purple,CTARoute pink,
			CTARoute orange,CTARoute yellow)
	{
		//Suppress warning for closing input object (the program doesn't work if I close the input object :/)
		@SuppressWarnings("resource")
		Scanner input = new Scanner (System.in);
		System.out.print("Name of the station: ");
		String name = input.nextLine();
		System.out.print("Latitude: ");
		double lat = input.nextDouble();
		System.out.print("Longitude: ");
		double lng = input.nextDouble();
		System.out.print("Location (elevation): ");
		String location = input.next();
		System.out.print("Wheelchair? (True/false): ");
		String wheelchair = input.next();
		System.out.print("Route: ");
		String route = input.next();
		System.out.println("What's the previous station? ");
		System.out.print("-> ");
		
		//NextLine for some reason skips Line 366, so kept an extra nextline here, so that line 366 can be executed 
		input.nextLine();
		
		String prev = input.nextLine();
		
		if(route.equalsIgnoreCase("red"))
		{
			//Handles incorrect name input
			if(red.lookupStation(prev) != null)
			{
				CTAStation a = red.lookupStation(prev);
				boolean opened = true;
				
				CTAStation newSt = new CTAStation(name, lat, lng, location, opened, Boolean.parseBoolean(wheelchair),
						a.getRed()+1, -1,-1,-1,-1,-1,-1,-1);
				
				red.insertStation(a.getRed() + 1, newSt);
			}
			else
				System.out.println("Station not found, returning to main menu...");
		}
		
		else if(route.equalsIgnoreCase("green"))
		{
			if(green.lookupStation(prev) != null)
			{
				CTAStation a = green.lookupStation(prev);
				boolean opened = true;
				CTAStation newSt = new CTAStation(name, lat, lng, location, opened, Boolean.parseBoolean(wheelchair), 
					-1, a.getGreen()+1,-1,-1,-1,-1,-1,-1);
				
				green.insertStation(a.getGreen() + 1, newSt);
			}
			else
				System.out.println("Station not found, returning to main menu...");
		}
		
		else if(route.equalsIgnoreCase("blue"))
		{
			if(blue.lookupStation(prev) != null)
			{
				CTAStation a = blue.lookupStation(prev);
				boolean opened = true;
				CTAStation newSt = new CTAStation(name, lat, lng, location, opened, Boolean.parseBoolean(wheelchair), 
						-1, -1,a.getBlue()+1,-1,-1,-1,-1,-1);
				
				blue.insertStation(a.getBlue() + 1, newSt);
			}
			else
				System.out.println("Station not found, returning to main menu...");
		}
		
		else if(route.equalsIgnoreCase("brown"))
		{
			if(brown.lookupStation(prev) != null)
			{
				CTAStation a = brown.lookupStation(prev);
				boolean opened = true;
				CTAStation newSt = new CTAStation(name, lat, lng, location, opened, Boolean.parseBoolean(wheelchair), 
						-1,-1,-1,a.getBrown()+1,-1,-1,-1,-1);
				
				brown.insertStation(a.getBrown() + 1, newSt);
			}
			else
				System.out.println("Station not found, returning to main menu...");
		}
		
		else if(route.equalsIgnoreCase("purple"))
		{
			if(purple.lookupStation(prev) != null)
			{
				CTAStation a = purple.lookupStation(prev);
				boolean opened = true;
				CTAStation newSt = new CTAStation(name, lat, lng, location, opened, Boolean.parseBoolean(wheelchair),
						-1,-1,-1,-1,a.getPurple()+1,-1,-1,-1);
				
				purple.insertStation(a.getPurple() + 1, newSt);
			}
			else
				System.out.println("Station not found, returning to main menu...");
		}
		
		else if(route.equalsIgnoreCase("pink"))
		{
			if(pink.lookupStation(prev) != null)
			{
				CTAStation a = pink.lookupStation(prev);
				boolean opened = true;
				CTAStation newSt = new CTAStation(name, lat, lng, location, opened, Boolean.parseBoolean(wheelchair),
						-1,-1,-1,-1,-1,a.getPink()+1,-1,-1);
				
				pink.insertStation(a.getPink() + 1, newSt);
			}
			else
				System.out.println("Station not found, returning to main menu...");
		}
		
		else if(route.equalsIgnoreCase("orange"))
		{
			if(orange.lookupStation(prev) != null)
			{
				CTAStation a = orange.lookupStation(prev);
				boolean opened = true;
				CTAStation newSt = new CTAStation(name, lat, lng, location, opened, Boolean.parseBoolean(wheelchair), 
						-1,-1,-1,-1,-1,-1,a.getOrange()+1,-1);
				
				orange.insertStation(a.getOrange() + 1, newSt);
			}
			else
				System.out.println("Station not found, returning to main menu...");
		}
		
		else if(route.equalsIgnoreCase("yellow"))
		{
			if(yellow.lookupStation(prev) != null)
			{
				CTAStation a = yellow.lookupStation(prev);
				boolean opened = true;
				CTAStation newSt = new CTAStation(name, lat, lng, location, opened, Boolean.parseBoolean(wheelchair),
						-1,-1,-1,-1,-1,-1,-1,a.getYellow()+1);
			
				yellow.insertStation(a.getYellow() + 1, newSt);
			}
			else
				System.out.println("Station not found, returning to main menu...");
		}
	}
	
	public void removeStation(CTARoute red, CTARoute green, CTARoute blue, CTARoute brown, CTARoute purple, CTARoute pink,
			CTARoute orange, CTARoute yellow)
	{
		@SuppressWarnings("resource")
		Scanner input = new Scanner (System.in);
		
		System.out.print("Name of the station: ");
		String name = input.nextLine();
		System.out.print("Which route(s) is it? (Seperate with a comma and no space): ");
		String route[] = input.nextLine().split(",");
		
		for(int i = 0; i < route.length; i++)
		{
			if (route[i].equalsIgnoreCase("red"))
			{
				if(red.lookupStation(name) != null)
				{
					red.removeStation(red.lookupStation(name));
					System.out.println(name + " station was removed from the " + route[i] + " line");
				}
				else
					System.out.println("The station wasn't found on " + route[i] + " line\n");
			}
			else if(route[i].equalsIgnoreCase("green"))
			{
				if(green.lookupStation(name) != null)
				{
					green.removeStation(green.lookupStation(name));
					System.out.println(name + " station was removed from the " + route[i] + " line");
				}
				else
					System.out.println("The station wasn't found on " + route[i] + " line\n");
			}
			else if(route[i].equalsIgnoreCase("blue"))
			{
				if(blue.lookupStation(name) != null)
				{
					blue.removeStation(blue.lookupStation(name));
					System.out.println(name + " station was removed from the " + route[i] + " line");
				}
				else
					System.out.println("The station wasn't found on " + route[i] + " line\n");
			}
			else if(route[i].equalsIgnoreCase("brown"))
			{
				if(brown.lookupStation(name) != null)
				{
					brown.removeStation(brown.lookupStation(name));
					System.out.println(name + " station was removed from the " + route[i] + " line");
				}
				else
					System.out.println("The station wasn't found on " + route[i] + " line\n");
			}
			else if(route[i].equalsIgnoreCase("purple"))
			{
				if(purple.lookupStation(name) != null)
				{
					purple.removeStation(purple.lookupStation(name));
					System.out.println(name + " station was removed from the " + route[i] + " line");
				}
				else
					System.out.println("The station wasn't found on " + route[i] + " line\n");
			}
			else if(route[i].equalsIgnoreCase("pink"))
			{
				if(pink.lookupStation(name) != null)
				{
					pink.removeStation(pink.lookupStation(name));
					System.out.println(name + " station was removed from the " + route[i] + " line");
				}
				else
					System.out.println("The station wasn't found on " + route[i] + " line\n");
			}
			else if(route[i].equalsIgnoreCase("orange"))
			{
				if(orange.lookupStation(name) != null)
				{
					orange.removeStation(orange.lookupStation(name));
					System.out.println(name + " station was removed from the " + route[i] + " line");
				}
				else
					System.out.println("The station wasn't found on " + route[i] + " line\n");
			}
			else if(route[i].equalsIgnoreCase("yellow"))
			{
				if(yellow.lookupStation(name) != null)
				{
					yellow.removeStation(yellow.lookupStation(name));
					System.out.println(name + " station was removed from the " + route[i] + " line");
				}
				else
					System.out.println("The station wasn't found on " + route[i] + " line\n");
			}
			else
				System.out.println("The " + route[i] + " line doesn't exist. Check name and try again");
		}
	}
	
	public void modifyStation(CTARoute red, CTARoute green,CTARoute blue,CTARoute brown,CTARoute purple,
			CTARoute pink,CTARoute orange,CTARoute yellow)
	{
		//Suppress warning because program wasn't working when scanner was closed, and it showed an error when not closing it
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Which Station do you want to modify?");
		String name = sc.nextLine();
		System.out.println("Which line is it a part of?\nNOTE: Only enter one of the line if the stop is part of multiple routes");
		System.out.print("-> ");
		String line = sc.nextLine();
		
		//Station where the changes are to be made
		CTAStation station = null;
		
		//Assigns the appropriate station
		if(line.equalsIgnoreCase("red"))
			station = red.lookupStation(name);
		else if (line.equalsIgnoreCase("green"))
			station = green.lookupStation(name);
		else if (line.equalsIgnoreCase("blue"))
			station = blue.lookupStation(name);
		else if (line.equalsIgnoreCase("brown"))
			station = brown.lookupStation(name);
		else if (line.equalsIgnoreCase("purple"))
			station = purple.lookupStation(name);
		else if (line.equalsIgnoreCase("pink"))
			station = pink.lookupStation(name);
		else if (line.equalsIgnoreCase("yellow"))
			station = yellow.lookupStation(name);
		else if (line.equalsIgnoreCase("orange"))
			station = orange.lookupStation(name);
		else
		{
			//Invalid input
			System.out.println("The line doesn't exist...quitting to main menu");
			return;
		}
		
		if(station != null)
		{
			/*
			 * I left out changing the latitude and longitude because I thought moving the entire station to a new location
			 * is not very practical, as people would just add a new station instead and delete this one
			 */
			
			System.out.println("1. Change name\n2.Change Location\n3.Change wheelchair accessbility status\n"
					+ "4.Add/remove station to new line");
		
			System.out.print("Enter option number: ");
			String option = sc.nextLine();
		
			if(option.equals("1"))
			{
				System.out.println("Enter the new name: ");
				String changedName = sc.nextLine();
				station.setname(changedName);
			}
			else if (option.equals("2"))
			{
				System.out.print("Enter new location: ");
				String newElevation = sc.nextLine();
				station.setlocation(newElevation);
			}
			else if (option.equals("3"))
			{
				System.out.print("Enter wheelchair accessibility (true/false): ");
				String newStatus = sc.nextLine();
				
				//Handling incorrect user input
				if(newStatus.equalsIgnoreCase("true") || newStatus.equalsIgnoreCase("false"))
					station.setwheelchair(Boolean.parseBoolean(newStatus));
				else
					System.out.println("Invalid input. Quitting to main menu");
			}
			else if (option.equals("4"))
			{
				System.out.print("Which line do you want to add/remove: ");
				String newline = sc.nextLine();
				System.out.print("Enter stop number (enter -1 if you want to remove the line): ");
				String stopNumber = sc.nextLine();
				
				if(stopNumber.matches("[0-9][0-9]") || stopNumber.matches("[0-9]"))
				{
					if(newline.equalsIgnoreCase("red"))
					{
						//This part makes the changes
						station.setRed(Integer.parseInt(stopNumber));
						
						//This part adds or remove the stop from the respective lines
						if(Integer.parseInt(stopNumber) >= 0)
							red.addStation(station);
						else if(Integer.parseInt(stopNumber) < 0)
							red.removeStation(station);
					}
					else if(newline.equalsIgnoreCase("green"))
					{
						station.setGreen(Integer.parseInt(stopNumber));
						
						if(Integer.parseInt(stopNumber) >= 0)
							green.addStation(station);
						else if(Integer.parseInt(stopNumber) < 0)
							green.removeStation(station);
					}
					else if(newline.equalsIgnoreCase("blue"))
					{
						station.setBlue(Integer.parseInt(stopNumber));
						
						if(Integer.parseInt(stopNumber) >= 0)
							blue.addStation(station);
						else if(Integer.parseInt(stopNumber) < 0)
							blue.removeStation(station);
					}
					else if(newline.equalsIgnoreCase("brown"))
					{
						station.setBrown(Integer.parseInt(stopNumber));
						
						if(Integer.parseInt(stopNumber) >= 0)
							brown.addStation(station);
						else if(Integer.parseInt(stopNumber) < 0)
							brown.removeStation(station);
					}
					else if(newline.equalsIgnoreCase("purple"))
					{
						station.setPurple(Integer.parseInt(stopNumber));
						
						if(Integer.parseInt(stopNumber) >= 0)
							purple.addStation(station);
						else if(Integer.parseInt(stopNumber) < 0)
							purple.removeStation(station);
					}
					else if(newline.equalsIgnoreCase("pink"))
					{
						station.setPink(Integer.parseInt(stopNumber));
						
						if(Integer.parseInt(stopNumber) >= 0)
							pink.addStation(station);
						else if(Integer.parseInt(stopNumber) < 0)
							pink.removeStation(station);
					}
					else if(newline.equalsIgnoreCase("orange"))
					{
						station.setOrange(Integer.parseInt(stopNumber));
						
						if(Integer.parseInt(stopNumber) >= 0)
							orange.addStation(station);
						else if(Integer.parseInt(stopNumber) < 0)
							orange.removeStation(station);
					}
					else if(newline.equalsIgnoreCase("yellow"))
					{
						station.setYellow(Integer.parseInt(stopNumber));
						
						if(Integer.parseInt(stopNumber) >= 0)
							yellow.addStation(station);
						else if(Integer.parseInt(stopNumber) < 0)
							yellow.removeStation(station);
					}
					else
						System.out.println("Incorrect line inputted. Quitting to main menu...");
					
				}
				else
					System.out.println("Invalid input. Quitting to main menu");
			}
		}
		else
			System.out.println("Station not found. Quitting to main menu...");
	}
	
	public void generateRoute (CTARoute red, CTARoute green, CTARoute blue, CTARoute brown, CTARoute purple, CTARoute pink, 
			CTARoute orange, CTARoute yellow)
	{
		//Scanner object, suppressed warnings to avoid closing scanner, which causes errors
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		System.out.print("From: ");
		String start = scan.nextLine();
		
		//Taking the line to avoid ambiguity between multiple stations
		System.out.print("Line: ");
		String startLine = scan.nextLine();
		
		System.out.print("To: ");
		String end = scan.nextLine();
		System.out.print("Line: ");
		String endLine = scan.nextLine();
		
		// Check for existence
		if((startLine.equalsIgnoreCase("red") && red.lookupStation(start) == null) || 
				(startLine.equalsIgnoreCase("green") && green.lookupStation(start) == null) || 
				(startLine.equalsIgnoreCase("blue") && blue.lookupStation(start) == null) ||
				(startLine.equalsIgnoreCase("brown") && brown.lookupStation(start) == null) ||
				(startLine.equalsIgnoreCase("purple") && purple.lookupStation(start) == null) ||
				(startLine.equalsIgnoreCase("pink") && pink.lookupStation(start) == null) ||
				(startLine.equalsIgnoreCase("orange") && orange.lookupStation(start) == null) ||
				(startLine.equalsIgnoreCase("yellow") && yellow.lookupStation(start) == null))
		{
			System.out.println("Station doesn't exist");
			return;
		}
		else if ((endLine.equalsIgnoreCase("red") && red.lookupStation(end) == null) || 
				(endLine.equalsIgnoreCase("green") && green.lookupStation(end) == null) || 
				(endLine.equalsIgnoreCase("blue") && blue.lookupStation(end) == null) ||
				(endLine.equalsIgnoreCase("brown") && brown.lookupStation(end) == null) ||
				(endLine.equalsIgnoreCase("purple") && purple.lookupStation(end) == null) ||
				(endLine.equalsIgnoreCase("pink") && pink.lookupStation(end) == null) ||
				(endLine.equalsIgnoreCase("orange") && orange.lookupStation(end) == null) ||
				(endLine.equalsIgnoreCase("yellow") && yellow.lookupStation(end) == null))
		{
			System.out.println("Station doesn't exist");
			return;
		}
		
		//For a direct route with no change of stations
		if(startLine.equalsIgnoreCase(endLine))
		{
			if(startLine.equalsIgnoreCase("red"))
			{
				if(red.lookupStation(start) != null && red.lookupStation(end) != null)
				{
					System.out.println(red.lookupStation(start).getName() + " to " + red.lookupStation(end).getName() + 
							" is a direct route and requires no change in stations");
					
					return;
				}
				else
				{
					System.out.println("One of the stations doesn't exist");
					return;
				}
			}
			else if(startLine.equalsIgnoreCase("green"))
			{
				if(green.lookupStation(start) != null && green.lookupStation(end) != null)
				{
					System.out.println(green.lookupStation(start).getName() + " to " + green.lookupStation(end).getName() + 
							" is a direct route and requires no change in stations");
					return;
				}
				else
				{
					System.out.println("One of the stations doesn't exist");
					return;
				}
			}
			else if(startLine.equalsIgnoreCase("blue"))
			{
				if(blue.lookupStation(start) != null && blue.lookupStation(end) != null)
				{
					System.out.println(blue.lookupStation(start).getName() + " to " + blue.lookupStation(end).getName() + 
							" is a direct route and requires no change in stations");
					return;
				}
				else
				{
					System.out.println("One of the stations doesn't exist");
					return;
				}
			}
			else if(startLine.equalsIgnoreCase("brown"))
			{
				if(brown.lookupStation(start) != null && brown.lookupStation(end) != null)
				{
					System.out.println(brown.lookupStation(start).getName() + " to " + brown.lookupStation(end).getName() + 
							" is a direct route and requires no change in stations");
					return;
				}
				else
				{
					System.out.println("One of the stations doesn't exist");
					return;
				}
			}
			else if(startLine.equalsIgnoreCase("purple"))
			{
				if(purple.lookupStation(start) != null && purple.lookupStation(end) != null)
				{
					System.out.println(purple.lookupStation(start).getName() + " to " + purple.lookupStation(end).getName() + 
							" is a direct route and requires no change in stations");
					return;
				}
				else
				{
					System.out.println("One of the stations doesn't exist");
					return;
				}
			}
			else if(startLine.equalsIgnoreCase("pink"))
			{
				if(pink.lookupStation(start) != null && pink.lookupStation(end) != null)
				{
					System.out.println(pink.lookupStation(start).getName() + " to " + pink.lookupStation(end).getName() + 
							" is a direct route and requires no change in stations");
					return;
				}
				else
				{
					System.out.println("One of the stations doesn't exist");
					return;
				}
			}
			else if(startLine.equalsIgnoreCase("orange"))
			{
				if(orange.lookupStation(start) != null && orange.lookupStation(end) != null)
				{
					System.out.println(orange.lookupStation(start).getName() + " to " + orange.lookupStation(end).getName() + 
							" is a direct route and requires no change in stations");
					return;
				}
				else
				{
					System.out.println("One of the stations doesn't exist");
					return;
				}
			}
			else if(startLine.equalsIgnoreCase("yellow"))
			{
				if(yellow.lookupStation(start) != null && yellow.lookupStation(end) != null)
				{
					System.out.println(yellow.lookupStation(start).getName() + " to " + yellow.lookupStation(end).getName() + 
							" is a direct route and requires no change in stations");
					return;
				}
				else
				{
					System.out.println("One of the stations doesn't exist");
					return;
				}
			}
			else
			{
				System.out.println("Invalid line, returning to main menu...");
				return;
			}
		}
		
		// for one or more stops
		// below are all the possible conditions that the user can give
		CTAStation common = new CTAStation();
		
		if ((startLine.equalsIgnoreCase("red") && endLine.equalsIgnoreCase("green")) || 
				(endLine.equalsIgnoreCase("red") && startLine.equalsIgnoreCase("green")))
		{
			
			for (CTAStation e : red.getStops())
			{
				for(CTAStation f : green.getStops())
				{
					if (f.equals(e))
						common = f;
				}
			}
			
			System.out.println("You need to go from " + start + " on " + startLine + " to " + common.getName());
			System.out.println("Then, you need to change from " + startLine + " to " + endLine + " at " + common.getName());
			System.out.println("Then, travel on the " + endLine + " from " + common.getName() + " to " + end);
		}
		else if ((startLine.equalsIgnoreCase("red") && endLine.equalsIgnoreCase("blue")) || 
				(endLine.equalsIgnoreCase("red") && startLine.equalsIgnoreCase("blue")))
		{
			for (CTAStation e : blue.getStops())
			{
				for(CTAStation f : red.getStops())
				{
					if (f.equals(e))
						common = f;
				}
			}
			
			System.out.println("You need to go from " + start + " on " + startLine + " to " + common.getName());
			System.out.println("Then, you need to change from " + startLine + " to " + endLine + " at " + common.getName());
			System.out.println("Then, travel on the " + endLine + " from " + common.getName() + " to " + end);
		}
		else if ((startLine.equalsIgnoreCase("red") && endLine.equalsIgnoreCase("brown")) || 
				(endLine.equalsIgnoreCase("red") && startLine.equalsIgnoreCase("brown")))
		{
			for (CTAStation e : red.getStops())
			{
				for(CTAStation f : brown.getStops())
				{
					if (f.equals(e))
						common = f;
				}
			}
			
			System.out.println("You need to go from " + start + " on " + startLine + " line to " + common.getName());
			System.out.println("Then, you need to change from " + startLine + " line to " + endLine + " line at " + common.getName());
			System.out.println("Then, travel on the " + endLine + " line from " + common.getName() + " to " + end);
		}
		else if ((startLine.equalsIgnoreCase("red") && endLine.equalsIgnoreCase("purple")) || 
				(endLine.equalsIgnoreCase("red") && startLine.equalsIgnoreCase("purple")))
		{
			for (CTAStation e : red.getStops())
			{
				for(CTAStation f : purple.getStops())
				{
					if (f.equals(e))
						common = f;
				}
			}
			
			System.out.println("You need to go from " + start + " on " + startLine + " line to " + common.getName());
			System.out.println("Then, you need to change from " + startLine + " line to " + endLine + " line at " + common.getName());
			System.out.println("Then, travel on the " + endLine + " line from " + common.getName() + " to " + end);
		}
		else if ((startLine.equalsIgnoreCase("red") && endLine.equalsIgnoreCase("pink")) || 
				(endLine.equalsIgnoreCase("red") && startLine.equalsIgnoreCase("pink")))
		{
			multipleStops(red, green, blue, brown, purple, pink, orange, yellow, start, end);
		}
		else if ((startLine.equalsIgnoreCase("red") && endLine.equalsIgnoreCase("orange")) || 
				(endLine.equalsIgnoreCase("red") && startLine.equalsIgnoreCase("orange")))
		{
			for (CTAStation e : red.getStops())
			{
				for(CTAStation f : orange.getStops())
				{
					if (f.equals(e))
						common = f;
				}
			}
			
			System.out.println("You need to go from " + start + " on " + startLine + " line to " + common.getName());
			System.out.println("Then, you need to change from " + startLine + " line to " + endLine + " line at " + common.getName());
			System.out.println("Then, travel on the " + endLine + " line from " + common.getName() + " to " + end);
		}
		else if ((startLine.equalsIgnoreCase("red") && endLine.equalsIgnoreCase("yellow")) || 
				(endLine.equalsIgnoreCase("red") && startLine.equalsIgnoreCase("yellow")))
		{
			for (CTAStation e : red.getStops())
			{
				for(CTAStation f : yellow.getStops())
				{
					if (f.equals(e))
						common = f;
				}
			}
			
			System.out.println("You need to go from " + start + " on " + startLine + " line to " + common.getName());
			System.out.println("Then, you need to change from " + startLine + " line to " + endLine + " line at " + common.getName());
			System.out.println("Then, travel on the " + endLine + " line from " + common.getName() + " to " + end);
		}
		else if ((startLine.equalsIgnoreCase("green") && endLine.equalsIgnoreCase("blue")) || 
				(endLine.equalsIgnoreCase("green") && startLine.equalsIgnoreCase("blue")))
		{
			for (CTAStation e : green.getStops())
			{
				for(CTAStation f : blue.getStops())
				{
					if (f.equals(e))
						common = f;
				}
			}
			
			System.out.println("You need to go from " + start + " on " + startLine + " line to " + common.getName());
			System.out.println("Then, you need to change from " + startLine + " line to " + endLine + " line at " + common.getName());
			System.out.println("Then, travel on the " + endLine + " line from " + common.getName() + " to " + end);
		}
		else if ((startLine.equalsIgnoreCase("green") && endLine.equalsIgnoreCase("brown")) || 
				(endLine.equalsIgnoreCase("green") && startLine.equalsIgnoreCase("brown")))
		{
			for (CTAStation e : green.getStops())
			{
				for(CTAStation f : brown.getStops())
				{
					if (f.equals(e))
						common = f;
				}
			}
			
			System.out.println("You need to go from " + start + " on " + startLine + " line to " + common.getName());
			System.out.println("Then, you need to change from " + startLine + " line to " + endLine + " line at " + common.getName());
			System.out.println("Then, travel on the " + endLine + " line from " + common.getName() + " to " + end);
		}
		else if ((startLine.equalsIgnoreCase("green") && endLine.equalsIgnoreCase("purple")) || 
				(endLine.equalsIgnoreCase("green") && startLine.equalsIgnoreCase("purple")))
		{
			for (CTAStation e : green.getStops())
			{
				for(CTAStation f : purple.getStops())
				{
					if (f.equals(e))
						common = f;
				}
			}
			
			System.out.println("You need to go from " + start + " on " + startLine + " line to " + common.getName());
			System.out.println("Then, you need to change from " + startLine + " line to " + endLine + " line at " + common.getName());
			System.out.println("Then, travel on the " + endLine + " line from " + common.getName() + " to " + end);
		}
		else if ((startLine.equalsIgnoreCase("green") && endLine.equalsIgnoreCase("pink")) || 
				(endLine.equalsIgnoreCase("green") && startLine.equalsIgnoreCase("pink")))
		{
			for (CTAStation e : green.getStops())
			{
				for(CTAStation f : pink.getStops())
				{
					if (f.equals(e))
						common = f;
				}
			}
			
			System.out.println("You need to go from " + start + " on " + startLine + " line to " + common.getName());
			System.out.println("Then, you need to change from " + startLine + " line to " + endLine + " line at " + common.getName());
			System.out.println("Then, travel on the " + endLine + " line from " + common.getName() + " to " + end);
		}
		else if ((startLine.equalsIgnoreCase("green") && endLine.equalsIgnoreCase("orange")) || 
				(endLine.equalsIgnoreCase("green") && startLine.equalsIgnoreCase("orange")))
		{
			for (CTAStation e : green.getStops())
			{
				for(CTAStation f : orange.getStops())
				{
					if (f.equals(e))
						common = f;
				}
			}
			
			System.out.println("You need to go from " + start + " on " + startLine + " line to " + common.getName());
			System.out.println("Then, you need to change from " + startLine + " line to " + endLine + " line at " + common.getName());
			System.out.println("Then, travel on the " + endLine + " line from " + common.getName() + " to " + end);
		}
		else if ((startLine.equalsIgnoreCase("green") && endLine.equalsIgnoreCase("yellow")) || 
				(endLine.equalsIgnoreCase("green") && startLine.equalsIgnoreCase("yellow")))
		{
			multipleStops(red, green, blue, brown, purple, pink, orange, yellow, start, end);
		}
		else if ((startLine.equalsIgnoreCase("blue") && endLine.equalsIgnoreCase("brown")) || 
				(endLine.equalsIgnoreCase("blue") && startLine.equalsIgnoreCase("brown")))
		{
			for (CTAStation e : blue.getStops())
			{
				for(CTAStation f : brown.getStops())
				{
					if (f.equals(e))
						common = f;
				}
			}
			
			System.out.println("You need to go from " + start + " on " + startLine + " line to " + common.getName());
			System.out.println("Then, you need to change from " + startLine + " line to " + endLine + " line at " + common.getName());
			System.out.println("Then, travel on the " + endLine + " line from " + common.getName() + " to " + end);
		}
		else if ((startLine.equalsIgnoreCase("blue") && endLine.equalsIgnoreCase("purple")) || 
				(endLine.equalsIgnoreCase("blue") && startLine.equalsIgnoreCase("purple")))
		{
			for (CTAStation e : blue.getStops())
			{
				for(CTAStation f : purple.getStops())
				{
					if (f.equals(e))
						common = f;
				}
			}
			
			System.out.println("You need to go from " + start + " on " + startLine + " line to " + common.getName());
			System.out.println("Then, you need to change from " + startLine + " line to " + endLine + " line at " + common.getName());
			System.out.println("Then, travel on the " + endLine + " line from " + common.getName() + " to " + end);
		}
		else if ((startLine.equalsIgnoreCase("blue") && endLine.equalsIgnoreCase("pink")) || 
				(endLine.equalsIgnoreCase("blue") && startLine.equalsIgnoreCase("pink")))
		{
			for (CTAStation e : blue.getStops())
			{
				for(CTAStation f : pink.getStops())
				{
					if (f.equals(e))
						common = f;
				}
			}
			
			System.out.println("You need to go from " + start + " on " + startLine + " line to " + common.getName());
			System.out.println("Then, you need to change from " + startLine + " line to " + endLine + " line at " + common.getName());
			System.out.println("Then, travel on the " + endLine + " line from " + common.getName() + " to " + end);
		}
		else if ((startLine.equalsIgnoreCase("blue") && endLine.equalsIgnoreCase("orange")) || 
				(endLine.equalsIgnoreCase("blue") && startLine.equalsIgnoreCase("orange")))
		{
			for (CTAStation e : blue.getStops())
			{
				for(CTAStation f : orange.getStops())
				{
					if (f.equals(e))
						common = f;
				}
			}
			
			System.out.println("You need to go from " + start + " on " + startLine + " line to " + common.getName());
			System.out.println("Then, you need to change from " + startLine + " line to " + endLine + " line at " + common.getName());
			System.out.println("Then, travel on the " + endLine + " line from " + common.getName() + " to " + end);
		}
		else if ((startLine.equalsIgnoreCase("blue") && endLine.equalsIgnoreCase("yellow")) || 
				(endLine.equalsIgnoreCase("blue") && startLine.equalsIgnoreCase("yellow")))
		{
			multipleStops(red, green, blue, brown, purple, pink, orange, yellow, start, end);
		}
		else if ((startLine.equalsIgnoreCase("brown") && endLine.equalsIgnoreCase("purple")) || 
				(endLine.equalsIgnoreCase("brown") && startLine.equalsIgnoreCase("purple")))
		{
			for (CTAStation e : brown.getStops())
			{
				for(CTAStation f : purple.getStops())
				{
					if (f.equals(e))
						common = f;
				}
			}
			
			System.out.println("You need to go from " + start + " on " + startLine + " line to " + common.getName());
			System.out.println("Then, you need to change from " + startLine + " line to " + endLine + " line at " + common.getName());
			System.out.println("Then, travel on the " + endLine + " line from " + common.getName() + " to " + end);
		}
		else if ((startLine.equalsIgnoreCase("brown") && endLine.equalsIgnoreCase("pink")) || 
				(endLine.equalsIgnoreCase("brown") && startLine.equalsIgnoreCase("pink")))
		{
			for (CTAStation e : brown.getStops())
			{
				for(CTAStation f : pink.getStops())
				{
					if (f.equals(e))
						common = f;
				}
			}
			
			System.out.println("You need to go from " + start + " on " + startLine + " line to " + common.getName());
			System.out.println("Then, you need to change from " + startLine + " line to " + endLine + " line at " + common.getName());
			System.out.println("Then, travel on the " + endLine + " line from " + common.getName() + " to " + end);
		}
		else if ((startLine.equalsIgnoreCase("brown") && endLine.equalsIgnoreCase("orange")) || 
				(endLine.equalsIgnoreCase("brown") && startLine.equalsIgnoreCase("orange")))
		{
			for (CTAStation e : brown.getStops())
			{
				for(CTAStation f : orange.getStops())
				{
					if (f.equals(e))
						common = f;
				}
			}
			
			System.out.println("You need to go from " + start + " on " + startLine + " line to " + common.getName());
			System.out.println("Then, you need to change from " + startLine + " line to " + endLine + " line at " + common.getName());
			System.out.println("Then, travel on the " + endLine + " line from " + common.getName() + " to " + end);
		}
		else if ((startLine.equalsIgnoreCase("brown") && endLine.equalsIgnoreCase("yellow")) || 
				(endLine.equalsIgnoreCase("brown") && startLine.equalsIgnoreCase("yellow")))
		{
			multipleStops(red, green, blue, brown, purple, pink, orange, yellow, start, end);
		}
		else if ((startLine.equalsIgnoreCase("purple") && endLine.equalsIgnoreCase("pink")) || 
				(endLine.equalsIgnoreCase("purple") && startLine.equalsIgnoreCase("pink")))
		{
			for (CTAStation e : purple.getStops())
			{
				for(CTAStation f : pink.getStops())
				{
					if (f.equals(e))
						common = f;
				}
			}
			
			System.out.println("You need to go from " + start + " on " + startLine + " line to " + common.getName());
			System.out.println("Then, you need to change from " + startLine + " line to " + endLine + " line at " + common.getName());
			System.out.println("Then, travel on the " + endLine + " line from " + common.getName() + " to " + end);
		}
		else if ((startLine.equalsIgnoreCase("purple") && endLine.equalsIgnoreCase("orange")) || 
				(endLine.equalsIgnoreCase("purple") && startLine.equalsIgnoreCase("orange")))
		{
			for (CTAStation e : purple.getStops())
			{
				for(CTAStation f : orange.getStops())
				{
					if (f.equals(e))
						common = f;
				}
			}
			
			System.out.println("You need to go from " + start + " on " + startLine + " line to " + common.getName());
			System.out.println("Then, you need to change from " + startLine + " line to " + endLine + " line at " + common.getName());
			System.out.println("Then, travel on the " + endLine + " line from " + common.getName() + " to " + end);
		}
		else if ((startLine.equalsIgnoreCase("purple") && endLine.equalsIgnoreCase("yellow")) || 
				(endLine.equalsIgnoreCase("purple") && startLine.equalsIgnoreCase("yellow")))
		{
			for (CTAStation e : purple.getStops())
			{
				for(CTAStation f : yellow.getStops())
				{
					if (f.equals(e))
						common = f;
				}
			}
			
			System.out.println("You need to go from " + start + " on " + startLine + " line to " + common.getName());
			System.out.println("Then, you need to change from " + startLine + " line to " + endLine + " line at " + common.getName());
			System.out.println("Then, travel on the " + endLine + " line from " + common.getName() + " to " + end);
		}
		else if ((startLine.equalsIgnoreCase("pink") && endLine.equalsIgnoreCase("orange")) || 
				(endLine.equalsIgnoreCase("pink") && startLine.equalsIgnoreCase("orange")))
		{
			for (CTAStation e : pink.getStops())
			{
				for(CTAStation f : orange.getStops())
				{
					if (f.equals(e))
						common = f;
				}
			}
			
			System.out.println("You need to go from " + start + " on " + startLine + " line to " + common.getName());
			System.out.println("Then, you need to change from " + startLine + " line to " + endLine + " line at " + common.getName());
			System.out.println("Then, travel on the " + endLine + " line from " + common.getName() + " to " + end);
		}
		else if ((startLine.equalsIgnoreCase("pink") && endLine.equalsIgnoreCase("yellow")) || 
				(endLine.equalsIgnoreCase("pink") && startLine.equalsIgnoreCase("yellow")))
		{
			for (CTAStation e : pink.getStops())
			{
				for(CTAStation f : yellow.getStops())
				{
					if (f.equals(e))
						common = f;
				}
			}
			
			System.out.println("You need to go from " + start + " on " + startLine + " line to " + common.getName());
			System.out.println("Then, you need to change from " + startLine + " line to " + endLine + " line at " + common.getName());
			System.out.println("Then, travel on the " + endLine + " line from " + common.getName() + " to " + end);
		}
		else if ((startLine.equalsIgnoreCase("orange") && endLine.equalsIgnoreCase("yellow")) || 
				(endLine.equalsIgnoreCase("orange") && startLine.equalsIgnoreCase("yellow")))
		{
			multipleStops(red, green, blue, brown, purple, pink, orange, yellow, start, end);
		}
		else
			System.out.println("Invaid input...quitting to main menu");
	}
	
	public void multipleStops (CTARoute red, CTARoute green, CTARoute blue, CTARoute brown, CTARoute purple, CTARoute pink, 
			CTARoute orange, CTARoute yellow, String start, String end)
	{
		//Stations that store the nearest of those two lines
		CTAStation a = new CTAStation();
		CTAStation b = new CTAStation();
		
		if(red.lookupStation(start) != null)
		{
			a = purple.nearestStation(pink.lookupStation(end).getLatitude(), pink.lookupStation(end).getLongitude());
			b = green.nearestStation(pink.lookupStation(end).getLatitude(), pink.lookupStation(end).getLongitude());
			
			if(a.calcDistance(pink.lookupStation(end).getLatitude(), pink.lookupStation(end).getLongitude()) < 
					b.calcDistance(pink.lookupStation(end).getLatitude(), pink.lookupStation(end).getLongitude()))
			{
				CTAStation common1 = new CTAStation();
				CTAStation common2 = new CTAStation();
				for (CTAStation e : red.getStops())
				{
					for(CTAStation f : purple.getStops())
					{
						if (f.equals(e))
							common1 = f;
					}
				}
				
				for (CTAStation e : purple.getStops())
				{
					for(CTAStation f : pink.getStops())
					{
						if (f.equals(e))
							common2 = f;
					}
				}
				
				System.out.println("You need to go from " + start + " on red line to " + common1.getName());
				System.out.println("Then, you need to change from red line to purple line at " + common1.getName());
				System.out.println("Then, travel on the purple line from " + common1.getName() + " to " + common2.getName());
				System.out.println("Switch to pink line at " + common2.getName() + " and continue your journey till " + end);
			}
			else
			{
				CTAStation common1 = new CTAStation();
				CTAStation common2 = new CTAStation();
				for (CTAStation e : red.getStops())
				{
					for(CTAStation f : purple.getStops())
					{
						if (f.equals(e))
							common1 = f;
					}
				}
				
				for (CTAStation e : purple.getStops())
				{
					for(CTAStation f : pink.getStops())
					{
						if (f.equals(e))
							common2 = f;
					}
				}
				
				System.out.println("You need to go from " + start + " on red line to " + common1.getName());
				System.out.println("Then, you need to change from red line to green line at " + common1.getName());
				System.out.println("Then, travel on the green line from " + common1.getName() + " to " + common2.getName());
				System.out.println("Switch to pink line at " + common2.getName() + " and continue your journey till " + end);
			}
		}
		else if (pink.lookupStation(start) != null)
		{
			a = purple.nearestStation(red.lookupStation(end).getLatitude(), red.lookupStation(end).getLongitude());
			b = green.nearestStation(red.lookupStation(end).getLatitude(), red.lookupStation(end).getLongitude());
			
			if(a.calcDistance(red.lookupStation(end).getLatitude(), red.lookupStation(end).getLongitude()) < 
					b.calcDistance(red.lookupStation(end).getLatitude(), red.lookupStation(end).getLongitude()))
			{
				CTAStation common1 = new CTAStation();
				CTAStation common2 = new CTAStation();
				for (CTAStation e : red.getStops())
				{
					for(CTAStation f : purple.getStops())
					{
						if (f.equals(e))
							common1 = f;
					}
				}
				
				for (CTAStation e : purple.getStops())
				{
					for(CTAStation f : pink.getStops())
					{
						if (f.equals(e))
							common2 = f;
					}
				}
				
				System.out.println("You need to go from " + start + " on pink line to " + common1.getName());
				System.out.println("Then, you need to change from pink line to purple line at " + common1.getName());
				System.out.println("Then, travel on the purple line from " + common1.getName() + " to " + common2.getName());
				System.out.println("Switch to red line at " + common2.getName() + " and continue your journey till " + end);
			}
			else
			{
				CTAStation common1 = new CTAStation();
				CTAStation common2 = new CTAStation();
				for (CTAStation e : red.getStops())
				{
					for(CTAStation f : purple.getStops())
					{
						if (f.equals(e))
							common1 = f;
					}
				}
				
				for (CTAStation e : purple.getStops())
				{
					for(CTAStation f : pink.getStops())
					{
						if (f.equals(e))
							common2 = f;
					}
				}
				
				System.out.println("You need to go from " + start + " on pink line to " + common1.getName());
				System.out.println("Then, you need to change from pink line to green line at " + common1.getName());
				System.out.println("Then, travel on the green line from " + common1.getName() + " to " + common2.getName());
				System.out.println("Switch to red line at " + common2.getName() + " and continue your journey till " + end);
			}
		}
		
		else
		{
			System.out.println("Route can't be generated.");
			return;
		}
	}
}




























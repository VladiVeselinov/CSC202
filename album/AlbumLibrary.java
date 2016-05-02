package album;

import java.util.*;

/**
 * AlbumLibrary.java
 * 
 * @author Vladi Veselinov <vpv266@email.vccs.edu>
 * @version 1.0
 */
public class AlbumLibrary
{
    private AlbumList list;

    public AlbumLibrary()
    {
	list = new AlbumList();
    }

    // Method for displaying errors to the console
    private static void error(String message)
    {
	System.out.println("Error: " + message);
    }

    public void add()
    {
	Scanner kbd = new Scanner(System.in);
	System.out.print("Enter title: ");
	String title = kbd.nextLine();
	System.out.print("Enter artist: ");
	String artist = kbd.nextLine();
	int numberOfTracks = 0;
	while (numberOfTracks < 1)
	{
	    System.out.print("Enter number of tracks: ");
	    String s = kbd.nextLine();
	    try
	    {
		numberOfTracks = Integer.parseInt(s);
	    } catch (NumberFormatException e)
	    {
		error("'" + s + "' is not a valid number!");
	    }
	    if (numberOfTracks < 1)
		error("The number of tracks must be positive!");
	}
	long tracking = 0;
	while (tracking < 1)
	{
	    System.out.print("Enter tracking number: ");
	    String s = kbd.nextLine();
	    try
	    {
		tracking = Long.parseLong(s);
	    } catch (NumberFormatException e)
	    {
		error("'" + s + "' is not a valid number!");
	    }
	    if (tracking < 1)
		error("The tracking number must be positive!");
	}
	int copies = 0;
	while (copies < 1)
	{
	    System.out.print("Enter number of copies: ");
	    String s = kbd.nextLine();
	    try
	    {
		copies = Integer.parseInt(s);
	    } catch (NumberFormatException e)
	    {
		error("'" + s + "' is not a valid number!");
	    }
	    if (copies < 1)
		error("The number of copies must be positive!");
	}
	if (list.findRecord(tracking) == null)
	{
	    list.addRecord(tracking, title, artist, numberOfTracks, copies);
	    System.out.println("Record added.");
	} else
	{
	    AlbumRecord rec = list.findRecord(tracking);
	    if (title.equals(rec.getTitle()))
	    {
		rec.incrementCopies(copies);
		System.out.println("Record exists. Copies incremented.");
	    } else
		error("Record exists, but the title doesn't match!");
	}
    }

    public void delete()
    {
	Scanner kbd = new Scanner(System.in);
	long tracking = 0;
	while (tracking < 1)
	{
	    System.out.print("Enter tracking number: ");
	    String s = kbd.nextLine();
	    try
	    {
		tracking = Long.parseLong(s);
	    } catch (NumberFormatException e)
	    {
		error("'" + s + "' is not a valid number!");
	    }
	    if (tracking < 1)
		error("The tracking number must be positive!");
	}
	if (list.findRecord(tracking) == null)
	    error("Record not found.");
	else
	{
	    AlbumRecord rec = list.findRecord(tracking);
	    if (rec.getCopies() == 1)
		list.deleteRecord(rec);
	    else
	    {
		System.out.println("Choose from the following:");
		System.out.println("ALL  : Deletes the record");
		System.out.println("ONE  : Decrements copies held");
		System.out.print("Enter your choice: ");
		String s = kbd.next().toUpperCase();
		switch (s)
		{
		case "ALL":
		    list.deleteRecord(rec);
		    break;
		case "ONE":
		    rec.decrementCopies();
		    break;
		default:
		    error("Invalid choice!");
		}
	    }
	}
    }

    public void list()
    {
	System.out.println(list.listRecords());
    }

    public void find()
    {
	Scanner kbd = new Scanner(System.in);
	System.out.println("Choose from the following:");
	System.out.println("TITLE     : Find by title");
	System.out.println("TRACKING  : Find by tracking number");
	System.out.print("Enter your choice: ");
	String s = kbd.nextLine().toUpperCase();
	switch (s)
	{
	case "TITLE":
	    System.out.print("Enter title: ");
	    String title = kbd.nextLine();
	    if (list.findRecord(title) == null)
		error("Record with title " + title + " not found!");
	    else
		System.out.println(list.findRecord(title).toString());
	    break;
	case "TRACKING":
	    long tracking = 0;
	    while (tracking < 1)
	    {
		System.out.print("Enter tracking number: ");
		String s1 = kbd.nextLine();
		try
		{
		    tracking = Long.parseLong(s1);
		} catch (NumberFormatException e)
		{
		    error("'" + s + "' is not a valid number!");
		}
		if (tracking < 1)
		    error("The tracking number must be positive!");
	    }
	    if (list.findRecord(tracking) == null)
		error("Record with tracking number " + tracking + " not found!");
	    else
		System.out.println(list.findRecord(tracking).toString());
	    break;
	default:
	    error("Invalid choice!");
	}
    }

    public static void main(String[] args)
    {
	Scanner kbd = new Scanner(System.in);
	System.out.println("*************************");
	System.out.println("Welcome to NOVA Library!");
	System.out.println("*************************");
	AlbumLibrary library = new AlbumLibrary();
	String option = "";
	do
	{
	    System.out.println("\nChoose from the following:");
	    System.out.println("ADD     : Add a record to the list");
	    System.out.println("DELETE  : Delete a record from the list");
	    System.out.println("FIND    : Find a record from the list");
	    System.out.println("LIST    : Display all of the records");
	    System.out.println("QUIT    : Exit this program");
	    System.out.print("Enter your choice: ");
	    option = kbd.nextLine().toUpperCase();
	    switch (option)
	    {
	    case "ADD":
		library.add();
		break;
	    case "DELETE":
		library.delete();
		break;
	    case "FIND":
		library.find();
		break;
	    case "LIST":
		library.list();
		break;
	    case "QUIT":
		System.out.println("Have a nice day!");
		break;
	    default:
		error("Invalid choice!");
	    }
	} while (!option.equals("QUIT"));
	kbd.close();
    }
}

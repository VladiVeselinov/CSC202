package album;

/**
 * AlbumRecord.java
 * 
 * @author Vladi Veselinov <vpv266@email.vccs.edu>
 * @version 1.0
 */
public class AlbumRecord
{
    private String title, artist;
    private int numberOfTracks, copies;
    private long trackingNumber;
    private AlbumRecord next; // reference to the next record

    public AlbumRecord()
    {
	title = "";
	artist = "";
	numberOfTracks = 0;
	copies = 0;
	trackingNumber = 0;
	next = null;
    }

    // Getter methods
    public String getTitle()
    {
	return title;
    }

    public String getArtist()
    {
	return artist;
    }

    public int getNumberOfTracks()
    {
	return numberOfTracks;
    }

    public int getCopies()
    {
	return copies;
    }

    public long getTrackingNumber()
    {
	return trackingNumber;
    }

    public AlbumRecord getNext()
    {
	return next;
    }

    // Modifier methods
    public void setTrackingNumber(long n)
    {
	trackingNumber = n;
    }

    public void setCopies(int n)
    {
	copies = n;
    }

    public void incrementCopies(int n)
    {
	copies += n;
    }

    public void decrementCopies()
    {
	copies--;
    }

    public void setNumberOfTracks(int n)
    {
	numberOfTracks = n;
    }

    public void setTitle(String s)
    {
	title = s;
    }

    public void setArtist(String s)
    {
	artist = s;
    }

    public void setNext(AlbumRecord next)
    {
	this.next = next;
    }

    public String toString()
    {
	String s = "";
	s += "\n**********************\n";
	s += "Title: ";
	s += getTitle();
	s += "\nArtist: ";
	s += getArtist();
	s += "\nNumber of tracks: ";
	s += Integer.toString(getNumberOfTracks());
	s += "\nTracking number: ";
	s += Long.toString(getTrackingNumber());
	s += "\nCopies: ";
	s += Integer.toString(getCopies());
	s += "\n**********************\n";
	return s;
    }
}

package album;

/**
 * AlbumList.java
 * 
 * @author Vladi Veselinov <vpv266@email.vccs.edu>
 * @version 1.0
 */
public class AlbumList
{
    private AlbumRecord start;
    private AlbumRecord end;
    private int size;

    public AlbumList()
    {
	start = null;
	end = null;
	size = 0;
    }

    public boolean isEmpty()
    {
	return size == 0;
    }

    public void addRecord(long trck, String ttl, String art, int n, int c)
    {
	AlbumRecord rec = new AlbumRecord();
	rec.setTrackingNumber(trck);
	rec.setTitle(ttl);
	rec.setArtist(art);
	rec.setNumberOfTracks(n);
	rec.setCopies(c);
	if (isEmpty())
	{
	    start = rec;
	    end = rec;
	} else
	{
	    end.setNext(rec);
	    end = rec;
	}
	size++;
    }

    public void deleteRecord(AlbumRecord rec)
    {
	if (isEmpty())
	    return;
	if (start == rec)
	{
	    start = rec.getNext();
	    size--;
	    if (isEmpty())
		end = null;
	    return;
	}
	AlbumRecord it = start; // iterator
	while (it != null)
	{
	    if (it.getNext() == rec)
	    {
		it.setNext(rec.getNext());
		size--;
		if (it.getNext() == null)
		    end = it;
		return;
	    }
	    it = it.getNext();
	}
    }

    public AlbumRecord findRecord(long tracking)
    {
	if (isEmpty())
	    return null;
	AlbumRecord it = start; // iterator
	while (it != null)
	{
	    if (it.getTrackingNumber() == tracking)
		return it;
	    it = it.getNext();
	}
	return null; // if not found
    }

    public AlbumRecord findRecord(String title)
    {
	if (isEmpty())
	    return null;
	AlbumRecord it = start; // iterator
	while (it != null)
	{
	    if (it.getTitle().equals(title))
		return it;
	    it = it.getNext();
	}
	return null; // if not found
    }

    public String listRecords()
    {
	if (isEmpty())
	    return "There are no records in the list.";
	String s = "";
	AlbumRecord it = start; // iterator
	while (it != null)
	{
	    s += it.toString();
	    it = it.getNext();
	}
	return s;
    }
}

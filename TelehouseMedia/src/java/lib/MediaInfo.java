package lib;

/**
 *
 * @author Konstantin Goncharov
 */
public class MediaInfo {

	public MediaInfo() {
	}

	public MediaInfo(String aurl, String iurl, String genre, String artist, String title) {
		this.aurl = aurl;
		this.iurl = iurl;
		this.genre = genre;
		this.artist = artist;
		this.title = title;
	}

	private String aurl = null;
	private String iurl = null;
	private String genre = null;
	private String artist = null;
	private String title = null;

	/**
	 * @return the aurl
	 */
	public String getAurl() {
		return aurl;
	}

	/**
	 * @param aurl the aurl to set
	 */
	public void setAurl(String aurl) {
		this.aurl = aurl;
	}

	/**
	 * @return the iurl
	 */
	public String getIurl() {
		return iurl;
	}

	/**
	 * @param iurl the iurl to set
	 */
	public void setIurl(String iurl) {
		this.iurl = iurl;
	}

	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}

	/**
	 * @return the artist
	 */
	public String getArtist() {
		return artist;
	}

	/**
	 * @param artist the artist to set
	 */
	public void setArtist(String artist) {
		this.artist = artist;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
}

package com.mycompany.java.model;
import com.mycompany.java.interfaces.Deliverable;

/**
 * Represents a TV series with attributes like title, seasons, and creator.
 * Implements Entregable to manage delivery status and comparison by seasons.
 */
public class TvSeries implements Deliverable {
    // Constants
    private static final int DEFAULT_SEASONS = 3; // Default number of seasons
    public static final int GREATER = 1;          // Indicates this series has more seasons
    public static final int LESS = -1;            // Indicates this series has fewer seasons
    public static final int EQUAL = 0;            // Indicates equal number of seasons

    // Attributes
    private String title;         // Title of the series
    private int numberOfSeasons;  // Number of seasons
    private boolean delivered;    // Delivery status (true if lent, false if available)
    private String genre;         // Genre (e.g., Comedy, Thriller)
    private String creator;       // Creator or showrunner of the series

    // Constructors
    /**
     * Default constructor: creates a series with default values.
     */
    public TvSeries() {
        this("", DEFAULT_SEASONS, "", "");
    }

    /**
     * Constructor with title and creator; other attributes use defaults.
     * @param title the series title
     * @param creator the series creator
     */
    public TvSeries(String title, String creator) {
        this(title, DEFAULT_SEASONS, "", creator);
    }

    /**
     * Constructor with all attributes except delivered, which defaults to false.
     * @param title the series title
     * @param numberOfSeasons number of seasons
     * @param genre the series genre
     * @param creator the series creator
     */
    public TvSeries(String title, int numberOfSeasons, String genre, String creator) {
        this.title = title;
        this.numberOfSeasons = numberOfSeasons;
        this.genre = genre;
        this.creator = creator;
        this.delivered = false;
    }

    // Getters
    public String getTitle() { return title; }
    public int getNumberOfSeasons() { return numberOfSeasons; }
    public String getGenre() { return genre; }
    public String getCreator() { return creator; }

    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setNumberOfSeasons(int numberOfSeasons) { this.numberOfSeasons = numberOfSeasons; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setCreator(String creator) { this.creator = creator; }

    // Deliverable Interface Methods
    @Override
    public void deliver() {
        delivered = true; // Mark as delivered
    }

    @Override
    public void returnItem() {
        delivered = false; // Mark as returned
    }

    @Override
    public boolean isDelivered() {
        return delivered; // Return current delivery status
    }

    @Override
    public int compareTo(Object obj) {
        TvSeries other = (TvSeries) obj; // Cast the object to a Serie
        if (this.numberOfSeasons > other.numberOfSeasons) return GREATER;
        if (this.numberOfSeasons < other.numberOfSeasons) return LESS;
        return EQUAL;
    }

    // toString
    @Override
    public String toString() {
        return "Series Info:\n" +
                "\tTitle: " + title + "\n" +
                "\tSeasons: " + numberOfSeasons + "\n" +
                "\tGenre: " + genre + "\n" +
                "\tCreator: " + creator;
    }
}
package com.mycompany.java.model;
import com.mycompany.java.interfaces.Deliverable;

/**
 * Represents a video game with attributes like title, hours, and company.
 * Implements Deliverable to manage delivery status and comparison by hours.
 */
public class VideoGame implements Deliverable {
    // Constants
    private static final int DEFAULT_HOURS = 10; // Default estimated hours
    public static final int GREATER = 1;         // Indicates this game has more hours
    public static final int LESS = -1;           // Indicates this game has fewer hours
    public static final int EQUAL = 0;           // Indicates equal hours

    // Attributes
    private String title;         // Title of the video game
    private int estimatedHours;   // Estimated hours to complete
    private boolean delivered;    // Delivery status (true if lent, false if available)
    private String genre;         // Genre (e.g., Action, RPG)
    private String company;       // Company that developed the game

    // Constructors
    /**
     * Default constructor: creates a video game with default values.
     */
    public VideoGame() {
        this("", DEFAULT_HOURS, "", "");
    }

    /**
     * Constructor with title and estimated hours; other attributes use defaults.
     * @param title the game title
     * @param estimatedHours hours to complete the game
     */
    public VideoGame(String title, int estimatedHours) {
        this(title, estimatedHours, "", "");
    }

    /**
     * Constructor with all attributes except delivered, which defaults to false.
     * @param title the game title
     * @param estimatedHours hours to complete the game
     * @param genre the game genre
     * @param company the developing company
     */
    public VideoGame(String title, int estimatedHours, String genre, String company) {
        this.title = title;
        this.estimatedHours = estimatedHours;
        this.genre = genre;
        this.company = company;
        this.delivered = false;
    }

    // Getters
    public String getTitle() { return title; }
    public int getEstimatedHours() { return estimatedHours; }
    public String getGenre() { return genre; }
    public String getCompany() { return company; }

    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setEstimatedHours(int estimatedHours) { this.estimatedHours = estimatedHours; }
    public void setGenre(String genre) { this.genre = genre; }
    public void setCompany(String company) { this.company = company; }

    // Entregable Interface Methods
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
        VideoGame other = (VideoGame) obj; // Cast the object to a Videojuego
        if (this.estimatedHours > other.estimatedHours) return GREATER;
        if (this.estimatedHours < other.estimatedHours) return LESS;
        return EQUAL;
    }

    // toString
    @Override
    public String toString() {
        return "Video Game Info:\n" +
                "\tTitle: " + title + "\n" +
                "\tEstimated Hours: " + estimatedHours + "\n" +
                "\tGenre: " + genre + "\n" +
                "\tCompany: " + company;
    }
}
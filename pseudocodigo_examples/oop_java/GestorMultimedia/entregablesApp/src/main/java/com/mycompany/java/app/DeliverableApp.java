package com.mycompany.java.app;
import com.mycompany.java.model.TvSeries;
import com.mycompany.java.model.VideoGame;

/**
 * Main application to manage and analyze a collection of series and video games.
 * Creates arrays, delivers items, counts delivered items, and finds the longest items.
 */
public class DeliverableApp {
    public static void main(String[] args) {
        // Create arrays for series and video games
        TvSeries[] seriesList = new TvSeries[5];
        VideoGame[] videoGameList = new VideoGame[5];

        // Populate series array with sample data
        seriesList[0] = new TvSeries(); // Default series
        seriesList[1] = new TvSeries("Game of Thrones", "George R. R. Martin");
        seriesList[2] = new TvSeries("The Simpsons", 25, "Comedy", "Matt Groening");
        seriesList[3] = new TvSeries("Family Guy", 12, "Comedy", "Seth MacFarlane");
        seriesList[4] = new TvSeries("Breaking Bad", 5, "Thriller", "Vince Gilligan");

        // Populate video games array with sample data
        videoGameList[0] = new VideoGame(); // Default video game
        videoGameList[1] = new VideoGame("Assassin’s Creed 2", 30);
        videoGameList[2] = new VideoGame("God of War 3", 50, "Action", "Santa Monica Studio");
        videoGameList[3] = new VideoGame("Super Mario 3DS", 30, "Platform", "Nintendo");
        videoGameList[4] = new VideoGame("Final Fantasy X", 200, "RPG", "Square Enix");

        // Deliver some items
        seriesList[1].deliver();  // Game of Thrones
        seriesList[4].deliver();  // Breaking Bad
        videoGameList[0].deliver(); // Default game
        videoGameList[3].deliver(); // Super Mario 3DS

        // Count delivered items and return them
        int deliveredCount = 0;
        for (int i = 0; i < seriesList.length; i++) {
            if (seriesList[i].isDelivered()) {
                deliveredCount++;
                seriesList[i].returnItem(); // Return the item after counting
            }
            if (videoGameList[i].isDelivered()) {
                deliveredCount++;
                videoGameList[i].returnItem(); // Return the item after counting
            }
        }
        System.out.println("Number of delivered items: " + deliveredCount);

        // Find the series with the most seasons and the video game with the most hours
        TvSeries longestSeries = seriesList[0];
        VideoGame longestGame = videoGameList[0];
        for (int i = 1; i < seriesList.length; i++) {
            if (seriesList[i].compareTo(longestSeries) == TvSeries.GREATER) {
                longestSeries = seriesList[i]; // Update if more seasons
            }
            if (videoGameList[i].compareTo(longestGame) == VideoGame.GREATER) {
                longestGame = videoGameList[i]; // Update if more hours
            }
        }

        // Display the longest series and video game
        System.out.println("\nLongest Series:\n" + longestSeries);
        System.out.println("\nLongest Video Game:\n" + longestGame);
    }
}
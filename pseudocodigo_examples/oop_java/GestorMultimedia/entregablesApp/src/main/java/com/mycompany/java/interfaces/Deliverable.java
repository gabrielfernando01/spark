package com.mycompany.java.interfaces;

/**
 * Interface that defines methods for items that can be delivered and compared.
 * Used by classes like tvSeries and videoGame to handle delivery status and comparisons.
 */
public interface Deliverable {
    /**
     * Marks the item as delivered (e.g., lent or used).
     */
    void deliver();

    /**
     * Marks the item as returned (e.g., available again).
     */
    void returnItem();

    /**
     * Check if the item is currently delivered.
     * @return true if delivered, false otherwise
     */
    boolean isDelivered();

    /**
     * Compares this item to another based on specific attribute (e.g. seasons or hours).
     * @param obj the object to compare with
     * @return 1 if this is greater, -1 if less, 0 if equal
     */
    int compareTo(Object obj);
}

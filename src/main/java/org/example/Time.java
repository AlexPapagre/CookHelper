package org.example;

/**
 * A time interface
 */
public interface Time {

    /**
     * Returns seconds.
     *
     * @return time the time in seconds
     */
    long getSeconds();

    /**
     * Add t to this time.
     *
     * @param t the second time to add
     */
    void addTimes(Time t);

    // Returns time as String

    /**
     * Returns time.
     *
     * @return str the time
     */
    @Override
    String toString();

}

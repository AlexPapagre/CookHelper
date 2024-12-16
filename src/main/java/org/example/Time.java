package org.example;

public interface Time {


    // Returns time
    long getTime();

    // Takes one time and adds to this time
    void addTimes(Time t);

    // Returns time as String
    @Override
    String toString();

}

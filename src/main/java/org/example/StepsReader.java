package org.example;

import java.util.List;

public interface StepsReader {

    // Returns a list of steps of the given file
    List<Step> parseSteps(String fileName);

}

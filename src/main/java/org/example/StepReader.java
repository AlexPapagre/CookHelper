package org.example;

import java.util.List;

/**
 * A step reader interface
 */
public interface StepReader {

    // Returns a list of steps of the given file

    /**
     * Parse steps. Returns list of steps.
     *
     * @param fileName the name of the file
     * @return steps the list of steps
     */
    List<Step> parseSteps(String fileName);
}

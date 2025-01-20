package org.example;

import java.util.Iterator;

public class Convertor {

    public static String convertIngredient(double amount, String measure) {
        int bigAmount = (int) (amount / 1000), smallAmount = (int) (amount % 1000);

        // Find measure
        String bigMeasure, smallMeasure;
        if (measure.equals("gr")) {

            // Big measure
            bigMeasure = "κιλ";
            bigMeasure += bigAmount == 1 ? "ό" : "ά";

            // Small measure
            smallMeasure = "γραμμάρι";
            smallMeasure += smallAmount == 1 ? "ο" : "α";

        } else if (measure.equals("ml")) {

            // Big measure
            bigMeasure = "λίτρ";
            bigMeasure += bigAmount == 1 ? "ο" : "α";

            // Small measure
            smallMeasure = "χιλιοστόλιτρ";
            smallMeasure += smallAmount == 1 ? "ο" : "α";

        } else {

            StringBuilder str = new StringBuilder();

            // Amount
            if (amount == (int) amount) {
                str.append(" ").append((int) amount);
            } else {
                str.append(" ").append(amount);
            }

            // Measure
            if (!measure.isEmpty()) {
                str.append(" ").append(measure);
            }

            return str.toString();
        }

        StringBuilder str = new StringBuilder();

        // Big measure
        if (bigAmount > 0) {
            str.append(" ").append(bigAmount).append(" ").append(bigMeasure);
        }

        // Small measure
        if (smallAmount > 0) {
            if (bigAmount > 0) {
                str.append(" και");
            }
            str.append(" ").append(smallAmount).append(" ").append(smallMeasure);
        }

        return str.toString();
    }

    public static String convertTime(long seconds) {

        if (seconds <= 0) {
            return "Δεν υπάρχει χρόνος αναμονής.";
        }

        long h = seconds / 60 / 60, m = (seconds / 60) % 60, s = seconds % 60;
        StringBuilder str = new StringBuilder();

        // Hours
        if (h > 0) {
            str.append(h).append(" ώρ");
            str.append(h == 1 ? "α" : "ες");
        }

        // Minutes
        if (m > 0) {
            if (h > 0) {
                if (s > 0) {
                    str.append(", ");
                } else {
                    str.append(" και ");
                }
            }
            str.append(m).append(" λεπτ");
            str.append(m == 1 ? "ό" : "ά");
        }

        // Seconds
        if (s > 0) {
            if (h > 0 || m > 0) {
                str.append(" και ");
            }
            str.append(s).append(" δευτερόλεπτ");
            str.append(s == 1 ? "ο" : "α");
        }

        return str.toString();
    }

    public static String convertCountdownTime(long seconds) {
        return "Χρονόμετρο: " + convertTime(seconds);
    }

    public static String convertNames(Iterator<String> namesIterator) {
        StringBuilder str = new StringBuilder();

        str.append("'").append(namesIterator.next()).append("'");
        while (namesIterator.hasNext()) {
            str.append(", '").append(namesIterator.next()).append("'");
        }

        return str.toString();
    }

    public static String convertFileName(String file) {
        return splitFileNameAndFilePath(file, 0);
    }

    public static String convertFileNames(Iterator<String> namesIterator) {
        StringBuilder str = new StringBuilder();

        str.append("'").append(convertFileName(namesIterator.next())).append("'");
        while (namesIterator.hasNext()) {
            str.append(", '").append(convertFileName(namesIterator.next())).append("'");
        }

        return str.toString();
    }

    public static String convertFilePath(String file) {
        return splitFileNameAndFilePath(file, 1);
    }

    private static String splitFileNameAndFilePath(String file, int i) {
        String[] parts = file.split(" --> \\(");
        parts[1] = parts[1].replace(")", "");

        return parts[i];
    }
}

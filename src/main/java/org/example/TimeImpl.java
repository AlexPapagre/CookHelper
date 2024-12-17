package org.example;

public class TimeImpl implements Time {
    private long seconds;

    public TimeImpl() {
        this(0);
    }

    public TimeImpl(long time) {
        this(time, "seconds");
    }

    public TimeImpl(double time, String measure) {
        calculateTime(time, measure);
    }

    @Override
    public long getSeconds() {
        return seconds;
    }

    @Override
    public void addTimes(Time t) {
        this.seconds += t.getSeconds();
    }

    @Override
    public String toString() {
        return Convertor.convertTime(seconds);
    }

    private void calculateTime(double time, String measure) {
        if (measure.equalsIgnoreCase("seconds") || measure.equalsIgnoreCase("second") || measure.equalsIgnoreCase("δευτερόλεπτα") || measure.equalsIgnoreCase("δευτερόλεπτο")) {
            this.seconds = (long) time;
        } else if (measure.equalsIgnoreCase("minutes") || measure.equalsIgnoreCase("minute") || measure.equalsIgnoreCase("λεπτά") || measure.equalsIgnoreCase("λεπτό")) {
            this.seconds = (long) (time * 60);
        } else if (measure.equalsIgnoreCase("hours") || measure.equalsIgnoreCase("hour") || measure.equalsIgnoreCase("ώρες") || measure.equalsIgnoreCase("ώρα")) {
            this.seconds = (long) (time * 60 * 60);
        } else {
            Logger logErr = new ErrorLogger();
            logErr.log("File has an unrecognizable time measure!");
            logErr.log("\"" + measure + "\" is not a supported time measure.");
            logErr.log("Supported time measures: seconds, second, δευτερόλεπτα, δευτερόλεπτo, minutes, minute, λεπτά, λεπτό, hours, hour, ώρες, ώρα.");
            Exit.error();
        }
    }

}

package perfectcube.tag.game;

public class TNTTimer {

    private String unit;
    private int value;
    private long time;

    public TNTTimer(String unit, int value) {
        this.unit = unit;
        this.value = value;
    }

    public void run() {
        long end = System.currentTimeMillis() + TimeUnit.getTicks(unit, value);

        long now = System.currentTimeMillis();
        long diff = end - now;
        if (diff > 0) {
            time = end;
        }
    }

    public void addTime(String unit, int value) {
        time += TimeUnit.getTicks(unit, value);
    }

    public String getTimeLeft(boolean base) {
        String message = "";

        long now = System.currentTimeMillis();
        long diff = time - now;
        int seconds = (int) (diff / 1000);

        if(seconds >= 60) {
            int min = seconds / 60;
            seconds = seconds % 60;

            message += min + ":";
        }
        if(seconds >= 10) {
            message += seconds + "";
        }
        if(seconds < 10 && time >= 1) {
            message += (base) ? "0" + seconds + "":seconds + "";
        }

        return message;
    }

    public int getSeconds() {
        long now = System.currentTimeMillis();
        long diff = time - now;
        int seconds = (int) (diff / 1000);
        return seconds;
    }

    public boolean isFinished() {
        long end = time;
        long now = System.currentTimeMillis();
        long diff = end - now;

        if (diff <= 0) {
            return true;
        }
        return false;
    }

    public long getTime() {
        return time;
    }

    public void stop() {
        time = 0;
    }

    public enum TimeUnit {
        SECOND("seconds", 1), MINUTE("minutes", 1*60);

        public String name;
        public int multi;

        TimeUnit(String n, int mult) {
            name = n;
            multi = mult;
        }

        public static long getTicks(String un, int time) {
            long sec = time;

            for (TimeUnit unit : TimeUnit.values()) {
                if (un.equals(unit.name)) {
                    return (sec *= unit.multi)*1000;
                }
            }

            return 0;
        }
    }
}
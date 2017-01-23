package main.java;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {


    private static final long DAYS_IN_MILLION_SECONDS = 86400000;// 24 * 60 * 60



    /**
     * count the days between calendar dates. for example, the interval is 1 day
     * from 1/1, 8PM to 1/2, 8AM
     *
     * @param begin
     * @param end
     * @return 0 if begin and end are the same day. return negative number if
     *         end date is before begin date,
     */
    public static int countDays(Calendar begin, Calendar end) {
        // time in milliseconds
        Calendar from, to;

        long m1 = begin.getTimeInMillis();
        long m2 = end.getTimeInMillis();

        boolean negative = false;
        long diffM;
        if (m1 > m2) {
            negative = true;
            from = (Calendar) end.clone();
            to = (Calendar) begin.clone();
            diffM = m1 - m2;
        } else {
            from = (Calendar) begin.clone();
            to = (Calendar) end.clone();
            diffM = m2 - m1;
        }

        // the diffDays might be negative numbers
        int diffDays = (int) (diffM / DAYS_IN_MILLION_SECONDS);

        if (diffDays > 0) {
            from.add(Calendar.DAY_OF_YEAR, diffDays);
        }

        if (from.get(Calendar.YEAR) == to.get(Calendar.YEAR)) {
            if (from.get(Calendar.DAY_OF_YEAR) < to.get(Calendar.DAY_OF_YEAR)) {
                // they
                // are
                // two
                // days
                // like
                // 1/11,
                // 1/12
                diffDays++;
            }
        } else {// cross year, this only happens at 12/31 and 1/1
            diffDays++;
        }

        if (negative) {
            return 0 - diffDays;
        } else {
            return diffDays;
        }
    }

    public static int countDays(Date from, Date to) {
        Calendar from2 = Calendar.getInstance();
        from2.setTime(from);

        Calendar to2 = Calendar.getInstance();
        to2.setTime(to);

        return countDays(from2, to2);
    }
}

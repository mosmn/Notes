package sections.java;

import java.util.GregorianCalendar;

// import java.lang.Math;

class QuickStart {
    public static void main(String[] args) {
        // Create a GregorianCalendar object representing a specific date and time
        GregorianCalendar calendar = new GregorianCalendar();
        // Note: In the GregorianCalendar constructor, months are 0-based (0 = January, 1 = February, and so on).

        // Retrieve different pieces of calendar information using the constants

        int year = calendar.get(GregorianCalendar.YEAR);
        int month = calendar.get(GregorianCalendar.MONTH); // 0-based (0 = January, 11 = December)
        int dayOfMonth = calendar.get(GregorianCalendar.DAY_OF_MONTH);
        int dayOfWeek = calendar.get(GregorianCalendar.DAY_OF_WEEK); // 1 = Sunday, 2 = Monday, and so on
        int dayOfYear = calendar.get(GregorianCalendar.DAY_OF_YEAR);
        int hour = calendar.get(GregorianCalendar.HOUR_OF_DAY);
        int minute = calendar.get(GregorianCalendar.MINUTE);
        int second = calendar.get(GregorianCalendar.SECOND);
        int millisecond = calendar.get(GregorianCalendar.MILLISECOND);

        System.out.println("Year: " + year);
        System.out.println("Month: " + (month + 1)); // Adding 1 to convert to 1-based month
        System.out.println("Day of Month: " + dayOfMonth);
        System.out.println("Day of Week: " + dayOfWeek);
        System.out.println("Day of Year: " + dayOfYear);
        System.out.println("Hour: " + hour);
        System.out.println("Minute: " + minute);
        System.out.println("Second: " + second);
        System.out.println("Millisecond: " + millisecond);
    }
    
}


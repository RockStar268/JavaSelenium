package commons;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConvertDate {

    public String convertNumericMonth(String month){
        month = extractMonthOutOfDate(month);
        System.out.println(month);
        switch(month) {
            case "01":
                return "Jan";
            case "02":
                return "Feb";
            case "03":
                return "Mar";
            case "04":
                return "Apr";
            case "05":
                return "May";
            case "06":
                return "Jun";
            case "07":
                return "Jul";
            case "08":
                return "Aug";
            case "09":
                return "Sep";
            case "10":
                return "Oct";
            case "11":
                return "Nov";
            case "12":
                return "Dec";
            default:
                System.out.println("Invalid month input");
                return null;
        }
    }

    public String[] bookingDateConfirmPay(String dateStart, String dateEnd){

        String convertMonthStart = convertNumericMonth(dateStart);
        String convertMonthEnd = convertNumericMonth(dateEnd);

        return new String[] {convertMonthStart, convertMonthEnd};

    }

    public String extractDayOutOfDate(String date){
        try {
            // Create a SimpleDateFormat object to parse the date string
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

            // Parse the date string to a Date object
            Date d = dateFormat.parse(date);

            // Extract the day from the Date object
            SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
            return dayFormat.format(d);

        } catch (Exception e) {
            e.printStackTrace();
            // Handle parsing exceptions
        }
        return date;
    }

    public String extractMonthOutOfDate(String date){
        try {
            // Create a SimpleDateFormat object to parse the date string
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

            // Parse the date string to a Date object
            Date m = dateFormat.parse(date);

            // Extract the day from the Date object
            SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
            return monthFormat.format(m);

        } catch (Exception e) {
            e.printStackTrace();
            // Handle parsing exceptions
        }
        return date;
    }
}

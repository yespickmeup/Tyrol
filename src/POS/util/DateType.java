/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dummy
 */
public class DateType {

    public static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat datetime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss aa");
    public static SimpleDateFormat time2 = new SimpleDateFormat("HH:mm aa");
    public static SimpleDateFormat time3 = new SimpleDateFormat("hh:mm:ss aa");
    public static SimpleDateFormat sf1 = new SimpleDateFormat("EEE, MMM dd,yyyy");
    public static SimpleDateFormat d = new SimpleDateFormat("dd");
    public static SimpleDateFormat m = new SimpleDateFormat("MMMMMMMMMMM");
    public static SimpleDateFormat m1 = new SimpleDateFormat("MM");
    public static SimpleDateFormat y = new SimpleDateFormat("yyyy");
    public static SimpleDateFormat liquid = new SimpleDateFormat("EEEEEEEEEEE dd MMMMMMMMMMM yyyy");
    public static SimpleDateFormat day = new SimpleDateFormat("EEEEEEEEEEE");
    public static SimpleDateFormat day_1 = new SimpleDateFormat("EEEEEEEEEEE dd");
    public static SimpleDateFormat month_year = new SimpleDateFormat("MMMMMMMMMMM yyyy");
    public static SimpleDateFormat month_date = new SimpleDateFormat("MMMMMMMMMM dd, yyyy");
    public static SimpleDateFormat day_and_time = new SimpleDateFormat("MMMMMMMMMM dd, yyyy HH:mm aa");
    public static SimpleDateFormat slash = new SimpleDateFormat("MM/dd/yyyy");
    public static SimpleDateFormat slash_w_time = new SimpleDateFormat("MM/dd/yyyy HH:mm aa");

    public static void main(String[] args) {
        System.out.println(sf1.format(new Date()));
    }

    public static String convert_jan_1_2013_datetime(String datetime) {
        String date = "";
        Date d = new Date();
        if (datetime.isEmpty()) {
            datetime = DateType.datetime.format(new Date());
        }
        try {
            d = DateType.datetime.parse(datetime);
        } catch (ParseException ex) {
            Logger.getLogger(DateType.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        date = DateType.day_and_time.format(d);
        return date;
    }
     public static String convert_jan_1_2013_datetime2(String datetime) {
        String date = "";
        Date d = new Date();
        if (datetime==null) {
            datetime = DateType.datetime.format(new Date());
        }
        try {
            d = DateType.datetime.parse(datetime);
        } catch (ParseException ex) {
            Logger.getLogger(DateType.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        date = DateType.month_date.format(d);
        return date;
    }
public static String convert_jan_1_2013_sf(String datetime) {
        String date = "";
        Date d = new Date();
        if (datetime.isEmpty()) {
            datetime = DateType.sf.format(new Date());
        }
        try {
            d = DateType.sf.parse(datetime);
        } catch (ParseException ex) {
            Logger.getLogger(DateType.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        date = DateType.month_date.format(d);
        return date;
    }

    public static String convert_slash_datetime(String datetime) {
        String date = "";
        Date d = new Date();
        if (datetime.isEmpty()) {
            datetime = DateType.datetime.format(new Date());
        }
        try {
            d = DateType.datetime.parse(datetime);
        } catch (ParseException ex) {
            Logger.getLogger(DateType.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        date = DateType.slash.format(d);
        return date;
    }
     public static String convert_slash_datetime2(String datetime) {
        String date = "";
        Date d = new Date();
        if (datetime.isEmpty()) {
            datetime = DateType.datetime.format(new Date());
        }
        try {
            d = DateType.datetime.parse(datetime);
        } catch (ParseException ex) {
            Logger.getLogger(DateType.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        date = DateType.slash_w_time.format(d);
        return date;
    }

    public static String convert_dash_date(String datetime) {
        String date = "";
        Date d = new Date();
        if (datetime.isEmpty()) {
            datetime = DateType.sf.format(new Date());
        }
        try {
            d = DateType.sf.parse(datetime);
        } catch (ParseException ex) {
            Logger.getLogger(DateType.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        date = DateType.month_date.format(d);
        return date;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.category;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import mijzcx.synapse.desk.utils.FitIn;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellReference;

/**
 *
 * @author Ronald
 */
public class Excel_categories {

    public static class to_encoded {

        public final String id;
        public final String category;

        public to_encoded(String id, String category) {
            this.id = id;
            this.category = category;
        }

    }

    public static void main(String[] args) {
        FileInputStream fis = null;
        String file = "C:\\Users\\Ronald\\Documents\\Projects\\casablanca\\categories.xls";
        final List sheetData = new ArrayList();
        try {
            fis = new FileInputStream(file);
            HSSFWorkbook workbook = new HSSFWorkbook(fis);
            HSSFSheet sheet = workbook.getSheetAt(0);
            Iterator rows = sheet.rowIterator();
            while (rows.hasNext()) {
                HSSFRow row = (HSSFRow) rows.next();
                Iterator cells = row.cellIterator();

                List data = new ArrayList();
                while (cells.hasNext()) {
                    HSSFCell cell = (HSSFCell) cells.next();
                    data.add(cell);
                }
                sheetData.add(data);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Unsupported Format");
        } finally {

            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(Excel_categories.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        List<to_encoded> datas = showExcelData(sheetData, file);

        for (to_encoded to : datas) {
            int id=FitIn.toInt(to.id);
            String category=to.category;
            String printing_assembly_id="1";
            String printing_assembly_name="Bar";
            String group_id="1";
            String group_name="Beverages";
            S1_inv_categories.to_inv_categories t=new S1_inv_categories.to_inv_categories(id, category, printing_assembly_id, printing_assembly_name, group_id, group_name);
            S1_inv_categories.add_inv_categories(t);
        }
    }

    public static List<to_encoded> showExcelData(List sheetData, String path) {

        FileInputStream fis;
        List<to_encoded> datas = new ArrayList();
        try {
            fis = new FileInputStream(path);
            int r = 0;
            int r_set = 1;
            int id = 0;
            for (int i = 0; i < sheetData.size(); i++) {
                List list = (List) sheetData.get(i);
                int size = list.size();
                String[] record = new String[2];
                int record_size = 0;
                for (int j = 0; j < list.size(); j++) {

                    CellReference cellReference = new CellReference("B3");
                    HSSFCell cell = (HSSFCell) list.get(j);
                    HSSFDataFormatter hdf = new HSSFDataFormatter();
                    String data = "";
                    if (j >= 2) {
                        break;
                    }
                    if (j == 0) {
                        data = "" + cell.getNumericCellValue();

                    } else {
                        data = cell.getStringCellValue();
                    }
                    record[record_size] = data;
                    System.out.print(data + " | ");
                    record_size++;
                }

                to_encoded t = new to_encoded(record[0], record[1]);
                if (record[0] != null) {
                    datas.add(t);
                    System.out.println("");
                }

            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Excel_categories.class.getName()).log(Level.SEVERE, null, ex);
        }

        return datas;
    }

    public static Date getRoundedDate(double date) {
        int SECONDS_PER_DAY = 24 * 3600;

        int wholeDays = (int) Math.floor(date);
        double ms = date - wholeDays;

        /**
         * round the time part to seconds
         */
        int millisecondsInDay = (int) Math.round(SECONDS_PER_DAY * ms) * 1000;

        Calendar calendar = new GregorianCalendar(); // using default time-zone
        org.apache.poi.ss.usermodel.DateUtil.setCalendar(calendar, wholeDays, millisecondsInDay, false);

        return calendar.getTime();
    }
}

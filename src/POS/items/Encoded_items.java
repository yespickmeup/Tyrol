/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.items;

import POS.category.Excel_categories;
import POS.sales.S1_multi_pricing;
import POS.util.DateType;
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
public class Encoded_items {

    public static class to_encoded {

        public final String description;
        public final String category_id;
        public final String category_name;
        public final double selling_price;

        public to_encoded(String description, String category_id, String category_name, double selling_price) {
            this.description = description;
            this.category_id = category_id;
            this.category_name = category_name;
            this.selling_price = selling_price;
        }

    }

    public static void main(String[] args) {
        FileInputStream fis = null;
        String file = "C:\\Users\\Ronald\\Documents\\Projects\\casablanca\\items.xls";
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
        int i = 1;
        for (to_encoded to : datas) {
            int id = 0;
            String barcode=""+i;
            String description=to.description;
            String generic_name="";
            String category=to.category_name;
            String category_id=""+FitIn.toInt(to.category_id);
            String classification="";
            String classification_id="";
            String sub_classification="";
            String sub_classification_id="";
            double product_qty=100;
            String unit="";
            double conversion=1;
            double selling_price=to.selling_price;
            String date_added=DateType.datetime.format(new Date());
            String user_name="";
            String item_type="";
            int status=1;
            String supplier="";
            int fixed_price=1;
            double cost=to.selling_price;
            String supplier_id="";
            int multi_level_pricing=0;
            List<S1_multi_pricing.to_multi_pricing> multi=new ArrayList();
            int vatable=0;
            double reorder_level=10;
            String printing_assembly_id="1";
            String printing_assembly_name="Bar";
            String group_id="1";
            String group_name="Beverages";
            System.out.println(""+i);
            i++;
            
            S1_items.to_items t=new S1_items.to_items(id, barcode, description, generic_name, category, category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price, date_added, user_name, item_type, status, supplier, fixed_price, cost, supplier_id, multi_level_pricing, multi, vatable, reorder_level, printing_assembly_id, printing_assembly_name, group_id, group_name);
            S1_items.add_items(t);
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
                String[] record = new String[4];
                int record_size = 0;
                for (int j = 0; j < list.size(); j++) {

                    CellReference cellReference = new CellReference("B3");
                    HSSFCell cell = (HSSFCell) list.get(j);
                    HSSFDataFormatter hdf = new HSSFDataFormatter();
                    String data = "";
                    if (j >= 4) {
                        break;
                    }
                    if (j == 1 || j == 3) {
                        data = "" + cell.getNumericCellValue();

                    } else {
                        data = cell.getStringCellValue();
                    }
                    record[record_size] = data;
                    System.out.print(data + " | ");
                    record_size++;
                }

                to_encoded t = new to_encoded(record[0], record[1], record[2], FitIn.toDouble(record[3]));
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

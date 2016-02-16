/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.sales;

import POS.items.S1_items;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author i1
 */
public class S1_sales_items {

    public static class to_sales_items {

        public final int id;
        public final String barcode;
        public final String description;
        public final String generic_name;
        public final String category;
        public final String category_id;
        public final String classification;
        public final String classification_id;
        public final String sub_classification;
        public final String sub_classification_id;
        public final double product_qty;
        public final String unit;
        public final double conversion;
        public final double selling_price;
        public final String date_added;
        public final String user_name;
        public final String item_type;
        public final int status;
        public final String session_no;
        public final String item_discount;
        public final double discount;
        public final double discount_amount;
        public final String sales_no;
        public final int fixed_price;
        public final String supplier;
        public final String supplier_id;
        public final int vatable;
        public final String or_no;
        public final String customer_name;
        public final String customer_id;
        public final String printing_assembly_id;
        public final String printing_assembly_name;
        public final String group_id;
        public final String group_name;

        public final String table_id;
        public final String table_name;
        public final String customer_ids;
        public final String customer_names;
        public final String waiter_id;
        public final String waiter_name;
        public final String specifications;
        
        public to_sales_items(int id, String barcode, String description, String generic_name, String category, String category_id
                , String classification, String classification_id, String sub_classification, String sub_classification_id
                , double product_qty, String unit, double conversion, double selling_price, String date_added, String user_name
                , String item_type, int status, String session_no, String item_discount, double discount, double discount_amount
                , String sales_no, int fixed_price, String supplier, String supplier_id, int vatable, String or_no, String customer_name
                , String customer_id, String printing_assembly_id, String printing_assembly_name, String group_id, String group_name
                , String table_id, String table_name, String customer_ids, String customer_names
                , String waiter_id, String waiter_name,String specifications) {
            this.id = id;
            this.barcode = barcode;
            this.description = description;
            this.generic_name = generic_name;
            this.category = category;
            this.category_id = category_id;
            this.classification = classification;
            this.classification_id = classification_id;
            this.sub_classification = sub_classification;
            this.sub_classification_id = sub_classification_id;
            this.product_qty = product_qty;
            this.unit = unit;
            this.conversion = conversion;
            this.selling_price = selling_price;
            this.date_added = date_added;
            this.user_name = user_name;
            this.item_type = item_type;
            this.status = status;
            this.session_no = session_no;
            this.item_discount = item_discount;
            this.discount = discount;
            this.discount_amount = discount_amount;
            this.sales_no = sales_no;
            this.fixed_price = fixed_price;
            this.supplier = supplier;
            this.supplier_id = supplier_id;
            this.vatable = vatable;
            this.or_no = or_no;
            this.customer_name = customer_name;
            this.customer_id = customer_id;
            this.printing_assembly_id = printing_assembly_id;
            this.printing_assembly_name = printing_assembly_name;
            this.group_id = group_id;
            this.group_name = group_name;
            this.table_id = table_id;
            this.table_name = table_name;
            this.customer_ids = customer_ids;
            this.customer_names = customer_names;
            this.waiter_id = waiter_id;
            this.waiter_name = waiter_name;
            this.specifications=specifications;
        }
    }

    public static void add_sales_items(List<to_sales_items> to_sales_items1, String sales_no) {
        try {
            Connection conn = MyConnection.connect();
            for (to_sales_items to_sales_items : to_sales_items1) {

                String s0 = "insert into sales_items("
                        + "barcode"
                        + ",description"
                        + ",generic_name"
                        + ",category"
                        + ",category_id"
                        + ",classification"
                        + ",classification_id"
                        + ",sub_classification"
                        + ",sub_classification_id"
                        + ",product_qty"
                        + ",unit"
                        + ",conversion"
                        + ",selling_price"
                        + ",date_added"
                        + ",user_name"
                        + ",item_type"
                        + ",status"
                        + ",session_no"
                        + ",item_discount"
                        + ",discount"
                        + ",discount_amount"
                        + ",sales_no"
                        + ",fixed_price"
                        + ",supplier"
                        + ",supplier_id"
                        + ",vatable"
                        + ",or_no"
                        + ",customer_name"
                        + ",customer_id"
                        + ",printing_assembly_id"
                        + ",printing_assembly_name"
                        + ",group_id"
                        + ",group_name"
                        + ",table_id"
                        + ",table_name"
                        + ",customer_ids"
                        + ",customer_names"
                        + ",waiter_id"
                        + ",waiter_name"
                        + ",specifications"
                        + ")values("
                        + ":barcode"
                        + ",:description"
                        + ",:generic_name"
                        + ",:category"
                        + ",:category_id"
                        + ",:classification"
                        + ",:classification_id"
                        + ",:sub_classification"
                        + ",:sub_classification_id"
                        + ",:product_qty"
                        + ",:unit"
                        + ",:conversion"
                        + ",:selling_price"
                        + ",:date_added"
                        + ",:user_name"
                        + ",:item_type"
                        + ",:status"
                        + ",:session_no"
                        + ",:item_discount"
                        + ",:discount"
                        + ",:discount_amount"
                        + ",:sales_no"
                        + ",:fixed_price"
                        + ",:supplier"
                        + ",:supplier_id"
                        + ",:vatable"
                        + ",:or_no"
                        + ",:customer_name"
                        + ",:customer_id"
                        + ",:printing_assembly_id"
                        + ",:printing_assembly_name"
                        + ",:group_id"
                        + ",:group_name"
                        + ",:table_id"
                        + ",:table_name"
                        + ",:customer_ids"
                        + ",:customer_names"
                        + ",:waiter_id"
                        + ",:waiter_name"
                        + ",:specifications"
                        + ")";

                s0 = SqlStringUtil.parse(s0)
                        .setString("barcode", to_sales_items.barcode)
                        .setString("description", to_sales_items.description)
                        .setString("generic_name", to_sales_items.generic_name)
                        .setString("category", to_sales_items.category)
                        .setString("category_id", to_sales_items.category_id)
                        .setString("classification", to_sales_items.classification)
                        .setString("classification_id", to_sales_items.classification_id)
                        .setString("sub_classification", to_sales_items.sub_classification)
                        .setString("sub_classification_id", to_sales_items.sub_classification_id)
                        .setNumber("product_qty", to_sales_items.product_qty)
                        .setString("unit", to_sales_items.unit)
                        .setNumber("conversion", to_sales_items.conversion)
                        .setNumber("selling_price", to_sales_items.selling_price)
                        .setString("date_added", to_sales_items.date_added)
                        .setString("user_name", to_sales_items.user_name)
                        .setString("item_type", to_sales_items.item_type)
                        .setNumber("status", to_sales_items.status)
                        .setString("session_no", to_sales_items.session_no)
                        .setString("item_discount", to_sales_items.item_discount)
                        .setNumber("discount", to_sales_items.discount)
                        .setNumber("discount_amount", to_sales_items.discount_amount)
                        .setString("sales_no", to_sales_items.sales_no)
                        .setNumber("fixed_price", to_sales_items.fixed_price)
                        .setString("supplier", to_sales_items.supplier)
                        .setString("supplier_id", to_sales_items.supplier_id)
                        .setNumber("vatable", to_sales_items.vatable)
                        .setString("or_no", to_sales_items.or_no)
                        .setString("customer_name", to_sales_items.customer_name)
                        .setString("customer_id", to_sales_items.customer_id)
                        .setString("printing_assembly_id", to_sales_items.printing_assembly_id)
                        .setString("printing_assembly_name", to_sales_items.printing_assembly_name)
                        .setString("group_id", to_sales_items.group_id)
                        .setString("group_name", to_sales_items.group_name)
                        .setString("table_id", to_sales_items.table_id)
                        .setString("table_name", to_sales_items.table_name)
                        .setString("customer_ids", to_sales_items.customer_ids)
                        .setString("customer_names", to_sales_items.customer_names)
                        .setString("waiter_id", to_sales_items.waiter_id)
                        .setString("waiter_name", to_sales_items.waiter_name)
                        .setString("specifications",to_sales_items.specifications)
                        .ok();
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(S1_sales_items.class, "Successfully Added");

                if (to_sales_items.fixed_price == 1) {
                    S1_items.to_items tt = S1_items.ret_data2(to_sales_items.barcode);
                    System.out.println(tt.product_qty + " - " + to_sales_items.conversion + " * " + to_sales_items.product_qty);
                    double new_qty = tt.product_qty - (to_sales_items.conversion * to_sales_items.product_qty);
                    String s2 = "update items set "
                            + "product_qty='" + new_qty + "' "
                            + " where barcode = '" + to_sales_items.barcode + "'"
                            + "";
                    PreparedStatement stmt2 = conn.prepareStatement(s2);
                    stmt2.execute();
                }

                if (to_sales_items.fixed_price == 0) {
                    S1_items.to_items tt = S1_items.ret_data2(to_sales_items.barcode);
                    double new_qty = tt.product_qty - (to_sales_items.product_qty);
                    String s2 = "update items set "
                            + "product_qty='" + new_qty + "' "
                            + " where barcode = '" + to_sales_items.barcode + "'"
                            + "";
                    PreparedStatement stmt2 = conn.prepareStatement(s2);
                    stmt2.execute();
                }

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_sales_items(to_sales_items to_sales_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update sales_items set "
                    + "barcode= :barcode"
                    + ",description= :description"
                    + ",generic_name= :generic_name"
                    + ",category= :category"
                    + ",category_id= :category_id"
                    + ",classification= :classification"
                    + ",classification_id= :classification_id"
                    + ",sub_classification= :sub_classification"
                    + ",sub_classification_id= :sub_classification_id"
                    + ",product_qty= :product_qty"
                    + ",unit= :unit"
                    + ",conversion= :conversion"
                    + ",selling_price= :selling_price"
                    + ",date_added= :date_added"
                    + ",user_name= :user_name"
                    + ",item_type= :item_type"
                    + ",status= :status"
                    + ",session_no= :session_no"
                    + ",item_discount= :item_discount"
                    + ",discount= :discount"
                    + ",discount_amount= :discount_amount"
                    + ",sales_no= :sales_no"
                    + ",fixed_price= :fixed_price"
                    + ",supplier= :supplier"
                    + ",supplier_id= :supplier_id"
                    + ",vatable= :vatable"
                    + ",or_no= :or_no"
                    + ",customer_name= :customer_name"
                    + ",customer_id= :customer_id"
                    + ",printing_assembly_id= :printing_assembly_id"
                    + ",printing_assembly_name= :printing_assembly_name"
                    + ",group_id= :group_id"
                    + ",group_name= :group_name"
                    + ",table_id= :table_id"
                    + ",table_name= :table_name"
                    + ",customer_ids= :customer_ids"
                    + ",customer_names= :customer_names"
                    + ",waiter_id= :waiter_id"
                    + ",waiter_name= :waiter_name"
                    + ",specifications= :specifications"
                    + " where "
                    + " id ='" + to_sales_items.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("barcode", to_sales_items.barcode)
                    .setString("description", to_sales_items.description)
                    .setString("generic_name", to_sales_items.generic_name)
                    .setString("category", to_sales_items.category)
                    .setString("category_id", to_sales_items.category_id)
                    .setString("classification", to_sales_items.classification)
                    .setString("classification_id", to_sales_items.classification_id)
                    .setString("sub_classification", to_sales_items.sub_classification)
                    .setString("sub_classification_id", to_sales_items.sub_classification_id)
                    .setNumber("product_qty", to_sales_items.product_qty)
                    .setString("unit", to_sales_items.unit)
                    .setNumber("conversion", to_sales_items.conversion)
                    .setNumber("selling_price", to_sales_items.selling_price)
                    .setString("date_added", to_sales_items.date_added)
                    .setString("user_name", to_sales_items.user_name)
                    .setString("item_type", to_sales_items.item_type)
                    .setNumber("status", to_sales_items.status)
                    .setString("session_no", to_sales_items.session_no)
                    .setString("item_discount", to_sales_items.item_discount)
                    .setNumber("discount", to_sales_items.discount)
                    .setNumber("discount_amount", to_sales_items.discount_amount)
                    .setString("sales_no", to_sales_items.sales_no)
                    .setNumber("fixed_price", to_sales_items.fixed_price)
                    .setString("supplier", to_sales_items.supplier)
                    .setString("supplier_id", to_sales_items.supplier_id)
                    .setNumber("vatable", to_sales_items.vatable)
                    .setString("or_no", to_sales_items.or_no)
                    .setString("customer_name", to_sales_items.customer_name)
                    .setString("customer_id", to_sales_items.customer_id)
                    .setString("printing_assembly_id", to_sales_items.printing_assembly_id)
                    .setString("printing_assembly_name", to_sales_items.printing_assembly_name)
                    .setString("group_id", to_sales_items.group_id)
                    .setString("group_name", to_sales_items.group_name)
                    .setString("table_id", to_sales_items.table_id)
                    .setString("table_name", to_sales_items.table_name)
                    .setString("customer_ids", to_sales_items.customer_ids)
                    .setString("customer_names", to_sales_items.customer_names)
                    .setString("waiter_id", to_sales_items.waiter_id)
                    .setString("waiter_name", to_sales_items.waiter_name)
                    .setString("specifications",to_sales_items.specifications)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_sales_items.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_sales_items(to_sales_items to_sales_items) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from sales_items where "
                    + " id ='" + to_sales_items.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_sales_items.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_sales_items> ret_data(String search) {
        List<to_sales_items> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",barcode"
                    + ",description"
                    + ",generic_name"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_classification"
                    + ",sub_classification_id"
                    + ",product_qty"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",date_added"
                    + ",user_name"
                    + ",item_type"
                    + ",status"
                    + ",session_no"
                    + ",item_discount"
                    + ",discount"
                    + ",discount_amount"
                    + ",sales_no"
                    + ",fixed_price"
                    + ",supplier"
                    + ",supplier_id"
                    + ",vatable"
                    + ",or_no"
                    + ",customer_name"
                    + ",customer_id"
                    + ",printing_assembly_id"
                    + ",printing_assembly_name"
                    + ",group_id"
                    + ",group_name"
                    + ",table_id"
                    + ",table_name"
                    + ",customer_ids"
                    + ",customer_names"
                    + ",waiter_id"
                    + ",waiter_name"
                    + ",specifications"
                    + " from sales_items where "
                    + " sales_no ='" + search + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String barcode = rs.getString(2);
                String description = rs.getString(3);
                String generic_name = rs.getString(4);
                String category = rs.getString(5);
                String category_id = rs.getString(6);
                String classification = rs.getString(7);
                String classification_id = rs.getString(8);
                String sub_classification = rs.getString(9);
                String sub_classification_id = rs.getString(10);
                double product_qty = rs.getDouble(11);
                String unit = rs.getString(12);
                double conversion = rs.getDouble(13);
                double selling_price = rs.getDouble(14);
                String date_added = rs.getString(15);
                String user_name = rs.getString(16);
                String item_type = rs.getString(17);
                int status = rs.getInt(18);
                String session_no = rs.getString(19);
                String item_discount = rs.getString(20);
                double discount = rs.getDouble(21);
                double discount_amount = rs.getDouble(22);
                String sales_no = rs.getString(23);
                int fixed_price = rs.getInt(24);
                String supplier = rs.getString(25);
                String supplier_id = rs.getString(26);
                int vatable = rs.getInt(27);
                String or_no = rs.getString(28);
                String customer_name = rs.getString(29);
                String customer_id = rs.getString(30);
                String printing_assembly_id = rs.getString(31);
                String printing_assembly_name = rs.getString(32);
                String group_id = rs.getString(33);
                String group_name = rs.getString(34);
                String table_id = rs.getString(35);
                String table_name = rs.getString(36);
                String customer_ids = rs.getString(37);
                String customer_names = rs.getString(38);
                String waiter_id = rs.getString(39);
                String waiter_name = rs.getString(40);
                String specifications=rs.getString(41);
                to_sales_items to = new to_sales_items(id, barcode, description, generic_name, category, category_id, classification
                        , classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price
                        , date_added, user_name, item_type, status, session_no, item_discount, discount, discount_amount, sales_no
                        , fixed_price, supplier, supplier_id, vatable, or_no, customer_name, customer_id, printing_assembly_id
                        , printing_assembly_name, group_id, group_name, table_id, table_name, customer_ids, customer_names
                        , waiter_id, waiter_name,specifications);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_sales_items> ret_data2(String date_from, String date_to) {
        List<to_sales_items> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",barcode"
                    + ",description"
                    + ",generic_name"
                    + ",category"
                    + ",category_id"
                    + ",classification"
                    + ",classification_id"
                    + ",sub_classification"
                    + ",sub_classification_id"
                    + ",product_qty"
                    + ",unit"
                    + ",conversion"
                    + ",selling_price"
                    + ",date_added"
                    + ",user_name"
                    + ",item_type"
                    + ",status"
                    + ",session_no"
                    + ",item_discount"
                    + ",discount"
                    + ",discount_amount"
                    + ",sales_no"
                    + ",fixed_price"
                    + ",supplier"
                    + ",supplier_id"
                    + ",vatable"
                    + ",or_no"
                    + ",customer_name"
                    + ",customer_id"
                    + ",printing_assembly_id"
                    + ",printing_assembly_name"
                    + ",group_id"
                    + ",group_name"
                    + ",table_id"
                    + ",table_name"
                    + ",customer_ids"
                    + ",customer_names"
                    + ",waiter_id"
                    + ",waiter_name"
                    + ",specifications"
                    + " from sales_items where "
                    + " date(date_added)  between '" + date_from + "' and '" + date_to + "' group by barcode,selling_price "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String barcode = rs.getString(2);
                String description = rs.getString(3);
                String generic_name = rs.getString(4);
                String category = rs.getString(5);
                String category_id = rs.getString(6);
                String classification = rs.getString(7);
                String classification_id = rs.getString(8);
                String sub_classification = rs.getString(9);
                String sub_classification_id = rs.getString(10);
                double product_qty = rs.getDouble(11);
                String unit = rs.getString(12);
                double conversion = rs.getDouble(13);
                double selling_price = rs.getDouble(14);
                String date_added = rs.getString(15);
                String user_name = rs.getString(16);
                String item_type = rs.getString(17);
                int status = rs.getInt(18);
                String session_no = rs.getString(19);
                String item_discount = rs.getString(20);
                double discount = rs.getDouble(21);
                double discount_amount = rs.getDouble(22);
                String sales_no = rs.getString(23);
                int fixed_price = rs.getInt(24);
                String supplier = rs.getString(25);
                String supplier_id = rs.getString(26);
                int vatable = rs.getInt(27);
                String or_no = rs.getString(28);
                String customer_name = rs.getString(29);
                String customer_id = rs.getString(30);
                String printing_assembly_id = rs.getString(31);
                String printing_assembly_name = rs.getString(32);
                String group_id = rs.getString(33);
                String group_name = rs.getString(34);
                String table_id = rs.getString(35);
                String table_name = rs.getString(36);
                String customer_ids = rs.getString(37);
                String customer_names = rs.getString(38);
                String waiter_id = rs.getString(39);
                String waiter_name = rs.getString(40);
                String specifications=rs.getString(41);
                to_sales_items to = new to_sales_items(id, barcode, description, generic_name, category, category_id, classification
                        , classification_id, sub_classification, sub_classification_id, product_qty, unit, conversion, selling_price
                        , date_added, user_name, item_type, status, session_no, item_discount, discount, discount_amount, sales_no
                        , fixed_price, supplier, supplier_id, vatable, or_no, customer_name, customer_id, printing_assembly_id
                        , printing_assembly_name, group_id, group_name, table_id, table_name, customer_ids, customer_names
                        , waiter_id, waiter_name,specifications);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}

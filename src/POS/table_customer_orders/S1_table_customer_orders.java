/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.table_customer_orders;

import POS.table_customer_orders.S1_table_customer_orders_queue.to_table_customer_orders_queue;
import POS.table_customers.S1_table_customers;
import POS.util.MyConnection;
import POS.util.Users;
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
 * @author Ronald
 */
public class S1_table_customer_orders {

    public static class to_table_customer_orders {

        public final int id;
        public final String table_customer_id;
        public final String customer_id;
        public final String customer_name;
        public final String table_id;
        public final String table_name;
        public final String date_added;
        public final String user_name;
        public final String waiter_id;
        public final String waiter_name;
        public final String barcode;
        public final String description;
        public final double qty;
        public final double selling_price;
        public final String category_id;
        public final String category_name;
        public final String sub_category_id;
        public final String sub_category_name;
        public final String printing_assembly_id;
        public final String priting_assembly_name;
        public final String group_id;
        public final String group_name;
        public final String discount_name;
        public final double discount_rate;
        public final double discount_amount;
        public final int status;
        public final String specifications;
        public to_table_customer_orders(int id, String table_customer_id, String customer_id, String customer_name
                , String table_id, String table_name, String date_added, String user_name, String waiter_id, String waiter_name
                , String barcode, String description, double qty, double selling_price, String category_id, String category_name
                , String sub_category_id, String sub_category_name, String printing_assembly_id, String priting_assembly_name
                , String group_id, String group_name, String discount_name, double discount_rate, double discount_amount, int status,String specifications) {
            this.id = id;
            this.table_customer_id = table_customer_id;
            this.customer_id = customer_id;
            this.customer_name = customer_name;
            this.table_id = table_id;
            this.table_name = table_name;
            this.date_added = date_added;
            this.user_name = user_name;
            this.waiter_id = waiter_id;
            this.waiter_name = waiter_name;
            this.barcode = barcode;
            this.description = description;
            this.qty = qty;
            this.selling_price = selling_price;
            this.category_id = category_id;
            this.category_name = category_name;
            this.sub_category_id = sub_category_id;
            this.sub_category_name = sub_category_name;
            this.printing_assembly_id = printing_assembly_id;
            this.priting_assembly_name = priting_assembly_name;
            this.group_id = group_id;
            this.group_name = group_name;
            this.discount_name = discount_name;
            this.discount_rate = discount_rate;
            this.discount_amount = discount_amount;
            this.status = status;
            this.specifications=specifications;
        }
    }

    public static void add_table_customer_orders(List<to_table_customer_orders_queue> to_table_customer_orders1, List<S1_table_customers.to_table_customers> customers, List<to_table_customer_orders> orders1) {
        try {
            Connection conn = MyConnection.connect();

            for (S1_table_customers.to_table_customers custom : customers) {
                if (custom.selected == 1) {
                    for (to_table_customer_orders_queue to_table_customer_orders : to_table_customer_orders1) {
                        int exists = 0;

                        double q=0;
                        for (to_table_customer_orders order : orders1) {
                            System.out.println(to_table_customer_orders.barcode + " : " + order.barcode);
                            System.out.println(custom.customer_id + " : " + order.customer_id);
                            System.out.println(to_table_customer_orders.table_id + " : " + order.table_id);

                            if (to_table_customer_orders.barcode.equals(order.barcode)
                                    && custom.customer_id.equals(order.customer_id)
                                    && to_table_customer_orders.table_id.equals(order.table_id)) {
                                exists = 1;
                                q=order.qty;
                                break;
                            }
                        }
                        if (exists == 1) {
                            q+=to_table_customer_orders.qty;
                            System.out.println("new Qty: "+q);
                            String s0 = "update table_customer_orders set "
                                    + "qty= :qty"
                                    + " where "
                                    + " customer_id ='" + custom.customer_id + "' "
                                    + " and table_id ='" + custom.table_id + "' "
                                    + " and barcode ='" + to_table_customer_orders.barcode + "' "
                                    + " ";
                            s0 = SqlStringUtil.parse(s0)
                                    .setNumber("qty",q)
                                    .ok();

                            PreparedStatement stmt = conn.prepareStatement(s0);
                            stmt.execute();
                            Lg.s(S1_table_customer_orders.class, "Successfully Updated");
                        } else {
                            String s0 = "insert into table_customer_orders("
                                    + "table_customer_id"
                                    + ",customer_id"
                                    + ",customer_name"
                                    + ",table_id"
                                    + ",table_name"
                                    + ",date_added"
                                    + ",user_name"
                                    + ",waiter_id"
                                    + ",waiter_name"
                                    + ",barcode"
                                    + ",description"
                                    + ",qty"
                                    + ",selling_price"
                                    + ",category_id"
                                    + ",category_name"
                                    + ",sub_category_id"
                                    + ",sub_category_name"
                                    + ",printing_assembly_id"
                                    + ",priting_assembly_name"
                                    + ",group_id"
                                    + ",group_name"
                                    + ",discount_name"
                                    + ",discount_rate"
                                    + ",discount_amount"
                                    + ",status"
                                    + ",specifications"
                                    + ")values("
                                    + ":table_customer_id"
                                    + ",:customer_id"
                                    + ",:customer_name"
                                    + ",:table_id"
                                    + ",:table_name"
                                    + ",:date_added"
                                    + ",:user_name"
                                    + ",:waiter_id"
                                    + ",:waiter_name"
                                    + ",:barcode"
                                    + ",:description"
                                    + ",:qty"
                                    + ",:selling_price"
                                    + ",:category_id"
                                    + ",:category_name"
                                    + ",:sub_category_id"
                                    + ",:sub_category_name"
                                    + ",:printing_assembly_id"
                                    + ",:priting_assembly_name"
                                    + ",:group_id"
                                    + ",:group_name"
                                    + ",:discount_name"
                                    + ",:discount_rate"
                                    + ",:discount_amount"
                                    + ",:status"
                                    + ",:specifications"
                                    + ")";

                            s0 = SqlStringUtil.parse(s0)
                                    .setString("table_customer_id", "" + custom.id)
                                    .setString("customer_id", custom.customer_id)
                                    .setString("customer_name", custom.customer_name)
                                    .setString("table_id", to_table_customer_orders.table_id)
                                    .setString("table_name", to_table_customer_orders.table_name)
                                    .setString("date_added", to_table_customer_orders.date_added)
                                    .setString("user_name", Users.user_name)
                                    .setString("waiter_id", to_table_customer_orders.waiter_id)
                                    .setString("waiter_name", to_table_customer_orders.waiter_name)
                                    .setString("barcode", to_table_customer_orders.barcode)
                                    .setString("description", to_table_customer_orders.description)
                                    .setNumber("qty", to_table_customer_orders.qty)
                                    .setNumber("selling_price", to_table_customer_orders.selling_price)
                                    .setString("category_id", to_table_customer_orders.category_id)
                                    .setString("category_name", to_table_customer_orders.category_name)
                                    .setString("sub_category_id", to_table_customer_orders.sub_category_id)
                                    .setString("sub_category_name", to_table_customer_orders.sub_category_name)
                                    .setString("printing_assembly_id", to_table_customer_orders.printing_assembly_id)
                                    .setString("priting_assembly_name", to_table_customer_orders.priting_assembly_name)
                                    .setString("group_id", to_table_customer_orders.group_id)
                                    .setString("group_name", to_table_customer_orders.group_name)
                                    .setString("discount_name", to_table_customer_orders.discount_name)
                                    .setNumber("discount_rate", to_table_customer_orders.discount_rate)
                                    .setNumber("discount_amount", to_table_customer_orders.discount_amount)
                                    .setNumber("status", to_table_customer_orders.status)
                                    .setString("specifications", to_table_customer_orders.specifications)
                                    .ok();
                            PreparedStatement stmt = conn.prepareStatement(s0);
                            stmt.execute();
                            Lg.s(S1_table_customer_orders.class, "Successfully Added");
                        }

                    }
                }

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_table_customer_orders(to_table_customer_orders to_table_customer_orders, double new_qty,String specification) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update table_customer_orders set "
                    + "table_customer_id= :table_customer_id"
                    + ",customer_id= :customer_id"
                    + ",customer_name= :customer_name"
                    + ",table_id= :table_id"
                    + ",table_name= :table_name"
                    + ",date_added= :date_added"
                    + ",user_name= :user_name"
                    + ",waiter_id= :waiter_id"
                    + ",waiter_name= :waiter_name"
                    + ",barcode= :barcode"
                    + ",description= :description"
                    + ",qty= :qty"
                    + ",selling_price= :selling_price"
                    + ",category_id= :category_id"
                    + ",category_name= :category_name"
                    + ",sub_category_id= :sub_category_id"
                    + ",sub_category_name= :sub_category_name"
                    + ",printing_assembly_id= :printing_assembly_id"
                    + ",priting_assembly_name= :priting_assembly_name"
                    + ",group_id= :group_id"
                    + ",group_name= :group_name"
                    + ",discount_name= :discount_name"
                    + ",discount_rate= :discount_rate"
                    + ",discount_amount= :discount_amount"
                    + ",status= :status"
                    + ",specifications= :specifications"
                    + " where "
                    + " id ='" + to_table_customer_orders.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("table_customer_id", to_table_customer_orders.table_customer_id)
                    .setString("customer_id", to_table_customer_orders.customer_id)
                    .setString("customer_name", to_table_customer_orders.customer_name)
                    .setString("table_id", to_table_customer_orders.table_id)
                    .setString("table_name", to_table_customer_orders.table_name)
                    .setString("date_added", to_table_customer_orders.date_added)
                    .setString("user_name", to_table_customer_orders.user_name)
                    .setString("waiter_id", to_table_customer_orders.waiter_id)
                    .setString("waiter_name", to_table_customer_orders.waiter_name)
                    .setString("barcode", to_table_customer_orders.barcode)
                    .setString("description", to_table_customer_orders.description)
                    .setNumber("qty", new_qty)
                    .setNumber("selling_price", to_table_customer_orders.selling_price)
                    .setString("category_id", to_table_customer_orders.category_id)
                    .setString("category_name", to_table_customer_orders.category_name)
                    .setString("sub_category_id", to_table_customer_orders.sub_category_id)
                    .setString("sub_category_name", to_table_customer_orders.sub_category_name)
                    .setString("printing_assembly_id", to_table_customer_orders.printing_assembly_id)
                    .setString("priting_assembly_name", to_table_customer_orders.priting_assembly_name)
                    .setString("group_id", to_table_customer_orders.group_id)
                    .setString("group_name", to_table_customer_orders.group_name)
                    .setString("discount_name", to_table_customer_orders.discount_name)
                    .setNumber("discount_rate", to_table_customer_orders.discount_rate)
                    .setNumber("discount_amount", to_table_customer_orders.discount_amount)
                    .setNumber("status", to_table_customer_orders.status)
                    .setString("specifications",specification)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_table_customer_orders.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_table_customer_orders(to_table_customer_orders to_table_customer_orders) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from table_customer_orders where "
                    + " id ='" + to_table_customer_orders.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_table_customer_orders.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_table_customer_orders> ret_data(String where) {
        List<to_table_customer_orders> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",table_customer_id"
                    + ",customer_id"
                    + ",customer_name"
                    + ",table_id"
                    + ",table_name"
                    + ",date_added"
                    + ",user_name"
                    + ",waiter_id"
                    + ",waiter_name"
                    + ",barcode"
                    + ",description"
                    + ",qty"
                    + ",selling_price"
                    + ",category_id"
                    + ",category_name"
                    + ",sub_category_id"
                    + ",sub_category_name"
                    + ",printing_assembly_id"
                    + ",priting_assembly_name"
                    + ",group_id"
                    + ",group_name"
                    + ",discount_name"
                    + ",discount_rate"
                    + ",discount_amount"
                    + ",status"
                    + ",specifications"
                    + " from table_customer_orders  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String table_customer_id = rs.getString(2);
                String customer_id = rs.getString(3);
                String customer_name = rs.getString(4);
                String table_id = rs.getString(5);
                String table_name = rs.getString(6);
                String date_added = rs.getString(7);
                String user_name = rs.getString(8);
                String waiter_id = rs.getString(9);
                String waiter_name = rs.getString(10);
                String barcode = rs.getString(11);
                String description = rs.getString(12);
                double qty = rs.getDouble(13);
                double selling_price = rs.getDouble(14);
                String category_id = rs.getString(15);
                String category_name = rs.getString(16);
                String sub_category_id = rs.getString(17);
                String sub_category_name = rs.getString(18);
                String printing_assembly_id = rs.getString(19);
                String priting_assembly_name = rs.getString(20);
                String group_id = rs.getString(21);
                String group_name = rs.getString(22);
                String discount_name = rs.getString(23);
                double discount_rate = rs.getDouble(24);
                double discount_amount = rs.getDouble(25);
                int status = rs.getInt(26);
                String specifications=rs.getString(27);
                to_table_customer_orders to = new to_table_customer_orders(id, table_customer_id, customer_id, customer_name
                        , table_id, table_name, date_added, user_name, waiter_id, waiter_name, barcode, description, qty
                        , selling_price, category_id, category_name, sub_category_id, sub_category_name, printing_assembly_id
                        , priting_assembly_name, group_id, group_name, discount_name, discount_rate, discount_amount, status,specifications);
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

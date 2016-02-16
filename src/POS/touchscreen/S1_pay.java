/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen;

import POS.sales.S1_sales;
import POS.sales.S1_sales_items;
import POS.sales.S1_sales_items.to_sales_items;
import POS.table_customer_orders.S1_table_customer_orders;
import POS.table_customers.S1_table_customers;
import POS.util.MyConnection;
import POS.util.Users;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Ronald
 */
public class S1_pay {

    public static void payment(List<S1_table_customers.to_table_customers> customers
            , List<S1_table_customer_orders.to_table_customer_orders> orders, S1_sales.to_sales sales) {

        try {
            Connection conn = MyConnection.connect();

            for (S1_table_customers.to_table_customers cust : customers) {
                if (cust.selected == 1) {
                    String s0 = "delete from table_customers "
//                            + "set "
//                            + "status= :status"
                            + " where "
                            + " id ='" + cust.id + "' "
                            + " ";

                    s0 = SqlStringUtil.parse(s0)
                            .setNumber("status", 1)
                            .ok();
                    PreparedStatement stmt = conn.prepareStatement(s0);
                    stmt.execute();
                    Lg.s(S1_table_customers.class, "Successfully Updated");
                }
            }

            List<to_sales_items> items = new ArrayList();
            double qty = 0;
            for (S1_table_customer_orders.to_table_customer_orders order : orders) {
                String s0 = "delete from table_customer_orders "                     
                        + " where "
                        + " id ='" + order.id + "' "
                        + " ";
                s0 = SqlStringUtil.parse(s0)
                        .setNumber("status", 1)
                        .ok();

                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(S1_table_customer_orders.class, "Successfully Updated");

                int id = order.id;
                String barcode = order.barcode;
                String description = order.description;
                String generic_name = "";
                String category = order.category_name;
                String category_id = order.category_id;
                String classification = "";
                String classification_id = "";
                String sub_classification = "";
                String sub_classification_id = "";
                double product_qty = order.qty;
                qty += product_qty;
                String unit = "";
                double conversion = 1;
                double selling_price = order.selling_price;
                String date_added = order.date_added;
                String user_name = Users.user_name;
                String item_type = "";
                int status = order.status;
                String session_no = Users.session_no;
                String item_discount = "";
                double discount = order.discount_rate;
                double discount_amount = order.discount_amount;
                String sales_no = sales.sales_no;
                String add = "";

                int fixed_price = 1;

                String supplier = "";
                String supplier_id = "";
                int vatable = 0;
                String or_no = sales.sales_no;
                String printing_assembly_id = order.printing_assembly_id;
                String printing_assembly_name = order.priting_assembly_name;
                String group_id = order.group_id;
                String group_name = order.group_name;
                S1_sales_items.to_sales_items to3 = new S1_sales_items.to_sales_items(id, barcode, description, generic_name, category
                        , category_id, classification, classification_id, sub_classification, sub_classification_id, product_qty, unit
                        , conversion, selling_price, date_added, user_name, item_type, status, session_no, item_discount, discount
                        , discount_amount, sales_no, fixed_price, supplier, supplier_id, vatable, or_no, sales.customer_name
                        , sales.customer_id, printing_assembly_id, printing_assembly_name, group_id, group_name
                        , sales.table_id, sales.table_name, sales.customer_ids, sales.customer_names, sales.waiter_id, sales.waiter_name,order.specifications);
                items.add(to3);
            }
            S1_sales.add_sales(sales);
            S1_sales_items.add_sales_items(items, sales.sales_no);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}

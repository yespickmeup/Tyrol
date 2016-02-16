/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.tables;

import POS.table_customer_orders.S1_table_customer_orders;
import POS.table_customers.S1_table_customers;
import POS.table_customers.S1_table_customers.to_table_customers;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Ronald
 */
public class S1_table_transfer {

    public static void edit_table_customers(List<to_table_customers> to_table_customers1, List<S1_table_customer_orders.to_table_customer_orders> to_table_customer_orders1, S1_tables.to_tables table) {
        try {
            Connection conn = MyConnection.connect();
            for (to_table_customers to_table_customers : to_table_customers1) {
                String s0 = "update table_customers set "
                        + "customer_id= :customer_id"
                        + ",customer_name= :customer_name"
                        + ",table_id= :table_id"
                        + ",table_name= :table_name"
                        + ",date_added= :date_added"
                        + ",user_name= :user_name"
                        + ",waiter_id= :waiter_id"
                        + ",waiter_name= :waiter_name"
                        + ",status= :status"
                        + " where "
                        + " id ='" + to_table_customers.id + "' "
                        + " ";
                s0 = SqlStringUtil.parse(s0)
                        .setString("customer_id", to_table_customers.customer_id)
                        .setString("customer_name", to_table_customers.customer_name)
                        .setString("table_id", ""+table.id)
                        .setString("table_name", table.table_name)
                        .setString("date_added", to_table_customers.date_added)
                        .setString("user_name", to_table_customers.user_name)
                        .setString("waiter_id", table.waiter_id)
                        .setString("waiter_name", table.waiter_name)
                        .setNumber("status", to_table_customers.status)
                        .ok();
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(S1_table_customers.class, "Successfully Updated");
            }

            for (S1_table_customer_orders.to_table_customer_orders to_table_customer_orders : to_table_customer_orders1) {
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
                        + " where "
                        + " id ='" + to_table_customer_orders.id + "' "
                        + " ";

                s0 = SqlStringUtil.parse(s0)
                        .setString("table_customer_id", to_table_customer_orders.table_customer_id)
                        .setString("customer_id", to_table_customer_orders.customer_id)
                        .setString("customer_name", to_table_customer_orders.customer_name)
                        .setString("table_id", ""+table.id)
                        .setString("table_name", table.table_name)
                        .setString("date_added", to_table_customer_orders.date_added)
                        .setString("user_name", to_table_customer_orders.user_name)
                        .setString("waiter_id", table.waiter_id)
                        .setString("waiter_name", table.waiter_name)
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
                        .ok();
                PreparedStatement stmt = conn.prepareStatement(s0);
                stmt.execute();
                Lg.s(S1_table_customer_orders.class, "Successfully Updated");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}

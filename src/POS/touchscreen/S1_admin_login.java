/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.touchscreen;

import POS.users.S1_users.to_users;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ronald
 */
public class S1_admin_login {

    public static to_users ret_data(String passwords) {
        to_users to1 = null;

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",screen_name"
                    + ",user_name"
                    + ",password"
                    + ",user_level"
                    + ",date_added"
                    + ",is_active"
                    + ",t_sales"
                    + ",t_receipts"
                    + ",t_stock_transfer"
                    + ",m_items"
                    + ",m_category"
                    + ",m_users"
                    + ",m_uom"
                    + ",m_suppliers"
                    + ",r_sales"
                    + ",r_cash_count"
                    + ",r_receipts"
                    + ",r_stock_transferred"
                    + ",r_stock_take"
                    + ",m_customers"
                    + ",m_discount"
                    + ",m_banks"
                    + ",r_stock_left_supplier"
                    + ",t_inventory_adjuster"
                    + " from users where "
                    + " password ='" + passwords + "' "
                    + " and user_level ='" + "0" + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String screen_name = rs.getString(2);
                String user_name = rs.getString(3);
                String password = rs.getString(4);
                int user_level = rs.getInt(5);
                String date_added = rs.getString(6);
                int is_active = rs.getInt(7);
                String t_sales = rs.getString(8);
                String t_receipts = rs.getString(9);
                String t_stock_transfer = rs.getString(10);
                String m_items = rs.getString(11);
                String m_category = rs.getString(12);
                String m_users = rs.getString(13);
                String m_uom = rs.getString(14);
                String m_suppliers = rs.getString(15);
                String r_sales = rs.getString(16);
                String r_cash_count = rs.getString(17);
                String r_receipts = rs.getString(18);
                String r_stock_transferred = rs.getString(19);
                String r_stock_take = rs.getString(20);
                String m_customers = rs.getString(21);
                String m_discount = rs.getString(22);
                String m_banks = rs.getString(23);
                String r_stock_left_supplier = rs.getString(24);
                String t_inventory_adjuster = rs.getString(25);

                to1 = new to_users(id, screen_name, user_name, password, user_level, date_added, is_active, t_sales, t_receipts, t_stock_transfer, m_items, m_category, m_users, m_uom, m_suppliers, r_sales, r_cash_count, r_receipts, r_stock_transferred, r_stock_take, m_customers, m_discount, m_banks, r_stock_left_supplier, t_inventory_adjuster);
            }
            return to1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}

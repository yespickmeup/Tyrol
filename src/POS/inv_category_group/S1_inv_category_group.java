/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.inv_category_group;

import POS.category.S1_inv_categories;
import POS.items.S1_items;
import POS.items.S1_items.to_items;
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
 * @author Ronald
 */
public class S1_inv_category_group {

    public static class to_inv_category_group {

        public final int id;
        public final String category_group;

        public to_inv_category_group(int id, String category_group) {
            this.id = id;
            this.category_group = category_group;
        }
    }

    public static void main2(String[] args) {
        to_inv_category_group to1 = new to_inv_category_group(0, "Beverages");
        to_inv_category_group to2 = new to_inv_category_group(0, "Foods");
        add_inv_category_group(to1);
        add_inv_category_group(to2);
    }

    public static void add_inv_category_group(to_inv_category_group to_inv_category_group) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into inv_category_group("
                    + "category_group"
                    + ")values("
                    + ":category_group"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("category_group", to_inv_category_group.category_group)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_inv_category_group.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_inv_category_group(to_inv_category_group to_inv_category_group) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update inv_category_group set "
                    + "category_group= :category_group"
                    + " where "
                    + " id ='" + to_inv_category_group.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("category_group", to_inv_category_group.category_group)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_inv_category_group.class, "Successfully Updated");

            String s2 = "update inv_categories set "
                    + "group_name= :group_name"
                    + " where "
                    + " group_id ='" + to_inv_category_group.id + "' "
                    + " ";

            s2 = SqlStringUtil.parse(s2)
                    .setString("group_name", to_inv_category_group.category_group)
                    .ok();

            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();
            Lg.s(S1_inv_categories.class, "Successfully Updated");

            String s3 = "update items set "
                    + "group_name= :group_name"
                    + " where "
                    + " group_id ='" + to_inv_category_group.id + "' "
                    + " ";

            s3 = SqlStringUtil.parse(s3)
                    .setString("group_name", to_inv_category_group.category_group)
                    .ok();

            PreparedStatement stmt3 = conn.prepareStatement(s3);
            stmt3.execute();
            Lg.s(S1_items.class, "Successfully Updated");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_inv_category_group(to_inv_category_group to_inv_category_group) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from inv_category_group where "
                    + " id ='" + to_inv_category_group.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_inv_category_group.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inv_category_group> ret_data(String where) {
        List<to_inv_category_group> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",category_group"
                    + " from inv_category_group  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String category_group = rs.getString(2);

                to_inv_category_group to = new to_inv_category_group(id, category_group);
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

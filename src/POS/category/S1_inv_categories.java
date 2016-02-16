/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.category;

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
public class S1_inv_categories {

    public static class to_inv_categories {

        public final int id;
        public final String category;
        public final String printing_assembly_id;
        public final String printing_assembly_name;
        public final String group_id;
        public final String group_name;

        public to_inv_categories(int id, String category, String printing_assembly_id, String printing_assembly_name, String group_id, String group_name) {
            this.id = id;
            this.category = category;
            this.printing_assembly_id = printing_assembly_id;
            this.printing_assembly_name = printing_assembly_name;
            this.group_id = group_id;
            this.group_name = group_name;
        }
    }

    public static void add_inv_categories(to_inv_categories to_inv_categories) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into inv_categories("
//                    + "id"
                    + "category"
                    + ",printing_assembly_id"
                    + ",printing_assembly_name"
                    + ",group_id"
                    + ",group_name"
                    + ")values("
//                    + ":id"
                    + ":category"
                    + ",:printing_assembly_id"
                    + ",:printing_assembly_name"
                    + ",:group_id"
                    + ",:group_name"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
//                    setNumber("id", to_inv_categories.id).
                    setString("category", to_inv_categories.category).
                    setString("printing_assembly_id", to_inv_categories.printing_assembly_id).
                    setString("printing_assembly_name", to_inv_categories.printing_assembly_name).
                    setString("group_id", to_inv_categories.group_id).
                    setString("group_name", to_inv_categories.group_name).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_inv_categories.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_inv_categories(to_inv_categories to_inv_categories) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update inv_categories set "
                    + "category= :category"
                    + ",printing_assembly_id= :printing_assembly_id"
                    + ",printing_assembly_name= :printing_assembly_name"
                    + ",group_id= :group_id"
                    + ",group_name= :group_name"
                    + " where "
                    + " id ='" + to_inv_categories.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("category", to_inv_categories.category)
                    .setString("printing_assembly_id", to_inv_categories.printing_assembly_id)
                    .setString("printing_assembly_name", to_inv_categories.printing_assembly_name)
                    .setString("group_id", to_inv_categories.group_id)
                    .setString("group_name", to_inv_categories.group_name)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_inv_categories.class, "Successfully Updated");

            String s4 = "update items set "
                    + "printing_assembly_id= :printing_assembly_id"
                    + ",printing_assembly_name= :printing_assembly_name"
                    + ",group_id= :group_id"
                    + ",group_name= :group_name"
                    + " where "
                    + " category ='" + to_inv_categories.category + "' "
                    + " ";

            s4 = SqlStringUtil.parse(s4)
                    .setString("printing_assembly_id", to_inv_categories.printing_assembly_id)
                    .setString("printing_assembly_name", to_inv_categories.printing_assembly_name)
                    .setString("group_id", to_inv_categories.group_id)
                    .setString("group_name", to_inv_categories.group_name)
                    .ok();

            PreparedStatement stmt4 = conn.prepareStatement(s4);
            stmt4.execute();
            Lg.s(S1_items.class, "Successfully Updated");

            String s1 = "update inv_classifications set "
                    + "category_name= '" + to_inv_categories.category + "'"
                    + "where "
                    + " category_id ='" + to_inv_categories.id + "' "
                    + " ";
            PreparedStatement stmt1 = conn.prepareStatement(s1);
            stmt1.execute();

            String s3 = "update inv_sub_classifications set "
                    + "category_name= '" + to_inv_categories.category + "'"
                    + "where "
                    + " category_id ='" + to_inv_categories.id + "' "
                    + " ";

            PreparedStatement stmt3 = conn.prepareStatement(s3);
            stmt3.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_inv_categories(to_inv_categories to_inv_categories) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from inv_categories where "
                    + " id ='" + to_inv_categories.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_inv_categories.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inv_categories> ret_data(String where) {
        List<to_inv_categories> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",category"
                    + ",printing_assembly_id"
                    + ",printing_assembly_name"
                    + ",group_id"
                    + ",group_name"
                    + " from inv_categories  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String category = rs.getString(2);
                String printing_assembly_id = rs.getString(3);
                String printing_assembly_name = rs.getString(4);
                String group_id = rs.getString(5);
                String group_name = rs.getString(6);

                to_inv_categories to = new to_inv_categories(id, category, printing_assembly_id, printing_assembly_name, group_id, group_name);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_inv_categories> ret_where(String where) {
        List<to_inv_categories> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",category"
                    + ",printing_assembly_id"
                    + ",printing_assembly_name"
                    + ",group_id"
                    + ",group_name"
                    + " from inv_categories  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String category = rs.getString(2);
                String printing_assembly_id = rs.getString(3);
                String printing_assembly_name = rs.getString(4);
                String group_id = rs.getString(5);
                String group_name = rs.getString(6);

                to_inv_categories to = new to_inv_categories(id, category, printing_assembly_id, printing_assembly_name, group_id, group_name);
                datas.add(to);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<String> ret_cb_data() {
        List<String> datas = new ArrayList();
        datas.add("");
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select category from inv_categories order by category asc";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String id = rs.getString(1);
                datas.add(id);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<String> ret_cb_data_report() {
        List<String> datas = new ArrayList();
        datas.add("ALL");
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select category from inv_categories order by category asc";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                String id = rs.getString(1);
                datas.add(id);
            }
            return datas;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static to_inv_categories ret_to(String where) {
        to_inv_categories to1 = new to_inv_categories(-1, "", "", "", "", "");

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",category"
                    + ",printing_assembly_id"
                    + ",printing_assembly_name"
                    + ",group_id"
                    + ",group_name"
                    + " from inv_categories  "
                    + " where category = '" + where + "'";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                int id = rs.getInt(1);
                String category = rs.getString(2);
                String printing_assembly_id = rs.getString(3);
                String printing_assembly_name = rs.getString(4);
                String group_id = rs.getString(5);
                String group_name = rs.getString(6);

                to1 = new to_inv_categories(id, category, printing_assembly_id, printing_assembly_name, group_id, group_name);
            }
            return to1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

}

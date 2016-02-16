/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.printing_assembly;

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
public class S1_printing_assembly {

    public static class to_printing_assembly {

        public final int id;
        public final String location;

        public to_printing_assembly(int id, String location) {
            this.id = id;
            this.location = location;
        }
    }

    public static void main2(String[] args) {
        to_printing_assembly to1 = new to_printing_assembly(0, "Bar");
        to_printing_assembly to2 = new to_printing_assembly(0, "Kitchen");

        add_printing_assembly(to1);
        add_printing_assembly(to2);
    }

    public static void add_printing_assembly(to_printing_assembly to_printing_assembly) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into printing_assembly("
                    + "location"
                    + ")values("
                    + ":location"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("location", to_printing_assembly.location)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_printing_assembly.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_printing_assembly(to_printing_assembly to_printing_assembly) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update printing_assembly set "
                    + "location= :location"
                    + " where "
                    + " id ='" + to_printing_assembly.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("location", to_printing_assembly.location)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_printing_assembly.class, "Successfully Updated");

            String s2 = "update inv_categories set "
                    + "printing_assembly_name= :printing_assembly_name"
                    + " where "
                    + " printing_assembly_id ='" + to_printing_assembly.id + "' "
                    + " ";

            s2 = SqlStringUtil.parse(s2)
                    .setString("printing_assembly_name", to_printing_assembly.location)
                    .ok();

            PreparedStatement stmt2 = conn.prepareStatement(s2);
            stmt2.execute();
            Lg.s(S1_inv_categories.class, "Successfully Updated");

            String s3 = "update items set "
                    + "printing_assembly_name= :printing_assembly_name"
                    + " where "
                    + " printing_assembly_id ='" + to_printing_assembly.id + "' "
                    + " ";

            s3 = SqlStringUtil.parse(s3)
                    .setString("printing_assembly_name", to_printing_assembly.location)
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

    public static void delete_printing_assembly(to_printing_assembly to_printing_assembly) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from printing_assembly where "
                    + " id ='" + to_printing_assembly.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_printing_assembly.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_printing_assembly> ret_data(String where) {
        List<to_printing_assembly> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",location"
                    + " from printing_assembly  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String location = rs.getString(2);
                to_printing_assembly to = new to_printing_assembly(id, location);
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

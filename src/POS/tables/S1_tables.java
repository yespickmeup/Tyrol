package POS.tables;

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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ronald
 */
public class S1_tables {

    public static class to_tables {

        public final int id;
        public final String table_name;
        public final String table_location;
        public final String table_location_id;
        public final String waiter_id;
        public final String waiter_name;
        public final int status;

        public to_tables(int id, String table_name, String table_location, String table_location_id, String waiter_id, String waiter_name, int status) {
            this.id = id;
            this.table_name = table_name;
            this.table_location = table_location;
            this.table_location_id = table_location_id;
            this.waiter_id = waiter_id;
            this.waiter_name = waiter_name;
            this.status = status;
        }
    }

    public static void main(String[] args) {
        for (int i = 12; i < 22; i++) {
            to_tables to = new to_tables(i, "" + i, "", "", "", "", 0);
            add_tables(to);
        }
    }

    public static void add_tables(to_tables to_tables) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into tables("
                    + "table_name"
                    + ",table_location"
                    + ",table_location_id"
                    + ")values("
                    + ":table_name"
                    + ",:table_location"
                    + ",:table_location_id"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("table_name", to_tables.table_name)
                    .setString("table_location", to_tables.table_location)
                    .setString("table_location_id", to_tables.table_location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_tables.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_tables(to_tables to_tables) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update tables set "
                    + "table_name= :table_name"
                    + ",table_location= :table_location"
                    + ",table_location_id= :table_location_id"
                    + " where "
                    + " id ='" + to_tables.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("table_name", to_tables.table_name)
                    .setString("table_location", to_tables.table_location)
                    .setString("table_location_id", to_tables.table_location_id)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_tables.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_tables(to_tables to_tables) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from tables where "
                    + " id ='" + to_tables.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_tables.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_tables> ret_data_touch(String where) {
        List<to_tables> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",table_name"
                    + ",table_location"
                    + ",table_location_id"
                    + " from tables  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String table_name = rs.getString(2);
                String table_location = rs.getString(3);
                String table_location_id = rs.getString(4);
                String waiter_id = "";
                String waiter_name = "";
                int status = 0;

                String s2 = "select "
                        + "id"
                        + ",customer_id"
                        + ",customer_name"
                        + ",table_id"
                        + ",table_name"
                        + ",date_added"
                        + ",user_name"
                        + ",waiter_id"
                        + ",waiter_name"
                        + ",status"
                        + " from table_customers "
                        + " where table_id='" + id + "' and status='" + "0" + "'"
                        + " ";

                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {

                    String customer_id = rs2.getString(2);
                    String customer_name = rs2.getString(3);
                    String table_id = rs2.getString(4);
                    String table_name2 = rs2.getString(5);
                    String date_added = rs2.getString(6);
                    String user_name = rs2.getString(7);
                    waiter_id = rs2.getString(8);
                    waiter_name = rs2.getString(9);
                    status = 1;

                }
                to_tables to = new to_tables(id, table_name, table_location, table_location_id, waiter_id, waiter_name, status);
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

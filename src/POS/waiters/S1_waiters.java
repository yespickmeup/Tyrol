/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.waiters;

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
public class S1_waiters {

    public static class to_waiters {

        public final int id;
        public final String waiter_name;

        public to_waiters(int id, String waiter_name) {
            this.id = id;
            this.waiter_name = waiter_name;
        }
    }

    public static void main(String[] args) {
        for (int i = 1; i < 6; i++) {
            to_waiters to = new to_waiters(i, "Waiter " + i);
            add_waiters(to);
        }
    }

    public static void add_waiters(to_waiters to_waiters) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into waiters("
                    + "waiter_name"
                    + ")values("
                    + ":waiter_name"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("waiter_name", to_waiters.waiter_name)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_waiters.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_waiters(to_waiters to_waiters) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update waiters set "
                    + "waiter_name= :waiter_name"
                    + " where "
                    + " id ='" + to_waiters.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("waiter_name", to_waiters.waiter_name)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_waiters.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_waiters(to_waiters to_waiters) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from waiters where "
                    + " id ='" + to_waiters.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_waiters.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_waiters> ret_data(String where) {
        List<to_waiters> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",waiter_name"
                    + " from waiters  "
                    + " " + where;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String waiter_name = rs.getString(2);

                to_waiters to = new to_waiters(id, waiter_name);
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS_order_specifications;

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
public class S1_order_specifications {

    public static class to_order_specifications {

        public final int id;
        public final String specification;

        public to_order_specifications(int id, String specification) {
            this.id = id;
            this.specification = specification;
        }
    }

    public static void add_order_specifications(to_order_specifications to_order_specifications) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into order_specifications("
                    + "specification"
                    + ")values("
                    + ":specification"
                    + ")";

            s0 = SqlStringUtil.parse(s0)
                    .setString("specification", to_order_specifications.specification)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_order_specifications.class, "Successfully Added");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_order_specifications(to_order_specifications to_order_specifications) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update order_specifications set "
                    + "specification= :specification"
                    + " where "
                    + " id ='" + to_order_specifications.id + "' "
                    + " ";

            s0 = SqlStringUtil.parse(s0)
                    .setString("specification", to_order_specifications.specification)
                    .ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_order_specifications.class, "Successfully Updated");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_order_specifications(to_order_specifications to_order_specifications) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from order_specifications where "
                    + " id ='" + to_order_specifications.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_order_specifications.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_order_specifications> ret_data(String where) {
        List<to_order_specifications> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",specification"
                    + " from order_specifications  "
                    + " " + where;

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String specification = rs.getString(2);

                to_order_specifications to = new to_order_specifications(id, specification);
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

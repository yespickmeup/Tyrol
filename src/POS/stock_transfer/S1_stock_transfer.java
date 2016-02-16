/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.stock_transfer;

import POS.main.Main;
import POS.main.Main.MyDB;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.ReceiptIncrementor;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Maytopacka
 */
public class S1_stock_transfer {

    public static class to_receipts {

        public final int id;
        public final String receipt_no;
        public final String user_name;
        public final String session_no;
        public final String date_added;
        public final String supplier;
        public final String supllier_id;
        public final String remarks;

        public to_receipts(int id, String receipt_no, String user_name, String session_no, String date_added, String supplier, String supllier_id, String remarks) {
            this.id = id;
            this.receipt_no = receipt_no;
            this.user_name = user_name;
            this.session_no = session_no;
            this.date_added = date_added;
            this.supplier = supplier;
            this.supllier_id = supllier_id;
            this.remarks = remarks;
        }
    }

    public static void add_receipts(to_receipts to_receipts) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into stock_transfer("
                    + "receipt_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supllier_id"
                    + ",remarks"
                    + ")values("
                    + ":receipt_no"
                    + ",:user_name"
                    + ",:session_no"
                    + ",:date_added"
                    + ",:supplier"
                    + ",:supllier_id"
                    + ",:remarks"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("receipt_no", to_receipts.receipt_no).
                    setString("user_name", to_receipts.user_name).
                    setString("session_no", to_receipts.session_no).
                    setString("date_added", to_receipts.date_added).
                    setString("supplier", to_receipts.supplier).
                    setString("supllier_id", to_receipts.supllier_id).
                    setString("remarks", to_receipts.remarks).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_stock_transfer.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_receipts(to_receipts to_receipts) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update stock_transfer set "
                    + "receipt_no= '" + to_receipts.receipt_no + "'"
                    + ",user_name= '" + to_receipts.user_name + "'"
                    + ",session_no= '" + to_receipts.session_no + "'"
                    + ",date_added= '" + to_receipts.date_added + "'"
                    + ",supplier= '" + to_receipts.supplier + "'"
                    + ",supllier_id= '" + to_receipts.supllier_id + "'"
                    + ",remarks= '" + to_receipts.remarks + "'"
                    + "where "
                    + " id ='" + to_receipts.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_stock_transfer.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_receipts(to_receipts to_receipts) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from stock_transfer where "
                    + " id ='" + to_receipts.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_stock_transfer.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_receipts> ret_data(String search) {
        List<to_receipts> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",receipt_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supllier_id"
                    + ",remarks"
                    + " from stock_transfer where "
                    + " receipt_no like'%" + search + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String receipt_no = rs.getString(2);
                String user_name = rs.getString(3);
                String session_no = rs.getString(4);
                String date_added = rs.getString(5);
                String supplier = rs.getString(6);
                String supllier_id = rs.getString(7);
                String remarks = rs.getString(8);

                to_receipts to = new to_receipts(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id, remarks);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_receipts> ret_data2(String search, String date_from, String date_to) {
        List<to_receipts> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",receipt_no"
                    + ",user_name"
                    + ",session_no"
                    + ",date_added"
                    + ",supplier"
                    + ",supllier_id"
                    + ",remarks"
                    + " from stock_transfer where "
                    + " supplier like'%" + search + "%'"
                    + " and date(date_added) between '"+date_from+"' and '"+date_to+"' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String receipt_no = rs.getString(2);
                String user_name = rs.getString(3);
                String session_no = rs.getString(4);
                String date_added = rs.getString(5);
                String supplier = rs.getString(6);
                String supllier_id = rs.getString(7);
                String remarks = rs.getString(8);

                to_receipts to = new to_receipts(id, receipt_no, user_name, session_no, date_added, supplier, supllier_id, remarks);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String increment_id() {
        String ids = "ST-00000000000";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from stock_transfer";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                ids = rs.getString(1);
            }
            if (ids == null) {
                ids = "ST-00000000001";
            } else {
                String s2 = "select receipt_no from stock_transfer where id='" + ids + "'";
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                if (rs2.next()) {
                    ids = rs2.getString(1);
                }
            }

            ids = ReceiptIncrementor.increment(ids);

            return ids;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}

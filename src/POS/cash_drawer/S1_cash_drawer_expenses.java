/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.cash_drawer;

import POS.bir_session.Srpt_checks;
import POS.util.DateType;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Maytopacka
 */
public class S1_cash_drawer_expenses {

    public static class to_cash_drawer_expenses {

        public final int id;
        public final String session_no;
        public final String user_name;
        public final String screen_name;
        public final String time_in;
        public final String time_out;
        public final String bank;
        public final String check_no;
        public final String check_holder;
        public final double amount;
        public final int vault;

        public to_cash_drawer_expenses(int id, String session_no, String user_name, String screen_name, String time_in, String time_out, String bank, String check_no, String check_holder, double amount, int vault) {
            this.id = id;
            this.session_no = session_no;
            this.user_name = user_name;
            this.screen_name = screen_name;
            this.time_in = time_in;
            this.time_out = time_out;
            this.bank = bank;
            this.check_no = check_no;
            this.check_holder = check_holder;
            this.amount = amount;
            this.vault = vault;
        }
    }

    public static void add_cash_drawer_checks(to_cash_drawer_expenses to_cash_drawer_checks) {
        try {
            Connection conn = MyConnection.connect();

            String s0 = "insert into cash_drawer_expenses("
                    + "session_no"
                    + ",user_name"
                    + ",screen_name"
                    + ",time_in"
                    + ",time_out"
                    + ",bank"
                    + ",check_no"
                    + ",check_holder"
                    + ",amount"
                    + ",vault"
                    + ")values("
                    + ":session_no"
                    + ",:user_name"
                    + ",:screen_name"
                    + ",:time_in"
                    + ",:time_out"
                    + ",:bank"
                    + ",:check_no"
                    + ",:check_holder"
                    + ",:amount"
                    + ",:vault"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("session_no", to_cash_drawer_checks.session_no).
                    setString("user_name", to_cash_drawer_checks.user_name).
                    setString("screen_name", to_cash_drawer_checks.screen_name).
                    setString("time_in", to_cash_drawer_checks.time_in).
                    setString("time_out", to_cash_drawer_checks.time_out).
                    setString("bank", to_cash_drawer_checks.bank).
                    setString("check_no", to_cash_drawer_checks.check_no).
                    setString("check_holder", to_cash_drawer_checks.check_holder).
                    setNumber("amount", to_cash_drawer_checks.amount).
                    setNumber("vault", 0).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_cash_drawer_expenses.class, "Successfully Added");

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_cash_drawer_checks(to_cash_drawer_expenses to_cash_drawer_checks) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update cash_drawer_expenses set "
                    + "session_no= '" + to_cash_drawer_checks.session_no + "'"
                    + ",user_name= '" + to_cash_drawer_checks.user_name + "'"
                    + ",screen_name= '" + to_cash_drawer_checks.screen_name + "'"
                    + ",time_in= '" + to_cash_drawer_checks.time_in + "'"
                    + ",time_out= '" + to_cash_drawer_checks.time_out + "'"
                    + ",bank= '" + to_cash_drawer_checks.bank + "'"
                    + ",check_no= '" + to_cash_drawer_checks.check_no + "'"
                    + ",check_holder= '" + to_cash_drawer_checks.check_holder + "'"
                    + ",amount= '" + to_cash_drawer_checks.amount + "'"
                    + ",vault= '" + to_cash_drawer_checks.vault + "'"
                    + "where "
                    + " id ='" + to_cash_drawer_checks.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_cash_drawer_expenses.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_cash_drawer_checks(to_cash_drawer_expenses to_cash_drawer_checks) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from cash_drawer_expenses where "
                    + " id ='" + to_cash_drawer_checks.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_cash_drawer_expenses.class, "Successfully Deleted");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_cash_drawer_expenses> ret_data(String session_no1) {
        List<to_cash_drawer_expenses> datas = new ArrayList();
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",session_no"
                    + ",user_name"
                    + ",screen_name"
                    + ",time_in"
                    + ",time_out"
                    + ",bank"
                    + ",check_no"
                    + ",check_holder"
                    + ",amount"
                    + ",vault"
                    + " from cash_drawer_expenses where "
                    + " session_no ='" + session_no1 + "' "
                    + " ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String session_no = rs.getString(2);
                String user_name = rs.getString(3);
                String screen_name = rs.getString(4);
                String time_in = rs.getString(5);
                String time_out = rs.getString(6);
                String bank = rs.getString(7);
                String check_no = rs.getString(8);
                String check_holder = rs.getString(9);
                double amount = rs.getDouble(10);
                int vault = rs.getInt(11);
                to_cash_drawer_expenses to = new to_cash_drawer_expenses(id, session_no, user_name, screen_name, time_in, time_out, bank, check_no, check_holder, amount, vault);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_cash_drawer_expenses> ret_data2(String session_no1) {
        List<to_cash_drawer_expenses> datas = new ArrayList();
        String date = DateType.sf.format(new Date());
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",session_no"
                    + ",user_name"
                    + ",screen_name"
                    + ",time_in"
                    + ",time_out"
                    + ",bank"
                    + ",check_no"
                    + ",check_holder"
                    + ",amount"
                    + ",vault"
                    + " from cash_drawer_expenses "
                    + " where date(time_out) ='" + date + "'"
                    + " ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String session_no = rs.getString(2);
                String user_name = rs.getString(3);
                String screen_name = rs.getString(4);
                String time_in = rs.getString(5);
                String time_out = rs.getString(6);
                String bank = rs.getString(7);
                String check_no = rs.getString(8);
                String check_holder = rs.getString(9);
                double amount = rs.getDouble(10);
                int vault = rs.getInt(11);
                to_cash_drawer_expenses to = new to_cash_drawer_expenses(id, session_no, user_name, screen_name, time_in, time_out, bank, check_no, check_holder, amount, vault);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<Srpt_checks.field> ret_data(String date_from, String date_to, String cashier_name) {
        List<Srpt_checks.field> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",session_no"
                    + ",user_name"
                    + ",screen_name"
                    + ",time_in"
                    + ",time_out"
                    + ",bank"
                    + ",check_no"
                    + ",check_holder"
                    + ",amount"
                    + ",date_added"
                    + " from cash_drawer_expenses where "
                    + " date(date_added) between '" + date_from + "' and '" + date_to + "' "
                    + " and user_name like'%" + cashier_name + "%' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            while (rs.next()) {
                int id = rs.getInt(1);
                String session_no = rs.getString(2);
                String user_name = rs.getString(3);
                String screen_name = rs.getString(4);
                String time_in = rs.getString(5);
                String time_out = rs.getString(6);
                String bank = rs.getString(7);
                String check_no = rs.getString(8);
                String check_holder = rs.getString(9);
                double amount = rs.getDouble(10);
                String date_added = DateType.convert_jan_1_2013_datetime2(rs.
                        getString(11));
                Srpt_checks.field t = new Srpt_checks.field(bank, check_holder, check_no, amount, date_added);
                datas.add(t);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }
}

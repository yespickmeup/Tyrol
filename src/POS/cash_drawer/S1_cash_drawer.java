/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.cash_drawer;

import POS.cash_drawer.S1_cash_drawer_checks.to_cash_drawer_checks;
import POS.main.Main;
import POS.main.Main.MyDB;
import POS.util.DateType;
import POS.util.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import mijzcx.synapse.desk.utils.Lg;
import mijzcx.synapse.desk.utils.ReceiptIncrementor;
import mijzcx.synapse.desk.utils.SqlStringUtil;

/**
 *
 * @author Maytopacka
 */
public class S1_cash_drawer {

    public static class to_cash_drawer {

        public final int id;
        public final String session_no;
        public final String user_name;
        public final String screen_name;
        public String time_in;
        public String time_out;
        public static double amount;
        public static double cash_out;
        public final double thousand;
        public final double five_hundred;
        public final double two_hundred;
        public final double fifty;
        public final double twenty;
        public final double coins;
        public final double one_hundred;
        public final List<S1_cash_drawer_checks.to_cash_drawer_checks> checks;
        public final List<S1_cash_drawer_expenses.to_cash_drawer_expenses> exp;
        public final double expenses;

        public static double getCash_out() {
            return cash_out;
        }

        public void setCash_out(double cash_out) {
            to_cash_drawer.cash_out = cash_out;
        }

        public String getTime_in() {
            return time_in;
        }

        public void setTime_in(String time_in) {
            this.time_in = time_in;
        }

        public String getTime_out() {
            return time_out;
        }

        public void setTime_out(String time_out) {
            this.time_out = time_out;
        }

        public to_cash_drawer(int id, String session_no, String user_name, String screen_name, String time_in, String time_out, double amount, double cash_out, double thousand, double five_hundred, double two_hundred, double fifty, double twenty, double coins, double one_hundred, List<S1_cash_drawer_checks.to_cash_drawer_checks> checks, List<S1_cash_drawer_expenses.to_cash_drawer_expenses> exp, double expenses) {
            this.id = id;
            this.session_no = session_no;
            this.user_name = user_name;
            this.screen_name = screen_name;
            this.time_in = time_in;
            this.time_out = time_out;
            to_cash_drawer.amount = amount;
            to_cash_drawer.cash_out = cash_out;
            this.thousand = thousand;
            this.five_hundred = five_hundred;
            this.two_hundred = two_hundred;
            this.fifty = fifty;
            this.twenty = twenty;
            this.coins = coins;
            this.checks = checks;
            this.one_hundred = one_hundred;
            this.exp = exp;
            this.expenses = expenses;
        }

        public double getAmount() {
            return amount;
        }

        public static void setAmount(double amount) {
            to_cash_drawer.amount = amount;
        }
    }

    public static void add_cash_drawer(to_cash_drawer to_cash_drawer) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "insert into cash_drawer("
                    + "session_no"
                    + ",user_name"
                    + ",screen_name"
                    + ",time_in"
                    + ",time_out"
                    + ",amount"
                    + ")values("
                    + ":session_no"
                    + ",:user_name"
                    + ",:screen_name"
                    + ",:time_in"
                    + ",:time_out"
                    + ",:amount"
                    + ")";

            s0 = SqlStringUtil.parse(s0).
                    setString("session_no", to_cash_drawer.session_no).
                    setString("user_name", to_cash_drawer.user_name).
                    setString("screen_name", to_cash_drawer.screen_name).
                    setString("time_in", to_cash_drawer.time_in).
                    setString("time_out", to_cash_drawer.time_out).
                    setNumber("amount", to_cash_drawer.amount).
                    ok();

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_cash_drawer.class, "Successfully Added");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void edit_cash_drawer(to_cash_drawer to_cash_drawer) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "update cash_drawer set "
                    + "time_out= '" + DateType.datetime.format(new Date()) + "'"
                    + ",amount= '" + to_cash_drawer.amount + "'"
                    + ",cash_out= '" + to_cash_drawer.cash_out + "'"
                    + ",thousand= '" + to_cash_drawer.thousand + "'"
                    + ",five_hundred= '" + to_cash_drawer.five_hundred + "'"
                    + ",two_hundred= '" + to_cash_drawer.two_hundred + "'"
                    + ",fifty= '" + to_cash_drawer.fifty + "'"
                    + ",twenty= '" + to_cash_drawer.twenty + "'"
                    + ",coins= '" + to_cash_drawer.coins + "'"
                    + ",one_hundred= '" + to_cash_drawer.one_hundred + "'"
                    + ",expenses= '" + to_cash_drawer.expenses + "'"
                    + "where "
                    + " session_no ='" + to_cash_drawer.session_no + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_cash_drawer.class, "Successfully Updated");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static void delete_cash_drawer(to_cash_drawer to_cash_drawer) {
        try {
            Connection conn = MyConnection.connect();
            String s0 = "delete from cash_drawer where "
                    + " id ='" + to_cash_drawer.id + "' "
                    + " ";

            PreparedStatement stmt = conn.prepareStatement(s0);
            stmt.execute();
            Lg.s(S1_cash_drawer.class, "Successfully Deleted");
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_cash_drawer> ret_data(String user_names, String date) {
        List<to_cash_drawer> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",session_no"
                    + ",user_name"
                    + ",screen_name"
                    + ",time_in"
                    + ",time_out"
                    + ",amount"
                    + ",cash_out"
                    + ",thousand"
                    + ",five_hundred"
                    + ",two_hundred"
                    + ",fifty"
                    + ",twenty"
                    + ",coins"
                    + ",one_hundred"
                    + ",expenses"
                    + " from cash_drawer where "
                    + " user_name ='" + user_names + "' "
                    + " and date)time_in) ='" + date + "' "
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
                double amount = rs.getDouble(7);
                double cash_out = rs.getDouble(8);
                double thousand = rs.getDouble(9);
                double five_hundred = rs.getDouble(10);
                double two_hundred = rs.getDouble(11);
                double fifty = rs.getDouble(12);
                double twenty = rs.getDouble(13);
                double coins = rs.getDouble(14);
                double one_hundred = rs.getDouble(15);
                double expenses = rs.getDouble(16);

                to_cash_drawer to = new to_cash_drawer(id, session_no, user_name, screen_name, time_in, time_out, amount, cash_out, thousand, five_hundred, two_hundred, fifty, twenty, coins, one_hundred, new ArrayList(), new ArrayList(), expenses);

                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static List<to_cash_drawer> ret_data2(String user_names, String date_from, String date_to) {
        List<to_cash_drawer> datas = new ArrayList();

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",session_no"
                    + ",user_name"
                    + ",screen_name"
                    + ",time_in"
                    + ",time_out"
                    + ",amount"
                    + ",cash_out"
                    + ",thousand"
                    + ",five_hundred"
                    + ",two_hundred"
                    + ",fifty"
                    + ",twenty"
                    + ",coins"
                    + ",one_hundred "
                    + ",expenses "
                    + " from cash_drawer where "
                    + " user_name like'%" + user_names + "%' "
                    + " and date(time_in) between '" + date_from + "' and '" + date_to + "' "
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
                double amount = rs.getDouble(7);
                double cash_out = rs.getDouble(8);
                double thousand = rs.getDouble(9);
                double five_hundred = rs.getDouble(10);
                double two_hundred = rs.getDouble(11);
                double fifty = rs.getDouble(12);
                double twenty = rs.getDouble(13);
                double coins = rs.getDouble(14);
                double one_hundred = rs.getDouble(15);
                double expenses = rs.getDouble(16);

                to_cash_drawer to = new to_cash_drawer(id, session_no, user_name, screen_name, time_in, time_out, amount, cash_out, thousand, five_hundred, two_hundred, fifty, twenty, coins, one_hundred, new ArrayList(), new ArrayList(), expenses);
                datas.add(to);
                datas.add(to);
            }
            return datas;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static to_cash_drawer ret_data2(String user_names, String date) {
        to_cash_drawer to1 = null;

        try {
            Connection conn = MyConnection.connect();
            String s0 = "select "
                    + "id"
                    + ",session_no"
                    + ",user_name"
                    + ",screen_name"
                    + ",time_in"
                    + ",time_out"
                    + ",amount"
                    + ",cash_out"
                    + ",thousand"
                    + ",five_hundred"
                    + ",two_hundred"
                    + ",fifty"
                    + ",twenty"
                    + ",coins"
                    + ",one_hundred"
                    + ",expenses "
                    + " from cash_drawer where "
                    + " user_name ='" + user_names + "' "
                    + " and date(time_in) ='" + date + "' "
                    + " ";

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                int id = rs.getInt(1);
                String session_no = rs.getString(2);
                String user_name = rs.getString(3);
                String screen_name = rs.getString(4);
                String time_in = rs.getString(5);
                String time_out = rs.getString(6);
                double amount = rs.getDouble(7);
                double cash_out = rs.getDouble(8);
                double thousand = rs.getDouble(9);
                double five_hundred = rs.getDouble(10);
                double two_hundred = rs.getDouble(11);
                double fifty = rs.getDouble(12);
                double twenty = rs.getDouble(13);
                double coins = rs.getDouble(14);
                double one_hundred = rs.getDouble(15);
                double expenses = rs.getDouble(16);
                List<S1_cash_drawer_checks.to_cash_drawer_checks> checks = new ArrayList();
                String s2 = "select "
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
                        + " from cash_drawer_checks where "
                        + " user_name ='" + user_names + "' "
                        + " and date(time_in) = '" + date + "' "
                        + " ";

                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2.executeQuery(s2);
                while (rs2.next()) {
                    int id1 = rs2.getInt(1);
                    String session_no1 = rs2.getString(2);
                    String user_name1 = rs2.getString(3);
                    String screen_name1 = rs2.getString(4);
                    String time_in1 = rs2.getString(5);
                    String time_out1 = rs2.getString(6);
                    String bank = rs2.getString(7);
                    String check_no = rs2.getString(8);
                    String check_holder = rs2.getString(9);
                    double amount1 = rs2.getDouble(10);
                    to_cash_drawer_checks to = new to_cash_drawer_checks(id1, session_no1, user_name1, screen_name1, time_in1, time_out1, bank, check_no, check_holder, amount1);
                    checks.add(to);
                }
                to1 = new to_cash_drawer(id, session_no, user_name, screen_name, time_in, time_out, amount, cash_out, thousand, five_hundred, two_hundred, fifty, twenty, coins, one_hundred, checks, new ArrayList(), expenses);

            }
            return to1;
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            MyConnection.close();
        }
    }

    public static String increment_id() {
        String ids = "CD-00000000000";
        try {
            Connection conn = MyConnection.connect();
            String s0 = "select max(id) from cash_drawer";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(s0);
            if (rs.next()) {
                ids = rs.getString(1);
            }
            if (ids == null) {
                ids = "CD-00000000001";
            } else {
                String s2 = "select session_no from cash_drawer where id='" + ids + "'";
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

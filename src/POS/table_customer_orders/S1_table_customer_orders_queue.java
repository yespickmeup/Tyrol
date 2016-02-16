/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.table_customer_orders;

/**
 *
 * @author Ronald
 */
public class S1_table_customer_orders_queue {

    public static class to_table_customer_orders_queue {

        public final int id;
        public final String table_customer_id;
        public final String customer_id;
        public final String customer_name;
        public final String table_id;
        public final String table_name;
        public final String date_added;
        public final String user_name;
        public final String waiter_id;
        public final String waiter_name;
        public final String barcode;
        public final String description;
        public double qty;
        public double selling_price;
        public final String category_id;
        public final String category_name;
        public final String sub_category_id;
        public final String sub_category_name;
        public final String printing_assembly_id;
        public final String priting_assembly_name;
        public final String group_id;
        public final String group_name;
        public String discount_name;
        public double discount_rate;
        public double discount_amount;
        public final int status;
        public String specifications;

        public to_table_customer_orders_queue(int id, String table_customer_id, String customer_id, String customer_name, String table_id, String table_name, String date_added, String user_name, String waiter_id, String waiter_name, String barcode, String description, double qty, double selling_price, String category_id, String category_name, String sub_category_id, String sub_category_name, String printing_assembly_id, String priting_assembly_name, String group_id, String group_name, String discount_name, double discount_rate, double discount_amount, int status, String specifications) {
            this.id = id;
            this.table_customer_id = table_customer_id;
            this.customer_id = customer_id;
            this.customer_name = customer_name;
            this.table_id = table_id;
            this.table_name = table_name;
            this.date_added = date_added;
            this.user_name = user_name;
            this.waiter_id = waiter_id;
            this.waiter_name = waiter_name;
            this.barcode = barcode;
            this.description = description;
            this.qty = qty;
            this.selling_price = selling_price;
            this.category_id = category_id;
            this.category_name = category_name;
            this.sub_category_id = sub_category_id;
            this.sub_category_name = sub_category_name;
            this.printing_assembly_id = printing_assembly_id;
            this.priting_assembly_name = priting_assembly_name;
            this.group_id = group_id;
            this.group_name = group_name;
            this.discount_name = discount_name;
            this.discount_rate = discount_rate;
            this.discount_amount = discount_amount;
            this.status = status;
            this.specifications = specifications;
        }

        public double getQty() {
            return qty;
        }

        public void setQty(double qty) {
            this.qty = qty;
        }

        public double getSelling_price() {
            return selling_price;
        }

        public void setSelling_price(double selling_price) {
            this.selling_price = selling_price;
        }

        public String getDiscount_name() {
            return discount_name;
        }

        public void setDiscount_name(String discount_name) {
            this.discount_name = discount_name;
        }

        public double getDiscount_rate() {
            return discount_rate;
        }

        public void setDiscount_rate(double discount_rate) {
            this.discount_rate = discount_rate;
        }

        public double getDiscount_amount() {
            return discount_amount;
        }

        public void setDiscount_amount(double discount_amount) {
            this.discount_amount = discount_amount;
        }

        public String getSpecifications() {
            return specifications;
        }

        public void setSpecifications(String specifications) {
            this.specifications = specifications;
        }

    }
}

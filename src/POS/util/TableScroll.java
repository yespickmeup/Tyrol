/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS.util;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ronald
 */
public class TableScroll {

    public static ArrayList set(int interval, int current_position, List<?> list) {
        ArrayList new_list = new ArrayList();
        int total = interval + current_position;

        int min = current_position;
        int max = total;
        new_list.addAll(list.subList(min, max));
        return new_list;
    }
    
    public static void main(String[] args) {
        
    }
}

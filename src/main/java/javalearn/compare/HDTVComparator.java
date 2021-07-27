package javalearn.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @description: Comparator: 不需要改动原来的类，且自由选择要比较的属性，比较时实现Comparator接口
 * @author: leo
 * @createDate: 2021/7/27 15:59
 * @version: 1.0
 */
public class HDTVComparator {
    private int size;
    private String brand;

    public HDTVComparator(int size, String brand) {
        this.size = size;
        this.brand = brand;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public static void main(String[] args) {
        HDTVComparator tv1 = new HDTVComparator(55, "Samsung");
        HDTVComparator tv2 = new HDTVComparator(60, "Sony");
        HDTVComparator tv3 = new HDTVComparator(42, "Panasonic");

        ArrayList<HDTVComparator> al = new ArrayList<HDTVComparator>();
        al.add(tv1);
        al.add(tv2);
        al.add(tv3);

        Collections.sort(al, new Comparator<HDTVComparator>() {
            @Override
            public int compare(HDTVComparator h1, HDTVComparator h2) {
                return h1.getSize() - h2.getSize();
            }
        });

        for (HDTVComparator a : al) {
            System.out.println(a.getBrand());
        }
    }
}

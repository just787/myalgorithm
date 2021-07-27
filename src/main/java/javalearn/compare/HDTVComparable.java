package javalearn.compare;

/**
 * @description: Comparable: 需要修改原有的类，实现Comparable接口
 * @author: leo
 * @createDate: 2021/7/27 15:56
 * @version: 1.0
 */
class HDTVComparable implements Comparable<HDTVComparable> {
    private int size;
    private String brand;

    public HDTVComparable(int size, String brand) {
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

    @Override
    public int compareTo(HDTVComparable tv) {

        if (this.getSize() > tv.getSize())
            return 1;
        else if (this.getSize() < tv.getSize())
            return -1;
        else
            return 0;
    }

    public static void main(String[] args) {
        HDTVComparable tv1 = new HDTVComparable(55, "Samsung");
        HDTVComparable tv2 = new HDTVComparable(60, "Sony");

        if (tv1.compareTo(tv2) > 0) {
            System.out.println(tv1.getBrand() + " is better.");
        } else {
            System.out.println(tv2.getBrand() + " is better.");
        }
    }
}



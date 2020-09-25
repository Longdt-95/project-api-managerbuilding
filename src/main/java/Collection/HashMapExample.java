/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class HashMapExample {

    static Scanner sc = new Scanner(System.in);
    static HashMap<Integer, String> listBook = new HashMap<Integer, String>();

    public static void menu() {
        System.out.println("1 - thêm: ");
        System.out.println("2 - sửa ");
        System.out.println("3 - xóa ");
        System.out.println("4 - tìm kiếm ");
        System.out.println("5 - xuất ");
        System.out.println("6 - thoát ");
        System.out.println(" mời bạn chọn mục ");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                them();
                break;
            case 2:
                sua();
                break;
            case 3:
                xoa();
                break;
            case 4:
                timKiem();
                break;
            case 5:
                xuat();
                break;
            case 6:
                System.out.println("cam on ban !");
                System.exit(0);
                break;
        }
    }

    static void them() {
        System.out.println("mời bạn nhập mã:");
        int ma = sc.nextInt();
        System.out.println("mời bạn nhập tên sách");
        sc.nextLine();
        String ten = sc.nextLine();
        if (listBook.containsKey(ma) == false) {
            listBook.put(ma, ten);
        }
    }

    static void sua() {
        System.out.println("nhập mã sinh viên bạn muốn sửa");
        int ma = sc.nextInt();
        sc.nextLine();
        if (listBook.containsKey(ma) == false) {
            System.out.println("mã không tồn tại");
        } else {
            System.out.println("nhập tên sách mới");
            String ten = sc.nextLine();
            listBook.put(ma, ten);
        }
    }

    static void xoa() {
        System.out.println("mời bạn nhập mã muốn xóa");
        int ma = sc.nextInt();
        if (listBook.containsKey(ma) == false) {
            System.err.println("mã bạn nhập không tồn tại");
        } else {
            listBook.remove(ma);
        }
    }

    static void timKiem() {
        System.out.println("mời bạn nhập tên sách");
        sc.nextLine();
        String ten = sc.nextLine();
        for (Map.Entry<Integer, String> item : listBook.entrySet()) {
            if (item.getValue().contains(ten)) {
                System.out.println(item.getKey() + "\t" + item.getValue());
            }
        }
    }

    static void xuat() {
        if (listBook.size() == 0) {
            System.err.println("hiện chưa có sách trong list");
            System.out.println("mời bạn chọn 1 để thêm sách vào list");
        } else {
            System.out.println("Mã \tTên sách");
            System.out.println("_________________________________________________________________");
            for (Map.Entry<Integer, String> item : listBook.entrySet()) {
                System.out.println(item.getKey() + "\t" + item.getValue());
            }
        }
    }

    public static void main(String[] args) {
        while (true) {
            menu();
        }
    }
}

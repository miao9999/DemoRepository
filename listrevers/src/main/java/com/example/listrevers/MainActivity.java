package com.example.listrevers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Integer> list = new ArrayList<Integer>();// 创建列表
//        for (int i = 0; i < 10; i++) {// 向列表中增加10个元素
            list.add(41);
            list.add(8);
            list.add(5);
            list.add(68);
            list.add(6);
            list.add(43);
            list.add(43);
            list.add(6);
//        }
//        Iterator it = list.iterator();
//        System.out.print("ArrayList集合中的元素为：");
//        while(it.hasNext()){
////            System.out.print(it.next()+" ");
//            Log.e("MainActivity","it.next:" + (it.next() + " "));
//
//        }
//        System.out.println();
//        System.out.println("逆序后为：");
//        Log.e("MainActivity","逆序后为：");
//        ListIterator<Integer> li = list.listIterator();// 获得ListIterator对象
//        for (li = list.listIterator(); li.hasNext();) {// 将游标定位到列表结尾
//            li.next();
//        }
//        for (; li.hasPrevious();) {// 逆序输出列表中的元素
////            System.out.print(li.previous() + " ");
//            Log.e("MainActivity","it.previous:" + (li.previous() + " "));
//        }

        for (int i = 0; i < list.size(); i++) {
            Log.e("MainActivity", "list.get(i)------:" + list.get(i));
        }
        Collections.reverse(list);
        for (int i = 0; i < list.size(); i++) {
            Log.e("MainActivity", "list.get(i):" + list.get(i));
        }
    }
}

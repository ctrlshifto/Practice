package com.arrayList;


public class ArrayList {


    public static void  main(String[] args){
        /**
         * ①构造方法
         */
        java.util.ArrayList<Integer> list_2 = new java.util.ArrayList<Integer>(20);
        //list_2中添加元素
        for (int i = 0; i < 10; i++)
            list_2.add(i);

        java.util.ArrayList<Integer> list_3 = new java.util.ArrayList<Integer>(list_2);
        //输出list_2中元素
        System.out.println("list_2:");
        for (Integer a : list_2)
            System.out.print(a + " ");
        //输出list_3中元素
        System.out.println("\nlist_3:");
        for (Integer a : list_3)
            System.out.print(a + " ");
        System.out.println("\n②indexOf(Object o)方法:");
        /**
         * ②indexOf(Object o)方法
         */
        java.util.ArrayList<Integer> list=new java.util.ArrayList<Integer>();

        list.add(1);
        list.add(2);
        list.add(null);
        list.add(2);
        list.add(3);

        System.out.println("null: "+list.indexOf(null));
        System.out.println("-------------------------");
        System.out.println("2: "+list.indexOf(2));
        System.out.println("-------------------------");
        System.out.println("4: "+list.indexOf(4));
        System.out.println("\n③lastIndexOf(Object o)方法 ");
        /**
         * ③lastIndexOf(Object o)方法
         */
        list.add(0);
        System.out.println(list.lastIndexOf(2));
        System.out.println("\n④get(int index)方法");
        /**
         * ④get(int index)方法
         */
        System.out.println(list.get(0));
        System.out.println("\n⑤set(int index, E element)方法 ");
        /**
         * ⑤set(int index, E element)方法
         */
        System.out.println(list.get(1));
        System.out.println(list.set(1,3));//打印被覆盖的元素
        System.out.println(list.get(1));
        System.out.println("\n⑦add(int index, E element)方法");
        /**
         * ⑦add(int index, E element)方法
         */
        for(int i = 0;i<list.size();i++)
            System.out.println(list.get(i));
        System.out.println();
        list.add(2,3);
        for(int i = 0;i<list.size();i++)
            System.out.println(list.get(i));
        System.out.println();
        System.out.println("⑧remove(int index)方法 ");
        /**
         * ⑧remove(int index)方法
         */
        for(int i = 0;i<list.size();i++)
            System.out.println(list.get(i));
        System.out.println();
        list.remove(2);
        for(int i = 0;i<list.size();i++)
            System.out.println(list.get(i));

//        int i = com.Integer.parseInt("123a");
    }

}

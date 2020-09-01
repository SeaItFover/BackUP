package Java集合类.HashMap.HashMap源码分析;

import java.util.*;

/**
 * 测试一下map接口中常用的十一种方法。
 * puy,get,remove,size,isEmpty,clear,keySet,values,entrySet,containsKey,containsValue
 *
 * put方法返回值是null或者value。如果存入的值不存在，也就是存入成功，那么返回null。
 * 如果存入的值存在，也就是存入失败（因为key不重复），那么返回value。
 *
 *
 */
public class Test01 {

    public static void main(String[] args) {
        /**
         * 新建一个hashMap
         * map中key不能重复，value可以重复
         */
        Map<String,Person> persons = new HashMap<>();
        // 01 --- Person id=01,name=刘备
        // 02 --- Person id=02,name=关羽
        // 03 --- Person id=03,name=张飞

        /**
         * put方法：返回值为null或者value
         * size方法：map中一共几个键值对（双列集合）
         */
        System.out.println(persons.put("01", new Person("01", "刘备")));
        persons.put("02",new Person("02","关羽"));
        System.out.println(persons.put("02", new Person("02", "关羽")));
        persons.put("04",new Person("02","关羽"));
        persons.put("03",new Person("03","张飞"));
        System.out.println("总共多少人"+persons.size());
        System.out.println("请输入编号：");

        /**
         * get(Key)方法：通过给定一个key得到一个返回值value。
         */
        Scanner input = new Scanner(System.in);
        String id = input.next();
        Person person = persons.get(id);
        System.out.println(person);

        /**
         * remove(Key)方法：给定一个key值，返回一个被删除的value值
         */
        Person p1 = persons.remove("02");  //remove方法返回的是删除的那个对象
        System.out.println(p1.getName()+"已经被干掉...");
        System.out.println("还剩多少人:"+persons.size());

        /**
         * clear方法：清空集合，size为0
         */
//        persons.clear();
//        System.out.println("还剩多少人:"+persons.size());

        /**
         * contanKey方法：判断是不是同一个key（equals、hashCode）
         */
        String id2 = input.next();
        if (persons.containsKey(id2)){
            System.out.println(persons.get(id2).getName()+"角色已经存在");
        }else{
            System.out.println(persons.get(id2).getName()+"角色已经不存在");
        }

        /**
         * containValue方法：判断是不是同一个对象（equals）
         */
        if (persons.containsValue(new Person("01","刘备"))){
            System.out.println("刘备存在");
        }else {
            System.out.println("刘备不存在");
        }

        /**
         * keySet方法：返回一个key的set集合
         * 迭代器遍历和增强for循环遍历都要掌握（本质上一样，只是版本不同）
         */
        Set<String> keys = persons.keySet();
        Iterator<String> ite = keys.iterator();
        while(ite.hasNext()){
            String key = ite.next();
            String name = persons.get(key).getName();
            System.out.printf("%s %s",key,name);
        }
        System.out.println();
        for(String key:keys){
            System.out.print(key+" "+persons.get(key).getName());
        }
        System.out.println();

        /**
         * values方法：
         */
        Collection<Person> values = persons.values();
        for (Person p:values){
            System.out.println(p);
        }

        /**
         * entrySet：拿到双列集合
         */
        Set<Map.Entry<String, Person>> entries = persons.entrySet();
        //也可以用迭代器遍历
        for (Map.Entry<String,Person> entry : entries){
            String key = entry.getKey();
            String name = entry.getValue().getName();
            System.out.printf("%s %s",key,name);
        }
    }
}

package com.javarush.task.task21.task2107;

import java.util.LinkedHashMap;
import java.util.Map;

/* 
Глубокое клонирование карты
Обеспечь возможность клонирования объекта класса Solution используя глубокое клонирование.
Данные в карте users также должны быть клонированы.
Не забудь о методах equals и hashCode для корректного добавления элементов типа User в HashMap.
*/
public class Solution implements Cloneable{

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.users.put("Hubert", new User(172, "Hubert"));
        solution.users.put("Zapp", new User(41, "Zapp"));
        Solution clone = null;
        try {
            clone =  solution.clone();
            System.out.println(solution);
            System.out.println(clone);

            System.out.println(solution.users);
            System.out.println(clone.users);

        } catch (CloneNotSupportedException e) {
            e.printStackTrace(System.err);
        }
    }

    protected Map<String, User> users = new LinkedHashMap();

    public static class User  implements Cloneable {
        int age;
        String name;

        public User(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public User clone() throws CloneNotSupportedException {
            User u = new User(age, name);

            return u;
        }


        @Override
        public int hashCode() {
            return 31*age+name.hashCode();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null)
                return true;



            if (!(o instanceof User) )
                return false;

            User u = (User) o;
            if(age != u.age) return false;
            if(!(name.equals(u.name)) && u.name != null) return false;
            return true;
        }
    }
    public Solution clone() throws CloneNotSupportedException {
Solution s=new Solution();
        if (this.users != null) {
            for (Map.Entry<String, User> mp : this.users.entrySet()) {
                int age = mp.getValue().age;
                String name = mp.getValue().name;
                s.users.put(mp.getKey(), new User(age, name));
            }
        }  return s;




    }
}
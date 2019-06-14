package cafeteria;


//import com.google.gson.JsonArray;
//import com.google.gson.JsonObject;

import faculty.Person;
import faculty.Role;
import faculty.Teacher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cafeteria {


    private Map<Person, List<Menu>> customerList = new HashMap<>();


    public void purchase(Person person, Menu item) {
        double price = item.getPrice();


        if (person.getRole().equals(Role.Teacher) && person.totalLessons() >= 5) {
            price = price - (((double) 25 / 100) * price);
            System.out.println(price);
        }

        if (!customerList.containsKey(person)) {
            customerList.put(person, new ArrayList<>());
        }

        if (person.withdrawTokens(price)) {
            customerList.get(person).add(item);
        }

    }

    public void salesList() {

        // List<String> result = new ArrayList();
        for (Map.Entry listItem : customerList.entrySet()) {

            Person currentPerson = (Person) listItem.getKey();
            List<Menu> currentList = (ArrayList<Menu>) listItem.getValue();

            System.out.println(String.format("%s %s",currentPerson.getName(),currentPerson.getSurname()));
            System.out.println("---------------------");
            for (Menu menu : currentList) {
                System.out.println("* " + menu);
            }

        }

    }


    public static void main(String[] args) {
        Person teacher = new Teacher("jon", "snow", "email");
        Cafeteria cafe = new Cafeteria();
        teacher.depositTokens(7);
        cafe.purchase(teacher, Menu.Lunch);
        System.out.println(teacher.getTokenBalance());

//        cafe.purchase(student1, Menu.Breakfast);

        // System.out.println();
        cafe.salesList();

    }

}

package cafeteria;

import faculty.Person;
import faculty.Student;

import java.util.*;

public class Cafeteria {

    private Map<Person, List<Menu>> customerList = new HashMap<>();

    public void purchase(Person person, Menu item){
      if(!customerList.containsKey(person)){
          customerList.put(person, new ArrayList<>());
      }
      customerList.get(person).add(item);

    }

    public void soldToList() {
        List<String> result = new ArrayList();
    for (Map.Entry listItem : customerList.entrySet()){

    Person currentPerson = (Person) listItem.getKey();
    ArrayList currentList = (ArrayList) listItem.getValue();
    String boughtItems = "";

    for (int i = 0; i< currentList.size();i++){
        boughtItems += currentList.get(i) + "";
    }
    result.add(currentPerson.getName() + " : " + boughtItems);
    boughtItems = "";

}
        result.forEach(System.out::println);
    }



    public static void main(String[] args) {
        Student student = new Student("jon", "snow", "email");
        Student student1 = new Student("pop", "snow", "email");
        Cafeteria cafe = new Cafeteria();
        cafe.purchase(student, Menu.Breakfast);
        cafe.purchase(student1, Menu.Breakfast);
        cafe.purchase(student, Menu.Lunch);
cafe.soldToList();


    }

}

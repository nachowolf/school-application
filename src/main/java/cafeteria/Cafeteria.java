package cafeteria;


//import com.google.gson.JsonArray;
//import com.google.gson.JsonObject;
import faculty.Person;
import faculty.Role;
import faculty.Student;
import faculty.Teacher;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.*;

public class Cafeteria {



    private Map<Person, List<Menu>> customerList = new HashMap<>();




    public void purchase(Person person, Menu item){
        double price = item.getPrice();


        if (person.getRole().equals(Role.Teacher) && person.totalLessons() >= 5){
            price = price - (((double)25/100) * price);
            System.out.println(price);
        }

      if(!customerList.containsKey(person)){
          customerList.put(person, new ArrayList<>());
      }

      if(person.withdrawTokens(price)){
          customerList.get(person).add(item);
      }

    }

    public List salesList() {

        List<String> result = new ArrayList();
    for (Map.Entry listItem : customerList.entrySet()){

    Person currentPerson = (Person) listItem.getKey();
    ArrayList currentList = (ArrayList) listItem.getValue();
    String boughtItems = "Items : {";

    for (int i = 0; i< currentList.size();i++){
       if(i<currentList.size()-1){
           boughtItems += currentList.get(i) + ", ";
       }
        else{
            boughtItems += currentList.get(i) + "}";
        }
    }
    result.add("\nName : " + currentPerson.getName() + " " + currentPerson.getSurname()+ "\n" + boughtItems);
    boughtItems = "";

}
        return result;
    }



    public static void main(String[] args) {
        Person teacher = new Teacher("jon", "snow", "email");
        Cafeteria cafe = new Cafeteria();
        teacher.depositTokens(7);
        cafe.purchase(teacher, Menu.Lunch);
        System.out.println(teacher.getTokenBalance());

//        cafe.purchase(student1, Menu.Breakfast);

        cafe.salesList();


    }

}

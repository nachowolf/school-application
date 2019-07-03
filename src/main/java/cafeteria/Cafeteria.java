package cafeteria;

import faculty.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cafeteria {


    private Map<Person, List<MenuItem>> customerList = new HashMap<>();
    private Map <MenuItem, Integer> MenuItemList = new HashMap<>();
    private double salesTotal = 0;


    public void purchase(Person person, MenuItem item) {
        double price = item.getPrice();

        if(!MenuItemList.containsKey(item)){
            MenuItemList.put(item, 0);
        }

        if (!customerList.containsKey(person)) {
            customerList.put(person, new ArrayList<>());
        }

        if (person.getRole().equals(Role.Teacher) && person.totalLessons() >= 5) {
            price = price - (((double) 25 / 100) * price);

        }

        if (person.withdrawTokens(price)) {
            salesTotal += price;
            customerList.get(person).add(item);
            MenuItemList.put(item, MenuItemList.get(item)+1);
            System.out.println("cost: " + price);
        }

    }

    public void totalItemsSold(){
        int total = 0;
        System.out.println("---------------------");
        System.out.println("Stock List: ");
        System.out.println("---------------------");
        for(Map.Entry item : MenuItemList.entrySet()){
            total += (int)item.getValue();
            MenuItem it = (MenuItem) item.getKey();
            System.out.println("# Item: " + it.getItem() + ", Total sold: " + item.getValue());

        }
        System.out.println("---------------------\n Total Items sold : " + total + "\n---------------------");
    }

    public double getSalesTotal(){
        return salesTotal;
    }

    public void salesList() {

        // List<String> result = new ArrayList();
        for (Map.Entry listItem : customerList.entrySet()) {

            Person currentPerson = (Person) listItem.getKey();
            List<MenuItem> currentList = (ArrayList<MenuItem>) listItem.getValue();

            int total = 0;

            System.out.println("---------------------");
            System.out.println(String.format("Customer: %s %s ",currentPerson.getName(),currentPerson.getSurname()));

            System.out.println("---------------------");
            System.out.println("Purchase List: ");
            for (MenuItem menu : currentList) {
                total += menu.getPrice();
                System.out.println("# " + menu);
            }
            System.out.println("---------------------");
            System.out.println("Total: " + total);
            System.out.println("---------------------\n");

        }

    }

    public static void main(String[] args) {
        Teacher teacher = new Teacher("jon", "snow", "email");
         teacher.qualifySubject(Subject.Maths);
         teacher.addLesson("09:00", Subject.Maths);
        teacher.addLesson("10:00", Subject.Maths);
        teacher.addLesson("11:00", Subject.Maths);
        teacher.addLesson("12:00", Subject.Maths);
        teacher.addLesson("13:00", Subject.Maths);

        Student student = new Student("black", "jack", "email");

        Cafeteria cafe = new Cafeteria();
        teacher.depositTokens(20);
        student.depositTokens(20);

        cafe.purchase(teacher, MenuItem.Breakfast);
        cafe.purchase(teacher, MenuItem.Lunch);
//        cafe.purchase(teacher, MenuItem.Drink);

        cafe.purchase(student, MenuItem.Breakfast);
        cafe.purchase(student, MenuItem.Lunch);
        cafe.purchase(student, MenuItem.Drink);

        System.out.println("teacher Balance: " + teacher.getTokenBalance());
        System.out.println("student Balance: " + student.getTokenBalance());

        cafe.salesList();
//        System.out.println("total sales : " + cafe.getSalesTotal() + " tokens");
        cafe.totalItemsSold();
    }

}

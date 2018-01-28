
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {

    private Map<String, Person> phoneBook;
    private String a = "";
    private String b = "";

    public PhoneBook() {
        this.phoneBook = new HashMap();
    }

    public void addPerson(Person person) {
        this.phoneBook.put(person.getName(), person);
    }

    public Person getPerson(String name) {
        return this.phoneBook.get(name);
    }

    public void addNumber(String name, String number) {
        if (!this.phoneBook.keySet().contains(name)) {
            this.phoneBook.put(name, new Person(name));
            this.phoneBook.get(name).addPhone(number);
        } else {
            this.phoneBook.get(name).addPhone(number);
        }
    }

    public void setAdress(String name, String street, String city) {
        if (!this.phoneBook.keySet().contains(name)) {
            this.phoneBook.put(name, new Person(name));
            this.phoneBook.get(name).setAdress(street, city);
        } else {
            this.phoneBook.get(name).setAdress(street, city);
        }
    }

    public List<String> searchNumber(Person person) {
        return this.phoneBook.get(person).getNumbers();
    }

    public void printNumbers(Person person) {
        if (person.getNumbers().isEmpty()) {
            System.out.println("  phone number not found");
        } else {
            System.out.println("  phone numbers:");
            for (String i : person.getNumbers()) {
                System.out.println("   " + i);
            }
        }
    }

    public String searchName(String number) {
        for (Person l : this.phoneBook.values()) {
            if (l.getNumbers().contains(number)) {
                return l.getName();
            }
        }
        return "  not found";
    }

    public void getAdress(Person person) {
        a = this.phoneBook.get(person.getName()).getStreet();
        b = this.phoneBook.get(person.getName()).getCity();
        if (a.length() == 0 && b.length() == 0) {
            System.out.println("  address unknown");
        } else {
            System.out.println("  address: " + a + " " + b);
        }
    }

    public void forgetMe(String name) {
        this.phoneBook.get(name).eraseData();
        this.phoneBook.remove(name);
    }

    public void searchByString(String string) {
        PhoneBook tempPhoneBook = new PhoneBook();
        for (Person l : this.phoneBook.values()) {
            if (l.getName().contains(string) || l.getNumbers().contains(string) || l.getCity().contains(string) || l.getStreet().contains(string)) {
                tempPhoneBook.addPerson(l);
            }
        }
        List sorted = tempPhoneBook.sortPeople();
        if (sorted.size() == 0) {
            System.out.println("   not found");
        } else {
            for (int i = 0; i < tempPhoneBook.phoneBook.size(); i++) {
                String a = (String) sorted.get(i);
                Person p = tempPhoneBook.getPerson(a);
                System.out.println(" " + p.getName());
                tempPhoneBook.getAdress(p);
                tempPhoneBook.printNumbers(p);
            }
        }
    }

    public Collection<Person> allPeople() {
        return this.phoneBook.values();
    }

    public List sortPeople() {
        List sortedKeys = new ArrayList(this.phoneBook.keySet());
        Collections.sort(sortedKeys);
        return sortedKeys;
    }
}

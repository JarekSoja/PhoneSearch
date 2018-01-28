
import java.util.List;
import java.util.Scanner;

public class Engine {

    private Scanner reader;
    private PhoneBook phoneBook;

    public Engine() {
        this.reader = new Scanner(System.in);
        this.phoneBook = new PhoneBook();
    }

    public String reader() {
        return this.reader.nextLine();
    }

    public void start() {
        System.out.println("phone search");
        System.out.println("available operations:");
        System.out.println(" 1 add a number");
        System.out.println(" 2 search for a number");
        System.out.println(" 3 search for a person by phone number");
        System.out.println(" 4 add an address");
        System.out.println(" 5 search for personal information");
        System.out.println(" 6 delete personal information");
        System.out.println(" 7 filtered listing");
        System.out.println(" x quit");
    }

    public void command(String command) {
        if (command.equals("1")) {
            this.addNumber();
        } else if (command.equals("2")) {
            this.searchNumber();
        } else if (command.equals("3")) {
            this.searchPerson();
        } else if (command.equals("4")) {
            this.addAdress();
        } else if (command.equals("5")) {
            this.personalInfo();
        } else if (command.equals("6")) {
            this.deleteInfo();
        } else if (command.equals("7")) {
            this.searchViaString();
        } else {
        }
    }

    public void addNumber() {
        System.out.println("whose number: ");
        String name = reader.nextLine();
        System.out.println("number: ");
        String number = reader.nextLine();
        this.phoneBook.addNumber(name, number);
    }

    public void searchNumber() {
        System.out.println("whose number: ");
        String name = reader.nextLine();
        if (this.phoneBook.getPerson(name) != null) {
            System.out.println((" " + this.phoneBook.getPerson(name).getNumbers()));
        } else {
            System.out.println("  not found");
        }
    }

    public void searchPerson() {
        System.out.println("number: ");
        String number = reader.nextLine();
        System.out.println(" " + this.phoneBook.searchName(number));
    }

    public void addAdress() {
        System.out.println("whose address: ");
        String name = reader.nextLine();
        System.out.println("street: ");
        String street = reader.nextLine();
        System.out.println("city: ");
        String city = reader.nextLine();
        this.phoneBook.setAdress(name, street, city);
    }

    public void personalInfo() {
        System.out.println("whose information: ");
        String name = reader.nextLine();
        if (this.phoneBook.getPerson(name) != null) {
            this.phoneBook.getAdress(this.phoneBook.getPerson(name));
            this.phoneBook.printNumbers(this.phoneBook.getPerson(name));
        } else {
            System.out.println("  not found");
        }
    }

    public void deleteInfo() {
        System.out.println("whose information: ");
        String name = reader.nextLine();
         if (this.phoneBook.getPerson(name) != null) {
        this.phoneBook.forgetMe(name);
    } else System.out.println("  not found");
    }

    public void searchViaString() {
        System.out.println("keyword (if empty, all listed): ");
        String keyword = reader.nextLine();
        if (keyword.isEmpty()) {
            List sorted = this.phoneBook.sortPeople();
            for (int i = 0; i < sorted.size(); i++) {
                String a = (String) sorted.get(i);
                Person p = this.phoneBook.getPerson(a);
                System.out.println(" " + p.getName());
                this.phoneBook.getAdress(p);
                this.phoneBook.printNumbers(p);
            }
        } else {
            this.phoneBook.searchByString(keyword);
        }
    }

}

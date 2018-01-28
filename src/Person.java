
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


public class Person  {

    private String name;
    private PhoneNumbers numbers;
    private Adress adress;
    
    
    public Person(String name) {
        this.name = name;
        this.numbers = new PhoneNumbers();
        this.adress = new Adress();
    }
    
    public void addPhone(String number) {
        this.numbers.addNumber(number);
    }
    
    public void setAdress(String street, String city) {
        this.adress.setCity(city);
        this.adress.setStreet(street);
    }
    
    public String getName() {
        return this.name;
    }
    
    public List<String> getNumbers() {
        return this.numbers.getNumbers();
    }
    
    public String getStreet() {
        return this.adress.getStreet();
    }
    
    public String getCity() {
        return this.adress.getCity();
    }
    
    public void eraseData() {
        this.numbers.removeNumbers();
        this.adress.removeAdress();
    }
}